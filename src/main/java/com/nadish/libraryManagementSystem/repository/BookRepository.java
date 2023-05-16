package com.nadish.libraryManagementSystem.repository;

import com.nadish.libraryManagementSystem.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {
//    Optional<Book> findBookByBookId(String bookId);
    List<Book> findBooksByTitle(String title);
    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<Book> findBooksByPartialTitle(String title);

    Optional<Book> findBookByIsbn(String isbn);
    void deleteByBookId(String bookId);

    //User  findByIsbn(String isbn);
}