import java.nio.file.Path;
import java.util.*;

public class Main {

    private static final Path fichierEtudiants = Path.of(System.getProperty("user.dir")).resolve("files/Etudiants.txt");
    private static final Path fichierCours = Path.of(System.getProperty("user.dir")).resolve("files/Cours.txt");
    private static final Path fichierInscriptions = Path.of(System.getProperty("user.dir")).resolve("files/Inscriptions.txt");

    private static final List<Etudiant> etudiants = new ArrayList<>();
    private static final List<Cours> cours = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        while(true) {
            System.out.println("|                       MENU SELECTION                         |");
            System.out.println("|        1. Lire les données.                                  |");
            System.out.println("|        2. Ajouter un cours.                                  |");
            System.out.println("|        3. Ajouter un étudiant.                               |");
            System.out.println("|        4. Inscrire un étudiant à un cours.                   |");
            System.out.println("|        5. Déinscrire un étudiant d'un cours.                 |");
            System.out.println("|        6. Lister les étudiants inscrits à un cours.          |");
            System.out.println("|        7. Lister les cours suivis par un étudiant.           |");
            System.out.println("|        8. Sauvegarder les données.                           |");
            System.out.println("|        9. Quitter.                                           |");

            int selection;
            try {
                selection = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                continue;
            }

            switch (selection) {
                case 1:
                    lireFichiers();
                    break;
                case 2:
                    ajouterCours();
                    break;
                case 3:
                    ajouterEtudiant();
                    break;
                case 4:
                    inscrireEtudiant();
                    break;
                case 5:
                    desinscrireEtudiant();
                    break;
                case 6:
                    listerEtudiants();
                    break;
                case 7:
                    listerCours();
                    break;
                case 8:
                    ecrireFichiers();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Sélection invalide");
                    break;
            }
        }
    }

    private static Optional<Etudiant> trouverEtudiant(String codePermanent) {
        return etudiants.stream().filter(e -> e.getCodePermanent().equals(codePermanent)).findAny();
    }

    private static Optional<Cours> trouverCours(String sigle) {
        return cours.stream().filter(c -> c.getSigle().equals(sigle)).findAny();
    }

    private static int demanderInteger(String message) {
        while(true) {
            String entry = demanderString(message);
            try {
                return Integer.parseInt(entry);
            } catch(NumberFormatException e) {
            }
        }
    }

    private static float demanderFloat(String message) {
        while(true) {
            String entry = demanderString(message);
            try {
                return Float.parseFloat(entry);
            } catch(NumberFormatException e) {
            }
        }
    }

    private static String demanderString(String message) {
        System.out.print(message + "\n");
        while(true) {
            String entry = scanner.nextLine();
            if(entry.isBlank()) continue;
            return entry;
        }
    }

    private static Optional<Etudiant> demanderEtudiant() {
        if(etudiants.isEmpty()) return Optional.empty();
        while(true) {
            String input = demanderString("Entrez le code permanent de l'étudiant ou \"a\" pour annuler :");
            if(input.equals("a")) return Optional.empty();
            Optional<Etudiant> optEtudiant = trouverEtudiant(input);
            if(optEtudiant.isPresent()) return optEtudiant;
        }
    }

    private static Optional<Cours> demanderCours() {
        if(cours.isEmpty()) return Optional.empty();
        while(true) {
            String input = demanderString("Entrez le sigle du cours ou \"a\" pour annuler :");
            if(input.equals("a")) return Optional.empty();
            Optional<Cours> optCours = trouverCours(input);
            if(optCours.isPresent()) return optCours;
        }
    }

    private static void lireFichiers() {
        cours.clear();
        etudiants.clear();

        List<Cours> coursList = Reader.lireCours(fichierCours);
        cours.addAll(coursList);
        System.out.println(coursList.size() + " cours loadés.");

        List<Etudiant> etudiantsList = Reader.lireEtudiants(fichierEtudiants);
        etudiants.addAll(etudiantsList);
        System.out.println(etudiantsList.size() + " étudiants loadés.");

        Reader.lireInscriptions(fichierInscriptions).forEach((String code, List<String> sigle) ->
            trouverEtudiant(code).ifPresent(e -> sigle.forEach(s -> trouverCours(s).ifPresent(c -> {
                if(c.ajouterEtudiant(e))
                    e.ajouterCours(c);
            })))
        );
    }

    private static void ecrireFichiers() {
        Writer.ecrireCours(fichierCours, cours);
        Writer.ecrireEtudiants(fichierEtudiants, etudiants);
        Writer.ecrireInscriptions(fichierInscriptions, cours);
    }

    private static void ajouterCours() {
        String sigle = demanderString("Entrez le sigle :");
        String nom = demanderString("Entrez le nom :");
        int max = demanderInteger("Entrez le nombre maximum d'inscriptions :");

        List<String> prerequis = new ArrayList<>();

        while(true) {
            String r = demanderString("Entrez un prerequis ou \"t\" pour terminer :");
            if(r.equals("t"))
                break;
            if(trouverCours(r).isEmpty()){
                System.out.println("Erreur: Cours introuvable.");
                continue;
            }
            prerequis.add(r);
        }

        cours.add(new Cours(sigle, nom, max, prerequis));
    }

    private static void ajouterEtudiant() {
        String codePermanent = demanderString("Entrez le code permanent :");
        String nom = demanderString("Entrez le nom :");
        String prenom = demanderString("Entrez le prénom :");
        int programme = demanderInteger("Entrez le numéro du programme :");
        int credits = demanderInteger("Entrez le nombre de crédits :");
        float moyenne = demanderFloat("Entrez la moyenne cumulative :");

        etudiants.add(new Etudiant(codePermanent, nom, prenom, programme, credits, moyenne));
    }

    private static void inscrireEtudiant() {
        demanderEtudiant().ifPresent(e -> demanderCours().ifPresent(c -> {
            if(c.ajouterEtudiant(e)) e.ajouterCours(c);
        }));
    }

    private static void desinscrireEtudiant() {
        demanderEtudiant().ifPresent(e -> demanderCours().ifPresent(c -> {
            c.retirerEtudiant(e);
            e.retirerCours(c);
        }));
    }

    private static void listerEtudiants() {
        demanderCours().ifPresent(c -> {
            System.out.println("==================================");
            c.getEtudiants().forEach(Etudiant::display);
            System.out.println("==================================");
        });
    }

    private static void listerCours() {
        demanderEtudiant().ifPresent(e -> {
            System.out.println("==================================");
            e.getCours().forEach(Cours::display);
            System.out.println("==================================");
        });
    }
}
