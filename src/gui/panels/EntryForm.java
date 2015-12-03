package gui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

/**
 * Created by ferlicotdelbe on 03/12/15.
 */
public class EntryForm extends AbstractForm {
    protected JTextField firstNameField;
    protected JTextField lastNameField;
    protected static final String FIRSTLABEL = "Prenom";
    protected static final String SECONDLABEL = "Nom";
    protected JLabel firstLabel;
    protected JLabel secondLabel;

    public EntryForm() {
        // 2 lines, 2 columns, 5px of vertically separation
        this.setLayout(new GridLayout(2, 2, 0, 5));
        initTextFields();
        initLabels();
        addTextFieldsAndLabels();
    }

    public void initTextFields(){
        lastNameField = new JTextField();
        firstNameField = new JTextField();
        firstNameField.setColumns(10);
        lastNameField.setColumns(10);
    }

    public void initLabels(){
        this.firstLabel = new JLabel(FIRSTLABEL);
        this.secondLabel = new JLabel(SECONDLABEL);
    }

    /**
     * Add the TextFields and Labels to the panel.
     * Warning: the order of the adding is important because we are in a GridLayout configuration.
     */
    public void addTextFieldsAndLabels(){
        this.add(this.firstLabel);
        this.add(firstNameField);
        this.add(this.secondLabel);
        this.add(lastNameField);
    }

    public void cleanFields() {
        firstNameField.setText("");
        lastNameField.setText("");
    }

    public String lastName() {
        return lastNameField.getText();
    }

    public String firstName() {
        return firstNameField.getText();
    }
}