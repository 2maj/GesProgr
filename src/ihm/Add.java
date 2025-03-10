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
import data.ProgrammeurBean;
import java.awt.BorderLayout;
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

/**
 *
 * @author moussa
 */
public class Add extends VueEditField{

    public void init() {
       
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
   
    @Override
    public void actionPerformed(ActionEvent event) {
        boolean condition = true;
        try{
            
            dt = new ActionsBD();
            if (event.getSource() == btnValider) {

                
                contenuMatricule = champMatricule.getText();
                contenuNom = champNom.getText();
                contenuPrenom = champPrenom.getText();
                contenuAdress = champAdress.getText();
                contenuResponsable = champResponsable.getText();
                contenuHobby = champHobby.getText();
                contenuPseudo = champPseudo.getText();
                
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
             }else{
                
                

                contenuDateNaiss = progrBean.convertFromStringToDate(champAnneeNaiss.getText(), champMoisNaiss.getSelectedIndex()+1, champJourNaiss.getText());

                contenuDateEmb = progrBean.convertFromStringToDate(champAnneeEmb.getText(), champMoisEmb.getSelectedIndex()+1, champJourEmb.getText());

                progrBean = new ProgrammeurBean(contenuMatricule, contenuNom, contenuPrenom, contenuAdress, contenuResponsable, contenuHobby, contenuPseudo, contenuDateEmb, contenuDateNaiss);
                System.out.println("Valider  :"+progrBean.toString());
                dt.addProgrammeur(progrBean);

                dt.fermerRessources();
            }}
            if (event.getSource() == btnReinit) {
                dt = new ActionsBD();
                if (progrBean == null) {
                    JOptionPane.showMessageDialog(this, Constantes.PROG_NOT_FOUND, "Echec", JOptionPane.ERROR_MESSAGE);
                } else {
                    contenuTextArea = progrBean.toString();
                }


            }

            if(event.getSource() == btnAnnuler){

            }}
            catch( Exception e){
                    JOptionPane.showMessageDialog(this, "Erreur", "Arret de la connexion", JOptionPane.ERROR_MESSAGE);
                    }
            dt.fermerRessources();
    }
    
        
    }
