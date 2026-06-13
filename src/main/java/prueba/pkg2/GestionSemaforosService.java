package prueba.pkg2;

import java.util.Date;

/**
 *
 * @author Heber Gomez
 */
public class GestionSemaforosService {

    public void registrarDenuncia (Denuncia denuncia) {
        denuncia.getSemaforo().
            agregarDenuncia(denuncia);
        denuncia.getDenunciante().
            agregarDenuncia(denuncia);
    }

    public void asignarOrden (Denuncia denuncia, OrdenComposicion orden) throws OrdenYaAsignadaException {
        denuncia.asignarOrden(orden);
    }

    public int calcularEstadisticasSemaforo (Semaforo semaforo) {
        return semaforo.cantidadDenuncias();
    }

    public void completarReparacion (OrdenComposicion orden, Date fechaEfectiva) {
        orden.marcarReparacionEfectiva(fechaEfectiva);
    }
}
