package com.workshopmongodb.resources;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.domain.User;
import com.workshopmongodb.dto.UserDTO;
import com.workshopmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controlador REST para gerenciar usuários.
 * Fornece endpoints para operações de CRUD e para obter posts de um usuário.
 *
 * @autor Ednaldo Tavares
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    /**
     * Retorna uma lista de todos os usuários como UserDTO.
     *
     * @return Lista de UserDTO.
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> dtoList = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    /**
     * Encontra um usuário pelo ID e retorna como UserDTO.
     *
     * @param id O ID do usuário.
     * @return O UserDTO do usuário encontrado.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        Optional<User> user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    /**
     * Insere um novo usuário.
     *
     * @param userDTO O DTO do usuário a ser inserido.
     * @return Um ResponseEntity com status 201 Created e o URI do novo recurso.
     */
    @PostMapping
    public ResponseEntity<Void> insertUser(@RequestBody UserDTO userDTO) {
        User user = userService.fromDTO(userDTO);
        user = userService.insertUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * Deleta um usuário pelo ID.
     *
     * @param id O ID do usuário a ser deletado.
     * @return Um ResponseEntity com status 204 No Content.
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um usuário existente.
     *
     * @param userDto O DTO do usuário com as atualizações.
     * @param id O ID do usuário a ser atualizado.
     * @return O usuário atualizado, se encontrado, ou 404 Not Found se não encontrado.
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO userDto, @PathVariable String id) {
        User user = userService.fromDTO(userDto);
        user.setId(id);
        Optional<User> obj = userService.update(user);
        return obj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Encontra os posts de um usuário pelo ID.
     *
     * @param id O ID do usuário.
     * @return Lista de posts do usuário.
     */
    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        Optional<User> user = userService.findById(id);
        return ResponseEntity.ok().body(user.get().getPosts());
    }
}
