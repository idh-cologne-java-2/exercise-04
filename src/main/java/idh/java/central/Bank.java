package idh.java.central;

import java.util.HashMap;
import java.util.Iterator;

public class Bank implements Iterable<Account>{

    private final HashMap<Integer, Account> konten = new HashMap<>();

    public Account erstelleKonto(float kontoStand, int kontoNummer){
        Account account = new Account(kontoStand, kontoNummer);

        konten.put(kontoNummer,account);

        return account;

    }

    //Aufruf Default Konstruktor "AccountIterator"
    @Override
    public Iterator<Account> iterator() {
        return new AccountIterator();
    }

    //Prüfen ob Kontonummer existiert
    //Wenn keine existiert - Exception werfen
    public Account getKonto(int kontoNummer) throws Exception {

        Iterator<Account> it = iterator();
       // if (!kontoExistiert(kontoNummer)) {
        // throw new Exception("Konto gibt es nicht!");
        // }

        while(it.hasNext())
        {
            Account ac = it.next();
            if(ac.kontoNummer == kontoNummer)
            {
                return ac;
            }
        }
        throw new Exception("Konto gibt es nicht!");

        //extrahiere Konto aus HashMap
        // return konten.get(kontoNummer);
    }

    //Funktion, ob Konto mit angegebener KontoNr. existiert
    public boolean kontoExistiert(int kontoNummer) {

        //return konten.containsKey(kontoNummer);
        Iterator<Account> it = iterator();
        while(it.hasNext())
        {
            Account ac = it.next();
            if(ac.kontoNummer == kontoNummer)
            {
                return true;
            }
        }
        return false;
    }

    //Inner Class "AccountIterator"
    public class AccountIterator implements Iterator<Account> {

        Iterator<Account> iteratorAccount = konten.values().iterator();

        @Override
        public boolean hasNext() {
            return iteratorAccount.hasNext();
        }

        @Override
        public Account next() {
            return iteratorAccount.next();
        }
    }
}
