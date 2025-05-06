package unicam.piattaforma_filiera_agricola.model.buyer;

import unicam.piattaforma_filiera_agricola.UtenteLoggato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrello {
    private final UtenteLoggato proprietario;
    private final List<RigaCarrello> righe = new ArrayList<>();

    public Carrello(UtenteLoggato proprietario) {
        this.proprietario = proprietario;
    }
    public UtenteLoggato getProprietario() { return proprietario; }
    public List<RigaCarrello> getRighe() { return Collections.unmodifiableList(righe); }
    void addRiga(RigaCarrello riga) { righe.add(riga); }
    void removeRiga(RigaCarrello riga) { righe.remove(riga); }
    void svuota() { righe.clear(); }
    public double calcolaTotale() {
        return righe.stream()
                .mapToDouble(r -> r.getProdotto().getPrezzo() * r.getQuantita())
                .sum();
    }
}