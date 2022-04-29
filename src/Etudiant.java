import java.util.ArrayList;
import java.util.List;

public class Etudiant {

   private String codePermanent;
   private String nom;
   private String prenom;
   private int noProgramme;
   private int credits;
   private float moyenne;
   private int nbCours;
   private List<Cours> cours = new ArrayList<>();

   public Etudiant(String codePermanent, String nom, String prenom, int noProgramme, int credits, float moyenne){
      this.codePermanent = codePermanent;
      this.nom = nom;
      this.prenom = prenom;
      this.noProgramme = noProgramme;
      this.credits = credits;
      this.moyenne = moyenne;
   }

   public String getCodePermanent() {
      return codePermanent;
   }

   public List<Cours> getCours() {return cours;}

   public boolean ajouterCours(Cours cours) {
      boolean result = this.cours.add(cours);
      if(result) this.nbCours = this.cours.size();
      return result;
   }

   public boolean retirerCours(Cours cours) {
      boolean result = this.cours.remove(cours);
      if(result) this.nbCours = this.cours.size();
      return result;
   }

   public void display() {
      System.out.println(this.prenom + " " + this.nom + " (" + this.codePermanent + ")");
   }
}
