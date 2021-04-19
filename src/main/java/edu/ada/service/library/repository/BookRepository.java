package edu.ada.service.library.repository;


import edu.ada.service.library.model.entity.BookEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Query(value = "SELECT category FROM books",nativeQuery = true)
    ArrayList<String> findCategories();

    @Query(value = "SELECT title FROM books",nativeQuery = true)
    ArrayList<String> findBookTitles();

    @Query(value = "SELECT id,title, category, author, publish_date, availability FROM books",nativeQuery = true)
    ArrayList<String> findMetaData();

    @Query(value = "SELECT title FROM books WHERE availability != 'AVAILABLE'",nativeQuery = true)
    ArrayList<String> findPickedUpBooks();

    @Modifying
    @Transactional
    @Query("update BookEntity b set b.availability = :username where b.title=:title")
    void pickupBook(@Param(value = "username") String username, @Param(value = "title") String title);

    @Modifying
    @Transactional
    @Query("update BookEntity b set b.availability = 'AVAILABLE' where b.title=:title")
    void dropoffBook(@Param(value = "title") String title);


    BookEntity findAllByCategory(String category);
    BookEntity findAllByTitle(String title);
    BookEntity findAllByAuthor(String author);





}
