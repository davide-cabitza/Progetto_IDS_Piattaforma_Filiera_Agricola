package unicam.piattaforma_filiera_agricola.model.curatore;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

public class NotaEsplicativa {

    private String spiegazione;
    private final Curatore mittente;
    private final Venditore destinatario;


    public NotaEsplicativa(String spiegazione, Curatore mittente, Venditore destinatario) {
        this.spiegazione = spiegazione;
        this.mittente = mittente;
        this.destinatario = destinatario;
    }
}
