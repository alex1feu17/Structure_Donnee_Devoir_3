package com.example;

import java.util.ArrayList;

public class Etudiant {

   private String codePermanent;
   private String nom;
   private String prenom;
   private String noProgramme;
   private int credit;
   private float moyenne;
   private int nb_cours;
   private ArrayList<Cours> cours_inscrit;

   public String getCodePermanent() {
      return codePermanent;
   }

   public String getNom() {
      return nom;
   }

   public String getPrenom() {
      return prenom;
   }

   public int getNb_cours() {
      return nb_cours;
   }

   public float getMoyenne() {
      return moyenne;
   }

   public int getCredit() {
      return credit;
   }

   public String getNoProgramme() {
      return noProgramme;
   }


   public void setCodePermanent(String codePermanent) {
      this.codePermanent = codePermanent;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }

   public void setNb_cours(int nb_cours) {
      this.nb_cours = nb_cours;
   }

   public void setCredit(int credit) {
      this.credit = credit;
   }

   public void setMoyenne(float moyenne) {
      this.moyenne = moyenne;
   }

   public void setNoProgramme(String noProgramme) {
      this.noProgramme = noProgramme;
   }
}
