package edu.ada.service.library.service;

import edu.ada.service.library.model.dto.CommentModel;

import java.util.List;

public interface CommentService {
    List<CommentModel> getCommentByBookExtId(long id);

    void newComment(Long bookExtId, String comment_author_name, String comment_content);
}
