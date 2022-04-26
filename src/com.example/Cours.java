package com.example;

import java.util.ArrayList;

public class Cours {

    private String sigleCours;
    private String nom;
    private int max_etudiant;
    private int nb_etudiant;
    private ArrayList<String> prerequis;
    private ArrayList<Etudiant> etudiant_inscrit;


    public String getSigleCours() {
        return sigleCours;
    }

    public String getNom() {
        return nom;
    }

    public int getMax_etudiant() {
        return max_etudiant;
    }

    public int getNb_etudiant() {
        return nb_etudiant;
    }

    public ArrayList<String> getPrerequis() {
        return prerequis;
    }

    public ArrayList<Etudiant> getEtudiant_inscrit() {return etudiant_inscrit;}





    public void setSigleCours(String sigleCours) {this.sigleCours = sigleCours;}

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMax_etudiant(int max_etudiant) {
        this.max_etudiant = max_etudiant;
    }

    public void setNb_etudiant(int nb_etudiant) {
        this.nb_etudiant = nb_etudiant;
    }

    public void setPrerequis(ArrayList<String> prerequis) {
        this.prerequis = prerequis;
    }

    public void setEtudiant_inscrit(ArrayList<Etudiant> etudiant_inscrit) {this.etudiant_inscrit = etudiant_inscrit;}


}
