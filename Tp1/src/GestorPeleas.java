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
    
    public class Pelea {

        public Peleador IniciarPelea(Peleador peleador1, Peleador peleador2) {
            
            int resultado = (int) (Math.random()*10) + 1;
            int round = (int) (Math.random()*3) + 1;
            
            System.out.println("resultado " + resultado );
            System.out.println("round " + round );

            JOptionPane.showMessageDialog(null, "Finalizo en el Round: Nº"+round);
            if (resultado >= 1 && resultado <= 5 && resultado != 3 && round == 3) {
                JOptionPane.showMessageDialog(null, "Ganador por decisión de los jueces: " + peleador1.getNombre());
                return peleador1;
            } else if (resultado >= 6 && resultado <= 10 && resultado != 8 && round == 3) {
                JOptionPane.showMessageDialog(null, "Ganador por decisión de los jueces: " + peleador2.getNombre());
                return peleador2;
            } else if (resultado == 3 && round != 3) {
                JOptionPane.showMessageDialog(null, "Victoria por KO del peleador " + peleador1.getNombre());
                return peleador1;
            } else if(resultado == 8 && round != 3){
                JOptionPane.showMessageDialog(null, "Victoria por KO del peleador " + peleador2.getNombre());
                return peleador2;
            }
            //-------------------
            if (resultado >= 1 && resultado <= 5 ) {
                JOptionPane.showMessageDialog(null, "Ganador por decisión de los jueces: " + peleador1.getNombre()  + " En el round " +round);
                return peleador1;
            } else  {
               if ( resultado == 3 ) {
            	   JOptionPane.showMessageDialog(null, "Ganador por KO: " + peleador1.getNombre() + " En el round " +round );
                   return peleador1;
			} else {

			}
              //-------------------  
            return peleador1;
			
			
			
        }
    }
}
