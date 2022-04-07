public class Main {
    public static void main(String args[])
    {
        int swValue;
        System.out.println("|                   MENU SELECTION                             |");
        System.out.println("|        1. Lecture des données à partir d’un fichier.         |");
        System.out.println("|        2. Inscription de l'étudiant                          |");
        System.out.println("|        3. Liste des étudiants inscrits à un cours donné.     |");
        System.out.println("|        4. Liste des cours suivis par l’étudiant.             |");
        System.out.println("|        5. Sauvegarde des données dans un fichier.            |");
        System.out.println("|        6. Quitter                                            |");

        swValue = Keyin.inInt(" Select option: ");

        switch (swValue) {
            case 1:
                //Lecture des données à partir d’un fichier.

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
