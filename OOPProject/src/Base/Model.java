package Base;

import java.awt.Color;

import javax.swing.JLabel;

public class Model {
	
	protected int StartX, StartY;
	protected int Width, Height;
	protected String Name;
	protected String Text;
	protected int Type;
	protected Model Next;	
	protected JLabel Label;
	protected int count=0;
	
	public Model(){
		Label = new JLabel();
		Label.setBounds(0, 0, 0, 0);
		Label.setOpaque(true);
		Label.setBackground(Color.cyan);		
		Type = 1;
	}
	
	public String toString(){
		return count+""; 
	}
	
}
