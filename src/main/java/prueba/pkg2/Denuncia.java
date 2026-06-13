package prueba.pkg2;

import java.util.Date;

/**
 *
 * @author Heber Gomez
 */
public class Denuncia {

    private int codD;
    private Date fechaDenuncia;
    private String calleX;
    private String calleY;
    private String problema;
    private String prioridad;
    private Denunciante denunciante;
    private Semaforo semaforo;
    private OrdenComposicion ordenAsignada;

    public Denuncia (int codD, Date fechaDenuncia, String calleX, String calleY,
        String problema, String prioridad, Denunciante denunciante, Semaforo semaforo) {
        this.codD = codD;
        this.fechaDenuncia = fechaDenuncia;
        this.calleX = calleX;
        this.calleY = calleY;
        this.problema = problema;
        this.prioridad = prioridad;
        this.denunciante = denunciante;
        this.semaforo = semaforo;
    }

    public int getCodD () {
        return codD;
    }

    public Date getFechaDenuncia () {
        return fechaDenuncia;
    }

    public String getCalleX () {
        return calleX;
    }

    public String getCalleY () {
        return calleY;
    }

    public String getProblema () {
        return problema;
    }

    public String getPrioridad () {
        return prioridad;
    }

    public Denunciante getDenunciante () {
        return denunciante;
    }

    public Semaforo getSemaforo () {
        return semaforo;
    }

    public OrdenComposicion getOrdenAsignada () {
        return ordenAsignada;
    }

    public void setCodD (int codD) {
        this.codD = codD;
    }

    public void setFechaDenuncia (Date fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }

    public void setCalleX (String calleX) {
        this.calleX = calleX;
    }

    public void setCalleY (String calleY) {
        this.calleY = calleY;
    }

    public void setProblema (String problema) {
        this.problema = problema;
    }

    public void setPrioridad (String prioridad) {
        this.prioridad = prioridad;
    }

    public void setDenunciante (Denunciante denunciante) {
        this.denunciante = denunciante;
    }

    public void setSemaforo (Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public void setOrdenAsignada (OrdenComposicion ordenAsignada) {
        this.ordenAsignada = ordenAsignada;
    }

    @Override
    public String toString () {
        return "Denuncia{" + "codD=" + codD + ", fechaDenuncia=" + fechaDenuncia
            + ", calleX=" + calleX + ", calleY=" + calleY + ", problema="
            + problema + ", prioridad=" + prioridad + ", denunciante="
            + denunciante + ", semaforo=" + semaforo + ", ordenAsignada="
            + ordenAsignada + '}';
    }

    public boolean esPrioridadValida () {
        return prioridad.equals("Alta") || prioridad.equals("Media")
            || prioridad.equals("Baja");
    }

    public boolean tieneOrdenAsignada () {
        return ordenAsignada != null;
    }

    public void asignarOrden (OrdenComposicion orden) throws OrdenYaAsignadaException {
//        eliminamos ese bloque para forzar el error los test deben salir en rojo
        if (this.ordenAsignada != null) {
            throw new OrdenYaAsignadaException(
                "La denuncia ya tiene una orden de composicion asignada");
        }
        this.ordenAsignada = orden;
    }
}
