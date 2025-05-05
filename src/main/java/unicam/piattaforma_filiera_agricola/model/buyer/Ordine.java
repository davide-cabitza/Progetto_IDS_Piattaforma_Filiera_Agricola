package unicam.piattaforma_filiera_agricola.model.buyer;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un ordine effettuato da un Acquirente.
 */
public class Ordine {
    private final String idOrdine;
    private final List<RigaCarrello> righe;
    private final LocalDateTime dataCreazione;
    private String stato;  // es. "CREATO", "PAGATO", "CONFERMATO"
    private double totale;

    public Ordine(String idOrdine, List<RigaCarrello> righe, LocalDateTime dataCreazione) {
        this.idOrdine = idOrdine;
        this.righe = new ArrayList<>(righe);
        this.dataCreazione = dataCreazione;
        this.stato = "CREATO";
        this.totale = calcolaTotale();
    }

    public String getIdOrdine() {
        return idOrdine;
    }

    public List<RigaCarrello> getRighe() {
        return new ArrayList<>(righe);
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public double getTotale() {
        return totale;
    }

    /**
     * Ricalcola e restituisce il totale dell'ordine.
     */
    public double calcolaTotale() {
        return righe.stream()
                .mapToDouble(r -> r.getProdotto().getPrezzo() * r.getQuantita())
                .sum();
    }
}
