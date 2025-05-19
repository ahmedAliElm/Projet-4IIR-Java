package Gestion_des_salles;

public class Utilisateur {
    
    private String nomUtilisateur;
    private String cinUtilisateur;
    private String emailUtilisateur;
    private String motDePasseUtilisateur;
    private boolean admin;


    //* Constructeur
    public Utilisateur(String nom, String cin, boolean adminCons, String email, String mdp) {

        nomUtilisateur = nom;
        cinUtilisateur = cin;
        admin = adminCons;
        emailUtilisateur = email;
        motDePasseUtilisateur = mdp;
    }


    //* Getters
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getCinUtilisateur() {
        return cinUtilisateur;
    }

    public boolean isAdmin() {
        return admin;
    }
    
    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }
    
    public String getMotDePasseUtilisateur() {
        return motDePasseUtilisateur;
    }


    //* Setters
    public void setNomUtilisateur(String nomUtilSetter) {
        nomUtilisateur = nomUtilSetter;
    }

    public void setCinUtilisateur(String CinUtilSetter) {
        cinUtilisateur = CinUtilSetter;
    }

    public void setAdmin(boolean adminSetter) {
        admin = adminSetter;
    }
    
    public void setEmailUtilisateur(String emailSetter) {
        emailUtilisateur = emailSetter;
    }
    
    public void setMotDePasseUtilisateur(String mdpSetter) {
        motDePasseUtilisateur = mdpSetter;
    }


    //* Khdama
    public void afficherInfosUtilisateur() {

        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String RESET = "\u001B[0m";

        System.out.println();
        System.out.println(YELLOW + " ----- Informations Utilisateur -----" + RESET);
        System.out.println();
        System.out.println(BLUE + "        - Nom: " + RESET + nomUtilisateur);
        System.out.println();
        System.out.println(BLUE + "        - CIN: " + RESET + cinUtilisateur);
        System.out.println();
        System.out.println(BLUE + "        - Admin: " + RESET + admin);
        System.out.println();
        System.out.println(BLUE + "        - Email: " + RESET + emailUtilisateur);
        System.out.println();
        System.out.println(BLUE + "        - Mot de passe: " + RESET + motDePasseUtilisateur);
        System.out.println();
    }
}

