package edu.ada.service.library.service.impl;

import edu.ada.service.library.model.dto.CommentModel;
import edu.ada.service.library.model.entity.CommentEntity;
import edu.ada.service.library.repository.CommentRepository;
import edu.ada.service.library.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "CommentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<CommentModel> getCommentByBookExtId(long id) {

        Optional<List<CommentEntity>> result = commentRepository.findAllByBook_ext_id(id);
        List<CommentModel> comments = new ArrayList<>(1);
        if(!result.isPresent())
            return comments;

        if(result.get().size()>0) {
            result.get().stream().forEach(commentEntity -> {
                comments.add(new CommentModel(commentEntity));
            });
        }

        return comments;
    }
}
