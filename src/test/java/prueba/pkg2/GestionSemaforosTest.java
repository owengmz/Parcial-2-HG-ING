package prueba.pkg2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GestionSemaforosTest {

    private GestionSemaforosService service;
    private Semaforo semaforo;

    public GestionSemaforosTest () {}

    @BeforeAll
    public static void setUpClass () {}

    @AfterAll
    public static void tearDownClass () {}

    @BeforeEach
    public void setup () {
        service = new GestionSemaforosService();
        semaforo = new Semaforo(1, "Av. Illia y Av. del Fundador", new SmartLed(30));
    }

    @AfterEach
    public void teardown () {
        System.out.println("tarea finalizada");
    }

    @Test
    public void testComposicionLuces () {
        assertEquals(3, semaforo.getLuces().size());
        assertSame(semaforo.getLuces().get(0), semaforo.getLuz(0));
    }

    @Test
    @Timeout(value = 400, unit = TimeUnit.MILLISECONDS)
    public void testOrdenYaAsignadaException () throws OrdenYaAsignadaException {
        Denunciante denunciante = new Denunciante("Maria Lopez", "maria@mail.com");
        Denuncia denuncia = new Denuncia(1, new Date(), "San Martin", "Belgrano",
            "Semaforo apagado", "Alta", denunciante, semaforo);
        OrdenComposicion ordenExistente = new OrdenComposicion(100, new Date(),
            "Reparacion previa", denuncia);
        service.asignarOrden(denuncia, ordenExistente);
        OrdenComposicion nuevaOrden = new OrdenComposicion(101, new Date(),
            "Reparacion nueva", denuncia);
        assertThrows(OrdenYaAsignadaException.class, () -> {
            service.asignarOrden(denuncia, nuevaOrden);
        });
    }

    @Test
    public void testFlujoReparacionExitoso () throws OrdenYaAsignadaException {
        Denunciante denunciante = new Denunciante("Carlos Diaz", "carlos@gmail.com");
        Denuncia denuncia = new Denuncia(2, new Date(), "Av. Illia", "Av. del Fundador",
            "Falla en LED", "Media", denunciante, semaforo);
        OrdenComposicion orden = new OrdenComposicion(102, new Date(), "Cambio de LED", denuncia);
        service.asignarOrden(denuncia, orden);
        List<Miembro> miembros = new ArrayList<>();
        miembros.add(new Miembro(1, "Juan Perez", "Tecnico", true));
        miembros.add(new Miembro(2, "Ana Gomez", "Tecnico", false));
        miembros.add(new Miembro(3, "Luis Ruiz", "Electricista", false));
        miembros.add(new Miembro(4, "Sofia Diaz", "Electricista", false));
        EquipoControl equipo = new EquipoControl("EQ-01", "Electromecanica", miembros);
        orden.setEquipoControl(equipo);
        service.completarReparacion(orden, new Date());
        assertTrue(orden.estaCompletada());
        assertEquals("Libre", equipo.getEstado());
        for (Miembro m : equipo.getMiembros()) {
            assertTrue(m.isLibre());
        }
    }

    @Test
    public void testPrioridadesValidas () {
        String[] prioridades = {"Alta", "Media", "Baja"};
        Denunciante denunciante = new Denunciante("Pedro Lopez", "pedro@gmail.com");
        for (String prioridad : prioridades) {
            Denuncia denuncia = new Denuncia(3, new Date(), "Calle 1", "Calle 2",
                "Problema generico", prioridad, denunciante, semaforo);
            assertTrue(denuncia.esPrioridadValida());
        }
    }

    @Test
    public void testEstadisticasDenunciasPorSemaforo () {
        Denunciante denunciante = new Denunciante("Lucia Fernandez", "lucia@mail.com");
        Denuncia d1 = new Denuncia(4, new Date(), "Calle A", "Calle B", "Problema 1", "Alta", denunciante, semaforo);
        Denuncia d2 = new Denuncia(5, new Date(), "Calle C", "Calle D", "Problema 2", "Media", denunciante, semaforo);
        Denuncia d3 = new Denuncia(6, new Date(), "Calle E", "Calle F", "Problema 3", "Baja", denunciante, semaforo);
        service.registrarDenuncia(d1);
        service.registrarDenuncia(d2);
        service.registrarDenuncia(d3);
        assertEquals(3, service.calcularEstadisticasSemaforo(semaforo));
    }
}