import java.util.*;

public class EvidencijaPolaznika {

    private static Set<Polaznik> polaznici = new HashSet<>();

    public static void main(String[] args) {

        Scanner skener = new Scanner(System.in);
        String nastavi;

        System.out.println("------ Unos polaznika tečaja ------");

        do {
            System.out.print("Ime: ");
            String ime = skener.nextLine();

            System.out.print("Prezime: ");
            String prezime = skener.nextLine();

            System.out.print("Email: ");
            String email = skener.nextLine();

            Polaznik noviPolaznik = new Polaznik(ime, prezime, email);
            if (polaznici.contains(noviPolaznik)) {
                System.out.println("GREŠKA! Polaznik s tim emailom je već dodan!");
            } else {
                polaznici.add(noviPolaznik);
                System.out.println("Polaznik uspješno dodan!");
            }

            System.out.print("Želite li dodati još jednog polaznika? (da/ne): ");
            nastavi = skener.nextLine().trim().toLowerCase();

        } while (nastavi.equals("da"));

        ArrayList<Polaznik> sortiraniPolaznici = new ArrayList<>(polaznici);
        sortiraniPolaznici.sort(Comparator
                .comparing(Polaznik::getPrezime, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Polaznik::getIme, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Polaznik::getEmail, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\n------ Popis svih polaznika na tečaju sortirani po prezimenu ------");
        for (Polaznik p : sortiraniPolaznici) {
            System.out.println(p);
        }

        skener.close();
    }

}
