abstract class Plan {
    protected int numeroTelefono;
    protected String nombreCliente;

    public Plan(int numeroTelefono, String nombreCliente) {
        this.numeroTelefono = numeroTelefono;
        this.nombreCliente = nombreCliente;
    }

    public int getTelefono() {
        return numeroTelefono;
    }

    public String getNombre() {
        return nombreCliente;
    }

    abstract double pagoMensual(int mins, int msgs);

    public String imprimir() {
        return "Numero de Cliente: " + numeroTelefono + "\nNombre de Cliente: " + nombreCliente;
    }
}
