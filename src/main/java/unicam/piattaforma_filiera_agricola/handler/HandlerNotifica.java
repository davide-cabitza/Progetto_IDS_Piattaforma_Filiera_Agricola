package unicam.piattaforma_filiera_agricola.handler;

import org.springframework.stereotype.Service;

@Service
public class HandlerNotifica {



    public void inviaNotifica(int id_destinatario, String messaggio) {
        System.out.println("Notifica: " + messaggio);
    }
}
