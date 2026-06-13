package prueba.pkg2;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Heber Gomez
 */
public class Denunciante {

    private String nombre;
    private String mail;
    private List<Denuncia> denuncias;

    public Denunciante(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.denuncias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public void setMail (String mail) {
        this.mail = mail;
    }

    public void setDenuncias (List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    @Override
    public String toString () {
        return "Denunciante{" + "nombre=" + nombre + ", mail=" + mail +
            ", denuncias=" + denuncias + '}';
    }
    

    public void agregarDenuncia(Denuncia d) {
        denuncias.add(d);
    }
}
