package Base;

public class convertJAVAset {

	static String a = "import java.awt.BorderLayout;"
			+ "import javax.swing.JLabel;"
			+ "import javax.swing.JTextField;"
			+ "import javax.swing.JButton;"
			+ "import java.awt.EventQueue;"
			+ "import javax.swing.JFrame;"
			+ "import javax.swing.JPanel;"
			+ "import javax.swing.border.EmptyBorder;"
			+ "public class ";
			//+ "ttt"										
	static String b	= " extends JFrame {"
			+ "private JPanel contentPane;"
			+ "public static void main(String[] args) {"
			+ "EventQueue.invokeLater(new Runnable() {"
			+ "public void run() {"
			+ "try {";
			//+ "ttt"										///
	static String c = " frame = new ";
			//+ "ttt"										///
	static String d = "();"
			+ "frame.setVisible(true);"
			+ "frame.setSize(1500, 800);"
			+ "} catch (Exception e) {e.printStackTrace();}}});}"
			+ "public ";
			//+ "ttt"									///
	static String e = "() {"
			+ "setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);"
			+ "setBounds(100, 100, 639, 479);"
			+ "contentPane = new JPanel();"
			+ "contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));"
			+ "setContentPane(contentPane);"
			+ "contentPane.setLayout(null);";
	
	static String f = "}}";

}
