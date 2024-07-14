package com.workshopmongodb.service;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.domain.repository.PostRepository;
import com.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Serviço para gerenciar posts no MongoDB.
 * Fornece operações como encontrar todos os posts, encontrar um post por ID,
 * buscar posts pelo título e realizar uma busca completa com parâmetros de texto e data.
 *
 * @autor Ednaldo Tavares
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository; // Injeção do repositório PostRepository

    /**
     * Retorna uma lista de todos os posts.
     *
     * @return Lista de posts.
     */
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    /**
     * Encontra um post pelo ID.
     *
     * @param id O ID do post.
     * @return Um Optional contendo o post encontrado, se existir.
     * @throws ObjectNotFoundException Se o post não for encontrado.
     */
    public Optional<Post> findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (!postRepository.existsById(id)) {
            throw new ObjectNotFoundException("Post not found: " + id);
        }
        return post;
    }

    /**
     * Busca posts pelo título usando um método customizado do repositório.
     *
     * @param text O texto a ser buscado no título dos posts.
     * @return Lista de posts que correspondem ao texto buscado.
     */
    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    /**
     * Realiza uma busca completa com parâmetros de texto e data.
     *
     * @param text O texto a ser buscado no título, corpo ou comentários dos posts.
     * @param minDate A data mínima para a busca.
     * @param maxDate A data máxima para a busca.
     * @return Lista de posts que correspondem aos parâmetros de busca.
     */
    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // Ajusta a data máxima para incluir o dia inteiro
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
