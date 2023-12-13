
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
	
  	public Browser(String keyword){
		// driverの設定 chrome
  		//System.setProperty("webdriver.chrome.driver","C:/workspace/mascot/driver/chromedriver.exe");
  		
  		// driverの設定 edge
  		System.setProperty("webdriver.msedge.driver","C:/workspace/mascot/driver/msedgedriver.exe");
  		
  	    // Webdriverのインスタンスを作成 chrome
  	    //WebDriver driver = new ChromeDriver();  
  		
  		// Webdriverのインスタンスを作成 edge
  	    WebDriver driver = new EdgeDriver();  

  	    // 開くサイトのURLを設定する
  	    //driver.get("https://www.google.com");
  	    
  	    // 開くサイトのURLを設定する
  	    driver.get("https://www.google.com");
  	    
  	    System.out.println(keyword);
  	    
  	    // 入力フォームの要素を取得 chrome
  		//driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).sendKeys(keyword);

  		// 検索ボタンの要素を取得する chrome
  	    //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
  	    
  	    //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));
  	    
  	    // 入力フォームの要素を取得 edge
  	    driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).sendKeys(keyword);

  		// 検索ボタンの要素を取得する edge
  	    driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();

  	    
  	    }
			
		
	}
