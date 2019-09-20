import javax.swing.*;
import java.awt.*;

public class AddProductView extends JFrame {

    public JButton btnAdd = new JButton("Add");
    public JButton btnCancel = new JButton("Cancel");

    public AddProductView() {
        this.setTitle("Add Product");
        this.setSize(800, 600);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        String[] labels = {"Product ID ", "Name ", "Price ", "Quantity ", "Vendor ", "Description "};
        int numPairs = labels.length;

//Create and populate the panel.
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            JPanel p = new JPanel(new FlowLayout(FlowLayout.TRAILING, 5, 5));
            p.add(l);
            JTextField textField = new JTextField(15);
            l.setLabelFor(textField);
            p.add(textField);
            this.getContentPane().add(p);
        }

        JPanel panelButtons = new JPanel(new FlowLayout());
        AddProductController addPControl = new AddProductController();
        btnAdd.addActionListener(addPControl.addButtonListener);
        btnCancel.addActionListener(addPControl.cancelButtonListener);
        panelButtons.add(btnAdd);
        panelButtons.add(btnCancel);
        this.getContentPane().add(panelButtons);
        this.pack();
    }
}
