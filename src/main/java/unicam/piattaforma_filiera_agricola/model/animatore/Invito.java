package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

import java.time.LocalDateTime;

public class Invito {

    private final String idInvito;
    private final AnimatoreFiliera mittente;
    private final Venditore destinatario;
    private final Evento evento;
    private final LocalDateTime dataInvio;
    private String testo; // testo del messaggio di invito

    public Invito(String idInvito,
                  AnimatoreFiliera mittente,
                  Venditore destinatario,
                  Evento evento) {
        this.idInvito     = idInvito;
        this.mittente     = mittente;
        this.destinatario = destinatario;
        this.evento       = evento;
        this.dataInvio    = LocalDateTime.now();
        this.testo        = toString();
    }

    public String getIdInvito() {
        return idInvito;
    }

    public AnimatoreFiliera getMittente() {
        return mittente;
    }

    public Venditore getDestinatario() {
        return destinatario;
    }

    public Evento getEvento() {
        return evento;
    }

    public LocalDateTime getDataInvio() {
        return dataInvio;
    }

    public String getTesto() {
        return testo;
    }


    @Override
    public String toString() {
        return "Invito{" +
                "idInvito='" + idInvito + '\'' +
                ", mittente=" + mittente.getUsername() +
                ", destinatario=" + destinatario.getUsername() +
                ", evento=" + evento.getNome() +
                ", dataInvio=" + dataInvio +
                '}';
    }
}
