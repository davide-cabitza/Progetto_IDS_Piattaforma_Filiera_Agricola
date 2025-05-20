package unicam.piattaforma_filiera_agricola.handler;

import org.springframework.stereotype.Service;
import unicam.piattaforma_filiera_agricola.model.animatore.Invito;

import java.util.ArrayList;
import java.util.List;

@Service
public class HandlerInvito {
    private List<Invito> invite;

    public HandlerInvito(List<Invito> invite) {
        this.invite = (invite != null) ? invite : new ArrayList<>();
    }

    public List<Invito> getInvite() {
        return invite;
    }

    public void setInvite(List<Invito> invite) {
        this.invite = (invite != null) ? invite : new ArrayList<>();
    }

    public void addInvite(Invito invite) {
        if (invite != null) {
            this.invite.add(invite);
        }
    }

    public void manageInvite(int id) {
        for (Invito invito : invite) {
            if (invito.getId() == id) {
                // Logica per gestire l'invito
                System.out.println("Managing invite with ID: " + id);
            }
        }
    }

    public Invito getInviteById(int id) {
        for (Invito invito : invite) {
            if (invito.getId() == id) {
                return invito;
            }
        }
        return null;
    }
}
