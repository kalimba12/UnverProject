package Base;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controller {

	View view;
	Model model;
	
	//	������
	public Controller(View view){
		this.view = view;
	}
	
	//	���� ���콺��ġ�� �Է¹޾�, �ش��ϴ� ��ġ�� �ִ� ���� ��ȯ
	public Model IsExist(int x, int y){
		Model CurrentModel = model;
		
		while(CurrentModel!=null){
			if(x>=CurrentModel.StartX && x<=CurrentModel.StartX+CurrentModel.Width && y>=CurrentModel.StartY && y<=CurrentModel.StartY+CurrentModel.Height){
				return CurrentModel;
			}
			CurrentModel=CurrentModel.Next;	
		}
		return null;
	}
	
	//	��� ���� ������ �⺻������ �ʱ�ȭ�ϰ� ���õ� �𵨿� ���� ����
	public void ColorInit(Model CurrentModel){
		Model m = model;
		
		while(m!=null){
			m.Label.setBackground(Color.cyan);
			m=m.Next;	
		}
		CurrentModel.Label.setBackground(Color.yellow);
	}
	
	//	���콺�� ����� x, y ��ǥ�� �����, ���콺�� �������ɋ��� ���� �Է¹޾� ������� ���� �����Ų��.
	public void setSize(int EX, int EY, Model CurrentModel, Model TempModel, int verX, int verY){	
	
		if(verX==1)
			if(EX<TempModel.StartX){
				CurrentModel.StartX = EX;
				CurrentModel.Width = TempModel.StartX - EX;
			}else
				CurrentModel.Width = EX - TempModel.StartX;
		else if(verX==2)
			if(EX<TempModel.StartX+TempModel.Width){
				CurrentModel.StartX = EX;
				CurrentModel.Width = TempModel.StartX + TempModel.Width - EX;
			}else
				CurrentModel.Width = EX - TempModel.StartX;
		
		if(verY==1)
			if(EY<TempModel.StartY){
				CurrentModel.StartY = EY;
				CurrentModel.Height = TempModel.StartY - EY;
			}else
				CurrentModel.Height = EY - TempModel.StartY;
		else if(verY==2)
			if(EY<TempModel.StartY+TempModel.Height){
				CurrentModel.StartY = EY;
				CurrentModel.Height = TempModel.StartY +TempModel.Height - EY;
			}else
				CurrentModel.Height = EY - TempModel.StartY;

	}

	//	���콺�� x, y ��ǥ�� ������� �Է¹޾� ������� ������ġ�� �ٲ۴�.
	public void setStart(int x, int y, Model CurrentModel){

		CurrentModel.StartX=x;
		CurrentModel.StartY=y;
		
	}

	//	MODEL�� ��� �Ӽ��� ����
	public void setAll (Model m, int StartX, int StartY, int Width, int Height, String Text, String Name, int Type){
		m.StartX = StartX;
		m.StartY = StartY;
		m.Width = Width;
		m.Height = Height;
		m.Text = Text;
		m.Name = Name;
		m.Label.setText(Text);
		m.Type = Type;
	}
	
	// �̸�����
	public void setName(String s, Model CurrentModel){
		CurrentModel.Name = s;
	}
	
	
	//	m2�� �ʵ尪�� m1�� �����Ѵ�.
	public void CopyModel(Model m1, Model m2){
		
		m1.StartX = m2.StartX;
		m1.StartY = m2.StartY;
		m1.Width = m2.Width;
		m1.Height = m2.Height;
		
	}
	
	//	�Է¹��� ���� �̵�
	public void MoveComponent(Model m, int MoveX, int MoveY){
		
		m.StartX += MoveX;
		m.StartY += MoveY;
		
	}
	
	//	�� ����
	protected Model AddComponent(){
		if(model==null){
			model = new Model();
			return model;
		}
		Model LastModel = model;
		
		while(LastModel.Next!=null)
			LastModel=LastModel.Next;

		LastModel.Next = new Model();
		return LastModel.Next;
	}
	
	//	���� �Ӽ����� �̿��Ͽ� ���� �����Ű�� �Ҷ�
	public void ViewToModel(Model m, JTextField txtStartX,JTextField txtStartY,JTextField txtWidth,JTextField txtHeight,JTextField txt,JTextField txtName,JComboBox combo){
		String s = txtStartX.getText();
		m.StartX = Integer.parseInt(s);
		s = txtStartY.getText();
		m.StartY = Integer.parseInt(s);
		s = txtWidth.getText();
		m.Width = Integer.parseInt(s);
		s = txtHeight.getText();
		m.Height = Integer.parseInt(s);
		m.Text = txt.getText();
		s = txtName.getText();
		m.Name = s;	
		m.Label.setBounds(m.StartX, m.StartY, m.Width, m.Height);
		m.Label.setText(txt.getText());
		m.Type = combo.getSelectedIndex();
	}
	
	public void setLabel(Model m){
		m.Label.setBounds(m.StartX, m.StartY, m.Width, m.Height);
	}
	
	public void Remove(Model CurrentModel){
		Model TempModel;
		
		TempModel = model;
		if(TempModel.equals(CurrentModel)){		// �����Ϸ��� ���� ù��° ���ϰ��
			if(CurrentModel.Next==null)		// ���� ���� ���� ���
				model = new Model();
			else		//���� ���� ���� ���
				model = model.Next;		
		}else{		//�����Ϸ��� ���� �ι�° �̻��� ���� ���
			while(TempModel.Next!=null){
				if(TempModel.Next.equals(CurrentModel)){
					if(TempModel.Next.Next==null){
						TempModel.Next=null;
						break;
					}
					TempModel.Next=TempModel.Next.Next;
				}
				TempModel = TempModel.Next;
			}
		}
	}
}
