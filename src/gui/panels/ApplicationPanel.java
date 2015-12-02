package gui.panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JeCisC on 02/12/2015.
 */
public abstract class ApplicationPanel extends JPanel implements ActionListener {

    public abstract void actionPerformed(ActionEvent e);
}
