package gui;

import factory.Annuaire;
import gui.customPanels.AnnuairePanel;
import gui.customPanels.EntreesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ferlicot & rousseau
 */
public class MainFrame extends JFrame{

    protected JPanel mainJPanel;
    protected AnnuairePanel annuaire;
    protected EntreesPanel entrees;

    public MainFrame(Annuaire annuaireController) {
        initFrameParameters();
        initPanels(annuaireController);
        addBehaviours();
        addPanelsToFrame();
    }

    public void addPanelsToFrame() {
        mainJPanel.add(annuaire);
        mainJPanel.add(entrees);
        this.add(mainJPanel);
    }

    public void addBehaviours(){
        annuaire.getUpPanel().getjList().addMouseListener(entreesMouseListener());
        annuaire.getDownPanel().getSupprimer().addActionListener(annuaireSupprimerActionListener());
    }

    public void initFrameParameters(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Annuaire");
        this.setLocation(200, 200);
        this.setSize(500, 500);
        this.setMinimumSize(new Dimension(700,500));
    }

    public void initPanels(Annuaire annuaireController){
        mainJPanel = new JPanel();
        annuaire = new AnnuairePanel(annuaireController);
        entrees = new EntreesPanel(annuaireController);
    }

    public MouseListener entreesMouseListener(){
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String selected = annuaire.getUpPanel().getjList().getSelectedValue();
                DefaultListModel<String> stringDefaultListModel = new DefaultListModel<>();
                stringDefaultListModel.add(0, selected);
                entrees.getUpPanel().getjList().setModel(stringDefaultListModel);
            }
        };
        return mouseListener;
    }

    public ActionListener annuaireSupprimerActionListener(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = annuaire.getUpPanel().getjList().getSelectedIndex();
                annuaire.getUpPanel().getjList().remove(index);

                DefaultListModel<String> stringDefaultListModel = (DefaultListModel)annuaire.getUpPanel().getjList().getModel();
                stringDefaultListModel.remove(index);
                annuaire.getUpPanel().getjList().setModel(stringDefaultListModel);

            }
        };
        return actionListener;
    }
}