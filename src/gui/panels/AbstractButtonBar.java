package gui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JeCisC on 02/12/2015.
 */
public abstract class AbstractButtonBar extends JPanel {

    protected Map<String , JButton> buttons;

    public AbstractButtonBar() {
        buttons = new HashMap<>();
        initButtons();
        addButtonsToPanel();
    }

    public abstract void initButtons();

    public void createButton(String name, String help, String action) {
        JButton button = new JButton(name);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setToolTipText(help);
        button.setActionCommand(action);
        buttons.put(name, button);
    }

    public void addButtonsToPanel(){
        buttons.values().forEach(this::add);
    };

    public void addListenerToAllButtons(ApplicationPanel panel) {
        for(JButton button: buttons.values()){
            button.addActionListener(panel);
        }
    }

}

