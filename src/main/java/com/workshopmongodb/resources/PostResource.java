package com.workshopmongodb.resources;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.resources.util.URLDecode;
import com.workshopmongodb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService; // Injeção do serviço PostService

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Post>> findByPost(@PathVariable String id) {
        // Busca um post pelo ID
        Optional<Post> post = postService.findById(id);
        // Retorna a resposta HTTP com o post encontrado
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        // Decodifica o parâmetro de texto da URL
        text = URLDecode.decodeParam(text);
        // Busca posts pelo título
        List<Post> post = postService.findByTitle(text);
        // Retorna a resposta HTTP com a lista de posts encontrados
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

        // Decodifica o parâmetro de texto da URL
        text = URLDecode.decodeParam(text);
        // Converte as datas de string para o tipo Date
        Date min = URLDecode.convertDate(minDate, new Date(0L));
        Date max = URLDecode.convertDate(maxDate, new Date());

        // Busca posts com os parâmetros fornecidos
        List<Post> list = postService.fullSearch(text, min, max);

        // Retorna a resposta HTTP com a lista de posts encontrados
        return ResponseEntity.ok().body(list);
    }
}
