/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import myutil.Constantes;

/**
 *
 * @author Jacques
 */
public class ActionsBD {

    private Connection dbConn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<ProgrammeurBean> listeProgrammeurs;
    private ProgrammeurBean prog;

    /**
     * Le constructeur permet d'initialiser la connexion
     *
     */
    public ActionsBD() {
        try {
            dbConn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBD.class.getName()).log(Level.SEVERE, null, sqle);
        }

    }

    /**
     * Lance la récupère passée en paramètre et retourne le ResultSet
     * correspondant à cette requête
     *
     * @param req La requête SQL que l'on souhaite exécuter
     * @return rs Une variable de type ResultSet
     */
    public ResultSet getResultSet(String req) {
        try {
            stmt = dbConn.createStatement();
            rs = stmt.executeQuery(req);
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBD.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return rs;
    }

    /**
     * Cette méthode récupère toutes les infos d'un programmeur et retourne une
     * liste de l'ensemble des programmeurs
     *
     * @return listeProgrammeurs Une variable de type ArryList
     */
    public ArrayList getProgrammeurs() {
        rs = this.getResultSet(Constantes.REQUETE_TOUS);
        listeProgrammeurs = new ArrayList<>();

        try {
            while (rs.next()) {
                prog = new ProgrammeurBean(
                        rs.getString("MATRICULE"), rs.getString("NOM"),
                        rs.getString("PRENOM"), rs.getString("ADRESSE"),
                        rs.getString("PSEUDO") ,rs.getString("RESPONSABLE"),
                        rs.getString("HOBBY"), convertFromSQLDateToJAVADate(rs.getDate("DATE_NAISS")),
                        convertFromSQLDateToJAVADate(rs.getDate("DATE_EMB"))
                );
                listeProgrammeurs.add(prog);
            }
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBD.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return listeProgrammeurs;
    }
    
    /**
     * 
     * @param p
     */
    public void setProgrammeur(ProgrammeurBean p){
        try {
            //MATRICULE, NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, DATE_NAISS, DATE_EMB
            pstmt = dbConn.prepareStatement(Constantes.REQUETE_UPDATE);
            //pstmt.setString(1, p.getMatricule());
            pstmt.setString(1, p.getNom());
            pstmt.setString(2, p.getPrenom());
            pstmt.setString(3, p.getAdresse());
            pstmt.setString(4, p.getPseudo());
            pstmt.setString(5, p.getResponsable());
            pstmt.setString(6, p.getHobby());
            pstmt.setDate(7, convertFromSQLDateToJAVADate(p.getDateNaiss()));
            pstmt.setDate(8, convertFromSQLDateToJAVADate(p.getDateEmb()));
            pstmt.setString(9, p.getMatricule());
            pstmt.executeUpdate();
            
            System.out.println("Setting");
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBD.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }
    
    public void addProgrammeur(ProgrammeurBean p){
        try {
            //MATRICULE, NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, DATE_NAISS, DATE_EMB
            pstmt = dbConn.prepareStatement(Constantes.REQUETE_INSERT);
            pstmt.setString(1, p.getMatricule());
            pstmt.setString(1, p.getNom());
            pstmt.setString(2, p.getPrenom());
            pstmt.setString(3, p.getAdresse());
            pstmt.setString(4, p.getPseudo());
            pstmt.setString(5, p.getResponsable());
            pstmt.setString(6, p.getHobby());
            pstmt.setDate(7, convertFromSQLDateToJAVADate(p.getDateNaiss()));
            pstmt.setDate(8, convertFromSQLDateToJAVADate(p.getDateEmb()));
            pstmt.setString(9, p.getMatricule());
            pstmt.executeUpdate();
            
            System.out.println("Adding");
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBD.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    /**
     * Cette méthode récupère toutes les infos d'un programmeur et retourne ce
     * programmeur sous la forme d'un Java Bean Cette méthode est utilisée pour
     * rechercher un progammeur via son matricule
     *
     * @param nom Le nom saisi par l'utilisateur pour lancer la recherche
     * @return prog Une variable de type ProgrammeurBean
     *
     */
    public ProgrammeurBean getProgrammeur(String matricule) {
        try {
            pstmt = dbConn.prepareStatement(Constantes.REQUETE_UNIQUE);
            pstmt.setString(1, matricule);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                //MATRICULE, NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, DATE_NAISS, DATE_EMB
                prog = new ProgrammeurBean();
                
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setNom(rs.getString("NOM"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setPseudo(rs.getString("PSEUDO"));
                prog.setResposable(rs.getString("RESPONSABLE"));
                prog.setHobby(rs.getString("HOBBY"));
                prog.setDateNaiss(rs.getDate("DATE_NAISS"));
                prog.setDateEmb(rs.getDate("DATE_EMB"));
                
            }
        } catch (SQLException sqle) {
            Logger.getLogger(ActionsBD.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return prog;
    }
    
    public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
    
    public static java.sql.Date convertFromSQLDateToJAVADate(
             java.util.Date javaDate) {
        return new java.sql.Date (javaDate.getTime());
    }

    /**
     * Cette méthode permet de construire la chaîne de caractères qui sera
     * affichée lorsqu'on choisit Programmeur - Afficher - Tous
     *
     * @return listeProg Une variable de type String
     *
     */
    public String afficherProgrammeurs() {
        String listeProg = "";

        listeProgrammeurs = this.getProgrammeurs();
        for (ProgrammeurBean progr : listeProgrammeurs) {
            listeProg = listeProg + progr;
        }

        return listeProg;
    }

    /**
     * Cette méthode permet de libérer les ressources liées à la base de données
     * *
     */
    public void fermerRessources() {
        if (dbConn != null) {
            try {
                dbConn.close();
                if (stmt != null) {
                    stmt.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                dbConn = null;
            } catch (SQLException ex) {
                Logger.getLogger(ActionsBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
