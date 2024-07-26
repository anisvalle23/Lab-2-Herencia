
public abstract class Plan {
    
    private String numeroTelefono;
    private String nombreCliente;

    
    public Plan(String numeroTelefono, String nombreCliente) {
        this.numeroTelefono = numeroTelefono;
        this.nombreCliente = nombreCliente;
    }

    
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    
    public abstract double pagoMensual(int mins, int msgs);

    
    public void imprimir() {
        System.out.println("Número de Teléfono: " + numeroTelefono);
        System.out.println("Nombre del Cliente: " + nombreCliente);
    }
}


