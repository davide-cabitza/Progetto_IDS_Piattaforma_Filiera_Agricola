package unicam.piattaforma_filiera_agricola.model.animatore;

import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

@Entity
public class Invito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AnimatoreFiliera sender;

    @ManyToOne
    private Venditore receiver;

    @ManyToOne
    private Evento event;

    private String description;

    private boolean accepted;

    public Invito(AnimatoreFiliera sender, Venditore receiver, Evento event, String description) {
        this.sender = sender;
        this.receiver = receiver;
        this.event = event;
        this.description = description;
        this.accepted = false;
    }

    public Invito() {}

    public AnimatoreFiliera getSender() {
        return sender;
    }

    public void setSender(AnimatoreFiliera sender) {
        this.sender = sender;
    }

    public Venditore getReceiver() {
        return receiver;
    }

    public void setReceiver(Venditore receiver) {
        this.receiver = receiver;
    }

    public Evento getEvent() {
        return event;
    }

    public void setEvent(Evento event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Long getId() {
        return id;
    }
}
