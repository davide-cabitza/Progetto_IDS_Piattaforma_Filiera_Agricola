package unicam.piattaforma_filiera_agricola.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.piattaforma_filiera_agricola.model.user.Notifica;
import unicam.piattaforma_filiera_agricola.repository.NotificaRepository;

import java.util.List;

@Service
public class HandlerNotifica {

    private final NotificaRepository notificaRepository;

    @Autowired
    public HandlerNotifica(NotificaRepository notificaRepository) {
        this.notificaRepository = notificaRepository;
    }

    public Notifica creaNotifica (String messaggio, Long utenteId){
        Notifica notifica = new Notifica(messaggio, utenteId);
        System.out.println("Creazione notifica per utente " + utenteId + ": " + messaggio);
        return notificaRepository.save(notifica);
    }

    public List<Notifica> getNotifichePerUtente(Long utenteId) {
        return notificaRepository.findByUtenteId(utenteId);
    }

}
