package unicam.piattaforma_filiera_agricola.event;

import unicam.piattaforma_filiera_agricola.seller.Venditore;

import java.util.Date;
import java.util.List;

public class Evento {
    private int id;
    private String nomeEvento;
    private String tipologia;
    private String descrizione;
    private Date data;
    private String link;
    private String luogoEvento;
    private AnimatoreFiliera creatore;
    private List<Venditore> venditoriInvitati;


    public Evento(int id, String nomeEvento, String tipologia, String descrizione, Date data, String link, String luogoEvento,AnimatoreFiliera creatore) {
        this.id = id;
        this.nomeEvento = nomeEvento;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.data = data;
        this.link = link;
        this.luogoEvento = luogoEvento;
        this.creatore = creatore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLuogoEvento() {
        return luogoEvento;
    }

    public void setLuogoEvento(String luogoEvento) {
        this.luogoEvento = luogoEvento;
    }

    public List<Venditore> getVenditoriInvitati() {
        return venditoriInvitati;
    }

    public void aggiungiInvitato(Venditore venditore) {
        if (!venditoriInvitati.contains(venditore)) {
            venditoriInvitati.add(venditore);
            System.out.println("Venditore " + venditore.getNome() + " invitato all'evento: " + nomeEvento);
        } else {
            System.out.println("Il venditore " + venditore.getNome() + " è già stato invitato.");
        }
    }


    public AnimatoreFiliera getCreatore() {
        return creatore;
    }
}
