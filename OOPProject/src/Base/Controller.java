package Base;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controller {

	View view;
	Model model;
	
	//	생성자
	public Controller(View view){
		this.view = view;
	}
	
	//	현재 마우스위치를 입력받아, 해당하는 위치에 있는 모델을 반환
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
	
	//	모든 모델의 배경색을 기본색으로 초기화하고 선택된 모델에 색을 입힘
	public void ColorInit(Model CurrentModel){
		Model m = model;
		
		while(m!=null){
			m.Label.setBackground(Color.cyan);
			m=m.Next;	
		}
		CurrentModel.Label.setBackground(Color.yellow);
	}
	
	//	마우스의 변경된 x, y 좌표와 현재모델, 마우스가 프레스될떄의 모델을 입력받아 현재모델의 값을 변경시킨다.
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

	//	마우스의 x, y 좌표와 현재모델을 입력받아 현재모델의 시작위치를 바꾼다.
	public void setStart(int x, int y, Model CurrentModel){

		CurrentModel.StartX=x;
		CurrentModel.StartY=y;
		
	}

	//	MODEL의 모든 속성을 변경
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
	
	// 이름설정
	public void setName(String s, Model CurrentModel){
		CurrentModel.Name = s;
	}
	
	
	//	m2의 필드값을 m1에 복사한다.
	public void CopyModel(Model m1, Model m2){
		
		m1.StartX = m2.StartX;
		m1.StartY = m2.StartY;
		m1.Width = m2.Width;
		m1.Height = m2.Height;
		
	}
	
	//	입력받은 모델의 이동
	public void MoveComponent(Model m, int MoveX, int MoveY){
		
		m.StartX += MoveX;
		m.StartY += MoveY;
		
	}
	
	//	모델 생성
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
	
	//	뷰의 속성탭을 이용하여 모델을 변경시키려 할때
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
		if(TempModel.equals(CurrentModel)){		// 삭제하려는 모델이 첫번째 모델일경우
			if(CurrentModel.Next==null)		// 다음 모델이 없을 경우
				model = new Model();
			else		//다음 모델이 있을 경우
				model = model.Next;		
		}else{		//삭제하려는 모델이 두번째 이상의 모델일 경우
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
