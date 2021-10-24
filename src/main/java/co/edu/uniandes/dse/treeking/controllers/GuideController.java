package co.edu.uniandes.dse.treeking.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.treeking.dto.GuideDTO;
import co.edu.uniandes.dse.treeking.entities.GuideEntity;
import co.edu.uniandes.dse.treeking.services.GuideService;
import org.modelmapper.TypeToken;

@RestController
@RequestMapping("/guides")
public class GuideController {
	
	@Autowired
	private GuideService guideService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<GuideDTO> findAll(){
		List<GuideEntity> guides = guideService.getGuides();
		return modelMapper.map(guides, new TypeToken<List<GuideDTO>>() {
        }.getType());
	}
}
