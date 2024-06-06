import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Peleador peleador1 = new Peleador("McGregor", 35, 71, 175);
        Peleador peleador2 = new Peleador("Porier", 35, 70, 175);
        Peleador peleador3 = new Peleador("Oliveira", 34, 70, 178);
        Peleador peleador4 = new Peleador("Holloway", 35, 68, 180);

        String[] opciones = {"Iniciar Pelea", "Agregar Luchador", "Salir"};

        GestorPeleas gestor = new GestorPeleas();
        gestor.getPeleadores().add(peleador1);
        gestor.getPeleadores().add(peleador2);
        gestor.getPeleadores().add(peleador3);
        gestor.getPeleadores().add(peleador4);

        int opcion = 0;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Bienvenido al simulador de peleas UFC", null, 0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    int p1 = seleccionarPeleador(gestor.getPeleadores());
                    int p2 = seleccionarPeleador(gestor.getPeleadores());
                    
                    while (p1 == p2) {
                        JOptionPane.showMessageDialog(null, "No puedes seleccionar el mismo peleador. Elige de nuevo.");
                        p1 = seleccionarPeleador(gestor.getPeleadores());
                        p2 = seleccionarPeleador(gestor.getPeleadores());
                    }
                    
                    gestor.JugarPartido(gestor.getPeleadores().get(p1),
                                    gestor.getPeleadores().get(p2));
                    break;
                case 1:
                    gestor.agregarManualmente();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
            }

        } while (opcion != 2);
    }

    public static int seleccionarPeleador(LinkedList<Peleador> peleadores) {
        String[] nombres = new String[peleadores.size()];
        for (int i = 0; i < peleadores.size(); i++) {
            nombres[i] = peleadores.get(i).getNombre();
        }
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione un peleador", "Seleccionar Peleador",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, nombres, nombres[0]);
        return seleccion;
    }
}

