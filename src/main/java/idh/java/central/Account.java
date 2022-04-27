package idh.java.central;

import java.util.HashMap;
import java.util.Iterator;

public class Account {

    //kontoStand des Inhabers als float
    private float kontoStand;

    public int kontoNummer;

    //HashMap mit Key (Kontonummer) und Value (Konto bzw. Kontostand)


    //Konstruktor
    Account(float kontoStand, int kontoNummer) {
        this.kontoStand = kontoStand;
        this.kontoNummer = kontoNummer;

        //Befüllen der HashMap mit kontoNummer und Konto (this)
        //konten.put(kontoNummer, this);
    }

    //GETTER getKontostand
    public float getKontoStand() {
        return kontoStand;
    }




    //geldAbheben erfolgreich ja oder nein
    public boolean geldAbheben(int betrag) {
        if (betrag > this.kontoStand) {
            System.out.println("Du hast nicht genug Geld auf deinem Konto!");
            return false;
        }
        kontoStand -= betrag;
        System.out.println("Hier ist dein Geld!, dein neuer Kontostand: " + kontoStand + " Euro");
        return true;


    }



}
