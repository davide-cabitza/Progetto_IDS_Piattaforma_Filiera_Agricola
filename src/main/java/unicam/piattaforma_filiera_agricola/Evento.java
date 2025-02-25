package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public class Evento {
    int id;
    String nomeEvento;
    String tipologia;
    String descrizione;
    Date data;
    String link;
    String luogoEvento;

    public Evento(int id, String nomeEvento, String tipologia, String descrizione, Date data, String link, String luogoEvento) {
        this.id = id;
        this.nomeEvento = nomeEvento;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.data = data;
        this.link = link;
        this.luogoEvento = luogoEvento;

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
}
