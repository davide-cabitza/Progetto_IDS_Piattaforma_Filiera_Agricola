package unicam.piattaforma_filiera_agricola;

public enum Certificati {
        BIOLOGICO("Certificazione Bio"),
        KM0("Prodotto a Km 0"),
        DOP("Denominazione di Origine Protetta"),
        IGP("Indicazione Geografica Protetta"),
        FAIR_TRADE("Certificato Fair Trade"),
        VEGANO("Prodotto Vegano"),
        GLUTEN_FREE("Senza Glutine");

    private final String descrizione;

    Certificati(String descrizione) {
        this.descrizione = descrizione;
    }
     public String getDescrizione() {return descrizione;}

}
