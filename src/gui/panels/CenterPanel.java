package gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicot & rousseau at Hyrule
 */
public class CenterPanel extends JPanel {
    protected JTextField firstTextField;
    protected JTextField secondTextField;
    protected JLabel firstLabel;
    protected JLabel secondLabel;

    public CenterPanel(String firstLabel, String secondLabel) {
        // 2 lines, 2 columns, 5px of vertically separation
        this.setLayout(new GridLayout(2, 2, 0, 5));
        initTextFields();
        initLabel(firstLabel, secondLabel);
        addTextFieldsAndLabels();
    }

    public void initTextFields(){
        secondTextField = new JTextField();
        firstTextField = new JTextField();
        firstTextField.setColumns(10);
        secondTextField.setColumns(10);
    }

    public void initLabel(String firstLabel, String secondLabel){
        this.firstLabel = new JLabel(firstLabel);
        this.secondLabel = new JLabel(secondLabel);
    }

    public void addTextFieldsAndLabels(){
        this.add(this.firstLabel);
        this.add(firstTextField);
        this.add(this.secondLabel);
        this.add(secondTextField);
    }
}
