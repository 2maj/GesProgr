/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

/**
 *
 * @author moussa
 */
public class Search extends VueEditField{
    
    /**
     * @description Ici nous initialisons/définissons les spécificités de l'interface d'édition tels des boutons grisés, des champs désactivés ...
     */
    public void init() {
        dt = new ActionsBD();
        
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
        
        
        
        champNom.setEditable(false);
        champPrenom.setEditable(false);
        champAdress.setEditable(false);
        champResponsable.setEditable(false);
        champHobby.setEditable(false);
        champPseudo.setEditable(false);
        
        
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
        

        dt.fermerRessources();
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        
        if (event.getSource() == btnRechercher) {
            dt = new ActionsBD();
            
            contenuMatricule = champMatricule.getText();
            try{
                progrBean = dt.getProgrammeur(contenuMatricule);
            }catch(Exception a){
                 JOptionPane.showMessageDialog(this, "Erreur de saisie ou programmeur inextistant !", "Programmeur introuvable", JOptionPane.ERROR_MESSAGE);
                
             }
            System.out.println("Valider"+contenuDateNaiss);
            dt.fermerRessources();
             }
           
             }
    
    }
  

