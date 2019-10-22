/**
 *
 * @author source code : Jacques
 * @author improvement: ADJI Moussa
 * @author improvement: KEBIECHE Wael
 * @author improvement: BRIGUI Achref
 * 
 */
package myutil;

import java.awt.Font;
import java.text.SimpleDateFormat;


public class Constantes {

    public static final String OCCUPATION = "Programmeur";
    
    public static final String URL = "jdbc:derby://localhost:1527/BDTPJAVA";
    
    public static final String USER = "adm";
    
    public static final String MDP = "adm";
    
    public static final String REQUETE_TOUS = "SELECT * from PROGRAMMEUR";
    
    public static final String REQUETE_UNIQUE = "SELECT * from PROGRAMMEUR WHERE matricule = ?";
    
    public static final String REQUETE_UPDATE = "UPDATE PROGRAMMEUR SET "
            + "NOM = ?, PRENOM = ?, ADRESSE = ?, PSEUDO = ?, RESPONSABLE = ?, HOBBY = ?,"
            + " DATE_NAISS = ?, DATE_EMB = ? WHERE MATRICULE = ?";
    
    public static final String REQUETE_INSERT = "INSERT INTO PROGRAMMEUR"
            + "(MATRICULE, NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, DATE_NAISS, DATE_EMB)"
            + " VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String MATRICULE = "Matricule";
    
    public static final String NOM = "Nom";
    
    public static final String PRENOM = "Prénom";
    
    public static final String ADRESSE = "Adresse";
    
    public static final String HOBBY = "Hobby";
    
    public static final String RESPONSABLE = "Responsable";
    
    public static final String PSEUDO = "Pseudo";
    
    public static final String DATE_NAISS = "Date de naissance";
    
    public static final String DATE_EMB = "Date d'embauche";
    
    public static final String[] OPTIONSMOIS = {"01","02","03","04","05","06","07","08","09","10","11","12"};

    public static final String JOUR = "jour";
    
    public static final String ANNEE = "année";
    
    public static final String PROG_NOT_FOUND = "Programmeur introuvable";
    
    public static final int COLUMNS = 10;
    
    public static final Font DEFAULTFONT = new Font("Sans-Serif",Font.TRUETYPE_FONT, 12);
    
    public static final SimpleDateFormat DATE_FORMAT= new SimpleDateFormat("yyyy-MM-dd");
    
    public static final SimpleDateFormat DATE_FORMAT_Y= new SimpleDateFormat("yyyy");
    
    public static final SimpleDateFormat DATE_FORMAT_M= new SimpleDateFormat("MM");
    
    public static final SimpleDateFormat DATE_FORMAT_D= new SimpleDateFormat("d");
}
