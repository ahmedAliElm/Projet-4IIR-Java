package Gestion_des_salles;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Reservation {
    
    //* Attributs
    private LocalDate date;
    private int heureDebut;
    private int heureFin;
    private int codeReservation;
    private Salle salle;
    private String evenement;


    //* Constructeur
    public Reservation(int code, LocalDate d, int hd, int hf, String nomEv, Salle s) {

        date = d;
        heureDebut = hd;
        heureFin = hf;
        evenement = nomEv;
        salle = s;
        codeReservation = code;
    }


    //* Getters
    public LocalDate getDate() {
        return date;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }
    
    public Salle getSalle() {
        return salle;
    }
    
    public int getCodeReservation() {
        return codeReservation;
    }
    
    public String getEvenement() {
        return evenement;
    }


    //* Setters
    public void setDate(LocalDate d) {
        date = d;
    }

    public void setHeureDebut(int hd) {
        heureDebut = hd;
    }

    public void setHeureFin(int hf) {
        heureFin = hf;
    }
    
    public void setSalle(Salle s) {
        salle = s;
    }
    
    public void setCodeReservation(int codeSetter) {
        codeReservation = codeSetter;
    }
    
    public void setEvenement(String nomEvSetter) {
        evenement = nomEvSetter;
    }


    //* Méthode pour générer un code aléatoire   Khdama
    public static int genererCodeReservation() {
        return ThreadLocalRandom.current().nextInt(1, 10000);
    }


    //* Afficher réservation   Khdama
    public void afficherReservation() {

        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String RESET = "\u001B[0m";

        System.out.println();
        System.out.println(YELLOW + " ----- Informations réservation ------" + RESET);
        System.out.println();
        System.out.println(BLUE + "         - Date: " + RESET + date);
        System.out.println();
        System.out.println(BLUE + "         - Heure de début: " + RESET + heureDebut);
        System.out.println();
        System.out.println(BLUE + "         - Heure de fin: " + RESET + heureFin);
        System.out.println();
        System.out.println(BLUE + "         - Code de réservation: " + RESET + codeReservation);
        System.out.println();
        System.out.println(BLUE + "         - Salle: " + RESET + salle.getNumSalle());
        System.out.println();
        System.out.println(BLUE + "         - Evenement: " + RESET + evenement);
        System.out.println();
    }
}

