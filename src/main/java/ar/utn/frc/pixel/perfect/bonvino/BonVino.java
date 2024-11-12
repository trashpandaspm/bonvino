package ar.utn.frc.pixel.perfect.bonvino;

import ar.utn.frc.pixel.perfect.bonvino.interfaz.Principal;


public class BonVino {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Principal principal = new Principal();
                
                principal.setVisible(true);
                
                principal.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }
}
