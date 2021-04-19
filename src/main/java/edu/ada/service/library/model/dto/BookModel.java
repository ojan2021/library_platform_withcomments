package edu.ada.service.library.model.dto;

import edu.ada.service.library.model.entity.BookEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class BookModel {
    private String title;
    private String category;
    private String author;
    private String publish_date;
    private String availability;
    private List<CommentModel> comments;

    public BookModel(BookEntity book) {
        this.title = book.getTitle();
        this.category = book.getCategory();
        this.author = book.getAuthor();
        this.publish_date = book.getPublish_date();
        this.availability = book.getAvailability();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public List<CommentModel> getComments() {
        return comments;
    }
}
