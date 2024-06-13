import javax.swing.JOptionPane;

public class Pelea {

	private Peleador peleador1;
	private String evento;
	
	
	
	
        public Pelea(Peleador peleador1, String evento) {
		super();
		this.peleador1 = peleador1;
		this.evento = evento;
		
		
    	}
        public Pelea() {
        	
    
        	
        }




		public Peleador IniciarPelea(Peleador peleador1, Peleador peleador2) {
            
            int resultado = (int) (Math.random()*10) + 1;
            int round = (int) (Math.random()*3) + 1;
            
            System.out.println("resultado " + resultado );
            System.out.println("round " + round );
            if (resultado >= 1 && resultado <= 5 && resultado != 3 && resultado != 2 ) {
                JOptionPane.showMessageDialog(null, "Ganador por decisión de los jueces: " + peleador1.getNombre()  + "\nEn el round: Nº" +round);
                return peleador1;
            } else  {
               if ( resultado == 3 ) {
            	   JOptionPane.showMessageDialog(null, "Ganador por KO: " + peleador1.getNombre() + "\nEn el round: Nº" +round );
                   return peleador1;
			} else {
				if (resultado >= 6 && resultado <= 10 && resultado != 8 && resultado != 9) {
					JOptionPane.showMessageDialog(null, "Ganador por decisión de los jueces: " + peleador2.getNombre()+ "\nEn el round: Nº" +round);
	                return peleador2;
				} else {
					if (resultado == 8) {
						JOptionPane.showMessageDialog(null, "Victoria por KO del peleador " + peleador2.getNombre()+ "\nEn el round: Nº" +round);
		                return peleador2;
					} else {
						if (resultado == 2) {
							JOptionPane.showMessageDialog(null, "Victoria por sumisión del peleador " + peleador1.getNombre()+ "\nEn el round: Nº" +round);
							return peleador1;
						} else {
							if (resultado == 9) {
								JOptionPane.showMessageDialog(null, "Victoria por sumisión del peleador " + peleador2.getNombre()+ "\nEn el round: Nº" +round);
								return peleador2;
							}
						}
					}
					}
					return peleador2;
            }
            /*
            int round2 = 0;
            for (int i = 0; i <3; i++) {
            	resultado = (int) (Math.random()*10) + 1;
	            

					}
				}
            }
               //-------------------  
            return peleador1;
			
			*/
			
        }
    }
     }

