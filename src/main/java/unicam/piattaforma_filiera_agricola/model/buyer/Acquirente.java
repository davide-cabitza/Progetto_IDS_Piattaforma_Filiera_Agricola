package unicam.piattaforma_filiera_agricola.model.buyer;

import unicam.piattaforma_filiera_agricola.handler.HandlerCarrello;
import unicam.piattaforma_filiera_agricola.handler.HandlerOrdine;
import unicam.piattaforma_filiera_agricola.model.platform.Marketplace;
import unicam.piattaforma_filiera_agricola.model.service.OSMService;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.user.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Rappresenta un Acquirente che può cercare prodotti, gestire il carrello,
 * acquistare, utilizzare servizi esterni (OSM) ed eliminare il profilo.
 */
public class Acquirente extends UtenteLoggato {
    public Acquirente() {super();}
}
