package unicam.piattaforma_filiera_agricola;

public enum CategoriaProdotto {
    FRUTTA,
    VERDURA,
    LATTICINI,
    CARNE,
    PESCE,
    BEVANDE,
    PRODOTTI_DA_FORNO,
    LEGUMI,
    CEREALI,
    SALUMI,
    DOLCI;

    public String getNomeFormattato() {
        return this.name().toLowerCase().replace("_", " ");
    }
}
