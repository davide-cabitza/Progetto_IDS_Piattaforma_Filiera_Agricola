package unicam.piattaforma_filiera_agricola.model.user;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Notifica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messaggio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNotifica;

    private Long utenteId;

    public Notifica() {}

    public Notifica(String messaggio, Long utenteId) {
        this.messaggio = messaggio;
        this.utenteId = utenteId;
        this.dataNotifica = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public Date getDataNotifica() {
        return dataNotifica;
    }

    public void setDataNotifica(Date dataNotifica) {
        this.dataNotifica = dataNotifica;
    }

    public Long getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(Long utenteId) {
        this.utenteId = utenteId;
    }
}
