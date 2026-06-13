package prueba.pkg2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heber Gomez
 */
public class EquipoControl {

    private String codigo;
    private List<Miembro> miembros;
    private String especialidad;
    private String estado;
    private List<OrdenComposicion> ordenesAsignadas;

    public EquipoControl (String codigo, String especialidad, List<Miembro> miembros) {
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.miembros = miembros;
        this.estado = "Ocupado";
        this.ordenesAsignadas = new ArrayList<>();
    }

    public List<OrdenComposicion> getOrdenesAsignadas () {
        return ordenesAsignadas;
    }

    public void agregarOrden (OrdenComposicion orden) {
        ordenesAsignadas.add(orden);
    }

    public String getCodigo () {
        return codigo;
    }

    public List<Miembro> getMiembros () {
        return miembros;
    }

    public String getEspecialidad () {
        return especialidad;
    }

    public String getEstado () {
        return estado;
    }

    public void liberarEquipo () {
        this.estado = "Libre";
        for (Miembro m : miembros) {
            m.setLibre(true);
        }
    }

    public Miembro getResponsable () {
        for (Miembro m : miembros) {
            if (m.isResponsable()) {
                return m;
            }
        }
        return null;
    }
}
