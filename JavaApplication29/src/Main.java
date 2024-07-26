import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static Tigo tigo = new Tigo();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Planes Tigo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Menú de Opciones", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton addPlanButton = new JButton("1- Agregar Plan");
        JButton pagoPlanButton = new JButton("2- Pago Plan");
        JButton agregarAmigoButton = new JButton("3- Agregar Amigo");
        JButton listarButton = new JButton("4- Listar");
        JButton salirButton = new JButton("5- Salir");

        panel.add(addPlanButton);
        panel.add(pagoPlanButton);
        panel.add(agregarAmigoButton);
        panel.add(listarButton);
        panel.add(salirButton);

        frame.add(panel, BorderLayout.CENTER);

        
        addPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField telefonoField = new JTextField();
                JTextField nombreField = new JTextField();
                JTextField extraField = new JTextField();
                JTextField tipoField = new JTextField();

                Object[] message = {
                    "Número de Teléfono:", telefonoField,
                    "Nombre del Cliente:", nombreField,
                    "Email o PIN:", extraField,
                    "Tipo de Plan (IPHONE/SAMSUNG):", tipoField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Agregar Plan", JOptionPane.OK_CANCEL_OPTION);
                if (nombreField.getText().isEmpty()==true){
                    JOptionPane.showMessageDialog(null, "Ingresas Datos");
                    nombreField.requestFocus();
                }
                
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int telefono = Integer.parseInt(telefonoField.getText());
                        String nombre = nombreField.getText();
                        String extra = extraField.getText();
                        String tipo = tipoField.getText();

                        tigo.agregarPlan(telefono, nombre, extra, tipo);
                        JOptionPane.showMessageDialog(null, "Plan agregado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Número de teléfono inválido.");
                    }
                }
            }
        });

        
        pagoPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField telefonoField = new JTextField();
                JTextField minutosField = new JTextField();
                JTextField mensajesField = new JTextField();

                Object[] message = {
                    "Número de Teléfono:", telefonoField,
                    "Minutos Consumidos:", minutosField,
                    "Mensajes Enviados:", mensajesField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Calcular Pago Plan", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int telefono = Integer.parseInt(telefonoField.getText());
                        int minutos = Integer.parseInt(minutosField.getText());
                        int mensajes = Integer.parseInt(mensajesField.getText());

                        double pago = tigo.pagoPlan(telefono, minutos, mensajes);
                        if (pago != 0) {
                            JOptionPane.showMessageDialog(null, "El pago mensual es: " + pago);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Datos inválidos.");
                    }
                }
            }
        });

        
        agregarAmigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField telefonoField = new JTextField();
                JTextField pinField = new JTextField();

                Object[] message = {
                    "Número de Teléfono:", telefonoField,
                    "PIN del Amigo:", pinField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Agregar Amigo a Plan Samsung", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int telefono = Integer.parseInt(telefonoField.getText());
                        String pin = pinField.getText();

                        tigo.agregarAmigo(telefono, pin);
                        JOptionPane.showMessageDialog(null, "Amigo agregado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Número de teléfono inválido.");
                    }
                }
            }
        });

        
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder listaPlanes = new StringBuilder();
                int totalIphone = 0;
                int totalSamsung = 0;

                for (Plan plan : tigo.getPlanes()) {
                    listaPlanes.append(plan.imprimir()).append("\n\n");
                    if (plan instanceof PlanIphone) {
                        totalIphone++;
                    } else if (plan instanceof PlanSamsung) {
                        totalSamsung++;
                    }
                }

                listaPlanes.append("Cantidad total de IPhones: ").append(totalIphone).append("\n");
                listaPlanes.append("Cantidad total de Samsungs: ").append(totalSamsung).append("\n");

                JTextArea textArea = new JTextArea(listaPlanes.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);

                JOptionPane.showMessageDialog(null, scrollPane, "Listado de Planes", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
