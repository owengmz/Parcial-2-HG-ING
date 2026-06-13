package prueba.pkg2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heber Gomez
 */
public class Semaforo {

    private int nro;
    private String estado;
    private String ubicacion;
    private Faro faro;
    private List<Luz> luces;
    private List<Denuncia> historicoDenuncias;

    public Semaforo (int nro, String ubicacion, Faro faro) {
        this.nro = nro;
        this.ubicacion = ubicacion;
        this.faro = faro;
        this.estado = "Funcionando";
        this.luces = new ArrayList<>();
        this.historicoDenuncias = new ArrayList<>();
        this.luces.add(new Luz("SN1", "Philips", "LED", "Rojo"));
        this.luces.add(new Luz("SN2", "Philips", "LED", "Amarillo"));
        this.luces.add(new Luz("SN3", "Philips", "LED", "Verde"));
    }

    public int getNro () {
        return nro;
    }

    public String getEstado () {
        return estado;
    }

    public void cambiarEstado (String estado) {
        this.estado = estado;
    }

    public String getUbicacion () {
        return ubicacion;
    }

    public Faro getFaro () {
        return faro;
    }

    public List<Luz> getLuces () {
        return luces;
    }

    public Luz getLuz (int index) {
        return luces.get(index);
    }

    public List<Denuncia> getHistoricoDenuncias () {
        return historicoDenuncias;
    }

    public void setNro (int nro) {
        this.nro = nro;
    }

    public void setEstado (String estado) {
        this.estado = estado;
    }

    public void setUbicacion (String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFaro (Faro faro) {
        this.faro = faro;
    }

    @Override
    public String toString () {
        return "Semaforo{" + "nro=" + nro + ", estado=" + estado
            + ", ubicacion=" + ubicacion + ", faro=" + faro + ", luces=" + luces
            + ", historicoDenuncias=" + historicoDenuncias + '}';
    }

    public void agregarDenuncia (Denuncia d) {
        historicoDenuncias.add(d);
    }

    public int cantidadDenuncias () {
        return historicoDenuncias.size();
    }
}
