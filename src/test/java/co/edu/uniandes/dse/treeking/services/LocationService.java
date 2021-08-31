package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.repositories.LocationRepository;
import co.edu.uniandes.dse.treeking.entities.LocationEntity;

@Service
public class LocationService {
	@Autowired
	LocationRepository LocationRepository;
	
	@Transactional
	public List<LocationEntity> getLocations() {
		return LocationRepository.findAll();
	}
	
	@Transactional
	public LocationEntity getPrimerLocation() {
		List<LocationEntity> locaciones = LocationRepository.findAll();
		if ( locaciones.size() > 0 ) {
			return locaciones.get( 0 );
		} else {
			return null;
		}
	}
}
