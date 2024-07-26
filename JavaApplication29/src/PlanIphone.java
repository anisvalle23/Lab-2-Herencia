class PlanIphone extends Plan {
    private String email;

    public PlanIphone(int numeroTelefono, String nombreCliente, String email) {
        super(numeroTelefono, nombreCliente);
        this.email = email;
    }

    @Override
    double pagoMensual(int mins, int msgs) {
        double costoBase = 22.0;
        double costoMinutos = mins * 0.4;
        double costoMensajes = msgs * 0.1;
        return costoBase + costoMinutos + costoMensajes;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nEmail: " + email;
    }

    public String getEmail() {
        return email;
    }
}
