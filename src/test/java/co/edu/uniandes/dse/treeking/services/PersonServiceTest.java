package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.treeking.entities.PersonEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Logic test of Person
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(PersonService.class)
class PersonServiceTest {

	@Autowired
	private PersonService personService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<PersonEntity> personList = new ArrayList<>();

	/**
	 * Initial configuration of the test.
	 */
	@BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

	/**
	 * Clean tables of test.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from PersonEntity").executeUpdate();
	}

	/**
	 * Insert initial data to the tables.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			PersonEntity personEntity = factory.manufacturePojo(PersonEntity.class);
			entityManager.persist(personEntity);
			personList.add(personEntity);
		}
	}

	/**
	 * Test for getting Person list.
	 */
	@Test
	void testGetPersons() {
		List<PersonEntity> list = personService.getPersons();
		assertEquals(list.size(), personList.size());
	}

	/**
	 * Test for getting Person.
	 */
	@Test
	void testGetPerson() throws EntityNotFoundException {
		PersonEntity personEntity = personList.get(0);
		PersonEntity person = personService.getPerson(personEntity.getId());
		assertEquals(person.getId(), personEntity.getId());
		assertEquals(person.getName(), personEntity.getName());
		assertEquals(person.getAddress(), personEntity.getAddress());
		assertEquals(person.getIdNumber(), personEntity.getIdNumber());
		assertEquals(person.getIdType(), personEntity.getIdType());
		assertNotNull(person);
	}

	/**
	 * Test for adding a new Person.
	 */
	@Test
	void testAddPerson() throws EntityNotFoundException, IllegalOperationException {
		PersonEntity newEntity = factory.manufacturePojo(PersonEntity.class);
		PersonEntity result = personService.createPerson(newEntity);
		assertNotNull(result);

		PersonEntity entity = entityManager.find(PersonEntity.class, result.getId());

		assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getName(), entity.getName());
		assertEquals(newEntity.getAddress(), entity.getAddress());
		assertEquals(newEntity.getIdNumber(), entity.getIdNumber());
		assertEquals(newEntity.getIdType(), entity.getIdType());
		assertNotNull(newEntity);
	}
}
