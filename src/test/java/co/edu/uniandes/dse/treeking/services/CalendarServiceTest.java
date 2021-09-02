package co.edu.uniandes.dse.treeking.services;

import co.edu.uniandes.dse.treeking.entities.CalendarEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(CalendarService.class)
class CalendarServiceTest {

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    private List<CalendarEntity> listadeCalendarios = new ArrayList<>();

    /**
     * Configuración inicial del test
     */

    @BeforeEach
    private void setUp(){
        limpiarData();
        insertarData();
    }
    private void insertarData() {
        for (int i = 0; i < 3; i++) {
            CalendarEntity calendarEntity = factory.manufacturePojo(CalendarEntity.class);
            entityManager.persist(calendarEntity);
            listadeCalendarios.add(calendarEntity);
        }
    }
    private void limpiarData() {
        entityManager.getEntityManager().createQuery("delete from CalendarEntity").executeUpdate();
    }

    @Test
    void getCalendars() {
        List<CalendarEntity> list = calendarService.getCalendars();
        assertEquals(listadeCalendarios.size(), list.size());
        for (CalendarEntity entidad : list) {
            boolean encontrao = false;
            for (CalendarEntity entidadGuardada : listadeCalendarios ) {
                if (entidad.getId().equals(entidadGuardada.getId())) {
                    encontrao = true;
                }
            }
            assertTrue(encontrao);
        }
    }
}