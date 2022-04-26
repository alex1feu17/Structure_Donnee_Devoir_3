package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        System.out.println("|                   MENU SELECTION                             |");
        System.out.println("|        1. Lecture des données à partir d’un fichier.         |");
        System.out.println("|        2. Inscription de l'étudiant                          |");
        System.out.println("|        3. Liste des étudiants inscrits à un cours donné.     |");
        System.out.println("|        4. Liste des cours suivis par l’étudiant.             |");
        System.out.println("|        5. Sauvegarde des données dans un fichier.            |");
        System.out.println("|        6. Quitter                                            |");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        ArrayList<Cours> list_cours = new ArrayList<Cours>();
        Programme programme = new Programme();

        switch (choice) {
            case 1:
                //Lecture des données à partir d’un fichier.
                String fichier_etudiant = "C:\\Users\\Alexy Duval\\IdeaProjects\\Structure_Donnee_Devoir3\\out\\production\\Structure_Donnee_Devoir3\\File\\Etudiants.txt";
                String fichier_cours = "C:\\Users\\Alexy Duval\\IdeaProjects\\Structure_Donnee_Devoir3\\out\\production\\Structure_Donnee_Devoir3\\File\\Cours.txt";
                String fichier_inscription = "C:\\Users\\Alexy Duval\\IdeaProjects\\Structure_Donnee_Devoir3\\out\\production\\Structure_Donnee_Devoir3\\File\\Inscriptions.txt";
                Programme.lireFichier(fichier_etudiant, fichier_cours, fichier_inscription);
                break;
            case 2:
                //Inscription de l'étudiant.

                Scanner sc = new Scanner(System.in);
                Etudiant etudiant = new Etudiant();
                String str;
                do {
                    System.out.print("Entrer le code permanent :");
                    str = sc.nextLine();
                    etudiant.setCodePermanent(str);

                } while (str != " " && str != null);

                do {
                    System.out.print("Entrer le nom :");
                    str = sc.nextLine();
                    etudiant.setNom(str);

                } while (str != " " && str != null);

                do {
                    System.out.print("Entrer le prénom :");
                    str = sc.nextLine();
                    etudiant.setPrenom(str);

                } while (str != " " && str != null);

                do {
                    System.out.print("Entrer le numéro du programme :");
                    str = sc.nextLine();
                    etudiant.setNoProgramme(str);

                } while (str != " " && str != null);

                do {
                    System.out.print("Entrer le nombre de crédits :");
                    str = sc.nextLine();
                    etudiant.setCredit(Integer.parseInt(str));

                } while (str != " " && str != null);

                do {
                    System.out.print("Entrer le moyenne cumulative :");
                    str = sc.nextLine();
                    etudiant.setMoyenne(Integer.parseInt(str));

                } while (str != " " && str != null);

                do {
                    System.out.print("Entrer le nombre de cours inscrit :");
                    str = sc.nextLine();
                    etudiant.setNb_cours(Integer.parseInt(str));

                } while (str != " " && str != null);


                do {
                    System.out.print("Entrer la liste des cours inscrit et lorsque terminé entrez la lettre (t) :");
                    str = sc.nextLine();
                    Cours cours = new Cours();
                    cours.setSigleCours(str);
                    list_cours.add(cours);

                } while (str != " " && str != null || str == "t");

                etudiant.setCours_inscrit(list_cours);

                break;
            case 3:
                //Liste des étudiants inscrits à un cours donné.
                Scanner scan = new Scanner(System.in);

                ArrayList<Etudiant> etudiantinscrit = new ArrayList<Etudiant>();
                do {
                    System.out.print("Entrer le cours dont vous voulez l'information :");
                    str = scan.nextLine();
                } while (str != " " && str != null);


                for (int i =0; programme.getList_cours().size() < i;i++)
                {
                    if(programme.getList_cours().get(i).getSigleCours()==str)
                    {
                        System.out.print("Pour le cours suivant : "+programme.getList_cours().get(i).getSigleCours());
                        etudiantinscrit=programme.getList_cours().get(i).getEtudiant_inscrit();
                    }
                }

                for(int i =0;etudiantinscrit.size() < i;i++)
                {
                    System.out.println("Prénom de l'étudiant :" + etudiantinscrit.get(i).getPrenom());
                    System.out.println("Nom de l'étudiant :" + etudiantinscrit.get(i).getNom());
                }

                break;
            case 4:
                //Liste des cours suivis par l’étudiant.

                break;
            case 5:
                //Sauvegarde des données dans un fichier.

                break;
            case 6:
                //Quitter
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }
    }
}
