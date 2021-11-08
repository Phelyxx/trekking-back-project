package co.edu.uniandes.dse.treeking.dto;

import co.edu.uniandes.dse.treeking.enums.FileType;
import lombok.Data;

@Data
public class MultimediaDTO {
	private String fileName;
	private FileType mediaType;
	private String extension;
	// esto no deberia estar en el DTO
}
