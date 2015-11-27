package gui.panels;

import domaine.Entry;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

/**
 * Created by ferlicot & rousseau at Las Vegas
 */
public class UpPanel extends JPanel {
    protected JList<String> jList = new JList();
    protected JScrollPane jScrollPane = new JScrollPane(jList);
    protected DefaultListModel<String> model = new DefaultListModel<>();

    public UpPanel(String borderName) {

        jList.setModel(model);



        Border border = new TitledBorder(borderName);
        jScrollPane.setBorder(border);
        jScrollPane.setPreferredSize(new Dimension(250,250));
        this.add(jScrollPane);
    }

    public JList<String> getjList() {
        return jList;
    }

    public void setTextFieldValues(List<Entry> entries, String separator){
        DefaultListModel<String> model = new DefaultListModel<>();
        for(Entry entry : entries){
            model.addElement(formatTextFieldValues(entry.getFirstName(), entry.getLastName(), separator));
        }
        jList.setModel(model);
    }

    public String formatTextFieldValues(String first_field, String last_field, String separator){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first_field);
        stringBuilder.append(separator);
        stringBuilder.append(" ");
        stringBuilder.append(last_field);
        return stringBuilder.toString();
    }
}
