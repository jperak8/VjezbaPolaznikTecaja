import java.util.Objects;

public class Polaznik implements Comparable<Polaznik> {

    private String ime;
    private String prezime;
    private String email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Polaznik)){
            return false;
        }
        Polaznik polaznik = (Polaznik) o;
        return email.equalsIgnoreCase(polaznik.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email.toLowerCase());
    }

    @Override
    public String toString() {
        return "Polaznik: " + getIme() + " " + getPrezime() + " " + getEmail();
    }

    @Override
    public int compareTo(Polaznik other) {
        int prezimeCompare = this.prezime.compareToIgnoreCase(other.prezime);
        if (prezimeCompare != 0) return prezimeCompare;

        int imeCompare = this.ime.compareToIgnoreCase(other.ime);
        if (imeCompare != 0) return imeCompare;

        return this.email.compareToIgnoreCase(other.email);
    }
}
