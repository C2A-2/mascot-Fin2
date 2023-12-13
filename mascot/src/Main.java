
import java.awt.AWTException;
import java.io.IOException;
import java.util.Timer;

public class Main {
	
	public static Character character;
	static boolean moveCheck=true;//ture:移動、false:停止
	

	public static void main(String[] args) throws IOException, AWTException {
		
		character=new Character();
		
		new Systemtray();
		
		String javaversion = System.getProperty("java.version");
		System.out.println("Java Runtime Environmentのバージョン:"+javaversion);
		
		String javavmspecificationversion = System.getProperty("java.version");
		System.out.println("Java仮想マシンの仕様バージョン:"+javavmspecificationversion);
		
		String javavmversion = System.getProperty("java.vm.version");
		System.out.println("Java仮想マシンの実装バージョン:"+javavmversion);
		
		String javaspecificationversion = System.getProperty("java.specification.version");
		System.out.println("Java Runtime Environmentの仕様バージョン:"+javaspecificationversion);
		
		String osname = System.getProperty("os.name");
		System.out.println("オペレーティング・システム名:"+osname);
		
		String osarch = System.getProperty("os.arch");
		System.out.println("オペレーティング・システムのアーキテクチャ:"+osarch);
		
		String osversion = System.getProperty("os.version");
		System.out.println("オペレーティング・システムのバージョン:"+osversion);
		
	}	
		
	//各ウィンドウを閉じたら呼び出し
	public static void closingCheck(){
		character.moveStart();
	}
	
	public static void moveStopMain(){
		//システムトレイ移動停止押したら呼び出し
		//移動停止
		if(character.timer != null&&moveCheck==true){
			character.timer.cancel();
			character.timer = null;
			moveCheck=false;
			character.drowPause();
		}
	}
	
	public static void moveStartMain(){
		//システムトレイ移動停止押したら呼び出し
		//移動開始
		if(character.timer==null ) {
			character.timer=new Timer(true);
			character.move();
			character.timer.schedule(character.task, 0, 1000);
			moveCheck=true;
		}
	}
	
	
	    
	    
}

	