package unicam.piattaforma_filiera_agricola.payment;

public class CardPayment implements IPaymentMethod {

        @Override
        public void eseguiPagamento(double importo) {
            System.out.println("Pagamento con carta di credito: €" + importo);
        }
}
