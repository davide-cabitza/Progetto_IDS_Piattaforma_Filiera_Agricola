package unicam.piattaforma_filiera_agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;
import unicam.piattaforma_filiera_agricola.repository.AnimatoreRepository;

@RestController
@RequestMapping("/api/animatori")
public class AnimatoreController {
    private final AnimatoreRepository animatoreRepository;

    @Autowired
    public AnimatoreController(AnimatoreRepository animatoreRepository) {
        this.animatoreRepository = animatoreRepository;
    }

    @PostMapping
    public ResponseEntity<AnimatoreFiliera> createAnimatore (@RequestBody AnimatoreFiliera animatoreFiliera) {
        AnimatoreFiliera saved = animatoreRepository.save(animatoreFiliera);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
