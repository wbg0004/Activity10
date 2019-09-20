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
        JButton button = (JButton)actionEvent.getSource();
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(button);
        Component[] components = topFrame.getComponents();
        for (Component comp : components) {
            if (comp instanceof JTextField) {
                int x = 1;
            }
        }
        SQLiteDataAdapter adapter = new SQLiteDataAdapter();
        adapter.connect();
        //"Product ID ", "Name ", "Price ", "Quantity ", "Vendor ", "Description "
        //ProductModel product = adapter.addProduct(new ProductModel());
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
