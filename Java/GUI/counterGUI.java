import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class counterGUI extends JFrame {
    private int counter = 0;
    private JLabel counterLabel;

    public counterGUI() {
        setTitle("Counter Click GUI");
        setSize(300, 200);
        setMinimumSize(new Dimension (250, 150));
        setMaximumSize(new Dimension (350, 250));;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        counterLabel = new JLabel("Counter: " + counter);
        counterLabel.setFont(new Font("Abadi", Font.PLAIN, 20));
        counterLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton incrementarButton = new JButton("Incrementer +1");
        JButton decrementarButton = new JButton("Decrementer -1");

        incrementarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                counterLabel.setText("Counter: " + counter);
            }
        });

        decrementarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                counterLabel.setText("Counter: " + counter);
            }
        });

        setLayout(new GridLayout(3, 1));
        add(incrementarButton);
        add(decrementarButton);
        add(counterLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                counterGUI counterGUI = new counterGUI();
                counterGUI.setVisible(true);
            }
        });
    }
}
