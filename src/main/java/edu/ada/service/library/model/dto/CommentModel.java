package edu.ada.service.library.model.dto;

import edu.ada.service.library.model.entity.CommentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CommentModel {
    private String id;
    private String author_name;
    private String content;

    private List<CommentModel> replies;

    public CommentModel(CommentEntity entity) {
        this.id = entity.getId();
        this.author_name = entity.getComment_author_name();
        this.content = entity.getComment_content();
    }
}