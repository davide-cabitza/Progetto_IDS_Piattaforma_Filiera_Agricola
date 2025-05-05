package unicam.piattaforma_filiera_agricola.service;

public class OSMService {
    public String getMappaUrl(String indirizzo) {
        String baseUrl = "https://www.openstreetmap.org/search?query=";
        return baseUrl + encode(indirizzo);
    }

    /**
     * Codifica l'indirizzo per essere passato nell'URL.
     */
    private String encode(String input) {
        if (input == null) {
            return "";
        }
        // Sobrio encoding spazi e caratteri speciali
        return input.trim().replace(" ", "%20");
    }
}

