import java.util.ArrayList;

public class PlanSamsung extends Plan {
    private String pin;
    private ArrayList<String> bbm;

    public PlanSamsung(int numeroTelefono, String nombreCliente, String pin) { 
        super(numeroTelefono, nombreCliente);
        this.pin = pin;
        this.bbm = new ArrayList<>();
    }

    @Override
    public double pagoMensual(int mins, int msgs) {
        double tarifa = 40;
        
        int minutos_gratis = 200;
        int mensaje_gratis = 300;
        
        double tarifa_minutoAdicional = 0.8;
        double tarifa_mensajeAdicional = 0.2;
        
        int minutos_excedentes = mins - minutos_gratis;
        int mensajes_excedentes = msgs - mensaje_gratis;
        
        if (minutos_excedentes < 0) {
            minutos_excedentes = 0;
        }
        if (mensajes_excedentes < 0) { 
            mensajes_excedentes = 0;
        }
        
        return tarifa + (minutos_excedentes * tarifa_minutoAdicional) + (mensajes_excedentes * tarifa_mensajeAdicional);
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
