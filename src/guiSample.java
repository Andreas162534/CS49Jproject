import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class box extends JFrame implements ActionListener {
    static JTextField t;

    static JFrame f;

    static JButton b;

    static JLabel l;

    box()
    {
    }

    public static void main(String[] args)
    {
        f = new JFrame("Discord");

        l = new JLabel("Empty");

        b = new JButton("submit");

        box te = new box();

        b.addActionListener(te);

        t = new JTextField(16);

        Font fo = new Font("Serif", Font.BOLD, 20);

        t.setFont(fo);

        JPanel p = new JPanel();

        p.add(t);
        p.add(b);
        p.add(l);

        f.add(p);

        f.setSize(300, 300);

        f.show();
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            l.setText(t.getText());

            t.setText("  ");
        }
    }
}
