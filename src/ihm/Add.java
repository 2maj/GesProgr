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
        if (event.getSource() == btnValider) {
            dt = new ActionsBD();
            
            contenuMatricule = champMatricule.getText();
            contenuNom = champNom.getText();
            contenuPrenom = champPrenom.getText();
            contenuAdress = champAdress.getText();
            contenuResponsable = champResponsable.getText();
            contenuHobby = champHobby.getText();
            contenuPseudo = champPseudo.getText();
               
            String strNaiss = champAnneeNaiss.getText()+"-"+Integer.toString(champMoisNaiss.getSelectedIndex()+1)+"-"+champJourNaiss.getText();
            contenuDateNaiss = java.sql.Date.valueOf(strNaiss);
            String strEmb = champAnneeEmb.getText()+"-"+Integer.toString(champMoisEmb.getSelectedIndex()+1)+"-"+champJourEmb.getText();
            contenuDateEmb = java.sql.Date.valueOf(strEmb);
            
            progrBean = new ProgrammeurBean(contenuMatricule, contenuNom, contenuPrenom, contenuAdress, contenuResponsable, contenuHobby, contenuPseudo, contenuDateEmb, contenuDateNaiss);
            System.out.println("Valider  :"+progrBean.toString());
            dt.addProgrammeur(progrBean);
            
            dt.fermerRessources();
        }
        if (event.getSource() == btnReinit) {
            dt = new ActionsBD();
            if (progrBean == null) {
                JOptionPane.showMessageDialog(this, Constantes.PROG_NOT_FOUND, "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                contenuTextArea = progrBean.toString();
                //zoneAffichageProgrammeurs.setText(contenuTextArea);
            }

            dt.fermerRessources();
        }
        
        if(event.getSource() == btnAnnuler){
            
        }
    }
    
}
