package edu.ada.service.library.controller.impl;

import edu.ada.service.library.controller.BookOperationsWS;
import edu.ada.service.library.model.dto.BookModel;
import edu.ada.service.library.model.entity.BookEntity;
import edu.ada.service.library.security.jwt.JwtUtils;
import edu.ada.service.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/search")
public class BookOperationsWSImpl implements BookOperationsWS {


    @Autowired
    @Qualifier(value = "BookServiceImpl")
    private BookService bookService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity listCategory() {
        ArrayList<String> categories = bookService.listCategory();
        String temp = "Categories:\n";
        for (String i:categories) {
            temp += i +"\n";
        }
        return ResponseEntity.ok(temp);
    }

    @Override
    @RequestMapping(value = "/book_titles", method = RequestMethod.GET)
    public ResponseEntity listBooks() {
        ArrayList<String> bookTitles = bookService.listBooks();
        String temp = "Books:\n";
        for (String i:bookTitles) {
            temp += i +"\n";
        }
        return ResponseEntity.ok(temp);
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value = "/pickedup_books", method = RequestMethod.GET)
    public ResponseEntity listPickedUpBooks() {
        ArrayList<String> availableBooks = bookService.listPickedUpBooks();
        String temp = "Books:\n";
        for (String i:availableBooks) {
            temp += i +"\n";
        }
        return ResponseEntity.ok(temp);
    }

    @Override
    @RequestMapping(value = "/pickup_book", method = RequestMethod.GET)
    public ResponseEntity pickUpBook(@RequestHeader("title") String title,
                                     @RequestHeader("Authorization") String token) {
        bookService.pickup(jwtUtils.getUserNameFromJwtToken(token),title);
        return ResponseEntity.ok("Picked the book successfully");
    }

    @Override
    @RequestMapping(value = "/dropoff_book", method = RequestMethod.GET) //Dont forget to add "Bearer " before JWT
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity dropoffBook(@RequestHeader("title") String title) {
        bookService.dropoff(title);
        return ResponseEntity.ok("Dropped off the book successfully");
    }


    @Override
    @RequestMapping(value = "/metadata", method = RequestMethod.GET)
    public ResponseEntity listMetaData() {
        ArrayList<String> metaData = bookService.listMetaData();
        String temp = "Meta Data:\n";
        for (String i:metaData) {
            temp += i +"\n";
        }
        return ResponseEntity.ok(temp);
    }

    @Override
    @RequestMapping(value = "/sbc", method = RequestMethod.GET)
    public ResponseEntity searchByCategory(
            @RequestHeader("category") String category) {
        return ResponseEntity.ok(bookService.searchByCategory(category));
    }

    @Override
    @RequestMapping(value = "/sbt", method = RequestMethod.GET)
    public ResponseEntity searchByTitle(
            @RequestHeader("title") String title) {
        return ResponseEntity.ok(bookService.searchByTitle(title));
    }

    @Override
    @RequestMapping(value = "/sba", method = RequestMethod.GET)
    public ResponseEntity searchByAuthor(
            @RequestHeader("author") String author) {
        return ResponseEntity.ok(bookService.searchByAuthor(author));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity getBookByID(@PathVariable("id") long book_id) {
        BookModel book = bookService.searchById(book_id);
        if(book != null){
            return ResponseEntity.ok(book);
        } else{
            return ResponseEntity.notFound().build();
        }

    }
}
