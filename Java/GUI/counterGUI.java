package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class counterGUI extends JFrame {
    private int counter = 0;
    private JLabel counterLabel;

    public counterGUI() {
        // Frame setup
        setTitle("Counter Click GUI");
        setSize(300, 200);
        setMinimumSize(new Dimension(250, 150));
        setMaximumSize(new Dimension(350, 250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Counter label setup
        counterLabel = new JLabel("Counter: " + counter);
        counterLabel.setFont(new Font("Abadi", Font.PLAIN, 20));
        counterLabel.setHorizontalAlignment(JLabel.CENTER);

        // Increment button setup
        JButton incrementarButton = new JButton("Incrementer +1");
        incrementarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++; // Increment the counter
                counterLabel.setText("Counter: " + counter); // Update label text
            }
        });

        // Decrement button setup
        JButton decrementarButton = new JButton("Decrementer -1");
        decrementarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--; // Decrement the counter
                counterLabel.setText("Counter: " + counter); // Update label text
            }
        });

        // Layout setup
        setLayout(new GridLayout(3, 1)); // 3 rows, 1 column
        add(incrementarButton); // Add increment button to the layout
        add(decrementarButton); // Add decrement button to the layout
        add(counterLabel); // Add counter label to the layout
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                counterGUI counterGUI = new counterGUI(); // Create the GUI instance
                counterGUI.setVisible(true); // Make the GUI visible
            }
        });
    }
}
