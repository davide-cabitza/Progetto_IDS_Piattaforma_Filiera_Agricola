package unicam.piattaforma_filiera_agricola.model.animatore;

public class Invitation {
    private final String idInvito;
    private final Invitatore mittente;
    private final Venditore destinatario;
    private final Evento evento;
    private final LocalDateTime dataInvio;
    private InvitationStatus status;

    public Invitation(String idInvito,
                      Invitatore mittente,
                      Venditore destinatario,
                      Evento evento,
                      LocalDateTime dataInvio) {
        this.idInvito = idInvito;
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.evento = evento;
        this.dataInvio = dataInvio;
        this.status = InvitationStatus.PENDING;
    }
    public String getIdInvito() { return idInvito; }
    public Invitatore getMittente() { return mittente; }
    public Venditore getDestinatario() { return destinatario; }
    public Evento getEvento() { return evento; }
    public LocalDateTime getDataInvio() { return dataInvio; }
    public InvitationStatus getStatus() { return status; }
    public void setStatus(InvitationStatus status) { this.status = status; }
}
