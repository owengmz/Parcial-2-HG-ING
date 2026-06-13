package prueba.pkg2;

/**
 *
 * @author Heber Gomez
 */
public class Luz {

    private String numeroSerie;
    private String empresaFabricadora;
    private String tipo;
    private String color;

    public Luz (String numeroSerie, String empresaFabricadora, String tipo, String color) {
        this.numeroSerie = numeroSerie;
        this.empresaFabricadora = empresaFabricadora;
        this.tipo = tipo;
        this.color = color;
    }

    public String getNumeroSerie () {
        return numeroSerie;
    }

    public String getEmpresaFabricadora () {
        return empresaFabricadora;
    }

    public String getTipo () {
        return tipo;
    }

    public String getColor () {
        return color;
    }

    public void setNumeroSerie (String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setEmpresaFabricadora (String empresaFabricadora) {
        this.empresaFabricadora = empresaFabricadora;
    }

    public void setTipo (String tipo) {
        this.tipo = tipo;
    }

    public void setColor (String color) {
        this.color = color;
    }

    @Override
    public String toString () {
        return "Luz{" + "numeroSerie=" + numeroSerie + ", empresaFabricadora=" +
            empresaFabricadora + ", tipo=" + tipo + ", color=" + color + '}';
    }
}
