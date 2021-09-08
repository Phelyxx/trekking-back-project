package co.edu.uniandes.dse.treeking.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.treeking.dto.MultimediaDTO;
import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;
import co.edu.uniandes.dse.treeking.services.MultimediaService;

/**
 * Class that implements resource "multimedias"
 */

@RestController
@RequestMapping("/multimedias")
public class MultimediaController {

	@Autowired
	private MultimediaService multimediaService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Search and return all multimedias that exist in the application.
	 *
	 * @return JSONArray {@link MultimediaDTO} - Multimedias find in the
	 *         application. If there are none, it returns an empty list.
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<MultimediaDTO> findAll() {
		List<MultimediaEntity> multimedias = multimediaService.getMultimedias();
		return modelMapper.map(multimedias, new TypeToken<List<MultimediaDTO>>() {
		}.getType());
	}
}
