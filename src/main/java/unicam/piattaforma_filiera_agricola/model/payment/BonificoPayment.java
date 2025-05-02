package unicam.piattaforma_filiera_agricola.model.payment;

public class BonificoPayment implements IPaymentMethod{

    @Override
    public void eseguiPagamento(double importo) {
        System.out.println("Pagamento tramite bonifico bancario: €" + importo);
    }
}
