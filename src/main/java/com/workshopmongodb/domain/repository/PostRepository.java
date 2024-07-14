package com.workshopmongodb.domain.repository;

import com.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Query customizada para buscar posts pelo título usando regex e ignorando case
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    // Query customizada para busca completa considerando data mínima e máxima
    // e procurando o texto no título, corpo ou comentários do post
    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

    // Método gerado automaticamente pelo Spring Data MongoDB para buscar posts
    // contendo um texto no título, ignorando case
    List<Post> findByTitleContainingIgnoreCase(String text);
}
