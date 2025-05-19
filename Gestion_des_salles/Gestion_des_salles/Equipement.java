package Gestion_des_salles;

public class Equipement {
    
    //* Attributs
    private String idEquipement;  //^ unique
    private String referenceEquipement;
    private boolean disponibiliteEquipement;
    private double prixEquipement;


    //* Constructeur
    public Equipement(String id, String refEq, boolean dispoEqu, double prix) {
        
        referenceEquipement = refEq;
        disponibiliteEquipement = dispoEqu;
        prixEquipement = prix;
        idEquipement = id;
    }


    //* Getters
    public String getReferenceEquipement() {
        return referenceEquipement;
    }

    public boolean getDisponibiliteEquipement() {
        return disponibiliteEquipement;
    }
    
    public double getPrixEquipement() {
        return prixEquipement;
    }
    
    public String getIdEquipement() {
        return idEquipement;
    }


    //* Setters
    public void setReferenceEquipement(String nomSetter) {
        referenceEquipement = nomSetter;
    }

    public void setDisponibiliteEquipement(boolean dispoSetter) {
        disponibiliteEquipement = dispoSetter;
    }

    public void setPrixEquipement(double prixSetter) {
        prixEquipement = prixSetter;
    }
    
    public void setIdEquipement(String idSetter) {
        idEquipement = idSetter;
    }
}

