package edu.ada.service.library.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Document
@Data
public class CommentEntity {
    @Id
    private String id;

    private Long bookExtId;
    private String comment_author_name;
    private String comment_content;

    public CommentEntity(Long bookExtId, String comment_author_name, String comment_content) {
        this.bookExtId = bookExtId;
        this.comment_author_name = comment_author_name;
        this.comment_content = comment_content;
    }

    //    @OneToMany(mappedBy = "replies")
    private List<CommentEntity> replies;

}
