package Test; import java.awt.BorderLayout;import javax.swing.JLabel;import javax.swing.JTextField;import javax.swing.JButton;import java.awt.EventQueue;import javax.swing.JFrame;import javax.swing.JPanel;import javax.swing.border.EmptyBorder;public class ddd extends JFrame {private JPanel contentPane;public static void main(String[] args) {EventQueue.invokeLater(new Runnable() {public void run() {try {ddd frame = new ddd();frame.setVisible(true);frame.setSize(1500, 800);} catch (Exception e) {e.printStackTrace();}}});}public ddd() {setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);setBounds(100, 100, 639, 479);contentPane = new JPanel();contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));setContentPane(contentPane);contentPane.setLayout(null);JLabel model_0= new JLabel();model_0.setBounds(371,166,175,154);contentPane.add(model_0);model_0.setText("null");JLabel model_1= new JLabel();model_1.setBounds(206,283,85,150);contentPane.add(model_1);model_1.setText("null");}}