import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MascotChange extends JFrame implements ActionListener,WindowListener {

	JFrame mascotChangeWindow = new JFrame("画像切替");
	JRadioButton radio1;
	JRadioButton radio2;
	
	ImageIcon left1A = new ImageIcon("walk1.png");
	ImageIcon left2A = new ImageIcon("walk2.png");
	ImageIcon left3A = new ImageIcon("walk3.png");
	ImageIcon right1A = new ImageIcon("walk1R.png");
	ImageIcon right2A = new ImageIcon("walk2R.png");
	ImageIcon right3A = new ImageIcon("walk3R.png");
	ImageIcon dragg1A = new ImageIcon("drag1.png");
	ImageIcon dragg2A = new ImageIcon("drag2.png");
	ImageIcon pauseA = new ImageIcon("top.png");
	
	ImageIcon left1B = new ImageIcon("R1.png");
	ImageIcon left2B = new ImageIcon("R2.png");
	ImageIcon left3B = new ImageIcon("R3.png");
	ImageIcon right1B = new ImageIcon("R1R.png");
	ImageIcon right2B = new ImageIcon("R2R.png");
	ImageIcon right3B = new ImageIcon("R3R.png");
	ImageIcon dragg1B = new ImageIcon("d1.png");
	ImageIcon dragg2B = new ImageIcon("d2.png");
	ImageIcon pauseB = new ImageIcon("main.png");
	ImageIcon iconMenuA = new ImageIcon("icon2.jpg");
	ImageIcon iconMenuB = new ImageIcon("icon.jpg");
	
	
	
	public MascotChange() {
		
		if(Character.radioButtonCheck==true) {
			radio1 = new JRadioButton("メイド", true);
			radio2 = new JRadioButton("アンドロイド");
		}else {
			radio1 = new JRadioButton("メイド");
			radio2 = new JRadioButton("アンドロイド", true);
		}
		
		// GUI画面の設定
		mascotChangeWindow.setLayout(new FlowLayout());
				
		// サイズを設定
		mascotChangeWindow.setSize(300, 70);
				
		//表示位置
		mascotChangeWindow.setLocation(450,250);
						
		//ウィンドウアイコン設定
		mascotChangeWindow.setIconImage(Character.iconMenu.getImage());
								
		// GUI画面の可視化
		mascotChangeWindow.setVisible(true);
						
		//前面表示
		mascotChangeWindow.setAlwaysOnTop(true);
		
		mascotChangeWindow.addWindowListener(this);
		
		mascotChangeWindow.add(radio1);
		mascotChangeWindow.add(radio2);
		
		ButtonGroup bgroup = new ButtonGroup();
		
		bgroup.add(radio1);
		bgroup.add(radio2);
		
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		
		radio1.setBounds(50,50,70,50);
		radio2.setBounds(140,50,150,50);
		
		// ボタンの生成
		JButton btn = new JButton("決定");
				
		mascotChangeWindow.add(btn);
				
		//ボタン座標
		btn.setBounds(200,50,70,30);
						
		// ボタン押下時の処理を設定
		btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	mascotChangeWindow.dispose();
    			Character.windowCheck=false;
    			System.out.println("決定ボタン押下");
    			Main.closingCheck();
            }
        });
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if (radio1.isSelected()) {
			//メイド
			Character.left1=left1A;
			Character.left2=left2A;
			Character.left3=left3A;
			Character.right1=right1A;
			Character.right2=right2A;
			Character.right3=right3A;
			Character.dragg1=dragg1A;
			Character.dragg2=dragg2A;
			Character.pause=pauseA;
			Character.iconMenu = iconMenuA;
			Character.radioButtonCheck=true;
		}else if (radio2.isSelected()){
			//アンドロイド
			Character.left1=left1B;
			Character.left2=left2B;
			Character.left3=left3B;
			Character.right1=right1B;
			Character.right2=right2B;
			Character.right3=right3B;
			Character.dragg1=dragg1B;
			Character.dragg2=dragg2B;
			Character.pause=pauseB;
			Character.iconMenu = iconMenuB;
			Character.radioButtonCheck=false;
		}
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		mascotChangeWindow.dispose();
		System.out.println("プルダウンウィンドウ閉じる");
		System.out.println(Character.windowCheck);
		Character.windowCheck=false;
		Main.closingCheck();
	}



	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
