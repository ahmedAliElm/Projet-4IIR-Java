package Gestion_des_salles;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Entreprise {

    //* Attributs
    private Salle[] sallesArray;
    private static int nombreSalles;

    private Reservation[] reservationsArray;
    private static int nombreReservations;

    private Utilisateur[] utilisateursArray;
    private static int nombreUtilisateurs;


    //* Constructeur
    public Entreprise() {

        sallesArray = new Salle[100];
        nombreSalles = 0;
        
        reservationsArray = new Reservation[100];
        nombreReservations = 0;
        
        utilisateursArray = new Utilisateur[100];
        nombreUtilisateurs = 0;
    }


    
    //!----- TRAITEMENT DES SALLES -----!// 

    //* Ajouter salle   Khdama
    public void ajouterSalle(Salle S) {

        Scanner scanner = new Scanner(System.in);
        String choix;
    
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
    
        System.out.println();
        System.out.print("Veuillez saisir votre CIN: ");
        choix = scanner.nextLine();
    
        boolean isCINValid = false;
    
        for (int i = 0; i < nombreUtilisateurs; i++) {

            if (utilisateursArray[i].getCinUtilisateur().equals(choix)) {

                isCINValid = true;
    
                if (utilisateursArray[i].isAdmin()) {

                    boolean salleExists = false;
    
                    for (int j = 0; j < nombreSalles; j++) {

                        //^ Vérifier si la salle existe déjà
                        if (sallesArray[j].getNumSalle() == S.getNumSalle()) {

                            salleExists = true;
                            break;
                        }
                    }
    
                    if (salleExists) {

                        System.out.println();
                        System.out.println(RED + " --> Erreur! Salle déjà existante." + RESET);
                        return;
                    }
    
                    //^ Ajouter la salle
                    sallesArray[nombreSalles] = S;
                    nombreSalles++;
    
                    System.out.println();
                    System.out.println(GREEN + " --> Salle ajoutée avec succès." + RESET);
                    return;

                }
                
                else {
                    System.out.println();
                    System.out.println(RED + " --> Vous n'êtes pas un admin. Vous n'avez pas le droit d'ajouter une salle." + RESET);
                    return;
                }
            }
        }
    
        if (!isCINValid) {
            System.out.println();
            System.out.println(RED + " --> CIN invalide." + RESET);
        }

        scanner.close();
    }
    

    //* Modifier salle   Khdama
    public void modifierSalle(int num, int capSalle, boolean dispo, boolean wifi) {

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Veuillez saisir votre CIN: ");
        String choix = scanner.nextLine();
    
        boolean isAdmin = false;
    
        for (int i = 0; i < nombreUtilisateurs; i++) {

            if (utilisateursArray[i].isAdmin() && utilisateursArray[i].getCinUtilisateur().equals(choix)) {

                isAdmin = true;
    
                for (int j = 0; j < nombreSalles; j++) {

                    if (num == sallesArray[j].getNumSalle()) {

                        sallesArray[j].setCapaciteSalle(capSalle);
                        sallesArray[j].setDisponibiliteSalle(dispo);
                        sallesArray[j].setWifiSalle(wifi);
    
                        System.out.println();
                        System.out.println(GREEN + " --> Salle modifiée avec succès." + RESET);
                        return;
                    }
                }

                System.out.println();
                System.out.println(RED + " --> Salle non trouvée." + RESET);
                System.exit(0);  //^ Terminer le programme
            }
        }
    
        if (!isAdmin) {

            System.out.println();
            System.out.println(RED + " --> Vous n'êtes pas un admin. Vous n'avez pas le droit de modifier une salle." + RESET);
            System.exit(0);  //^ Terminer le programme
        }

        scanner.close();
    }    


    //* Supprimer salle   Khdama
    public void supprimerSalle(int num) {

        for (int i = 0; i < nombreSalles; i++) {
    
            if (num == sallesArray[i].getNumSalle()) {
    
                Salle[] newArray = new Salle[sallesArray.length - 1];
    
                System.arraycopy(sallesArray, 0, newArray, 0, i);
    
                System.arraycopy(sallesArray, i + 1, newArray, i, sallesArray.length - i - 1);
    
                sallesArray = newArray;
    
                nombreSalles--;

                System.out.println();
                System.out.println(" Salle supprimée avec succès."); 
    
                break; 
            }
        }
    }


    //* Afficher tous les salles   Khdama
    public void afficherTousLesSalles() {

        String RESET = "\u001B[0m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";

        for(int i = 0; i < nombreSalles; i++) {

            System.out.println();
            System.out.println();
            System.out.println(PURPLE + " ---- Informations de la salle " + (i + 1) + " -----" + RESET);
            System.out.println();
            System.out.println(BLUE + "          - Numéro de la salle: " + RESET + sallesArray[i].getNumSalle());
            System.out.println();
            System.out.println(BLUE + "          - Capacité de la salle: " + RESET + sallesArray[i].getCapaciteSalle());
            System.out.println();
            System.out.println(BLUE + "          - Disponibilité de la salle: " + RESET + sallesArray[i].getDisponibiliteSalle());
            System.out.println();
            System.out.println(BLUE + "          - Wi-Fi de la salle: " + RESET + sallesArray[i].getWifiSalle());

            sallesArray[i].afficherEquipements();
        }
    }
    
    
    //* Afficher une seule salle   Khdama
    public void afficherSalle(int num) {

        String RESET = "\u001B[0m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";

        for(int i = 0; i < nombreSalles; i++) {

            if (sallesArray[i].getNumSalle() == num) {

                System.out.println();
                System.out.println();
                System.out.println(PURPLE + " ---- Informations de la salle " + (i + 1) + " -----" + RESET);
                System.out.println();
                System.out.println(BLUE + "          - Numéro de la salle: " + RESET + sallesArray[i].getNumSalle());
                System.out.println();
                System.out.println(BLUE + "          - Capacité de la salle: " + RESET + sallesArray[i].getCapaciteSalle());
                System.out.println();
                System.out.println(BLUE + "          - Disponibilité de la salle: " + RESET + sallesArray[i].getDisponibiliteSalle());
                System.out.println();
                System.out.println(BLUE + "          - Wi-Fi de la salle: " + RESET + sallesArray[i].getWifiSalle());
        
                sallesArray[i].afficherEquipements();
            }
        }
    }


    //* Rechercher salle   Khdama
    public void rechercherSalle(int num) {

        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        Scanner scanner = new Scanner(System.in);
        int choix1;
        int choix2;

        boolean capaciteExiste = false; //^ Variable pour tester si la capacité désirée existe
        boolean salleExiste = false; //^ Variable pour tester si la salle désirée existe

        System.out.println();
        System.out.print(" Saisir la capacité: ");
        choix1 = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println();
        System.out.print(" Voulez-vous que la salle contient un réseau WLAN (Wi-Fi) (1|0): ");
        choix2 = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nombreSalles; i++) {

            if ((sallesArray[i].getNumSalle() == num) && (sallesArray[i].getCapaciteSalle() >= choix1)) {

                if (choix2 == 1) {  //^ User veut wifi

                    if (sallesArray[i].getWifiSalle()) {  //^ Salle avec wifi

                        afficherSalle(num);
                        return;
                    }

                    else if (!(sallesArray[i].getWifiSalle())) {  //^ User veut pas wifi mais salle ne contient pas wifi

                        int choice;

                        System.out.println();
                        System.out.println(RED + " --> La salle existe mais sans Wi-Fi." + RESET);
                        System.out.println();

                        System.out.print("Voulez-vous afficher la salle en tout cas? (1|0): ");
                        choice = scanner.nextInt();

                        if (choice == 1) 
                            afficherSalle(num);
                    }
                }

                else if (choix2 == 0) {  //^ User ne veut pas wifi

                    if (!(sallesArray[i].getWifiSalle())) {  //^ Salle sans wifi

                        afficherSalle(num);
                        return;
                    }
                    
                    else if ((sallesArray[i].getWifiSalle())) {  //^ User ne veut pas wifi mais salle contient wifi

                        int choice;

                        System.out.println();
                        System.out.println(RED + " --> La salle existe mais sans Wi-Fi." + RESET);
                        System.out.println();

                        System.out.print("Voulez-vous afficher la salle en tout cas? (1|0): ");
                        choice = scanner.nextInt();

                        if (choice == 1) 
                            afficherSalle(num);
                    }
                }
            }

            if (sallesArray[i].getCapaciteSalle() >= choix1) 
                capaciteExiste = true;
                
            if (sallesArray[i].getNumSalle() == num) 
                salleExiste = true;
        }

        if (!capaciteExiste) {

            System.out.println();
            System.out.println(RED + " --> Aucune salle avec la capacité désirée existe!" + RESET);
            System.out.println();
        }
            
        if (!salleExiste) {

            System.out.println();
            System.out.println(RED + " --> Aucune salle avec le numéro désiré existe!" + RESET);
            System.out.println();
        }

        scanner.close();
    }



    //!----- TRAITEMENT DES RESERVATIONS -----!//

    //* Afficher une réservation   Khdama
    public void afficherReservationESE(int code) {

        for (int i = 0; i < nombreReservations; i++)
            if (code == reservationsArray[i].getCodeReservation())
                reservationsArray[i].afficherReservation();
    }
    
    
    //* Afficher tous les réservations   Khdama
    public void afficherTousLesReservations() {

        for (int i = 0; i < nombreReservations; i++) 
            reservationsArray[i].afficherReservation();
    }


    //* Créer réservation   Khdama
    public void creerReservation(Reservation R) {

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        boolean salleOccupee = false;

        for (int i = 0; i < nombreReservations; i++) {

            //^ Gestion des conflits
            if ((reservationsArray[i].getDate() == R.getDate()) || (reservationsArray[i].getHeureDebut() == R.getHeureDebut()) || (reservationsArray[i].getHeureFin() == R.getHeureFin()) || (reservationsArray[i].getSalle().getDisponibiliteSalle() == false)) {

                System.out.println();
                System.out.println(RED + " --> Erreur! Salle occupée, impossible de réserver cette salle." + RESET);
                salleOccupee = true;

                break;
            }
        }

        if (!salleOccupee) {

            reservationsArray[nombreReservations] = R;
            nombreReservations++;

            System.out.println();
            System.out.println(GREEN + " --> Réservation réussie." + RESET); 
        }
    }


    //* Modifier réservation   Khdama
    public void modifierReservation(LocalDate date, int hd, int hf, int num_salle, String eve) {

        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        for (int i = 0; i < nombreReservations; i++) {

            if (num_salle == reservationsArray[i].getSalle().getNumSalle()) {

                reservationsArray[i].setDate(date);
                System.out.println();
                System.out.println(GREEN + " --> Date modifiée avec succès." + RESET); 

                reservationsArray[i].setHeureDebut(hd);
                System.out.println();
                System.out.println(GREEN + " --> Heure de début modifiée avec succès." + RESET);
                
                reservationsArray[i].setHeureFin(hf);
                System.out.println();
                System.out.println(GREEN + " --> Heure de fin modifiée avec succès." + RESET);
                
                reservationsArray[i].getSalle().setNumSalle(num_salle);
                System.out.println();
                System.out.println(GREEN + " --> Numéro de salle modifié avec succès." + RESET);
                
                reservationsArray[i].setEvenement(eve);
                System.out.println();
                System.out.println(GREEN + " --> Evénement modifié avec succès." + RESET); 

                break;
            }
        }
    }


    //* Annuler réservation   Khdama
    public void annulerReservation(int code) {

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";

        int choix;
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.print(RED + " --> Voulez-vous vraiment annuler cette réservation (1|0): " + RESET);
        choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {

            for (int i = 0; i < nombreReservations; i++) {

                if (code == reservationsArray[i].getCodeReservation()) {
    
                    Reservation[] newArray = new Reservation[reservationsArray.length - 1];
        
                    System.arraycopy(reservationsArray, 0, newArray, 0, i);
        
                    System.arraycopy(reservationsArray, i + 1, newArray, i, reservationsArray.length - i - 1);
        
                    reservationsArray = newArray;
        
                    nombreReservations--;
    
                    System.out.println();
                    System.out.println(GREEN + " --> Réservation annulée avec succès." + RESET); 
                    System.out.println();
        
                    break;
                }
            }
        }

        scanner.close();
    }


    //* Rechercher réservation   Khdama
    public void rechercherReservation(String evenement, String nomUtil) {

        for (int i = 0; i < nombreReservations; i++)

            if (((reservationsArray[i].getEvenement()).equals(evenement)) || ((utilisateursArray[i].getNomUtilisateur()).equals(nomUtil)))

                reservationsArray[i].afficherReservation();
    }


    //* Rappel réservation   Khdama
    public void rappelReservation() {

        LocalDate liveDate = LocalDate.now();
        long daysDifference;

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";

        for (int i = 0; i < nombreReservations; i++) {

            daysDifference = ChronoUnit.DAYS.between(liveDate, reservationsArray[i].getDate());

            if (Math.abs(daysDifference) <= 1) {

                System.out.println();
                System.out.println(RED + " La réservation " + reservationsArray[i].getEvenement() + " est demain!" + RESET);
                System.out.println();
            }
        }
    }


    //!----- TRAITEMENT DES UTILISATEURS -----!//

    //* Ajouter Utilisateur  Khdama
    public void ajouterUtilisateur(Utilisateur U) {

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        boolean utilisateurExiste = false;

        for (int i = 0; i < nombreUtilisateurs; i++) {

            if (utilisateursArray[i].getCinUtilisateur() == U.getCinUtilisateur()) {

                System.out.println();
                System.out.println(RED + " --> Erreur! Utilisateur déjà existant." + RESET);
                utilisateurExiste = true; 

                break;
            }
        }

        if (!utilisateurExiste) {

            utilisateursArray[nombreUtilisateurs] = U;
            nombreUtilisateurs++;

            System.out.println();
            System.out.println(GREEN + " --> Utilisateur ajouté avec succès." + RESET); 
        }
    }


    //* Rechercher utilisateur  Khdama
    public void rechercherUtilisateur(String cin) {

        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        boolean utilisateurTrouve = false;

        for (int i = 0; i < nombreUtilisateurs; i++) {

            if ((utilisateursArray[i].getCinUtilisateur()).equals(cin)) {

                utilisateursArray[i].afficherInfosUtilisateur();
                utilisateurTrouve = true;
            }
        }           

        if (!utilisateurTrouve)
            System.out.println(RED + " --> Utilisateur introuvable!" + RESET);
    }


    //* Modifier infos utilisateur  Khdama
    public void modifierInfosUtil(String cin, String n, String email, String mdp, boolean ad) {

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        if (utilisateursArray == null || utilisateursArray.length == 0) {

            System.out.println(RED + " --> Erreur! La liste des utilisateurs est vide ou non initialisée." + RESET);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean utilisateurTrouve = false;

        for (int i = 0; i < nombreUtilisateurs; i++) {

            if (cin.equals(utilisateursArray[i].getCinUtilisateur())) {

                utilisateurTrouve = true;

                System.out.print(" --> Voulez-vous modifier le nom (1|0): ");

                if (getValidChoice(scanner)) 
                    utilisateursArray[i].setNomUtilisateur(n);

                System.out.println();

                System.out.print(" --> Voulez-vous modifier le droit d'accès (1|0): ");

                if (getValidChoice(scanner)) 
                    utilisateursArray[i].setAdmin(ad);

                System.out.println();

                System.out.print(" --> Voulez-vous modifier l'email (1|0): ");

                if (getValidChoice(scanner)) 
                    utilisateursArray[i].setEmailUtilisateur(email);

                System.out.println();
                
                System.out.print(" --> Voulez-vous modifier le mot de passe (1|0): ");

                if (getValidChoice(scanner)) 
                    utilisateursArray[i].setMotDePasseUtilisateur(mdp);

                System.out.println();

                System.out.println(GREEN + " --> Les informations de l'utilisateur ont été mises à jour avec succès." + RESET);
                break; // Exit the loop once the user is found and modified.
            }
        }

        if (!utilisateurTrouve) 
            System.out.println(RED + " --> Erreur! Aucun utilisateur avec le CIN fourni n'a été trouvé." + RESET);
    }


    //* Gestion des exceptions  Khdama
    private boolean getValidChoice(Scanner scanner) {

        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        while (true) {

            try {

                int choix = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character.

                if (choix == 1 || choix == 0) 
                    return choix == 1;

                System.out.print(RED + " --> Entrée invalide. Veuillez saisir 1 pour Oui ou 0 pour Non: " + RESET);

            } 
            
            catch (InputMismatchException e) {

                System.out.print(RED + " --> Entrée invalide. Veuillez saisir un entier (1 ou 0): " + RESET);
                scanner.nextLine(); // Clear invalid input.
            }
        }
    }
}

