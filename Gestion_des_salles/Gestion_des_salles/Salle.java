package Gestion_des_salles;

public class Salle {

    //* Attributs
    private int numSalle;
    private int capaciteSalle;
    private int nombreEqu;
    private boolean disponibiliteSalle;
    private boolean wifiSalle;
    private Equipement[] equipementsArray;
    

    //* Constructeur
    public Salle(int num, int cap, boolean dispoSalle, boolean wifi) {
        
        numSalle = num;
        capaciteSalle = cap;
        disponibiliteSalle = dispoSalle;
        equipementsArray = new Equipement[100];
        nombreEqu = 0;
        wifiSalle = wifi;
    }


    //* Getters
    public int getNumSalle() {
        return numSalle;
    }

    public int getCapaciteSalle() {
        return capaciteSalle;
    }

    public boolean getDisponibiliteSalle() {
        return disponibiliteSalle;
    }
    
    public int getNombreEqu() {
        return nombreEqu;
    }
    
    public boolean getWifiSalle() {
        return wifiSalle;
    }


    //* Setters
    public void setNumSalle(int numSetter) {
        numSalle = numSetter;
    }

    public void setCapaciteSalle(int capSetter) {
        capaciteSalle = capSetter;
    }

    public void setDisponibiliteSalle(boolean dispoSetter) {
        disponibiliteSalle = dispoSetter;
    }
    
    public void setNombreEqu(int nombreEqSetter) {
        nombreEqu = nombreEqSetter;
    }
    
    public void setWifiSalle(boolean wifiSetter) {
        wifiSalle = wifiSetter;
    }



    //!----- TRAITEMENT DES EQUIPEMENTS -----!//

    //* Ajouter equipement    Khdama
    public void ajouterEquipement(Equipement E) {

        boolean eqExiste = false;

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        for (int i = 0; i < nombreEqu; i++) {

            if (equipementsArray[i].getIdEquipement().equals(E.getIdEquipement())) {

                System.out.println();
                System.out.println(RED + " --> Erreur! Equipement deja existant." + RESET);
                eqExiste = true; 

                break;
            }
        }

        if (!eqExiste) {

            equipementsArray[nombreEqu] = E;
            nombreEqu++;

            System.out.println();
            System.out.println(GREEN + " --> Equipement ajouté avec succès." + RESET); 
        }
    }


    //* Afficher equipement   Khdama
    public void afficherEquipements() {

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        // String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        // String CYAN = "\u001B[36m";
        // String WHITE = "\u001B[37m";

        if (nombreEqu == 0) {

            System.out.println();
            System.out.println(RED + " --> Aucun équipement dans cette salle." + RESET);
            System.out.println();

            return;
        }

        System.out.println();
        System.out.println();
        System.out.println(YELLOW + "          { Informations Equipements (Salle " + getNumSalle() + ") }" + RESET);

        for (int i = 0; i < nombreEqu; i++) {

            System.out.println();
            System.out.println(PURPLE + "               + Equipement " + (i + 1) + ":" + RESET);
            System.out.println();
            System.out.println(BLUE + "                     - ID: " + RESET + equipementsArray[i].getIdEquipement());
            System.out.println();
            System.out.println(BLUE + "                     - Référence: " + RESET + equipementsArray[i].getReferenceEquipement());
            System.out.println();
            System.out.println(BLUE + "                     - Disponibilité: " + RESET + equipementsArray[i].getDisponibiliteEquipement());
            System.out.println();
            System.out.println(BLUE + "                     - Prix: " + RESET + equipementsArray[i].getPrixEquipement());
            System.out.println();
        }
    }


    //* Modifier equipement   Khdama
    public void modifierEquipement(String id, String ref, boolean dispo) {

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        boolean eqTrouve = false;

        for (int i = 0; i < nombreEqu; i++) {

            if (id.equals(equipementsArray[i].getIdEquipement())) {

                equipementsArray[i].setReferenceEquipement(ref);
                System.out.println();
                System.out.println(GREEN + " --> Référence modifiée avec succès." + RESET); 

                equipementsArray[i].setDisponibiliteEquipement(dispo);
                System.out.println();
                System.out.println(GREEN + " --> Disponibilité modifiée avec succès." + RESET); 
                
                eqTrouve = true;
                break; 
            }
        }

        if (!eqTrouve) {

            System.out.println();
            System.out.println(RED + " --> Equipement introuvable!" + RESET);
            System.out.println();
        }
    }


    //* Supprimer équipement  Khdama
    public void supprimerEquipement(String id) {

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";

        boolean eqTrouve = false;

        for (int i = 0; i < nombreEqu; i++) {
    
            if (id.equals(equipementsArray[i].getIdEquipement())) {
    
                Equipement[] newArray = new Equipement[equipementsArray.length - 1];
    
                System.arraycopy(equipementsArray, 0, newArray, 0, i);
    
                System.arraycopy(equipementsArray, i + 1, newArray, i, equipementsArray.length - i - 1);
    
                equipementsArray = newArray;
    
                nombreEqu--;

                System.out.println();
                System.out.println(GREEN + " --> Equipement supprimé avec succès." + RESET); 
    
                eqTrouve = true;
                break; 
            }
        }

        if (!eqTrouve) {

            System.out.println();
            System.out.println(RED + " --> Equipement introuvable!" + RESET);
            System.out.println();
        }
            
    }
}

