package edu.ada.service.library.service;

import edu.ada.service.library.model.dto.BookModel;
import edu.ada.service.library.model.entity.BookEntity;

import java.util.ArrayList;

public interface BookService {

    ArrayList<String> listCategory();
    ArrayList<String> listBooks();
    ArrayList<String> listPickedUpBooks();
    ArrayList<String> listMetaData();
    void pickup(String username, String title);
    void dropoff(String title);
    BookEntity searchByCategory(String category);
    BookEntity searchByTitle(String title);
    BookEntity searchByAuthor(String author);
    BookModel searchById(long book_id);
}

