import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GestorPeleas {

    private LinkedList<Peleador> peleadores = new LinkedList<Peleador>();

    public GestorPeleas() {
        super();
    }

    public LinkedList<Peleador> getPeleadores() {
        return peleadores;
    }

    public void setPeleadores(LinkedList<Peleador> peleadores) {
        this.peleadores = peleadores;
    }
    
    public Peleador JugarPartido(Peleador peleador1, Peleador peleador2) {
        Pelea pelea = new Pelea();
        return pelea.IniciarPelea(peleador1, peleador2);
    }
    
    public void agregarManualmente() {
        String nombre ="";
        do {   
            nombre= JOptionPane.showInputDialog("Ingresar nombre");
        } while (nombre.isEmpty());
        
        int edad=0;
        do {
            edad =Integer.parseInt(JOptionPane.showInputDialog("Ingresar edad"));
        } while (edad < 18 || edad > 40);
        
        int peso=0;
        do {
            peso = Integer.parseInt(JOptionPane.showInputDialog("Ingresar peso"));
        } while (peso < 68 || peso > 71);
        
        int altura=0;
        do {
            altura = Integer.parseInt(JOptionPane.showInputDialog("Ingresar altura (En Cm)"));
        } while (altura < 160);
        
        Peleador nuevo = new Peleador(nombre,edad,peso,altura);
        peleadores.add(nuevo);
    }
}

   