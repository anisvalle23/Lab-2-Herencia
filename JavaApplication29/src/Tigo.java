
import java.util.ArrayList;

public class Tigo {
    private ArrayList<Plan> planes;

    public Tigo() {
        this.planes = new ArrayList<>();
    }

    public void agregarPlan(int numeroTel, String nombre, String extra, String tipo) {
        if (!busqueda(numeroTel, extra, tipo)) {
            switch (tipo.toUpperCase()) {
                case "IPHONE":
                    PlanIphone nuevoIphone = new PlanIphone(numeroTel, nombre);
                    nuevoIphone.setEmail(extra);
                    planes.add(nuevoIphone);
                    break;
                case "SAMSUNG":
                    PlanSamsung nuevoSamsung = new PlanSamsung(numeroTel, nombre, extra);
                    planes.add(nuevoSamsung);
                    break;
                default:
                    System.out.println("Tipo de plan no reconocido.");
            }
        } else {
            System.out.println("El número de teléfono o el dato extra ya existen.");
        }
    }

    public boolean busqueda(int numeroTel, String extra, String tipo) {
        for (Plan plan : planes) {
            if (plan.getTelefono() == numeroTel) {
                return true;
            }
            if (tipo.equalsIgnoreCase("IPHONE")) {
                if (((PlanIphone) plan).getEmail().equals(extra)) {
                    return true;
                }
            } else if (tipo.equalsIgnoreCase("SAMSUNG")) {
                if (((PlanSamsung) plan).getPin().equals(extra)) {
                    return true;
                }
            }
        }
        return false;
    }

    public double pagoPlan(int numeroTel, int mins, int msgs) {
        for (Plan plan : planes) {
            if (plan.getTelefono() == numeroTel) {
                return plan.pagoMensual(mins, msgs);
            }
        }
        System.out.println("Número de teléfono no encontrado.");
        return 0;
    }

    public void agregarAmigo(int numeroTel, String pin) {
        for (Plan plan : planes) {
            if (plan.getTelefono() == numeroTel && plan instanceof PlanSamsung) {
                ((PlanSamsung) plan).agregarPinAmigo(pin);
                return;
            }
        }
        System.out.println("Número de teléfono no encontrado o el plan no es Samsung.");
    }

    public void lista() {
        int cont_IPhone = 0;
        int cont_Samsung = 0;

        for (Plan plan : planes) {
            System.out.println(plan.imprimir());
            if (plan instanceof PlanIphone) {
                cont_IPhone++;
            } else if (plan instanceof PlanSamsung) {
                cont_Samsung++;
            }
        }

        System.out.println("Cantidad total de IPhones: " + cont_IPhone);
        System.out.println("Cantidad total de Samsungs: " + cont_Samsung);
    }
}