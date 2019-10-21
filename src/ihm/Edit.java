/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import data.ActionsBD;
import data.ProgrammeurBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import myutil.Constantes;

/**
 *
 * @author moussa
 */
public class Edit extends JFrame implements ActionListener{
     // Déclaration des attributs
    // L'initialisation se fera "en local" dans des méthodes
    private JButton btnAnnuler;
    private JButton btnValider;
    private JButton btnReinit;
    private JButton btnRechercher;
    
    private JLabel labelMatricule;
    private JLabel labelNom;
    private JLabel labelPrenom;
    private JLabel labelAdress;
    private JLabel labelResponsable;
    private JLabel labelHobby;
    private JLabel labelPseudo;
    private JLabel labelDateNaiss;
    private JLabel labelDateEmb;
    
    private JTextField champMatricule;
    private JTextField champNom;
    private JTextField champPrenom;
    private JTextField champAdress;
    private JTextField champResponsable;
    private JTextField champHobby;
    private JTextField champPseudo;
    private JTextField champJourEmb;
    private JTextField champJourNaiss;
    private JTextField champAnneeEmb;
    private JTextField champAnneeNaiss;

    private JComboBox champMoisEmb;
    private JComboBox champMoisNaiss;
    
    private JPanel mainPanel;
    private JPanel btnPanel;
    private JPanel editPanel ;
    private JPanel matriculePanel;
    
    private JScrollPane scroll;
    private ProgrammeurBean progrBean;
    
    private String contenuMatricule;
    private String contenuTextArea;
    private String contenuNom;
    private String contenuPrenom;
    private String contenuAdress;
    private String contenuResponsable;
    private String contenuHobby;
    private String contenuPseudo;
    private String contenuDateNaiss;
    private String contenuDateEmb;
    
    static final String[] OPTIONSMOIS = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    static final String JOUR = "jour";
    static final String ANNEE = "année";
    static final int COLUMNS = 10;
    private ActionsBD dt;

    public void init() {
        dt = new ActionsBD();
        progrBean = dt.getProgrammeur("Mafalda");
        
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
        
        Date aujourdhui = new Date();

        System.out.println(Constantes.DATE_FORMAT.format(aujourdhui));
        
        btnBottom();
        
        editField();
        
        champMatricule.setText(progrBean.getPseudo());
        champNom.setText(progrBean.getNom());
        champPrenom.setText(progrBean.getPrenom());
        //champAdress.SetText(progrBean.getAdress());
        //champResponsable.setText(progrBean.getResponsable());
        //champHobby.setText(progrBean.getHobby());
        //champPseudo.setText(progrBean.getPseudo());
        //champJourEmb.setText(progrBean.getJourEmb());
        //champJourNaiss.setText(progrBean.getJourNaiss());
        //champAnneeEmb.setText(progrBean.getAnneeEmb());
        //champAnneeNaiss.setText(progrBean.getAnneeNaiss());
        
        
        

        
        matriculePanel.setBackground(Color.BLACK);

        mainPanel.add(matriculePanel, BorderLayout.NORTH);
        mainPanel.add(editPanel);
        editPanel.setBorder(new EmptyBorder(30,30,30,30));
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.setBorder(new EmptyBorder(0,30,10,30));
        
       
        //mainPanel.add(scroll);

        

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
    
    public void editField(){
        labelMatricule = new JLabel("Matricule");
        labelMatricule.setForeground(Color.white);
        labelMatricule.setFont(Constantes.DEFAULTFONT);
        champMatricule = new JTextField();
        
        champMatricule.setColumns(COLUMNS);
        champMatricule.getDocument().addDocumentListener(new InputTextListener());
        
        matriculePanel.add(labelMatricule);
        matriculePanel.add(champMatricule);
       
        
        labelNom = new JLabel("Nom");
        labelNom.setFont(Constantes.DEFAULTFONT);
        champNom = new JTextField();
        champNom.setColumns(COLUMNS/2);
        JPanel nomPanel = new JPanel();
        nomPanel.setLayout(new GridLayout());
        nomPanel.add(labelNom);
        nomPanel.add(champNom);
        editPanel.add(nomPanel);
        
        
        
        labelPrenom = new JLabel("Prénom");
        labelPrenom.setFont(Constantes.DEFAULTFONT);
        champPrenom = new JTextField();
        champPrenom.setColumns(COLUMNS);
        JPanel prenomPanel = new JPanel(new GridLayout());
        prenomPanel.add(labelPrenom);
        prenomPanel.add(champPrenom);
        editPanel.add(prenomPanel);
        
        labelAdress = new JLabel("Adresse");
        labelAdress.setFont(Constantes.DEFAULTFONT);
        champAdress = new JTextField();
        champAdress.setColumns(COLUMNS);
        JPanel adressPanel = new JPanel(new GridLayout());
        adressPanel.add(labelAdress);
        adressPanel.add(champAdress);
        editPanel.add(adressPanel);
        
        labelPseudo = new JLabel("Pseudo");
        labelPseudo.setFont(new Font("Sans-Serif",Font.TRUETYPE_FONT, 12));
        champPseudo = new JTextField();
        champPseudo.setColumns(COLUMNS);
        JPanel PseudoPanel = new JPanel(new GridLayout());
        PseudoPanel.add(labelPseudo);
        PseudoPanel.add(champPseudo);
        editPanel.add(PseudoPanel);
        
        labelResponsable = new JLabel("Responsable");
        labelResponsable.setFont(Constantes.DEFAULTFONT);
        champResponsable = new JTextField();
        champResponsable.setColumns(COLUMNS);
        JPanel ResponsablePanel = new JPanel(new GridLayout());
        ResponsablePanel.add(labelResponsable);
        ResponsablePanel.add(champResponsable);
        editPanel.add(ResponsablePanel);
        
       
        
        labelDateNaiss = new JLabel("Date de naissance");
        labelDateNaiss.setFont(Constantes.DEFAULTFONT);
        champJourNaiss = new JTextField();
        champJourNaiss.setText(JOUR);
        champJourNaiss.setColumns(COLUMNS/2);
        champAnneeNaiss = new JTextField();
        champAnneeNaiss.setText(ANNEE);
        champMoisNaiss = new JComboBox(OPTIONSMOIS);
        JPanel dateNaissPanel = new JPanel(new GridLayout());
        JPanel champsNaiss = new JPanel(new GridLayout(1,3,10,5));
        
        champsNaiss.add(champJourNaiss);
        champsNaiss.add(champMoisNaiss);
        champsNaiss.add(champAnneeNaiss);
        dateNaissPanel.add(labelDateNaiss);
        dateNaissPanel.add(champsNaiss);
        
        editPanel.add(dateNaissPanel);
        
         labelHobby = new JLabel("Hobby");
         labelHobby.setFont(Constantes.DEFAULTFONT);
        champHobby = new JTextField();
        champHobby.setColumns(COLUMNS);
        JPanel HobbyPanel = new JPanel(new GridLayout());
        HobbyPanel.add(labelHobby);
        HobbyPanel.add(champHobby);
        editPanel.add(HobbyPanel);
        
        labelDateEmb = new JLabel("Date d'embauche");
        labelDateEmb.setFont(Constantes.DEFAULTFONT);
        champJourEmb = new JTextField();
        champJourEmb.setText(JOUR);
        champJourEmb.setColumns(COLUMNS/2);
        champAnneeEmb = new JTextField();
        champAnneeEmb.setText(ANNEE);
        champAnneeEmb.setColumns(COLUMNS/2);
        champMoisEmb = new JComboBox(OPTIONSMOIS);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        c.weightx = 1;
        c.weighty = 0;
        JPanel dateEmb = new JPanel(new GridLayout());
        JPanel champsEmb = new JPanel(new GridLayout(1,3,10,5));
        
        champsEmb.add(champJourEmb);
        champsEmb.add(champMoisEmb);
        champsEmb.add(champAnneeEmb);
        dateEmb.add(labelDateEmb,c);
        dateEmb.add(champsEmb, c);
        editPanel.add(dateEmb, c);
    }
    
    public void btnBottom(){
        btnReinit = new JButton("Réinitialiser");
        btnReinit.setFont(Constantes.DEFAULTFONT);
        btnReinit.setSize(5,5);
        btnPanel.add(btnReinit);
        btnReinit.addActionListener(this);
        
        btnValider = new JButton("Valider");
        btnValider.setFont(Constantes.DEFAULTFONT);
        btnPanel.add(btnValider);
        btnValider.addActionListener(this);
        
        btnRechercher = new JButton("Rechercher");
        btnRechercher.setFont(Constantes.DEFAULTFONT);
        btnPanel.add(btnRechercher);
        btnRechercher.addActionListener(this);
        
        btnAnnuler = new JButton("Annuler");
        btnAnnuler.setFont(Constantes.DEFAULTFONT);
        //btnAnnuler.setPreferredSize(new Dimension(90, 25));
        btnPanel.add(btnAnnuler);
        btnAnnuler.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnValider) {
            dt = new ActionsBD();
            contenuNom = champNom.getText();
            contenuMatricule = champMatricule.getText();
            contenuPrenom = champPrenom.getText();
            progrBean.setNom(contenuNom);
            dt.setProgrammeur(progrBean);
            System.out.println("Valider"+contenuNom);
            //JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            dt.fermerRessources();
        }
        if (event.getSource() == btnRechercher) {
            dt = new ActionsBD();
            progrBean = dt.getProgrammeur(this.champNom.getText());
            if (progrBean == null) {
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                contenuTextArea = progrBean.toString();
                //zoneAffichageProgrammeurs.setText(contenuTextArea);
            }

            dt.fermerRessources();
        }
    }
    
}
