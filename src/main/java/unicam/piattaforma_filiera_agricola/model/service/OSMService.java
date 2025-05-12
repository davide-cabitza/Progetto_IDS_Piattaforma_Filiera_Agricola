package unicam.piattaforma_filiera_agricola.model.service;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

/**
 * Servizio che, dato un prodotto, torna l'indirizzo (embedded) del venditore.
 */
public class OSMService {

    /**
     * Restituisce l'oggetto Indirizzo del venditore di un prodotto.
     * @param prodotto il prodotto di cui vogliamo l'indirizzo venditore
     * @return l'Indirizzo del venditore (street + number)
     */
    public Indirizzo getIndirizzoVenditore(Prodotto prodotto) {
        // qui si assume che Prodotto abbia un metodo getVenditore()
        // che restituisce un UtenteLoggato con embedded Indirizzo
        return prodotto.getVenditore().getIndirizzo();
    }

    /**
     * Sovraccarico che restituisce una stringa human-readable.
     */
    public String getIndirizzoString(Prodotto prodotto) {
        Indirizzo ind = getIndirizzoVenditore(prodotto);
        return ind.getAddress() + ", " + ind.getNumber();
    }
}