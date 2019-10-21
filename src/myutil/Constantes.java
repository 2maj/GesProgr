/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

import java.awt.Font;
import java.text.SimpleDateFormat;

/**
 *
 * @author Jacques
 */
public class Constantes {

    public static final String OCCUPATION = "Programmeur";
    public static final String URL = "jdbc:derby://localhost:1527/BDTPJAVA";
    public static final String USER = "adm";
    public static final String MDP = "adm";
    public static final String REQUETE_TOUS = "SELECT * from PROGRAMMEUR";
    public static final String REQUETE_UNIQUE = "SELECT * from PROGRAMMEUR WHERE nom = ?";
    public static final String REQUETE_UPDATE = "UPDATE PROGRAMMEUR SET NOM = ?, PRENOM = ?,"
            + " ANNAISSANCE = ?, SALAIRE = ?, PRIME = ? WHERE PSEUDO = ?";
    public static final String REQUETE_INSERT = "INSERT INTO PROGRAMMEUR"
            + "(MATRICULE, NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, DATE_NAISS, DATE_EMB)"
            + " VALUES(?,?,?,?,?,?,?,?,?)";
    public static final Font DEFAULTFONT = new Font("Sans-Serif",Font.TRUETYPE_FONT, 12);
    
    public static final SimpleDateFormat DATE_FORMAT= new SimpleDateFormat("Y-M-d");

}
