package Gestion_des_salles;

import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.time.format.DateTimeParseException;
// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //!  DECLARATIONS  !//

        //* Equipements *//
        Equipement E1 = new Equipement("1ERE5", "PC", true, 4000);
        Equipement E2 = new Equipement("50AFG0", "Imprimante", true, 2000);
        Equipement E3 = new Equipement("SDFS55", "Projecteur", false, 3500);


        //* Salles *//
        Salle S1 = new Salle(1, 40, true, true);
        Salle S2 = new Salle(2, 35, true, false);
        Salle S3 = new Salle(3, 25, false, true);


        //*  Utilisateurs  *//
        Utilisateur U1 = new Utilisateur("Ali", "User_1", false, "alielm@gmail.com", "user1");
        Utilisateur U2 = new Utilisateur("Ahmed", "User_2", true, "ahmedelm@gmail.com", "root");
        Utilisateur U3 = new Utilisateur("Mohamed", "User_3", false, "mohelm@gmail.com", "user2");


        //*  Reservations  *//
        LocalDate reservationDate1 = LocalDate.of(2024, 11, 18);
        LocalDate reservationDate2 = LocalDate.of(2024, 12, 2);
        LocalDate reservationDate3 = LocalDate.of(2024, 5, 25);

        Reservation R1 = new Reservation(Reservation.genererCodeReservation(), reservationDate1, 15, 18, "Conférence", S1);
        Reservation R2 = new Reservation(Reservation.genererCodeReservation(), reservationDate2, 9, 12, "Présentation de projet", S2);
        Reservation R3 = new Reservation(Reservation.genererCodeReservation(), reservationDate3, 14, 16, "Réunion", S3);


        //*  Entreprise  *//
        Entreprise ESE1 = new Entreprise();
        // Entreprise ESE2 = new Entreprise();
        // Entreprise ESE3 = new Entreprise();



        //!  TEST DES EQUIPEMENTS  !// 

        //*  Ajout des équipements  *//

        S1.ajouterEquipement(E1);
        S1.ajouterEquipement(E2);
        S1.ajouterEquipement(E3);
        System.out.println();
        
        S2.ajouterEquipement(E1);
        S2.ajouterEquipement(E2);
        S2.ajouterEquipement(E3);
        System.out.println();
        
        S3.ajouterEquipement(E1);
        S3.ajouterEquipement(E2);
        S3.ajouterEquipement(E3);
        System.out.println();

        // S2.ajouterEquipement(E1);
        // S2.ajouterEquipement(E2);
        // S2.ajouterEquipement(E3);
        // System.out.println();

        // S3.ajouterEquipement(E1);
        // S3.ajouterEquipement(E2);
        // S3.ajouterEquipement(E3);
        // System.out.println();

        // S1.afficherEquipements();
        // S2.afficherEquipements();
        // S3.afficherEquipements();
        // System.out.println();

        // S1.modifierEquipement("1ERE5", "PC1", false);
        // S1.afficherEquipements();
        // System.out.println();

        // S1.supprimerEquipement("SDFS5");
        // S1.afficherEquipements();
        // System.out.println();



        //!  TEST DES RESERVATIONS  !//

        // R1.genererCodeReservation();
        // R1.afficherReservation();
        // System.out.println();
        
        // R2.genererCodeReservation();
        // R2.afficherReservation();
        // System.out.println();
        
        // R3.genererCodeReservation();
        // R3.afficherReservation();
        // System.out.println();
        
        
        
        //!  TEST DES UTILISATEURS  !//

        // U1.afficherInfosUtilisateur();
        // U2.afficherInfosUtilisateur();
        // U3.afficherInfosUtilisateur();
        // System.out.println();



        //!  TEST DES ENTREPRISES  !//

        //* Ajout des utilisateurs *//

        ESE1.ajouterUtilisateur(U1);
        ESE1.ajouterUtilisateur(U2);
        ESE1.ajouterUtilisateur(U3);
        System.out.println();


        //* Recherche des utilisateurs *//

        // ESE1.rechercherUtilisateur("User_1");
        // System.out.println();
        // ESE1.rechercherUtilisateur("User_2");
        // System.out.println();
        // ESE1.rechercherUtilisateur("User_3");
        // System.out.println();
        // ESE1.rechercherUtilisateur("kk");
        // System.out.println();


        //* Modification des utilisateurs *//

        // ESE1.modifierInfosUtil("User_1", "Alichangé", "emailchangé", "mdpchangé", true);
        // System.out.println();
        // ESE1.modifierInfosUtil("User_2", "Ahmedchangé", "emailchangé", "mdpchangé", true);
        // System.out.println();
        // ESE1.modifierInfosUtil("User_3", "Mohamedchangé", "emailchangé", "mdpchangé", true);
        // System.out.println();
        // ESE1.modifierInfosUtil("User", "Alichangé", "emailchangé", "mdpchangé", true);
        // System.out.println();


        //* Recherche des utilisateurs *//

        // ESE1.rechercherUtilisateur("User_1");
        // System.out.println();
        // ESE1.rechercherUtilisateur("User_2");
        // System.out.println();
        // ESE1.rechercherUtilisateur("User_3");
        // System.out.println();


        //! ----------------------------------------------------------------------------------------- !\\


        //* Ajout des salles *//

        ESE1.ajouterSalle(S1);
        ESE1.ajouterSalle(S2);
        ESE1.ajouterSalle(S3);
        // ESE1.ajouterSalle(S3);
        // ESE1.ajouterSalle(S2);
        // ESE1.ajouterSalle(S1);
        System.out.println();


        //* Afficher tous les salles *//

        // ESE1.afficherTousLesSalles();
        
        
        //* Afficher une seule salle *//

        // ESE1.afficherSalle(1);
        // ESE1.afficherSalle(2);
        // ESE1.afficherSalle(3);


        //* Rechercher une salle *//

        // int choix_num_salle;
        // Scanner scanner = new Scanner(System.in);

        // System.out.println();
        // System.out.print(" Veuillez saisir le numéro de la salle à rechercher: ");
        // choix_num_salle = scanner.nextInt();

        // ESE1.rechercherSalle(choix_num_salle);

        // scanner.close();
        
        
        //* Supprimer une salle *//

        // int choix_num_salle;
        // Scanner scanner = new Scanner(System.in);

        // System.out.println();
        // System.out.print(" Veuillez saisir le numéro de la salle à supprimer: ");
        // choix_num_salle = scanner.nextInt();

        // ESE1.supprimerSalle(choix_num_salle);
        // ESE1.afficherTousLesSalles();

        // scanner.close();
        
        
        //* Modifier une salle *//

        // int choix_num_salle, choix_cap_salle; 
        // boolean choix_dispo, choix_wifi;
        // Scanner scanner = new Scanner(System.in);

        // System.out.println();
        // System.out.print(" Veuillez saisir le numéro de la salle à modifier: ");
        // choix_num_salle = scanner.nextInt();
        
        // System.out.println();
        // System.out.print(" Veuillez saisir la nouvelle capacité: ");
        // choix_cap_salle = scanner.nextInt();
        
        // System.out.println();
        // System.out.print(" Veuillez saisir la disponibilité (Disponible: 1 | Indisponible: 0): ");
        // choix_dispo = scanner.nextBoolean();
        
        // System.out.println();
        // System.out.print(" Veuillez saisir la disponibilité Wi-Fi (Disponible: 1 | Indisponible: 0): ");
        // choix_wifi = scanner.nextBoolean();

        // ESE1.modifierSalle(choix_num_salle, choix_cap_salle, choix_dispo, choix_wifi);
        // ESE1.afficherTousLesSalles();


        //! ----------------------------------------------------------------------------------------- !\\


        //* Création des réservations *//

        ESE1.creerReservation(R1);
        // ESE1.creerReservation(R1);

        ESE1.creerReservation(R2);
        // ESE1.creerReservation(R2);

        ESE1.creerReservation(R3);
        // ESE1.creerReservation(R3);


        //* Modification des réservations *//

        // int choix_heure_debut, choix_heure_fin, choix_num_salle;
        // LocalDate choix_date = null;
        // String choix_eve;

        // Scanner scanner = new Scanner(System.in);

        // System.out.println();
        // System.out.print(" Veuillez choisir le numéro de la salle qui contient la réservation à modifier: ");
        // choix_num_salle = scanner.nextInt();
        // scanner.nextLine();
        
        // System.out.println();
        // System.out.print(" Veuillez choisir la nouvelle date (formats acceptés: yyyy-MM-dd ou dd-MM-yyyy): ");

        // while (choix_date == null) {

        //     String input = scanner.nextLine();

        //     try {
        //         // Try the standard format first
        //         choix_date = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //     } 

        //     catch (DateTimeParseException e1) {

        //         try {
        //             // Try the alternative format
        //             choix_date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        //         } 
                
        //         catch (DateTimeParseException e2) {
        //             System.out.print("Format de date invalide. Veuillez réessayer: ");
        //         }
        //     }
        // }
        
        // System.out.println();
        // System.out.print(" Veuillez choisir le nouvel événement: ");
        // choix_eve = scanner.nextLine();

        // System.out.println();
        // System.out.print(" Veuillez choisir la nouvelle heure de début: ");
        // choix_heure_debut = scanner.nextInt();
        // scanner.nextLine();
        
        // System.out.println();
        // System.out.print(" Veuillez choisir la nouvelle heure de fin: ");
        // choix_heure_fin = scanner.nextInt();
        // scanner.nextLine();
        
        // ESE1.modifierReservation(choix_date, choix_heure_debut, choix_heure_fin, choix_num_salle, choix_eve);
        // ESE1.afficherTousLesReservations();

        // scanner.close();


        //* Afficher une réservation *//

        // ESE1.afficherReservationESE(R1.getCodeReservation());
        // ESE1.afficherReservationESE(R2.getCodeReservation());
        // ESE1.afficherReservationESE(R3.getCodeReservation());


        //* Afficher tous les réservations *//

        // ESE1.afficherTousLesReservations();


        //* Annuler une réservation *//

        // ESE1.annulerReservation(R3.getCodeReservation());
        // ESE1.afficherTousLesReservations();


        //* Rechercher une réservation *//

        // ESE1.rechercherReservation("h", U2.getNomUtilisateur());


        //* Rappel d'une réservation *//

        // ESE1.rappelReservation();

        System.out.println();
    }
}

