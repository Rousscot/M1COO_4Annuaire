package gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 03/12/15.
 */
public class NumberForm extends AbstractForm {
    protected JTextField codeField;
    protected JTextField valueField;
    protected static final String FIRSTLABEL = "Code";
    protected static final String SECONDLABEL = "Numero";
    protected JLabel firstLabel;
    protected JLabel secondLabel;

    public NumberForm() {
        // 2 lines, 2 columns, 5px of vertically separation
        this.setLayout(new GridLayout(2, 2, 0, 5));
        initTextFields();
        initLabels();
        addTextFieldsAndLabels();
    }

    public void initTextFields(){
        valueField = new JTextField();
        codeField = new JTextField();
        codeField.setColumns(10);
        valueField.setColumns(10);
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
        this.add(codeField);
        this.add(this.secondLabel);
        this.add(valueField);
    }

    public void cleanFields() {
        codeField.setText("");
        valueField.setText("");
    }

    public String code() {
        return codeField.getText();
    }

    public String value() {
        return valueField.getText();
    }
}