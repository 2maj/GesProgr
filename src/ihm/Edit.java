/**
 *
 * @author source code : Jacques 
 * @author improvement: ADJI Moussa
 * @author improvement: KEBIECHE Wael
 * @author improvement: BRIGUI Achref
 * 
 */
package ihm;

import data.ActionsBD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Date;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import myutil.Constantes;


public class Edit extends VueEditField {
    /**
     * @description Ici nous initialisons/définissons les spécificités de l'interface d'édition tels des boutons grisés, des champs désactivés ...
     */
    public void init() {
        dt = new ActionsBD();
        progrBean = dt.getProgrammeur("17548");
        
        if (progrBean == null) {
            
            JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
        } else {
        mainPanel = new JPanel(); // Créantion d'un mainPanell pour gérer les widgets
        mainPanel.setLayout(new BorderLayout(8,6));
       
        matriculePanel = new JPanel();
        matriculePanel.setLayout(new FlowLayout(3));
        
        editPanel = new JPanel();
        editPanel.setLayout(new GridLayout(4,5,20,10));
        
        btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout());
                
        btnBottom();
        
        editField();
        
        addingListenerToField();
        
        champMatricule.setText(progrBean.getMatricule());
        champMatricule.setEditable(false); //Désactiver le champ matricule
        champNom.setText(progrBean.getNom());
        champPrenom.setText(progrBean.getPrenom());
        champAdress.setText(progrBean.getAdresse());
        champResponsable.setText(progrBean.getResponsable());
        champHobby.setText(progrBean.getHobby());
        champPseudo.setText(progrBean.getPseudo());
        champPseudo.setEditable(false);

        champJourEmb.setText(Constantes.DATE_FORMAT_D.format(progrBean.getDateEmb()));
        champJourNaiss.setText(Constantes.DATE_FORMAT_D.format(progrBean.getDateNaiss()));
        champMoisNaiss.setSelectedIndex(Integer.parseInt(Constantes.DATE_FORMAT_M.format(progrBean.getDateNaiss())) -1);
        champMoisEmb.setSelectedIndex(Integer.parseInt(Constantes.DATE_FORMAT_M.format(progrBean.getDateEmb())) -1);
        champAnneeEmb.setText(Constantes.DATE_FORMAT_Y.format(progrBean.getDateEmb()));
        champAnneeNaiss.setText(Constantes.DATE_FORMAT_Y.format(progrBean.getDateNaiss()));
        
        matriculePanel.setBackground(Color.BLACK);

        mainPanel.add(matriculePanel, BorderLayout.NORTH);
        mainPanel.add(editPanel);
        editPanel.setBorder(new EmptyBorder(30,30,30,30));
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.setBorder(new EmptyBorder(0,30,10,30));
        

        /**
         * Par défaut, notre frame n'est pas visible
         * Il faut donc forcer la visibilité à "true"
         */
        this.setVisible(true);
        this.setTitle("Modifier");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Fermeture fenêtre = arrêt de l'application 
        setBounds(10, 10, 600, 300);

        this.add(mainPanel); // Ajout du mainPanell à notre frame de base
        }

        dt.fermerRessources();
        
        
    }
    
    @Override
    /*
    public void actionPerformed(ActionEvent event) {
        try{
            dt = new ActionsBD();


            if (event.getSource() == btnValider) {


                contenuPrenom = champPrenom.getText();

                contenuNom = champNom.getText();

                contenuAdress = champAdress.getText();
                contenuResponsable = champResponsable.getText();
                contenuHobby = champHobby.getText();

                progrBean.setNom(contenuNom);
                progrBean.setPrenom(contenuPrenom);
                progrBean.setAdresse(contenuAdress);
                progrBean.setHobby(contenuHobby);

                contenuDateNaiss = progrBean.convertFromStringToDate(champAnneeNaiss.getText(), champMoisNaiss.getSelectedIndex()+1, champJourNaiss.getText());

                contenuDateEmb = progrBean.convertFromStringToDate(champAnneeEmb.getText(), champMoisEmb.getSelectedIndex()+1, champJourEmb.getText());

                dt.setProgrammeur(progrBean);
                System.out.println("Valider"+contenuDateNaiss);


            }

            if(event.getSource() == btnAnnuler){

            }
            dt.fermerRessources();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
        }
    }
    */
    
    /**
     * Avant d'éffectuer le traitement sur le contenu des champs récupérés de l'utilisateur nous allons vérifier que cest données sont correctes.
    */
    
    public void actionPerformed(ActionEvent event) {
        boolean condition = true;
        if (event.getSource() == btnValider) {
            dt = new ActionsBD();
            
            
             
             
            
            contenuPrenom = champPrenom.getText();
            contenuNom = champNom.getText();
            
            contenuAdress = champAdress.getText();
            contenuResponsable = champResponsable.getText();
            contenuHobby = champHobby.getText();
            
            String cMatricule = String.valueOf(champMatricule.getText());
            String cAnneeNaiss =  champAnneeNaiss.getText();
            String cMoisNaiss = Integer.toString(champMoisNaiss.getSelectedIndex()+1);
            String cJourNaiss = champJourNaiss.getText();
            
            String cAnneeEmb = champAnneeEmb.getText();
            String cMoisEmb = Integer.toString(champMoisEmb.getSelectedIndex()+1);
            String cJourEmb = champJourEmb.getText();
            
            
        
            
            if ((cJourEmb==cJourNaiss) && (cAnneeEmb==cAnneeNaiss) && (cMoisEmb==cMoisNaiss)){
                condition = false;
            }
        
            if(!checkday(cJourNaiss) || !checkday(cJourEmb)){
                condition = false;
            }
            
            if (!checkyear(cAnneeEmb)|| !checkyear(cAnneeEmb)){
            condition = false;
            }
            
             if (!checkvalue(contenuPrenom) || !checkvalue(contenuNom) 
                 || !checkvalue(contenuAdress) || !checkvalue(contenuResponsable) ||
                     !checkvalue(contenuHobby)){
                    condition = false;
                       // JOptionPane.showMessageDialog(this, "Il y a une ou plusieurs valeurs nulles", "Echec", JOptionPane.ERROR_MESSAGE);
                      }
             
             if (!isInteger(cMatricule) ||!isInteger(cJourNaiss) ||!isInteger(cJourEmb)){
                 condition = false;
             }
             
             if (!isNotInteger(contenuPrenom) || !isNotInteger(contenuNom) 
                 || !isNotInteger(contenuResponsable) ||
                     !isNotInteger(contenuHobby)
                     ){
                        condition = false;
                        //JOptionPane.showMessageDialog(this, "Erreur de saisie", "Programmeur introuvable", JOptionPane.ERROR_MESSAGE);
                        //OptionPane.showMessageDialog(this, "Mauvais contenu dans l'un des champs", "Echec", JOptionPane.ERROR_MESSAGE);
                      }
             
            
             
             if (!condition){
                 JOptionPane.showMessageDialog(this, "Erreur de saisie", "Programmeur introuvable", JOptionPane.ERROR_MESSAGE);
                
             }
             else{
            progrBean.setNom(contenuNom);
            progrBean.setPrenom(contenuPrenom);
            progrBean.setAdresse(contenuAdress);
            progrBean.setHobby(contenuHobby);
            
            String strNaiss = champAnneeNaiss.getText()+"-"+Integer.toString(champMoisNaiss.getSelectedIndex()+1)+"-"+champJourNaiss.getText();
            contenuDateNaiss = Date.valueOf(strNaiss);
            String strEmb = champAnneeEmb.getText()+"-"+Integer.toString(champMoisEmb.getSelectedIndex()+1)+"-"+champJourEmb.getText();
            contenuDateEmb = Date.valueOf(strEmb);
            
            dt.setProgrammeur(progrBean);
            System.out.println("Valider"+contenuDateNaiss);
            //JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            dt.fermerRessources();
             }
           
             }
    
    }
}
