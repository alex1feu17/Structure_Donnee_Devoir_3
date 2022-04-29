import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Reader {

    private static boolean validerFichier(Path fichier) {
        if(fichier.toFile().exists()) return true;
        System.out.println("Erreur: Fichier introuvable");
        return false;
    }

    private static String[] lireLignes(Path fichier) {
        try {
            return Files.readString(fichier).split("\n");
        } catch (IOException e) {
            System.out.println("Erreur: Impossible de lire fichier (" + fichier + ")");
            e.printStackTrace();
        }
        return new String[]{};
    }

    public static List<Etudiant> lireEtudiants(Path fichier) {
        List<Etudiant> etudiants = new ArrayList<>();
        if(!validerFichier(fichier)) return etudiants;

        String[] etudiantsDonnees = lireLignes(fichier);
        for (String etudiantsDonnee : etudiantsDonnees) {
            String[] etudiantDonnees = etudiantsDonnee.split("\t");
            if (etudiantDonnees.length < 6) continue;
            try {
                Etudiant etudiant = new Etudiant(etudiantDonnees[0], etudiantDonnees[1], etudiantDonnees[2], Integer.parseInt(etudiantDonnees[3]), Integer.parseInt(etudiantDonnees[4]), Float.parseFloat(etudiantDonnees[5]));
                etudiants.add(etudiant);
            } catch (NumberFormatException e) {
                System.out.println("Erreur: Impossible de lire étudiant (" + etudiantDonnees[0] + ")");
            }
        }

        return etudiants;
    }

    public static List<Cours> lireCours(Path fichier) {
        List<Cours> cours = new ArrayList<>();
        if(!validerFichier(fichier)) return cours;

        String[] coursDonnees = lireLignes(fichier);
        for (String coursDonnee : coursDonnees) {
            String[] donnes = coursDonnee.split("\t");
            if (donnes.length < 3) continue;
            try {
                List<String> prerequis = new ArrayList<>();
                if (donnes.length == 4)
                    prerequis.addAll(Arrays.asList(donnes[3].split(" ; ")));

                Cours c = new Cours(donnes[0], donnes[1], Integer.parseInt(donnes[2]), prerequis);
                cours.add(c);
            } catch (NumberFormatException e) {
                System.out.println("Erreur: Impossible de lire cours (" + donnes[0] + ")");
            }
        }

        return cours;
    }

    public static Map<String, List<String>> lireInscriptions(Path fichier) {
        Map<String, List<String>> inscriptions = new HashMap<>();
        if(!validerFichier(fichier)) return inscriptions;

        String[] inscriptionsDonnees = lireLignes(fichier);
        for (String inscriptionsDonnee : inscriptionsDonnees) {
            String[] donnes = inscriptionsDonnee.split("\t");
            if (donnes.length < 2) continue;
            try {
                String codePermanent = donnes[1].replace("\r", "");
                String sigle = donnes[0];
                List<String> cours = inscriptions.getOrDefault(codePermanent, new ArrayList<>());
                if(cours.contains(sigle)) continue;
                cours.add(sigle);
                inscriptions.put(codePermanent, cours);
            } catch (NumberFormatException e) {
                System.out.println("Erreur");
            }
        }

        return inscriptions;
    }
}
