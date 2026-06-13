package prueba.pkg2;

import java.util.Date;
/**
 *
 * @author Heber Gomez
 */
public class OrdenComposicion {
    
    private int nroOrden;
    private Date fechaProgramada;
    private Date fechaEfectiva;
    private String detalle;
    private Denuncia denuncia;
    private EquipoControl equipoControl;

    public OrdenComposicion(int nroOrden, Date fechaProgramada, String detalle, Denuncia denuncia) {
        this.nroOrden = nroOrden;
        this.fechaProgramada = fechaProgramada;
        this.detalle = detalle;
        this.denuncia = denuncia;
        this.fechaEfectiva = null;
    }

    public int getNroOrden() {
        return nroOrden;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public Date getFechaEfectiva() {
        return fechaEfectiva;
    }

    public String getDetalle() {
        return detalle;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public EquipoControl getEquipoControl() {
        return equipoControl;
    }

    public void setNroOrden (int nroOrden) {
        this.nroOrden = nroOrden;
    }

    public void setFechaProgramada (Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public void setFechaEfectiva (Date fechaEfectiva) {
        this.fechaEfectiva = fechaEfectiva;
    }

    public void setDetalle (String detalle) {
        this.detalle = detalle;
    }

    public void setDenuncia (Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public void setEquipoControl (EquipoControl equipoControl) {
        this.equipoControl = equipoControl;
    }

    @Override
    public String toString () {
        return "OrdenComposicion{" + "nroOrden=" + nroOrden +
            ", fechaProgramada=" + fechaProgramada + ", fechaEfectiva=" +
            fechaEfectiva + ", detalle=" + detalle + ", denuncia=" + denuncia +
            ", equipoControl=" + equipoControl + '}';
    }
    



    public void marcarReparacionEfectiva(Date fecha) {
        this.fechaEfectiva = fecha;
        if (this.equipoControl != null) {
            this.equipoControl.liberarEquipo();
        }
    }

    public boolean estaCompletada() {
        return fechaEfectiva != null;
    }

}
