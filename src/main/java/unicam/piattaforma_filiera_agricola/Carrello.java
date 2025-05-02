package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum StatoProdottoCarrello { ATTIVO, RIMOSSO }

public class Carrello {
    private final UtenteLoggato proprietario;
    private final List<RigaCarrello> righe;

    public Carrello(UtenteLoggato proprietario) {
        this.proprietario = proprietario;
        this.righe = new ArrayList<>();
    }

    public UtenteLoggato getProprietario() {
        return proprietario;
    }

    public List<RigaCarrello> getRighe() {
        return Collections.unmodifiableList(righe);
    }

    void addRiga(RigaCarrello riga) {
        righe.add(riga);
    }

    void removeRiga(RigaCarrello riga) {
        righe.remove(riga);
    }

    public void svuota() {
        righe.clear();
    }

    public double calcolaTotale() {
        return righe.stream()
                .mapToDouble(r -> r.getProdotto().getPrezzo() * r.getQuantita())
                .sum();
    }



}
