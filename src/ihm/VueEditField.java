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
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Character.isDigit;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import myutil.Constantes;

public abstract class VueEditField extends JFrame implements ActionListener{
    // Déclaration des attributs
    // L'initialisation se fera "en local" dans des méthodes
    JButton btnAnnuler;
    JButton btnValider;
    JButton btnReinit;
    JButton btnRechercher;

    JLabel labelMatricule;

    JLabel labelNom;
    JLabel labelPrenom;
    JLabel labelAdress;
    JLabel labelResponsable;
    JLabel labelHobby;
    JLabel labelPseudo;
    JLabel labelDateNaiss;
    JLabel labelDateEmb;

    JTextField champMatricule;
    JTextField champNom;
    JTextField champPrenom;
    JTextField champAdress;
    JTextField champResponsable;
    JTextField champHobby;
    JTextField champPseudo;
    JTextField champJourEmb;
    JTextField champJourNaiss;
    JTextField champAnneeEmb;
    JTextField champAnneeNaiss;

    JComboBox champMoisEmb;
    JComboBox champMoisNaiss;

    JPanel mainPanel;
    JPanel btnPanel;
    JPanel editPanel ;
    JPanel matriculePanel;

    ProgrammeurBean progrBean;

    String contenuMatricule;
    String contenuTextArea;
    String contenuNom;
    String contenuPrenom;
    String contenuAdress;
    String contenuResponsable;
    String contenuHobby;
    String contenuPseudo;
    java.sql.Date contenuDateNaiss;
    java.sql.Date contenuDateEmb;
    ActionsBD dt;
     
    
    public abstract void init();
    
    public void editField(){
        labelMatricule = new JLabel(Constantes.MATRICULE);
        labelMatricule.setForeground(Color.white);
        labelMatricule.setFont(Constantes.DEFAULTFONT);
        champMatricule = new JTextField();
        
        champMatricule.setColumns(Constantes.COLUMNS);
        
        matriculePanel.add(labelMatricule);
        matriculePanel.add(champMatricule);
       
        
        labelNom = new JLabel(Constantes.NOM);
        labelNom.setFont(Constantes.DEFAULTFONT);
        champNom = new JTextField();
        champNom.setColumns(Constantes.COLUMNS);
                
        JPanel nomPanel = new JPanel();
        nomPanel.setLayout(new GridLayout());
        nomPanel.add(labelNom);
        nomPanel.add(champNom);
        editPanel.add(nomPanel);
        
        
        
        labelPrenom = new JLabel(Constantes.PRENOM);
        labelPrenom.setFont(Constantes.DEFAULTFONT);
        champPrenom = new JTextField();
        champPrenom.setColumns(Constantes.COLUMNS);
        
        JPanel prenomPanel = new JPanel(new GridLayout());
        prenomPanel.add(labelPrenom);
        prenomPanel.add(champPrenom);
        editPanel.add(prenomPanel);
        
        labelAdress = new JLabel(Constantes.ADRESSE);
        labelAdress.setFont(Constantes.DEFAULTFONT);
        champAdress = new JTextField();
        champAdress.setColumns(Constantes.COLUMNS);
        JPanel adressPanel = new JPanel(new GridLayout());
        adressPanel.add(labelAdress);
        adressPanel.add(champAdress);
        editPanel.add(adressPanel);
        
        labelPseudo = new JLabel(Constantes.PSEUDO);
        labelPseudo.setFont(Constantes.DEFAULTFONT);
        champPseudo = new JTextField();
        champPseudo.setColumns(Constantes.COLUMNS);
        
        JPanel PseudoPanel = new JPanel(new GridLayout());
        PseudoPanel.add(labelPseudo);
        PseudoPanel.add(champPseudo);
        editPanel.add(PseudoPanel);
        
        labelResponsable = new JLabel(Constantes.RESPONSABLE);
        labelResponsable.setFont(Constantes.DEFAULTFONT);
        champResponsable = new JTextField();
        champResponsable.setColumns(Constantes.COLUMNS);
        
        JPanel ResponsablePanel = new JPanel(new GridLayout());
        ResponsablePanel.add(labelResponsable);
        ResponsablePanel.add(champResponsable);
        editPanel.add(ResponsablePanel);
        
       
        
        labelDateNaiss = new JLabel(Constantes.DATE_NAISS);
        labelDateNaiss.setFont(Constantes.DEFAULTFONT);
        champJourNaiss = new JTextField();
        champJourNaiss.setText(Constantes.JOUR);
        champJourNaiss.setColumns(Constantes.COLUMNS/2);
        champAnneeNaiss = new JTextField();
        champAnneeNaiss.setText(Constantes.ANNEE);
        champMoisNaiss = new JComboBox(Constantes.OPTIONSMOIS);
        JPanel dateNaissPanel = new JPanel(new GridLayout());
        JPanel champsNaiss = new JPanel(new GridLayout(1,3,10,5));
        
        champsNaiss.add(champJourNaiss);
        champsNaiss.add(champMoisNaiss);
        champsNaiss.add(champAnneeNaiss);
        dateNaissPanel.add(labelDateNaiss);
        dateNaissPanel.add(champsNaiss);
        
        editPanel.add(dateNaissPanel);
        
         labelHobby = new JLabel(Constantes.HOBBY);
         labelHobby.setFont(Constantes.DEFAULTFONT);
        champHobby = new JTextField();
        champHobby.setColumns(Constantes.COLUMNS);
        JPanel HobbyPanel = new JPanel(new GridLayout());
        HobbyPanel.add(labelHobby);
        HobbyPanel.add(champHobby);
        editPanel.add(HobbyPanel);
        
        labelDateEmb = new JLabel(Constantes.DATE_EMB);
        labelDateEmb.setFont(Constantes.DEFAULTFONT);
        champJourEmb = new JTextField();
        champJourEmb.setText(Constantes.JOUR);
        champJourEmb.setColumns(Constantes.COLUMNS/2);

        champAnneeEmb = new JTextField();
        champAnneeEmb.setText(Constantes.ANNEE);
        champAnneeEmb.setColumns(Constantes.COLUMNS/2);
        champMoisEmb = new JComboBox(Constantes.OPTIONSMOIS);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        c.weightx = 1;
        c.weighty = 0;
        JPanel dateEmb = new JPanel(new GridLayout());
        JPanel champsEmb = new JPanel(new GridLayout(1,3,10,5));
        
        champsEmb.add(champJourEmb);
        //champJourEmb.setEditable(false);
        champsEmb.add(champMoisEmb);
        champsEmb.add(champAnneeEmb);
        //champAnneeEmb.setEditable(false);
        dateEmb.add(labelDateEmb,c);
        dateEmb.add(champsEmb, c);
        editPanel.add(dateEmb, c);
    }
    
    public void addingListenerToField(){
        champMatricule.getDocument().addDocumentListener(new InputTextListener());
        champNom.getDocument().addDocumentListener(new InputTextListener());
        champPrenom.getDocument().addDocumentListener(new InputTextListener());
        champPseudo.getDocument().addDocumentListener(new InputTextListener());
        champResponsable.getDocument().addDocumentListener(new InputTextListener());
        champJourNaiss.getDocument().addDocumentListener(new InputNumberListener());
        champAnneeNaiss.getDocument().addDocumentListener(new InputNumberListener());
        champJourEmb.getDocument().addDocumentListener(new InputNumberListener());
        champAnneeEmb.getDocument().addDocumentListener(new InputNumberListener());

    }
    
    public JPanel getPanelMenu(){
        return this.mainPanel;
    }
    
  /**
 * Vérifie que le jour du mois est bien compris entre 1 et 31.
 */
    
    public boolean checkday(String text){
        int result = Integer.parseInt(text);
        boolean tmp = true;
        if (result <=0 || result >= 32){
            tmp = false;
        }
        return tmp;
    }
    
 /**
 * Vérifie que l'année ne dépasse pas l'année courante
 */
    public boolean checkyear(String text){
        int result = Integer.parseInt(text);
        boolean tmp = true;
        
        if (result <=1950 || result >= 2019){
            tmp = false;
        }
        return tmp;
    }
    
    
  /**
 * Vérifie que le contenu du champs n'est pas vide
 */ 
    public boolean checkvalue(String text){
        return (text.length() != 0);
    }
    
 /**
 * Vérifie que le champs n'est composé que de chiffres
 */   
    public boolean isNotInteger(String text){
        
        char[] stringToCharArray = text.toCharArray();
        int len = text.length();
        boolean tmp = true;
        for (int i = 0; i<len && tmp ; i++){
            if (isDigit(stringToCharArray[i])){
                tmp = false;
            }
        }
        return tmp;
    }
 
/**
 * Vérifie que le champs n'est composé que de chiffres
 */    
    
    public boolean isInteger(String text){
        
        char[] stringToCharArray = text.toCharArray();
        int len = text.length();
        boolean tmp = true;
        for (int i = 0; i<len && tmp ; i++){
            if (!isDigit(stringToCharArray[i])){
                tmp = false;
            }
        }
        return tmp;
    }
    
    public void btnBottom(){
        btnReinit = new JButton("Réinitialiser");
        btnReinit.setEnabled(false);
        btnReinit.setFont(Constantes.DEFAULTFONT);
        btnReinit.setSize(5,5);
        btnPanel.add(btnReinit);
        btnReinit.addActionListener(this);
        
        btnValider = new JButton("Valider");
        btnValider.setFont(Constantes.DEFAULTFONT);
        btnPanel.add(btnValider);
        btnValider.addActionListener(this);
        
        btnRechercher = new JButton("Rechercher");
        btnRechercher.setEnabled(false);
        btnRechercher.setFont(Constantes.DEFAULTFONT);
        btnPanel.add(btnRechercher);
        btnRechercher.addActionListener(this);
        
        btnAnnuler = new JButton("Annuler");
        btnAnnuler.setFont(Constantes.DEFAULTFONT);
        
        btnPanel.add(btnAnnuler);
        btnAnnuler.addActionListener(this);
    }

    @Override
    public abstract void actionPerformed(ActionEvent event);
    
    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }

    public void setBtnAnnuler(JButton btnAnnuler) {
        this.btnAnnuler = btnAnnuler;
    }

    public JButton getBtnValider() {
        return btnValider;
    }

    public void setBtnValider(JButton btnValider) {
        this.btnValider = btnValider;
    }

    public JButton getBtnReinit() {
        return btnReinit;
    }

    public void setBtnReinit(JButton btnReinit) {
        this.btnReinit = btnReinit;
    }

    public JButton getBtnRechercher() {
        return btnRechercher;
    }

    public void setBtnRechercher(JButton btnRechercher) {
        this.btnRechercher = btnRechercher;
    }

    public JLabel getLabelMatricule() {
        return labelMatricule;
    }

    public void setLabelMatricule(JLabel labelMatricule) {
        this.labelMatricule = labelMatricule;
    }

    public JLabel getLabelNom() {
        return labelNom;
    }

    public void setLabelNom(JLabel labelNom) {
        this.labelNom = labelNom;
    }

    public JLabel getLabelPrenom() {
        return labelPrenom;
    }

    public void setLabelPrenom(JLabel labelPrenom) {
        this.labelPrenom = labelPrenom;
    }

    public JLabel getLabelAdress() {
        return labelAdress;
    }

    public void setLabelAdress(JLabel labelAdress) {
        this.labelAdress = labelAdress;
    }

    public JLabel getLabelResponsable() {
        return labelResponsable;
    }

    public void setLabelResponsable(JLabel labelResponsable) {
        this.labelResponsable = labelResponsable;
    }

    public JLabel getLabelHobby() {
        return labelHobby;
    }

    public void setLabelHobby(JLabel labelHobby) {
        this.labelHobby = labelHobby;
    }

    public JLabel getLabelPseudo() {
        return labelPseudo;
    }

    public void setLabelPseudo(JLabel labelPseudo) {
        this.labelPseudo = labelPseudo;
    }

    public JLabel getLabelDateNaiss() {
        return labelDateNaiss;
    }

    public void setLabelDateNaiss(JLabel labelDateNaiss) {
        this.labelDateNaiss = labelDateNaiss;
    }

    public JLabel getLabelDateEmb() {
        return labelDateEmb;
    }

    public void setLabelDateEmb(JLabel labelDateEmb) {
        this.labelDateEmb = labelDateEmb;
    }

    public JTextField getChampMatricule() {
        return champMatricule;
    }

    public void setChampMatricule(JTextField champMatricule) {
        this.champMatricule = champMatricule;
    }

    public JTextField getChampNom() {
        return champNom;
    }

    public void setChampNom(JTextField champNom) {
        this.champNom = champNom;
    }

    public JTextField getChampPrenom() {
        return champPrenom;
    }

    public void setChampPrenom(JTextField champPrenom) {
        this.champPrenom = champPrenom;
    }

    public JTextField getChampAdress() {
        return champAdress;
    }

    public void setChampAdress(JTextField champAdress) {
        this.champAdress = champAdress;
    }

    public JTextField getChampResponsable() {
        return champResponsable;
    }

    public void setChampResponsable(JTextField champResponsable) {
        this.champResponsable = champResponsable;
    }

    public JTextField getChampHobby() {
        return champHobby;
    }

    public void setChampHobby(JTextField champHobby) {
        this.champHobby = champHobby;
    }

    public JTextField getChampPseudo() {
        return champPseudo;
    }

    public void setChampPseudo(JTextField champPseudo) {
        this.champPseudo = champPseudo;
    }

    public JTextField getChampJourEmb() {
        return champJourEmb;
    }

    public void setChampJourEmb(JTextField champJourEmb) {
        this.champJourEmb = champJourEmb;
    }

    public JTextField getChampJourNaiss() {
        return champJourNaiss;
    }

    public void setChampJourNaiss(JTextField champJourNaiss) {
        this.champJourNaiss = champJourNaiss;
    }

    public JTextField getChampAnneeEmb() {
        return champAnneeEmb;
    }

    public void setChampAnneeEmb(JTextField champAnneeEmb) {
        this.champAnneeEmb = champAnneeEmb;
    }

    public JTextField getChampAnneeNaiss() {
        return champAnneeNaiss;
    }

    public void setChampAnneeNaiss(JTextField champAnneeNaiss) {
        this.champAnneeNaiss = champAnneeNaiss;
    }

    public JComboBox getChampMoisEmb() {
        return champMoisEmb;
    }

    public void setChampMoisEmb(JComboBox champMoisEmb) {
        this.champMoisEmb = champMoisEmb;
    }

    public JComboBox getChampMoisNaiss() {
        return champMoisNaiss;
    }

    public void setChampMoisNaiss(JComboBox champMoisNaiss) {
        this.champMoisNaiss = champMoisNaiss;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getBtnPanel() {
        return btnPanel;
    }

    public void setBtnPanel(JPanel btnPanel) {
        this.btnPanel = btnPanel;
    }

    public JPanel getEditPanel() {
        return editPanel;
    }

    public void setEditPanel(JPanel editPanel) {
        this.editPanel = editPanel;
    }

    public JPanel getMatriculePanel() {
        return matriculePanel;
    }

    public void setMatriculePanel(JPanel matriculePanel) {
        this.matriculePanel = matriculePanel;
    }

    public ProgrammeurBean getProgrBean() {
        return progrBean;
    }

    public void setProgrBean(ProgrammeurBean progrBean) {
        this.progrBean = progrBean;
    }

    public String getContenuMatricule() {
        return contenuMatricule;
    }

    public void setContenuMatricule(String contenuMatricule) {
        this.contenuMatricule = contenuMatricule;
    }

    public String getContenuTextArea() {
        return contenuTextArea;
    }

    public void setContenuTextArea(String contenuTextArea) {
        this.contenuTextArea = contenuTextArea;
    }

    public String getContenuNom() {
        return contenuNom;
    }

    public void setContenuNom(String contenuNom) {
        this.contenuNom = contenuNom;
    }

    public String getContenuPrenom() {
        return contenuPrenom;
    }

    public void setContenuPrenom(String contenuPrenom) {
        this.contenuPrenom = contenuPrenom;
    }

    public String getContenuAdress() {
        return contenuAdress;
    }

    public void setContenuAdress(String contenuAdress) {
        this.contenuAdress = contenuAdress;
    }

    public String getContenuResponsable() {
        return contenuResponsable;
    }

    public void setContenuResponsable(String contenuResponsable) {
        this.contenuResponsable = contenuResponsable;
    }

    public String getContenuHobby() {
        return contenuHobby;
    }

    public void setContenuHobby(String contenuHobby) {
        this.contenuHobby = contenuHobby;
    }

    public String getContenuPseudo() {
        return contenuPseudo;
    }

    public void setContenuPseudo(String contenuPseudo) {
        this.contenuPseudo = contenuPseudo;
    }

    public Date getContenuDateNaiss() {
        return contenuDateNaiss;
    }

    public void setContenuDateNaiss(Date contenuDateNaiss) {
        this.contenuDateNaiss = contenuDateNaiss;
    }

    public Date getContenuDateEmb() {
        return contenuDateEmb;
    }

    public void setContenuDateEmb(Date contenuDateEmb) {
        this.contenuDateEmb = contenuDateEmb;
    }

    public ActionsBD getDt() {
        return dt;
    }

    public void setDt(ActionsBD dt) {
        this.dt = dt;
    }
}
