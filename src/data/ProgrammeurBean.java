/**
 *
 * @author source code : Jacques
 * @author improvement: ADJI Moussa
 * @author improvement: KEBIECHE Wael
 * @author improvement: BRIGUI Achref
 * 
 */
package data;

import myutil.Constantes;

import java.sql.Date;

public class ProgrammeurBean {

    private String matricule;
    private String nom;
    private String prenom;
    private String adresse;
    private String pseudo;
    private String responsable;
    private String hobby;
    private java.sql.Date dateEmb;
    private java.sql.Date dateNaiss;

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
     
    public static Date convertFromStringToDate(String year, int month, String day){
        String strNaiss = year+"-"+Integer.toString(month)+"-"+day;
        return Date.valueOf(strNaiss);
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
