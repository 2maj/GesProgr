/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import myutil.Constantes;

import java.util.Date;

/**
 *
 * @author Jacques
 */
public class ProgrammeurBean {

    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String pseudo;
    private String responsable;
    private String hobby;
    private Date dateEmb;
    private Date dateNaiss;

    public ProgrammeurBean() {
    }
    
     public ProgrammeurBean(String matricule, String nom, String prenom, String adresse, String pseudo, String responsable, String hobby, Date dateEmb, Date dateNaiss) {
         this.matricule = matricule;
         this.nom = nom;
         this.prenom = prenom;
         this.adresse = adresse;
         this.pseudo = pseudo;
         this.responsable = responsable;
         this.hobby = hobby;
         this.dateEmb = dateEmb;
         this.dateNaiss = dateNaiss;
         
    }

    @Override
    public String toString() {
        String affichage = "Matricule : " + this.getMatricule() + "\n"
							+ "Nom : " + this.getNom() + "\n"
							+ "Prénom : " + this.getPrenom() + "\n"
							+ "Addresse : " + this.getAdresse() + "\n"
							+ "Pseudo : " + this.getPseudo() + "\n"
							+ "Responsable : " + this.getResponsable() + "\n"
							+ "Hobby : " + this.getHobby() + "\n"
							+ "Date de naissance : " + Constantes.DATE_FORMAT.format(this.getDateNaiss()) + "\n"
							+ "Date Embauche : " + Constantes.DATE_FORMAT.format(this.getDateEmb()) + "\n"
                            + "\n";

        return affichage;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
	
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
	
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
	
    public String getResponsable() {
        return responsable;
    }

    public void setResposable(String responsable) {
        this.responsable = responsable;
    }
	
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaissance) {
        this.dateNaiss = dateNaissance;
    }

    public Date getDateEmb() {
        return dateEmb;
    }

    public void setDateEmb(Date dateEmb) {
        this.dateEmb = dateEmb;
    }
}
