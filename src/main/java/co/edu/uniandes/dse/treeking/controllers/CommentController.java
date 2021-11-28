package co.edu.uniandes.dse.treeking.controllers;

import co.edu.uniandes.dse.treeking.dto.CommentDTO;
import co.edu.uniandes.dse.treeking.dto.CommentDetailDTO;
import co.edu.uniandes.dse.treeking.dto.CommentDTO;
import co.edu.uniandes.dse.treeking.entities.CommentEntity;
import co.edu.uniandes.dse.treeking.entities.CommentEntity;
import co.edu.uniandes.dse.treeking.entities.CommentEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.CommentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<CommentDTO> findAll() {
        List<CommentEntity> comments = commentService.getComments();
        return modelMapper.map(comments, new TypeToken<List<CommentDTO>>() {
        }.getType());
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CommentDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
        CommentEntity entity = commentService.getComment(id);
        return modelMapper.map(entity, CommentDetailDTO.class);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CommentDTO create(@RequestBody CommentDTO commentDTO) {
        CommentEntity commentEntity = commentService.createComment(modelMapper.map(commentDTO, CommentEntity.class));
        return modelMapper.map(commentEntity, CommentDTO.class);
    }
}
