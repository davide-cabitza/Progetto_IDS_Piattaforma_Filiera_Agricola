package unicam.piattaforma_filiera_agricola.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.repository.ProdottoRepository;
import unicam.piattaforma_filiera_agricola.repository.VenditoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HandlerVenditore {
    private final ProdottoRepository prodottoRepository;
    private final VenditoreRepository venditoreRepository;

    @Autowired
    public HandlerVenditore(ProdottoRepository prodottoRepository, VenditoreRepository venditoreRepository) {
        this.prodottoRepository = prodottoRepository;
        this.venditoreRepository = venditoreRepository;
    }

    public Prodotto createProduct(Venditore venditore,
                                  String nome,
                                  double costo,
                                  String descrizione,
                                  Indirizzo indirizzo) {
        if(venditore == null) {
            throw new RuntimeException("Venditore non trovato");
        }
        if(indirizzo == null) {
            throw new RuntimeException("Indirizzo non trovato");
        }
        Prodotto prodotto = venditore.createProdotto(nome, costo, descrizione);
        prodotto.setIndirizzo(indirizzo);
        return prodottoRepository.save(prodotto);
    }

    public Prodotto updateProdotto(Long id, Prodotto updatedProdotto) {
        Prodotto existing = prodottoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con id: " + id));
        existing.setNomeProdotto(updatedProdotto.getNomeProdotto());
        existing.setCosto(updatedProdotto.getCosto());
        existing.setDescrizione(updatedProdotto.getDescrizione());
        existing.setIndirizzo(updatedProdotto.getIndirizzo());
        return prodottoRepository.save(existing);
    }

    public Pacchetto creaPacchetto(Pacchetto pacchetto) {
        // Calcola il costo totale solo se la lista non è nulla o vuota
        if (pacchetto.getPacchetto() != null && !pacchetto.getPacchetto().isEmpty()) {
            double totale = pacchetto.getPacchetto().stream()
                    .mapToDouble(Prodotto::getCosto)
                    .sum();
            pacchetto.setCosto(totale);
        } else {
            // Se vuoi, imposta costo 0 per pacchetti vuoti
            pacchetto.setCosto(0.0);
        }

        // Puoi impostare anche lo stato a true di default
        pacchetto.setStato(true);

        return prodottoRepository.save(pacchetto);
    }


    public Optional<Venditore> findVenditoreById(Long id) {
        return venditoreRepository.findById(id);
    }

    public void deleteProdotto(Long id) {
        prodottoRepository.deleteById(id);
    }

    public Prodotto getProdottoById(Long id) {
        return prodottoRepository.findById(id).orElse(null);
    }

    public List<Prodotto> getAllProducts() {
        return prodottoRepository.findAll();
    }

}
