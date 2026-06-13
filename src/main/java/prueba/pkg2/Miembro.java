package prueba.pkg2;

/**
 *
 * @author Heber Gomez
 */
public class Miembro {
    
    private int id;
    private String nombre;
    private String puesto;
    private boolean libre;
    private boolean responsable;

    public Miembro(int id, String nombre, String puesto, boolean responsable) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.responsable = responsable;
        this.libre = false;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto (String puesto) {
        this.puesto = puesto;
    }

    public void setResponsable (boolean responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString () {
        return "Miembro{" + "id=" + id + ", nombre=" + nombre + ", puesto=" +
            puesto + ", libre=" + libre + ", responsable=" + responsable + '}';
    }
    

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public boolean isResponsable() {
        return responsable;
    }

}
