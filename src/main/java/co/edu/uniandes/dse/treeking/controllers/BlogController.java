package co.edu.uniandes.dse.treeking.controllers;
import co.edu.uniandes.dse.treeking.dto.BlogDTO;
import co.edu.uniandes.dse.treeking.dto.BlogDetailDTO;
import co.edu.uniandes.dse.treeking.dto.BlogDTO;
import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.entities.BlogEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.BlogService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<BlogDetailDTO> findAll() {
        List<BlogEntity> blogs = blogService.getBlogs();
        return modelMapper.map(blogs, new TypeToken<List<BlogDetailDTO>>() {
        }.getType());
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public BlogDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
        BlogEntity entity = blogService.getBlog(id);
        return modelMapper.map(entity, BlogDetailDTO.class);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BlogDetailDTO create(@RequestBody BlogDetailDTO blogDTO) {
        BlogEntity blogEntity = blogService.createBlog(modelMapper.map(blogDTO, BlogEntity.class));
        return modelMapper.map(blogEntity, BlogDetailDTO.class);
    }

}
