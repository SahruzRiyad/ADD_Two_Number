import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.EventHandler;


public class CalculationTextField {
    public static Frame f =  new Frame("Calculate");
    public static Container cnt = new Container();
    Cursor crs = new Cursor(Cursor.HAND_CURSOR);
    Panel cpnl = new Panel();
    Font fnt = new Font("Arial",Font.BOLD,35);
    Button ad = new Button("Add");
    Button clr = new Button("Clear");
    Label lbl = new Label("Num 1:");
    TextField tx = new TextField();
    TextField tx1 = new TextField();
    TextField tx2 = new TextField();
    Label lbl2 = new Label("Num 2:");
    Label lbl3 = new Label("Sum  = ");
    Font fnt1 = new Font("Arial",Font.PLAIN,20);

    CalculationTextField(){
        create_frame();
        set_component();
        set_action();
        set_keyLisner();
        set_action_add();
    }
    void create_frame(){
        f.setVisible(true);
        f.setBounds(470,150,600,600);
        f.setResizable(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        f.setLayout(null);
    }
    void set_component(){
        lbl.setBounds(60,32,700,100);
        lbl2.setBounds(60,135,700,100);
        lbl3.setBounds(60,230,700,100);
        lbl.setFont(fnt);
        lbl2.setFont(fnt);
        lbl3.setFont(fnt);
        f.add(tx1);
        f.add(tx);
        f.add(tx2);
        f.add(lbl);
        f.add(lbl2);
        f.add(lbl3);
        tx1.setFont(fnt1);
        tx.setFont(fnt1);
        ad.setFont(fnt);
        tx1.setBounds(200,150,320,50);
        tx.setBounds(200,50,320,50);
        tx2.setBounds(200,250,320,50);
        tx2.setFont(fnt);
        f.add(ad);
        f.add(clr);
        clr.setFont(fnt);
        ad.setCursor(crs);
        ad.setBounds(350,350,100,40);
        clr.setBounds(200,350,100,40);
        clr.setCursor(crs);
        f.setBackground(Color.RED);
        ad.setBounds(350,350,100,40);
        lbl.setBackground(Color.RED);
        lbl2.setBackground(Color.RED);
        lbl3.setBackground(Color.RED);
    }
    void set_action_add() {
        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = tx.getText();
                String input2 = tx1.getText();
                if (!input1.equals("") || !input2.equals("")) {
                    try {
                        double inp1 = Double.parseDouble(input1);
                        double inp2 = Double.parseDouble(input2);
                        double result = inp1 + inp2;
                        String sum = Double.toString(result);
                        tx2.setText(sum);
                    } catch (Exception ee) {

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "EMPTY INPUT", "Warning", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    void set_action(){
            clr.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e3) {
                    tx.setText("");
                    tx1.setText("");
                    tx2.setText("");
                }
            });

    }
    void set_keyLisner(){
        tx.requestFocus();
        tx.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(c == KeyEvent.VK_ENTER)tx1.requestFocus();

               else if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) || c=='.')) {
                    Toolkit tk = Toolkit.getDefaultToolkit();
                    tk.beep();
                    e.consume();
                }
            }
        });
        tx1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(c==KeyEvent.VK_ENTER)ad.requestFocusInWindow();
                else if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) || c=='.')) {
                    Toolkit tk = Toolkit.getDefaultToolkit();
                    tk.beep();
                    e.consume();
                }
            }
        });
        ad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if (ch == KeyEvent.VK_ENTER) {
                    String input1 = tx.getText();
                    String input2 = tx1.getText();
                    if (!input1.equals("") || !input2.equals("")) {
                        try {
                            double inp1 = Double.parseDouble(input1);
                            double inp2 = Double.parseDouble(input2);
                            double result = inp1 + inp2;
                            String sum = Double.toString(result);
                            tx2.setText(sum);
                        } catch (Exception ee) {

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "EMPTY INPUT", "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }



    public static void main(String[] args) {
        CalculationTextField ob = new CalculationTextField();
    }
}
