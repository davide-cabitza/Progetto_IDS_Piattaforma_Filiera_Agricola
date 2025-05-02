package unicam.piattaforma_filiera_agricola.model.payment;

public class PagoPaPayment implements IPaymentMethod {

    @Override
    public void eseguiPagamento(double importo) {
        System.out.println("Pagamento tramite PagoPa: €" + importo);
    }
}
