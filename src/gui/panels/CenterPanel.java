package gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicot & rousseau at Hyrule
 */
public class CenterPanel extends JPanel {
    protected JTextField first_name = new JTextField();
    protected JTextField last_name = new JTextField();
    protected JLabel firstLabel;
    protected JLabel secondLabel;

    public CenterPanel(String firstLabel, String secondLabel) {
        // 2 lines, 2 columns, 5px of vertically separation
        this.setLayout(new GridLayout(2, 2, 0, 5));
        // input size
        first_name.setColumns(10);
        last_name.setColumns(10);

        this.firstLabel = new JLabel(firstLabel);
        this.secondLabel = new JLabel(secondLabel);

        this.add(this.secondLabel);
        this.add(first_name);
        this.add(this.firstLabel);
        this.add(last_name);
    }

    public String getFirstLabelToString() {
        return first_name.getText().trim();
    }

    public String getSecondLabelToString() {
        return last_name.getText().trim();
    }
}
