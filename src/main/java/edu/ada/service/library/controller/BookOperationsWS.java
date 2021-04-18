package edu.ada.service.library.controller;

import org.springframework.http.ResponseEntity;

public interface BookOperationsWS {

    ResponseEntity listCategory();
    ResponseEntity listBooks();
    ResponseEntity listPickedUpBooks();
    ResponseEntity pickUpBook(String title, String token);
    ResponseEntity dropoffBook(String title);
    ResponseEntity searchByCategory(String category);
    ResponseEntity searchByTitle(String title);
    ResponseEntity searchByAuthor(String author);
    ResponseEntity getBookByID(long book_id);
    ResponseEntity listMetaData();
}
