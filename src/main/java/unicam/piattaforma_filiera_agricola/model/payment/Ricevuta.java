// src/main/java/com/example/filiera_francoletti_belardinelli_raiola/model/payment/Ricevuta.java
package unicam.piattaforma_filiera_agricola.model.payment;

/**
 * Rappresenta la ricevuta di un pagamento,
 * contenente il testo dettagliato della transazione.
 */
public class Ricevuta {

    private final String invoiceText;

    /**
     * Costruisce una ricevuta con il contenuto testuale fornito.
     *
     * @param invoiceText testo della ricevuta
     */
    public Ricevuta(String invoiceText) {
        this.invoiceText = invoiceText;
    }

    /**
     * Restituisce il testo completo della ricevuta.
     */
    public String getInvoiceText() {
        return invoiceText;
    }

    @Override
    public String toString() {
        return "Ricevuta{" +
                "invoiceText='" + invoiceText + '\'' +
                '}';
    }
}