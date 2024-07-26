import java.util.ArrayList;

class PlanSamsung extends Plan {
    private String pin;
    private ArrayList<String> bbm;

    public PlanSamsung(int numeroTelefono, String nombreCliente, String pin) {
        super(numeroTelefono, nombreCliente);
        this.pin = pin;
        this.bbm = new ArrayList<>();
    }

    @Override
    double pagoMensual(int mins, int msgs) {
        double tarifa = 40;
        int minutosGratis = 200;
        int mensajesGratis = 300;
        double tarifaMinutoAdicional = 0.8;
        double tarifaMensajeAdicional = 0.2;
        int minutosExcedentes = Math.max(0, mins - minutosGratis);
        int mensajesExcedentes = Math.max(0, msgs - mensajesGratis);
        return tarifa + (minutosExcedentes * tarifaMinutoAdicional) + (mensajesExcedentes * tarifaMensajeAdicional);
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nPIN: " + pin;
    }

    public void agregarPinAmigo(String pin) {
        if (!bbm.contains(pin)) {
            bbm.add(pin);
        }
    }

    public String getPin() {
        return pin;
    }
}
