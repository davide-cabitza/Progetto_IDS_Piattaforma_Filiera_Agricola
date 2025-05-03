package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.time.LocalDateTime;

public class RichiestaPubblicazione {
    private final String idRichiesta;
    private final UtenteLoggato richiedente;
    private final Prodotto prodotto;
    private StatoRichiesta stato;
    private String motivazioneRifiuto;
    private final LocalDateTime dataRichiesta;

    public RichiestaPubblicazione(String idRichiesta,
                                  UtenteLoggato richiedente,
                                  Prodotto prodotto,
                                  LocalDateTime dataRichiesta) {
        this.idRichiesta = idRichiesta;
        this.richiedente = richiedente;
        this.prodotto = prodotto;
        this.stato = StatoRichiesta.IN_ATTESA;
        this.dataRichiesta = dataRichiesta;
    }

    // Getter
    public String getIdRichiesta() {
        return idRichiesta;
    }

    public UtenteLoggato getRichiedente() {
        return richiedente;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public StatoRichiesta getStato() {
        return stato;
    }

    public String getMotivazioneRifiuto() {
        return motivazioneRifiuto;
    }

    public LocalDateTime getDataRichiesta() {
        return dataRichiesta;
    }

    // Setter per stato (usato dal Curatore)
    public void setStato(StatoRichiesta nuovoStato) {
        this.stato = nuovoStato;
    }

    // Setter per motivazione rifiuto (usato dal Curatore)
    public void setMotivazioneRifiuto(String motivazione) {
        this.motivazioneRifiuto = motivazione;
    }

    // Azioni sullo stato
    public void approva() {
        if (stato != StatoRichiesta.IN_ATTESA) {
            throw new IllegalStateException("Richiesta già gestita");
        }
        this.stato = StatoRichiesta.APPROVATA;
    }

    public void rifiuta(String motivazione) {
        if (stato != StatoRichiesta.IN_ATTESA) {
            throw new IllegalStateException("Richiesta già gestita");
        }
        this.stato = StatoRichiesta.RIFIUTATA;
        this.motivazioneRifiuto = motivazione;
    }
}

