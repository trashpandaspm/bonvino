package ar.utn.frc.pixel.perfect.bonvino;

import ar.utn.frc.pixel.perfect.bonvino.interfaz.Principal;
import ar.utn.frc.pixel.perfect.bonvino.repositorios.contexto.DbContext;


public class BonVino {
    public static void main(String[] args){
        DbContext db = db.getInstance();
        Principal principal = new Principal();
        principal.setVisible(true);
    }
}
