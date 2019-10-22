/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.sql.Array;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 * @author moussa
 * Listener custom pour valider les champs text
 */
public class InputTextListener implements DocumentListener{
    String newline = "\n";
 
    public void insertUpdate(DocumentEvent e) {
        
        updateLog(e, "inserted into");
    }
    public void removeUpdate(DocumentEvent e) {
            updateLog(e, "removed from");
      
        
    }
    public void changedUpdate(DocumentEvent e) {
        //Plain text components do not fire these events
    }

    public void updateLog(DocumentEvent e, String action) {
        Document doc = (Document)e.getDocument();
        int changeLength = e.getLength();
        
        System.out.println(
            changeLength + " character" +
            ((changeLength == 1) ? " " : "s ") +
            action + doc + "." + newline +
            "  Text length = " + doc.getLength()+ e + newline);
    }
}
