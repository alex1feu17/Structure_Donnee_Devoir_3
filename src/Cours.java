import java.util.ArrayList;
import java.util.List;

public class Cours {

    private String sigle;
    private String nom;
    private int maxEtudiants;
    private int nbEtudiants;
    private List<String> prerequis;
    private List<Etudiant> etudiants = new ArrayList<>();

    public Cours(String sigle, String nom, int maxEtudiants, List<String> prerequis) {
        this.sigle = sigle;
        this.nom = nom;
        this.maxEtudiants = maxEtudiants;
        this.prerequis = prerequis;
    }

    public String getSigle() {
        return sigle;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public boolean ajouterEtudiant(Etudiant etudiant) {
        if(this.etudiants.contains(etudiant)){
            System.out.print("Erreur: Étudiant déjà inscrit.");
            return false;
        }
        if(this.etudiants.size() >= maxEtudiants){
            System.out.print("Erreur: Cours complet.");
            return false;
        }
        this.etudiants.add(etudiant);
        this.nbEtudiants = this.etudiants.size();
        return true;
    }

    public boolean retirerEtudiant(Etudiant etudiant) {
        boolean result = this.etudiants.remove(etudiant);
        if(result)
            this.nbEtudiants = this.etudiants.size();
        else
            System.out.println("Erreur: Étudiant n'est pas inscrit au cours.");
        return result;
    }

    public void display() {
        System.out.println(sigle);
    }

}
