package prueba.pkg2;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class PrioridadParameterizadaTest {

    private Semaforo semaforo;
    private Denunciante denunciante;

    @BeforeEach
    public void setup() {
        semaforo = new Semaforo(1, "Av. Illia y Av. del Fundador", new SmartLed(30));
        denunciante = new Denunciante("Usuario", "usuario@mail.com");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Alta", "Media", "Baja"})
    public void testPrioridadValida(String prioridad) {
        Denuncia denuncia = new Denuncia(99, new Date(), "Calle X", "Calle Y",
            "Problema", prioridad, denunciante, semaforo);
        assertTrue(denuncia.esPrioridadValida());
    }

    @Test
    public void testPrioridadInvalida() {
        Denuncia denuncia = new Denuncia(99, new Date(), "Calle X", "Calle Y",
            "Problema", "Urgente", denunciante, semaforo);
        assertFalse(denuncia.esPrioridadValida());
    }
}