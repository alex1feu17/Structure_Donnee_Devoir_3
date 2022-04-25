package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Programme {
    public String noProgramme;

    public static void lireFichier(String Fl_Etudiant, String Fl_Cours, String Fl_Inscription) {

        // Etudiant
        ArrayList<Etudiant> list_etudiant = new ArrayList<Etudiant>();
        Etudiant etudiant = new Etudiant();
        String value="";
        try(BufferedReader br = new BufferedReader(new FileReader(Fl_Etudiant)))
        {
            int i;
            int compteur = 0;
            FileReader fr = new FileReader(Fl_Etudiant);
            while ((i = fr.read()) != -1)
            {
                if((char)i!='\n') {

                    if((char)i!='\t')
                    {
                        value = value+(char)i;

                        if(compteur==0)
                            etudiant.setCodePermanent(value);
                        if(compteur==1)
                            etudiant.setNom(value);
                        if(compteur==2)
                            etudiant.setPrenom(value);
                        if(compteur==3)
                            etudiant.setNoProgramme(value);
                        if(compteur==4)
                            etudiant.setCredit(Integer.valueOf(value));
                        if(compteur==5) {
                            if ((char) i != '.')
                                etudiant.setMoyenne(Float.parseFloat(value));
                        }
                    }
                    else
                    {
                        compteur ++;
                        value="";
                    }
                }
                else
                {
                    list_etudiant.add(etudiant);
                    compteur=0;
                    value="";
                    etudiant = new Etudiant();

                }

            }

        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Cours
        ArrayList<Cours> list_cours = new ArrayList<Cours>();
        ArrayList<String> list_prerequis = new ArrayList<String>();
        Cours cours = new Cours();
        value="";
        try(BufferedReader br = new BufferedReader(new FileReader(Fl_Cours)))
        {
            int i;
            int compteur = 0;
            FileReader fr = new FileReader(Fl_Cours);

            while ((i = fr.read()) != -1)
            {
                if((char)i!='\n') {

                    if((char)i!='\t')
                    {
                        if((char)i!=';')
                        {
                            value = value+(char)i;
                        }


                        if(compteur==0)
                            cours.setSigleCours(value);
                        if(compteur==1)
                            cours.setNom(value);
                        if(compteur==2)
                            cours.setMax_etudiant(Integer.valueOf(value));
                        if(compteur==3)
                        {
                            if((char)i==';')
                            {
                                compteur = 3 ;
                                list_prerequis.add(value);
                                value = "";
                            }
                        }

                    }
                    else
                    {
                        compteur ++;
                        value="";


                    }
                }
                else
                {
                    cours.setPrerequis(list_prerequis);
                    list_cours.add(cours);
                    compteur=0;
                    value="";
                    cours = new Cours();

                }

            }

        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Inscription
        value="";
        try(BufferedReader br = new BufferedReader(new FileReader(Fl_Inscription)))
        {
            int i;
            int compteur = 0;
            FileReader fr = new FileReader(Fl_Inscription);

            while ((i = fr.read()) != -1)
            {
                if((char)i!='\n') {

                    if((char)i!='\t')
                    {

                        if(compteur==0)
                            for (int j = 0;j<list_cours.size(); j++)
                            {
                                if(value == list_cours.get(i).getSigleCours())
                                {
                                    int nombre = list_cours.get(i).getNb_etudiant();

                                    if(nombre == list_cours.get(i).getMax_etudiant())
                                        System.out.println("On ne peux pas ajouter l'étudiant, car le cours est plein");
                                    else
                                        list_cours.get(i).setNb_etudiant(nombre+1);

                                }
                            }
                        if(compteur==1)
                            for (int j = 0;j<list_etudiant.size(); j++)
                            {
                                if(value == list_etudiant.get(i).getCodePermanent())
                                {
                                    int nombre = list_etudiant.get(i).getNb_cours();
                                    list_etudiant.get(i).setNb_cours(nombre+1);

                                }
                            }

                    }
                    else
                    {
                        compteur ++;
                        value="";
                    }
                }
                else
                {
                    compteur=0;
                    value="";
                }

            }

        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
