/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Jacques
 */
public class ProgrammeurBean {

    private String nom;
    private String prenom;
    private int anNaissance;
    private float salaire;
    private float prime;
    private String pseudo;

    public ProgrammeurBean() {
    }

    @Override
    public String toString() {
        String affichage = "Prénom : " + this.getPrenom() + "\n"
                            + "Nom : " + this.getNom() + "\n"
                            + "Année de naissance : " + this.getAnNaissance() + "\n"
                            + "Salaire : " + this.getSalaire() + "\n"
                            + "Prime : " + this.getPrime() + "\n"
                            + "Pseudo : " + this.getPseudo() + "\n"
                            + "\n";

        return affichage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnNaissance() {
        return anNaissance;
    }

    public void setAnNaissance(int anNaissance) {
        this.anNaissance = anNaissance;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

}
