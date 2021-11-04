package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.CalendarEntity;
import co.edu.uniandes.dse.treeking.repositories.CalendarRepository;

@Service
public class CalendarService {

	@Autowired
	CalendarRepository calendarRepository;

	/**
	 * Obtiene la lista de los registros de Calendario
	 */
	@Transactional
	public List<CalendarEntity> getCalendars() {
		return calendarRepository.findAll();
	}

	public CalendarEntity getCalendarById(Integer id) throws EntityNotFoundException {
		Optional<CalendarEntity> calendarEntity = Optional.of(calendarRepository.getById(Long.valueOf(id)));
		if (calendarEntity.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.ROUTE_NOT_FOUND);
		}
		return calendarEntity.get();
	}
}
