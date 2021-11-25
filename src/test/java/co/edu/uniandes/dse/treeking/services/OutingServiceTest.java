package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(OutingService.class)
class OutingServiceTest {

	@Autowired
	private OutingService outingService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<OutingEntity> outingList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from OutingEntity").executeUpdate();
	}

	/**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			OutingEntity outingEntity = factory.manufacturePojo(OutingEntity.class);
			entityManager.persist(outingEntity);
			outingList.add(outingEntity);
		}
	}

	@Test
	void testGetOutings() {
		List<OutingEntity> list = outingService.getOutings();
		assertEquals(list.size(), outingList.size());
	}
	
	@Test
	void testGetOuting() throws EntityNotFoundException{
		OutingEntity outingEntity = outingList.get(0);
		OutingEntity outing = outingService.getOuting(outingEntity.getId());
		assertNotNull(outing);
		assertEquals(outing.getId(), outingEntity.getId());
		assertEquals(outing.getDate(), outingEntity.getDate());
		assertEquals(outing.getPlace(), outingEntity.getPlace());
		assertEquals(outing.getParticipationCost(), outingEntity.getParticipationCost());
	}
	
	/**
	 * Prueba para crear un Outing
	 */
	@Test
	void testCreateOuting() throws EntityNotFoundException, IllegalOperationException {
		OutingEntity newEntity = factory.manufacturePojo(OutingEntity.class);
		OutingEntity result = outingService.createOuting(newEntity);
		assertNotNull(result);

		OutingEntity entity = entityManager.find(OutingEntity.class, result.getId());

		assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getDate(), entity.getDate());
		assertEquals(newEntity.getPlace(), entity.getPlace());
		assertEquals(newEntity.getParticipationCost(), entity.getParticipationCost());
	}


}
