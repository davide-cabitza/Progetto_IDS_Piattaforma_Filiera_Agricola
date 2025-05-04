package unicam.piattaforma_filiera_agricola.model.curatore;

import java.time.LocalDateTime;


public class RichiestaPubblicazione {
    private final String idRichiesta;
    private final String idRichiedente;
    private final String idProdotto; // o pacchetto
    private final LocalDateTime dataRichiesta;
    private StatoRichiesta stato;
    private String motivazioneRifiuto;

    public RichiestaPubblicazione(String idRichiesta,
                                  String idRichiedente,
                                  String idProdotto,
                                  LocalDateTime dataRichiesta) {
        this.idRichiesta = idRichiesta;
        this.idRichiedente = idRichiedente;
        this.idProdotto = idProdotto;
        this.dataRichiesta = dataRichiesta;
        this.stato = StatoRichiesta.IN_ATTESA;
    }

    public String getIdRichiesta() {
        return idRichiesta;
    }

    public String getIdRichiedente() {
        return idRichiedente;
    }

    public String getIdProdotto() {
        return idProdotto;
    }

    public LocalDateTime getDataRichiesta() {
        return dataRichiesta;
    }

    public StatoRichiesta getStato() {
        return stato;
    }

    public String getMotivazioneRifiuto() {
        return motivazioneRifiuto;
    }

    /**
     * Aggiorna lo stato della richiesta.
     */
    public void setStato(StatoRichiesta stato) {
        this.stato = stato;
    }

    /**
     * Imposta la motivazione per il rifiuto.
     */
    public void setMotivazioneRifiuto(String motivazione) {
        this.motivazioneRifiuto = motivazione;
    }
}
