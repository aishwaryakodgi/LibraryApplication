package com.libraryApplication.library.repository;

import com.libraryApplication.library.model.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface LibraryRepository extends MongoRepository<Library, Integer> {

    @Query("{bookTitle:?0}")
    Optional<Library> findByTitle(String bookTitle);

    @Query("{genre:?0}")
    Optional<Library> findByGenre(String genre);

    @Query("{author:?0}")
    Optional<Library> findByAuthor(String author);
}
