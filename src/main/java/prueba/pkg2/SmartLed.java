package prueba.pkg2;

/**
 *
 * @author Heber Gomez
 */
public class SmartLed extends Faro {

    private int cuentaRegresiva;

    public SmartLed (int cuentaRegresiva) {
        this.cuentaRegresiva = cuentaRegresiva;
    }

    @Override
    public void encenderLuz () {
    }

    @Override
    public void iniciarCuentaRegresiva () {
    }

    public int getCuentaRegresiva () {
        return cuentaRegresiva;
    }
}
