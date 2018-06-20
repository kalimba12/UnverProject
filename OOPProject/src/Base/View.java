package Base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class View extends JFrame{

	private JPanel contentPane;
	private JTextField textField_X;
	private JTextField textField_Y;
	private JTextField textField_Width;
	private JTextField textField_Height;
	private JTextField textField_text;
	private JTextField textField_Name;
	private JComboBox comboBox;

	protected int LabelCount=0, lock=0, xxx, yyy;
	JPanel panel;
	Controller control;
	Model model;
	Model TempModel;
	Model CurrentModel;
	JLabel setSizeComp1,setSizeComp2,setSizeComp3,setSizeComp4;
	JPopupMenu popup = new JPopupMenu();
	JMenuItem popDel = new JMenuItem("삭제");
	JSONObject obj;
	JSONParser parser = new JSONParser();
	JSONArray nameArr;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setSize(1500, 800);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the frame.
	 */
	public View() {
		
		popup.add(popDel);
		popDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DelComp();	
			}});
		control = new Controller(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uBA54\uB274");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\uC0C8\uB85C \uB9CC\uB4E4\uAE30");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initAll();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uC5F4\uAE30");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Open();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\uC800\uC7A5");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Save();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\uB2E4\uB978 \uC774\uB984\uC73C\uB85C \uC800\uC7A5");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSave();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem(".java \uD30C\uC77C \uC0DD\uC131");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvertJAVA();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\uB2EB\uAE30");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_5);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.gridwidth = 6;
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		getContentPane().add(toolBar, gbc_toolBar);
		
		JButton btnNewButton = new JButton("\uC0C8\uB85C\uB9CC\uB4E4\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initAll();
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnOpen = new JButton("\uC5F4\uAE30");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Open();
			}
		});
		toolBar.add(btnOpen);
		
		JButton btnSave = new JButton("\uC800\uC7A5");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Save();
			}
		});
		toolBar.add(btnSave);
		
		JButton btnNewSave = new JButton("\uB2E4\uB978 \uC774\uB984\uC73C\uB85C \uC800\uC7A5");
		btnNewSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSave();
			}
		});
		toolBar.add(btnNewSave);
		
		JButton btnNewButton_4 = new JButton(".java \uD30C\uC77C \uC0DD\uC131");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConvertJAVA();
			}
		});
		toolBar.add(btnNewButton_4);
		
		JButton btnExit = new JButton("\uC885\uB8CC");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		toolBar.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weightx = 0.5;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblStartX = new JLabel("\uC2DC\uC791 x \uC88C\uD45C");
		GridBagConstraints gbc_lblStartX = new GridBagConstraints();
		gbc_lblStartX.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartX.gridx = 0;
		gbc_lblStartX.gridy = 0;
		panel_1.add(lblStartX, gbc_lblStartX);
		
		textField_X = new JTextField();
		GridBagConstraints gbc_textField_X = new GridBagConstraints();
		gbc_textField_X.insets = new Insets(0, 0, 5, 5);
		gbc_textField_X.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_X.gridx = 2;
		gbc_textField_X.gridy = 0;
		panel_1.add(textField_X, gbc_textField_X);
		textField_X.setColumns(10);
		
		JLabel lblStartY = new JLabel("\uC2DC\uC791 y \uC88C\uD45C");
		GridBagConstraints gbc_lblStartY = new GridBagConstraints();
		gbc_lblStartY.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartY.gridx = 0;
		gbc_lblStartY.gridy = 1;
		panel_1.add(lblStartY, gbc_lblStartY);
		
		textField_Y = new JTextField();
		GridBagConstraints gbc_textField_Y = new GridBagConstraints();
		gbc_textField_Y.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Y.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Y.gridx = 2;
		gbc_textField_Y.gridy = 1;
		panel_1.add(textField_Y, gbc_textField_Y);
		textField_Y.setColumns(10);
		
		JLabel lblWidth = new JLabel("\uB108\uBE44");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidth.gridx = 0;
		gbc_lblWidth.gridy = 2;
		panel_1.add(lblWidth, gbc_lblWidth);
		
		textField_Width = new JTextField();
		GridBagConstraints gbc_textField_Width = new GridBagConstraints();
		gbc_textField_Width.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Width.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Width.gridx = 2;
		gbc_textField_Width.gridy = 2;
		panel_1.add(textField_Width, gbc_textField_Width);
		textField_Width.setColumns(10);
		
		JLabel lblHeight = new JLabel("\uB192\uC774");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeight.gridx = 0;
		gbc_lblHeight.gridy = 3;
		panel_1.add(lblHeight, gbc_lblHeight);
		
		textField_Height = new JTextField();
		GridBagConstraints gbc_textField_Height = new GridBagConstraints();
		gbc_textField_Height.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Height.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Height.gridx = 2;
		gbc_textField_Height.gridy = 3;
		panel_1.add(textField_Height, gbc_textField_Height);
		textField_Height.setColumns(10);
		
		JLabel lblText = new JLabel("\uD14D\uC2A4\uD2B8 \uB0B4\uC6A9");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.insets = new Insets(0, 0, 5, 5);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = 4;
		panel_1.add(lblText, gbc_lblText);
		
		textField_text = new JTextField();
		GridBagConstraints gbc_textField_text = new GridBagConstraints();
		gbc_textField_text.insets = new Insets(0, 0, 5, 5);
		gbc_textField_text.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_text.gridx = 2;
		gbc_textField_text.gridy = 4;
		panel_1.add(textField_text, gbc_textField_text);
		textField_text.setColumns(10);
		
		JLabel lblType = new JLabel("\uD0C0\uC785");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 5;
		panel_1.add(lblType, gbc_lblType);
		
		String[] comboList = {"","JLabel","JButton","JTextfield"};
		comboBox = new JComboBox(comboList);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		panel_1.add(comboBox, gbc_comboBox);
		
		JLabel lblName = new JLabel("\uBCC0\uC218\uBA85");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 6;
		panel_1.add(lblName, gbc_lblName);
		
		textField_Name = new JTextField();
		GridBagConstraints gbc_textField_Name = new GridBagConstraints();
		gbc_textField_Name.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Name.gridx = 2;
		gbc_textField_Name.gridy = 6;
		panel_1.add(textField_Name, gbc_textField_Name);
		textField_Name.setColumns(10);
		
		
		
		
		JButton btn_Convert = new JButton("\uBCC0\uD658");		// 변환 버튼
		btn_Convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CurrentModel==null)
					return;
				control.ViewToModel(CurrentModel, textField_X, textField_Y, textField_Width, textField_Height, textField_text, textField_Name, comboBox);
				setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);
				setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
				setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
				setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
			}
		});
		
		
		JButton btn_Delete = new JButton("\uC0AD\uC81C");		// 삭제 버튼
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DelComp();	
			}
		});
		
		
		GridBagConstraints gbc_btn_Delete = new GridBagConstraints();
		gbc_btn_Delete.anchor = GridBagConstraints.NORTH;
		gbc_btn_Delete.insets = new Insets(0, 0, 0, 5);
		gbc_btn_Delete.gridx = 0;
		gbc_btn_Delete.gridy = 19;
		panel_1.add(btn_Delete, gbc_btn_Delete);
		GridBagConstraints gbc_btn_Convert = new GridBagConstraints();
		gbc_btn_Convert.insets = new Insets(0, 0, 0, 5);
		gbc_btn_Convert.gridx = 2;
		gbc_btn_Convert.gridy = 19;
		panel_1.add(btn_Convert, gbc_btn_Convert);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		
		setSizeComp1 = new JLabel();
		setSizeComp1.setBounds(0, 0, 0, 0);
		setSizeComp1.setOpaque(true);
		setSizeComp1.setBackground(Color.BLACK);
		panel.add(setSizeComp1);
		setSizeComp2 = new JLabel();
		setSizeComp2.setBounds(0, 0, 0, 0);
		setSizeComp2.setOpaque(true);
		setSizeComp2.setBackground(Color.BLACK);
		panel.add(setSizeComp2);
		setSizeComp3 = new JLabel();
		setSizeComp3.setBounds(0, 0, 0, 0);
		setSizeComp3.setOpaque(true);
		setSizeComp3.setBackground(Color.BLACK);
		panel.add(setSizeComp3);
		setSizeComp4 = new JLabel();
		setSizeComp4.setBounds(0, 0, 0, 0);
		setSizeComp4.setOpaque(true);
		setSizeComp4.setBackground(Color.BLACK);
		panel.add(setSizeComp4);
		
		
		CurrentModel = model;
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lock=0;
				
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				
				if(lock==0){		//새로 만들기
					
					control.setSize(e.getX(), e.getY(), CurrentModel, TempModel, 1, 1);
					control.setLabel(CurrentModel);
				}
				else if(lock==2){		//이동하기
					control.MoveComponent(CurrentModel, e.getX()-xxx, e.getY()-yyy);
					control.setLabel(CurrentModel);
					xxx=e.getX();
					yyy=e.getY();
					setField();		
					
					setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
					setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
				}
				else if(lock==10){		//오른쪽 아래 사이즈  변경	
					if(e.getX()<TempModel.StartX || e.getY()<TempModel.StartY){
						lock=-1;
					}else{
					control.setSize(-xxx+e.getX()+CurrentModel.StartX+CurrentModel.Width, -yyy+e.getY()+CurrentModel.StartY+CurrentModel.Height, CurrentModel, TempModel, 1, 1);
					control.setLabel(CurrentModel);
					
					setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
					setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
					xxx=e.getX();
					yyy=e.getY();
					setField();
					}
				}else if(lock==11){		//왼쪽 아래 사이즈 변경
					if(e.getX()>TempModel.StartX+TempModel.Width || e.getY()<TempModel.StartY){
						lock=-1;
					}else{
					control.setSize(-xxx+e.getX()+CurrentModel.StartX, -yyy+e.getY()+CurrentModel.StartY+CurrentModel.Height, CurrentModel, TempModel, 2, 1);
					control.setLabel(CurrentModel);
					
					setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
					setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
					xxx=e.getX();
					yyy=e.getY();
					setField();
					}
				}else if(lock==12){		//왼쪽 위 사이즈 변경
					if(e.getX()>TempModel.StartX+TempModel.Width || e.getY()>TempModel.StartY+TempModel.Height){
						lock=-1;
					}else{
					control.setSize(-xxx+e.getX()+CurrentModel.StartX, -yyy+e.getY()+CurrentModel.StartY, CurrentModel, TempModel, 2, 2);
					control.setLabel(CurrentModel);
					
					setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
					setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
					xxx=e.getX();
					yyy=e.getY();
					setField();
					}
				}else if(lock==13){		//오른쪽 위 사이즈 변경
					if(e.getX()<TempModel.StartX || e.getY()>TempModel.StartY+TempModel.Height){
						lock=-1;
					}else{
					control.setSize(-xxx+e.getX()+CurrentModel.StartX+CurrentModel.Width, -yyy+e.getY()+CurrentModel.StartY, CurrentModel, TempModel, 1, 2);
					control.setLabel(CurrentModel);
					
					setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
					setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
					setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
					xxx=e.getX();
					yyy=e.getY();
					setField();
					}
				}
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mousePressed(MouseEvent e) {
				
				if(e.getButton()==3)
					lock=3;
				if(CurrentModel!=null)		//사이즈 변경
					if( IsSizeBox(e.getX(), e.getY())==1 ){		//오른쪽 아래 사이즈 변경
						lock=10;
						xxx=e.getX();
						yyy=e.getY();
						TempModel = new Model();
						control.CopyModel(TempModel, CurrentModel);
						return;
					}else if(IsSizeBox(e.getX(), e.getY())==2){
						lock=11;
						xxx=e.getX();
						yyy=e.getY();
						TempModel = new Model();
						control.CopyModel(TempModel, CurrentModel);
						return;
					}else if(IsSizeBox(e.getX(), e.getY())==3){
						lock=12;
						xxx=e.getX();
						yyy=e.getY();
						TempModel = new Model();
						control.CopyModel(TempModel, CurrentModel);
						return;
					}else if(IsSizeBox(e.getX(), e.getY())==4){
						lock=13;
						xxx=e.getX();
						yyy=e.getY();
						TempModel = new Model();
						control.CopyModel(TempModel, CurrentModel);				
						return;
					}
				
				CurrentModel = control.IsExist(e.getX(), e.getY());
				
				if(CurrentModel!=null){	//선택하기
					control.ColorInit(CurrentModel);
					setField();
					
					if(lock==3){	//마우스 오른쪽
						popup.show((Component)e.getSource(), e.getX(), e.getY());
						setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);	
						setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
						setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
						setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
					}else{		//이동하기				
						lock=2;
						xxx=e.getX();
						yyy=e.getY();
						setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);	
						setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
						setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
						setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
					}
				}

				
				if(lock==0){		//새로 만들기
					control.AddComponent();
					model = control.model;
					CurrentModel = model;
					while(CurrentModel.Next!=null)
						CurrentModel=CurrentModel.Next;
				
					control.setStart(e.getX(), e.getY(), CurrentModel);
					control.setName("model_"+LabelCount, CurrentModel);
					
					LabelCount++;
					panel.add(CurrentModel.Label);
					
					TempModel = new Model();
					control.CopyModel(TempModel, CurrentModel);
					
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				lock=0;
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				CurrentModel = control.IsExist(e.getX(), e.getY());
				
				if(CurrentModel!=null){		
					
					// 사이즈박스 선택
					if( IsSizeBox(e.getX(), e.getY())==1 ){
						lock=10;
					}else if(IsSizeBox(e.getX(), e.getY())==2){
						lock=11;
					}else if(IsSizeBox(e.getX(), e.getY())==3){
						lock=12;
					}else if(IsSizeBox(e.getX(), e.getY())==4){
						lock=13;
					}else{		// 선택하기
						control.ColorInit(CurrentModel);
						setField();
						
						setSizeComp1.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY+CurrentModel.Height, 5, 5);
						setSizeComp2.setBounds(CurrentModel.StartX-5, CurrentModel.StartY+CurrentModel.Height, 5, 5);
						setSizeComp3.setBounds(CurrentModel.StartX-5, CurrentModel.StartY-5, 5, 5);
						setSizeComp4.setBounds(CurrentModel.StartX+CurrentModel.Width, CurrentModel.StartY-5, 5, 5);
						lock=1;
						if(e.getButton()==3){	//마우스 오른쪽
							popup.show((Component)e.getSource(), e.getX(), e.getY());
						}
						
					}

				}
			}
		});
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weightx = 8.0;
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
	}
	
	
	//	선택된 모델의 속성값 보이기
	public void setField(){
		textField_X.setText(CurrentModel.StartX+"");
		textField_Y.setText(CurrentModel.StartY+"");
		textField_Width.setText(CurrentModel.Width+"");
		textField_Height.setText(CurrentModel.Height+"");
		textField_text.setText(CurrentModel.Text);
		textField_Name.setText(CurrentModel.Name);
		comboBox.setSelectedIndex(CurrentModel.Type);
	}
	
	//	속성값 안보이기
	public void setFieldClear(){
		textField_X.setText("");
		textField_Y.setText("");
		textField_Width.setText("");
		textField_Height.setText("");
		textField_text.setText("");
		textField_Name.setText("");
		comboBox.setSelectedIndex(0);
		
	}
	
	//	마우스위치가 사이즈조절박스 위에 있는지 확인
	public int IsSizeBox(int x, int y){
		int X,Y,W,H;
		X=CurrentModel.StartX;
		Y=CurrentModel.StartY;
		W=CurrentModel.Width;
		H=CurrentModel.Height;
		if( x>=X+W && x<=X+W+5 && y>=Y+H && y<=Y+H+5)
			return 1;
		else if( x>=X-5 && x<=X && y>=Y+H && y<=Y+H+5)
			return 2;
		else if( x>=X-5 && x<=X && y>=Y-5 && y<=Y)
			return 3;
		else if( x>=X+W && x<=X+W+5 && y>=Y-5 && y<=Y)
			return 4;
	
		return -1;
	}
		
	//	삭제하기
	public void DelComp(){
		if(CurrentModel!=null){
			setFieldClear();
			panel.remove(CurrentModel.Label);
			control.Remove(CurrentModel);
			model=control.model;
					
			CurrentModel = null;
			setSizeComp1.setBounds(0, 0, 0, 0);
			setSizeComp2.setBounds(0, 0, 0, 0);
			setSizeComp3.setBounds(0, 0, 0, 0);
			setSizeComp4.setBounds(0, 0, 0, 0);
			panel.repaint();
		}
	}

	//	새로만들기
	public void initAll(){
		TempModel = model;
		
		while(TempModel!=null){
			panel.remove(TempModel.Label);
			TempModel=TempModel.Next;	
		}
		control.model = null;
		model = null;
		CurrentModel = null;
		LabelCount=0;
		setFieldClear();	
		panel.repaint();
		setSizeComp1.setBounds(0, 0, 0, 0);	
		setSizeComp2.setBounds(0, 0, 0, 0);
		setSizeComp3.setBounds(0, 0, 0, 0);
		setSizeComp4.setBounds(0, 0, 0, 0);
		this.setTitle(null);
	}
	
	
	//	다른이름으로 저장
	public void NewSave(){
		obj = new JSONObject();
		int count=0;
		
		JSONObject tempobj;
		CurrentModel=model;
		while(CurrentModel!=null){
			tempobj=new JSONObject();
			tempobj.put("StartX", CurrentModel.StartX);
			tempobj.put("StartY", CurrentModel.StartY);
			tempobj.put("Width", CurrentModel.Width);
			tempobj.put("Height",CurrentModel.Height);
			tempobj.put("Text", CurrentModel.Text);
			tempobj.put("Name", CurrentModel.Name);
			tempobj.put("Type", CurrentModel.Type);
			obj.put(count,tempobj);
			count++;
			CurrentModel=CurrentModel.Next;
		}
		
		JFileChooser fs = new JFileChooser(new File(System.getProperty("user.home") + "//" + "Desktop"));
		fs.setDialogTitle("다른 이름으로 저장");
		fs.setFileFilter(new FileTypeFilter(".json", "JSON File"));
		int result = fs.showSaveDialog(null);
		if(result==JFileChooser.APPROVE_OPTION){
			File file = fs.getSelectedFile();
			try {
				FileWriter fw = new FileWriter(file.getPath()+".json");
				fw.write(obj.toJSONString());
				fw.flush();
				fw.close();
				this.setTitle(file.getPath()+".json");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}
	}
	
	// 저장하기
	public void Save(){
		obj = new JSONObject();
		int count=0;
		if( this.getTitle()==null || this.getTitle()=="" ){		//	이름이 없을 경우 새로 만들기
			NewSave();
			return;
		}
			
		
		JSONObject tempobj;
		CurrentModel=model;
		while(CurrentModel!=null){
			tempobj=new JSONObject();
			tempobj.put("StartX", CurrentModel.StartX);
			tempobj.put("StartY", CurrentModel.StartY);
			tempobj.put("Width", CurrentModel.Width);
			tempobj.put("Height",CurrentModel.Height);
			tempobj.put("Text", CurrentModel.Text);
			tempobj.put("Name", CurrentModel.Name);
			tempobj.put("Type", CurrentModel.Type);
			obj.put(count,tempobj);
			count++;
			CurrentModel=CurrentModel.Next;
		}
		
		
		try {
			FileWriter fw = new FileWriter(this.getTitle());
			fw.write(obj.toJSONString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	// 불러오기
	public void Open(){
		JSONObject tempobj;
		int a,b,c,d,t;
		
		JFileChooser fs = new JFileChooser(new File(System.getProperty("user.home") + "//" + "Desktop"));
		fs.setDialogTitle("열기");
		fs.setFileFilter(new FileTypeFilter(".json","JSON File"));
		int result = fs.showOpenDialog(null);
		if(result==JFileChooser.APPROVE_OPTION){
			File file = fs.getSelectedFile();
			try{
				initAll();
				obj = (JSONObject) parser.parse(new FileReader(file.getPath()));
				this.setTitle(file.getPath());
				while(obj.get(LabelCount+"")!=null){
					CurrentModel = control.AddComponent();
					model = control.model;
					tempobj = (JSONObject) obj.get(LabelCount+"");
					a=Math.toIntExact((long)tempobj.get("StartX"));
					b=Math.toIntExact((long)tempobj.get("StartY"));
					c=Math.toIntExact((long)tempobj.get("Width"));
					d=Math.toIntExact((long)tempobj.get("Height"));
					t=Math.toIntExact((long)tempobj.get("Type"));
					control.setAll(CurrentModel, a, b, c, d, (String)tempobj.get("Text"),(String)tempobj.get("Name"), t);
					control.setLabel(CurrentModel);
					panel.add(CurrentModel.Label);
					LabelCount++;
				};
				
			}catch(Exception e2){
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}
	}

	
	public void ConvertJAVA(){
		int typeNum;
		CurrentModel=model;
		String temp,fileName;
		
		JFileChooser fs = new JFileChooser(new File(System.getProperty("user.home") + "//" + "Desktop"));
		fs.setDialogTitle(".java 파일 생성");
		fs.setFileFilter(new FileTypeFilter(".java", "JAVA File"));
		int result = fs.showSaveDialog(null);
		if(result==JFileChooser.APPROVE_OPTION){
			File file = fs.getSelectedFile();
			try {
				fileName = file.getName();
				temp = convertJAVAset.a+fileName+convertJAVAset.b+fileName+convertJAVAset.c+fileName+convertJAVAset.d+fileName+convertJAVAset.e;
				while(CurrentModel!=null){
					typeNum=CurrentModel.Type;
					switch (typeNum) {
					case 1:
						temp += "JLabel "+CurrentModel.Name+"= new JLabel();"
								+ CurrentModel.Name+".setBounds("+CurrentModel.StartX+","+CurrentModel.StartY+","+CurrentModel.Width+","+CurrentModel.Height+");"
								+ "contentPane.add("+CurrentModel.Name+");"
								+ CurrentModel.Name+".setText(\""+CurrentModel.Text+"\");";
						break;
					case 2:
						temp += "JButton "+CurrentModel.Name+"= new JButton();"
								+ CurrentModel.Name+".setBounds("+CurrentModel.StartX+","+CurrentModel.StartY+","+CurrentModel.Width+","+CurrentModel.Height+");"
								+ "contentPane.add("+CurrentModel.Name+");"
								+ CurrentModel.Name+".setText(\""+CurrentModel.Text+"\");";
						break;
					case 3:
						temp += "JTextField "+CurrentModel.Name+"= new JTextField();"
								+ CurrentModel.Name+".setBounds("+CurrentModel.StartX+","+CurrentModel.StartY+","+CurrentModel.Width+","+CurrentModel.Height+");"
								+ "contentPane.add("+CurrentModel.Name+");"
								+ CurrentModel.Name+".setText(\""+CurrentModel.Text+"\");";
						break;
					default:
						break;
					}
					CurrentModel = CurrentModel.Next;
				}
					
				temp += convertJAVAset.f;
				
				
				FileWriter fw = new FileWriter(file.getPath()+".java");
				fw.write(temp);
				fw.flush();
				fw.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}
		
	}
	
	public void Exit(){
		System.exit(0);
	}
	
}
