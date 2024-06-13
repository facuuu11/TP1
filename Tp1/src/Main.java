import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Peleador peleador1 = new Peleador("McGregor", 35, 71, 175,"Ligero");
        Peleador peleador2 = new Peleador("Porier", 35, 70, 175,"Ligero");
        Peleador peleador3 = new Peleador("Oliveira", 34, 70, 178,"Ligero");
        Peleador peleador4 = new Peleador("Holloway", 35, 68, 180,"Ligero");
        Peleador peleador5 = new Peleador("Gaethje", 35, 70, 180,"Ligero");
        Peleador peleador6 = new Peleador("Nurmagomedov", 35, 70, 178,"Ligero");
        Peleador peleador7 = new Peleador("Diaz", 39, 71, 183,"Ligero");
        Peleador peleador8 = new Peleador("Ferguson", 40, 71, 180,"Ligero");
        Peleador peleador9 = new Peleador("Ponzinibbio", 37, 77, 183,"Welter");
        Peleador peleador10 = new Peleador("Edwards", 32, 77, 183,"Welter");
        Peleador peleador11 = new Peleador("Usman", 37, 80, 183,"Welter");
        Peleador peleador12 = new Peleador("Masvidal", 39, 77, 180,"Welter");
        Peleador peleador13 = new Peleador("Burns", 37, 77, 178,"Welter");
        Peleador peleador14 = new Peleador("Woodley", 42, 77, 175,"Welter");
        Peleador peleador15 = new Peleador("Chimaev", 32, 80, 188,"Welter");
        Peleador peleador16 = new Peleador("Covington", 36, 77, 180,"Welter");
        Peleador peleador17 = new Peleador("Jones", 36, 113, 193,"Pesado");
        Peleador peleador18 = new Peleador("Ngannou", 37, 124, 180,"Pesado");
        Peleador peleador19 = new Peleador("Miocic", 41, 109, 193,"Pesado");
        Peleador peleador20 = new Peleador("Lesnar", 46, 124, 191,"Pesado");
        Peleador peleador21 = new Peleador("Cormier", 45, 114, 175,"Pesado");
        Peleador peleador22 = new Peleador("Aspinall", 31, 119, 196,"Pesado");
        Peleador peleador23 = new Peleador("Gane", 34, 112, 193,"Pesado");
        Peleador peleador24 = new Peleador("Lewis", 39, 120, 190,"Pesado");

        String[] opciones = {"Iniciar Pelea", "Agregar Luchador", "Salir"};

        GestorPeleas gestor = new GestorPeleas();
        gestor.getPeleadores().add(peleador1);
        gestor.getPeleadores().add(peleador2);
        gestor.getPeleadores().add(peleador3);
        gestor.getPeleadores().add(peleador4);
        gestor.getPeleadores().add(peleador5);
        gestor.getPeleadores().add(peleador6);
        gestor.getPeleadores().add(peleador7);
        gestor.getPeleadores().add(peleador8);
        gestor.getPeleadores().add(peleador9);
        gestor.getPeleadores().add(peleador10);
        gestor.getPeleadores().add(peleador11);
        gestor.getPeleadores().add(peleador12);
        gestor.getPeleadores().add(peleador13);
        gestor.getPeleadores().add(peleador14);
        gestor.getPeleadores().add(peleador15);
        gestor.getPeleadores().add(peleador16);
        gestor.getPeleadores().add(peleador17);
        gestor.getPeleadores().add(peleador18);
        gestor.getPeleadores().add(peleador19);
        gestor.getPeleadores().add(peleador20);
        gestor.getPeleadores().add(peleador21);
        gestor.getPeleadores().add(peleador22);
        gestor.getPeleadores().add(peleador23);
        gestor.getPeleadores().add(peleador24);
        int opcion = 0;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Bienvenido al simulador de peleas UFC", null, 0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    String[] categorias = {"Ligero", "Welter","Pesado"};
                    String categoriaElegida = (String) JOptionPane.showInputDialog(null, "Selecciona la categoría de peleadores", "Selección de Categoría", JOptionPane.QUESTION_MESSAGE, null, categorias, categorias[0]);
                    if (categoriaElegida != null) {
                        LinkedList<Peleador> peleadoresCategoria = obtenerPeleadoresPorCategoria(gestor.getPeleadores(), categoriaElegida);
                        if (peleadoresCategoria.size() < 2) {
                            JOptionPane.showMessageDialog(null, "No hay suficientes peleadores en la categoría " + categoriaElegida + " para iniciar una pelea.");
                        } else {
                            int p1 = seleccionarPeleador(peleadoresCategoria);
                            int p2 = seleccionarPeleador(peleadoresCategoria);
                            while (p1 == p2) {
                                JOptionPane.showMessageDialog(null, "No puedes seleccionar el mismo peleador. Elige de nuevo.");
                                p1 = seleccionarPeleador(peleadoresCategoria);
                                p2 = seleccionarPeleador(peleadoresCategoria);
                            }
                            gestor.JugarPartido(peleadoresCategoria.get(p1), peleadoresCategoria.get(p2));
                        }
                    }
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
    
    public static LinkedList<Peleador> obtenerPeleadoresPorCategoria(LinkedList<Peleador> peleadores, String categoria) {
        LinkedList<Peleador> filtro = new LinkedList<Peleador>();
        for (Peleador peleador : peleadores) {
            if (peleador.getCategoria().equals(categoria)) {
                filtro.add(peleador);
            }
        }
        return filtro;
    }
}

