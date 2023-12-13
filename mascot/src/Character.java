
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Character extends JFrame implements MouseMotionListener, MouseListener {
	static ImageIcon left1;
	static JLabel label;
	static ImageIcon left2;
	static ImageIcon left3;
	static ImageIcon right1;
	static ImageIcon right2;
	static ImageIcon right3;
	static ImageIcon dragg1;
	static ImageIcon dragg2;
	static ImageIcon pause;
	
	static ImageIcon iconMenu;
	
//	ImageIcon left1 = new ImageIcon("R1.png");
//	JLabel label = new JLabel(left1);
//	ImageIcon left2 = new ImageIcon("R2.png");
//	ImageIcon left3 = new ImageIcon("R3.png");
//	ImageIcon right1 = new ImageIcon("R1R.png");
//	ImageIcon right2 = new ImageIcon("R2R.png");
//	ImageIcon right3 = new ImageIcon("R3R.png");
//	ImageIcon dragg1 = new ImageIcon("d1.png");
//	ImageIcon dragg2 = new ImageIcon("d2.png");
//	ImageIcon pause = new ImageIcon("main.png");
	
	
	
	
	
	
	Timer timer= new Timer(true);
	TimerTask task;
	
	//座標初期位置
	private int x=1080,y=480;
	
	//移動距離
	private int w=10,z=5;
	
	private int dx,dy;
	
	//画面端最大値、最小値定数
	private final int xMin=-50;
	private final int xMax=1140;
	private final int yMin=0;
	private final int yMax=480;
	
	//画像切り替えチェック
	//boolean drowCheck=true;
	private int drowCheck=0;
	
	//プルダウンメニューチェック
	static boolean windowCheck=false;
	
	//ラジオボタン初期設定チェック用
	static boolean radioButtonCheck=true;//true:メイド、false:アンドロイド
	
	//マウスカーソル乗る判定用
	private int i=0;
	
	//ドラッグ時表示切替用
	private int dragged=0;
	
	//ドラッグ中チェック
	private boolean draggedCheck=false;
	

	

	public Character() {
		
		left1 = new ImageIcon("walk1.png");
		label = new JLabel(left1);
		left2 = new ImageIcon("walk2.png");
		left3 = new ImageIcon("walk3.png");
		right1 = new ImageIcon("walk1R.png");
		right2 = new ImageIcon("walk2R.png");
		right3 = new ImageIcon("walk3R.png");
		dragg1 = new ImageIcon("drag1.png");
		dragg2 = new ImageIcon("drag2.png");
		pause = new ImageIcon("top.png");
		
		iconMenu = new ImageIcon("icon2.jpg");
		
		//終了設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//画面のウィンドウサイズ指定
		setSize(1920, 1080);
		getContentPane().setLayout(null);
		
		//label指定
		label.setBounds(x, y, 200, 200);
		// 枠を外す。
        setUndecorated(true);
        // 背景色を透明にする。
        setBackground(new Color(0, 0, 0, 0));
        // タスクバーのアイコンを非表示
        setType(Type.UTILITY) ;
		
        //ラベル追加
		getContentPane().add(label); //引数label
		
		//前面表示
		setAlwaysOnTop(true);
		
		addMouseMotionListener(this);
		addMouseListener(this);
		
		setVisible(true);
		
		move();
		timer.schedule(task, 0, 1000);
	}
	
	public void move() {
		task = new TimerTask() {
        public void run(){
        	
        	System.out.println("move_run");
        	
        	//チェック
        	drowCheck++;
        	if(3<drowCheck) {
        		drowCheck=0;
        	}
        	
        	//画像切り替え
        	
        		System.out.println("drowCheck");
        		for(int I=0;I<5;I++) {
        			//移動距離計算
        			x-=w;
        			y-=z;
        			System.out.println(w+","+z);
        			//画面端判定
        			if((x>=xMin && x<=xMax) && (y>=yMin && y<=yMax)) {
        				//左右どちらの移動か判定
        				if(w>=1) {
        					switch(drowCheck) {
        		        		case 1:
        		        			drowLeft1();
        		        			break;
        		        		case 3:
        		        			drowLeft3();
        		        			break;
        		        		//初期表示は0なのでデフォルト、0と2の描画を兼ねる
        		        		default:
        		        			drowLeft2();
        		        			break;
        					}
        				}else {
        					switch(drowCheck) {
	    		        		case 1:
	    		        			drowRigth1();
	    		        			break;
	    		        		case 3:
	    		        			drowRigth3();
	    		        			break;
	    		        		//初期表示は0なのでデフォルト、0と2の描画を兼ねる
	    		        		default:
	    		        			drowRigth2();
	    		        			break;
        					}
        				}
        			}else if(x<=xMin || x>=xMax){
	    				w=w*-1;
	    			}else {
	    				z=z*-1;
	    			}
        		}
        	
        	}
    
		};

	}
	
	//画像表示1
	private void drowLeft1() {
		label.setIcon(left1);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R1.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示2
	private void drowLeft2() {
		label.setIcon(left2);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R3.png表示");
    	System.out.println(x+","+y);
		}
	
	//画像表示3
	private void drowLeft3() {
		label.setIcon(left3);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R2.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示4
	private void drowRigth1() {
		label.setIcon(right1);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R1R.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示5
	private void drowRigth2() {
		label.setIcon(right2);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R3R.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示6
	private void drowRigth3() {
		label.setIcon(right3);
		label.setBounds(x, y, 200, 200);
    	System.out.println("R2R.png表示");
    	System.out.println(x+","+y);
	}
	
	//画像表示7
	public void drowPause() {
		label.setIcon(pause);
	    System.out.println("pause.png表示");
	    System.out.println(x+","+y);
	}
		
	//移動停止
	public void moveStop() {
		if(timer != null){
			timer.cancel();
			timer = null;
		}
	}
	
	//移動開始
	public void moveStart() {
		if(timer==null&&windowCheck==false&&Main.moveCheck==true) {
			timer=new Timer(true);
			move();
			timer.schedule(task, 0, 1000);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネント上でクリックして離す
		System.out.println("クリックして離す");
		System.out.println(windowCheck);
		
		drowPause();
		
		moveStop();
		
		if(windowCheck==false) {
			windowCheck=true;
			new Menu();
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネントにマウスが入る
		System.out.println("カーソルがコンポーネントに乗った");
		
		//ドラッグ時は呼び出さない
		if(draggedCheck==false) {
			moveStop();
			
			//起動時カーソルは乗る判定が入るので1回目は除外する
			i++;
			if(1!=i) {
				drowPause();
			}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネント上でクリックする
		
		//現在のイベント位置から最初のクリック位置の差を計算
		dx=e.getXOnScreen()-label.getX();
		dy=e.getYOnScreen()-label.getY();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//クリックしてドラッグする
		
		draggedCheck=true;
        
		System.out.println("停止後");
		 
		//ドラッグ位置の計算
		x=e.getXOnScreen()-dx;
		y=e.getYOnScreen()-dy;
		
		System.out.println(e.getXOnScreen());
		System.out.println(e.getX());
		System.out.println(dx);
		System.out.println(x);
		 
		//表示切替
		if(dragged<29) {
			label.setIcon(dragg1);
			label.setLocation(x,y);
			System.out.println("ドラッグ描画1");
			dragged++;
		}else {
			label.setIcon(dragg2);
			label.setLocation(x,y);
			System.out.println("ドラッグ描画2");
			dragged++;
			if(dragged==60) {
				dragged=0;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//マウスクリックが離されると呼出し
		//x=e.getX();
		//y=e.getY();
		
		drowPause();
		
		draggedCheck=false;
		
		System.out.print(x+","+y);
		
		//画面外にドラッグした場合の処理
		if(x<xMin || x>xMax || y<yMin || y>yMax) {
			System.out.print("画面外です");
			if((x<xMin && y<yMin) || (x>xMax && y<yMin) || (x<xMin && y>yMax) || (x>xMax && y>yMax)) {//x軸y軸両方範囲外（右上右下左上左下）
				System.out.print("x軸y軸両方範囲外");
				if(x<xMin && y<yMin) {//右上左上か右下左下の判定
					//左上
					System.out.println("左上");
					x=xMin;
					y=yMin;
				}else if(x>xMax && y<yMin) {
					//右上
					System.out.println("右上");
					x=xMax;
					y=yMin;
				}else if(x<xMin && y>yMax) {
					//左下
					System.out.println("左下");
					x=xMin;
					y=yMax;
				}else {
					//右下
					System.out.println("右下");
					x=xMax;
					y=yMax;
				}
			}else if(x<xMin || x>xMax){//x軸のみ超えているかどうか
				if(x<xMin) {//x軸のどっちが超えてるか判定
					//x軸左
					System.out.println("//x軸左");
					x=xMin;
				}else {
					//x軸右
					System.out.println("//x軸右");
					x=xMax;
				}
			}else if(y<yMin) {//y軸のどっちが超えているか判定
				//y軸上
				System.out.println("//y軸上");
				y=yMin;
			}else {
				//y軸下
				System.out.println("//y軸下");
				y=yMax;
			}
		
		}
		
		
		System.out.println("if抜けた");
		System.out.println(timer);
		
		moveStart();
		
		System.out.print("クリック離す");
				
				
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネントからマウスが出る
		
		//ドラッグ時は呼び出さない
		if(draggedCheck==false) {
			System.out.println("コンポーネントからマウスが出る");
			
			if(windowCheck==true||Main.moveCheck==false) {
				drowPause();
				System.out.println("マウスが出る");
			}else {
				//ドラック前の向きチェック
				if(w>=1) {
					switch(drowCheck) {
						case 1:
							drowLeft1();
						case 3:
							drowLeft3();
						default:
							drowLeft2();
					}
				}else {
					switch(drowCheck) {
						case 1:
							drowRigth1();
						case 3:
							drowRigth3();
						default:
							drowRigth2();
					}
				}
				
			}
			
			i++;
			
			moveStart();
			
			System.out.println("移動開始");
		}
	}

	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
