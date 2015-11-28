package gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicot & rousseau at Hyrule
 */
public class CenterPanel extends JPanel {
    protected JTextField secondTextField = new JTextField();
    protected JTextField firstTextField = new JTextField();
    protected JLabel firstLabel;
    protected JLabel secondLabel;

    public CenterPanel(String firstLabel, String secondLabel) {
        // 2 lines, 2 columns, 5px of vertically separation
        this.setLayout(new GridLayout(2, 2, 0, 5));
        // input size
        secondTextField.setColumns(10);
        firstTextField.setColumns(10);

        this.firstLabel = new JLabel(firstLabel);
        this.secondLabel = new JLabel(secondLabel);

        this.add(this.firstLabel);
        this.add(firstTextField);
        this.add(this.secondLabel);
        this.add(secondTextField);
    }

    public String getFirstLabelToString() {
        return secondTextField.getText().trim();
    }

    public String getSecondLabelToString() {
        return firstTextField.getText().trim();
    }
}
