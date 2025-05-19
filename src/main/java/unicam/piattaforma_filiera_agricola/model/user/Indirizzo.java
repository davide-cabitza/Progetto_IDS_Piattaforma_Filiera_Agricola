package unicam.piattaforma_filiera_agricola.model.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Indirizzo {
    private String address;
    private int number;

    public Indirizzo(String address, int number) {
        this.address = address;
        this.number = number;
    }

    public Indirizzo() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.address + " " + this.number;
    }
}
