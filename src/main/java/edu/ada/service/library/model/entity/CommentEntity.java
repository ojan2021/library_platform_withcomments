package edu.ada.service.library.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
public class CommentEntity {
    @Id
    private String id;

    private String book_ext_id;
    private String comment_author_name;
    private String comment_content;

    @OneToMany(mappedBy = "replies")
    private List<CommentEntity> replies;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBook_ext_id() {
        return book_ext_id;
    }

    public void setBook_ext_id(String book_ext_id) {
        this.book_ext_id = book_ext_id;
    }

    public String getComment_author_name() {
        return comment_author_name;
    }

    public void setComment_author_name(String comment_author_name) {
        this.comment_author_name = comment_author_name;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }
}
