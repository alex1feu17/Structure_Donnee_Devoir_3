package com.example;

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

        switch (choice) {
            case 1:
                //Lecture des données à partir d’un fichier.
                String fichier_etudiant = "C:\\Users\\Alexy Duval\\IdeaProjects\\Structure_Donnee_Devoir3\\out\\production\\Structure_Donnee_Devoir3\\File\\Etudiants.txt";
                String fichier_cours= "C:\\Users\\Alexy Duval\\IdeaProjects\\Structure_Donnee_Devoir3\\out\\production\\Structure_Donnee_Devoir3\\File\\Cours.txt";
                String fichier_inscription= "C:\\Users\\Alexy Duval\\IdeaProjects\\Structure_Donnee_Devoir3\\out\\production\\Structure_Donnee_Devoir3\\File\\Inscriptions.txt";
                Programme.lireFichier(fichier_etudiant,fichier_cours,fichier_inscription);
                break;
            case 2:
                //Inscription de l'étudiant.

                break;
            case 3:
                //Liste des étudiants inscrits à un cours donné.


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
