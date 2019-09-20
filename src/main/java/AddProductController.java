import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AddProductController {
    AddButtonListener addButtonListener = new AddButtonListener();
    CancelButtonListener cancelButtonListener = new CancelButtonListener();

}

class AddButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int productID;
        String name, vendor, description;
        double price, quantity;
        int i = 0;
        JButton button = (JButton)actionEvent.getSource();
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(button);
        Component[] components = topFrame.getComponents();
        for (Component wrapper : components) {
            for (Component comp : ((JRootPane) wrapper).getContentPane().getComponents()) {
                if (i < 6) {
                    JLabel j = (JLabel) ((JPanel) comp).getComponents()[0];
                    JTextField tf = (JTextField) ((JPanel) comp).getComponents()[1];
                    if (j.getText().equals("Product ID ")) {
                        productID = Integer.parseInt(tf.getText());
                    }
                    else if (j.getText().equals("Name ")) {
                        name = tf.getText();
                    }
                    else if (j.getText().equals("Price ")) {
                        price = Double.parseDouble(tf.getText());
                    }
                    else if (j.getText().equals("Quantity ")) {
                        quantity = Double.parseDouble(tf.getText());
                    }
                    else if (j.getText().equals("Vendor ")) {
                        vendor = tf.getText();
                    }
                    else if (j.getText().equals("Description ")) {
                        description = tf.getText();
                    }
                    i++;
                }
            }
        }
        SQLiteDataAdapter adapter = new SQLiteDataAdapter();
        adapter.connect();
        ProductModel product = adapter.addProduct(new ProductModel(productID, name, price, quantity, vendor, description));
        JOptionPane.showMessageDialog(null, "Product successfully added!");
    }
}

class CancelButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton)actionEvent.getSource();
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(button);
        topFrame.dispose();
    }
}
