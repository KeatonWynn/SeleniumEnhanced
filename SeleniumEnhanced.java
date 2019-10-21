package globalclasses;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumEnhanced {
	
	ChromeOptions options = new ChromeOptions();
		
	private String userHMF = System.getProperty("user.name");
	public WebDriver driver = new ChromeDriver();
    public Actions action = new Actions(driver);
    
    	
	private String co; //Catch output
	private String xp; //xPath
	private int mt = 5; // MaxTries
	private String kts; // Keys to Send
	private String gt; //return values for getText method/function
	private String an; //Attribute Name;
	private String on; //Option name
	private boolean FatalError = false; 
	public boolean eoe = true;
	
	//alter variables here
	private int SecondsToWait = 10;
	
	
	public void setErrorExit(boolean ExitOnError){
		eoe = ExitOnError;
	}
	
	public void setMaxTries(int MaxTries){
		mt = MaxTries;
	}
	
	public void setChromeDriver(String Location){
		
		System.setProperty("webdriver.chrome.driver", Location);
		
	}
	
	public void setIEDriver(String Location){
		
		driver = new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\" + userHMF + "\\Java_Files\\IEDriverServer.exe");
		
	}
	
	public String getText(String XPath, String CatchOutput) throws InterruptedException{

		xp = XPath;
		co = CatchOutput;
		

		for(int i=0; i < (mt);){

			try{  
				gt = driver.findElement(By.xpath(xp)).getText(); 
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);
				if(i == (mt-1)){
					FatalError = true;
					System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:getText");
					driver.close();
					driver.quit();
					System.exit(0); 
				}
				i++;
							}
		}

		return gt; 
	}
	
	public String getText(String XPath, String CatchOutput, boolean ExitOnError) throws InterruptedException{

		xp = XPath;
		co = CatchOutput;
		eoe = ExitOnError;

		for(int i=0; i < (mt);){

			try{  
				gt = driver.findElement(By.xpath(xp)).getText(); 
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);

				if(i == (mt-1)){
					FatalError = true;
					if (eoe = ExitOnError){
						System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:getText");
						driver.close();
						driver.quit();
						System.exit(0); 
					}
					else { System.out.println("FATAL ERROR: " + CatchOutput  + " | " + "Action:getText");}
				}
			}
			i++;

		}

		return gt; 
	}
	
	
	
	public String getAttribute(String XPath, String CatchOutput, String AttributeName) throws InterruptedException{

		xp = XPath;
		co = CatchOutput;
		an = AttributeName;
		eoe = true;

		for(int i=0; i < (mt);){

			try{  
				gt = driver.findElement(By.xpath(xp)).getAttribute(an); 
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);
				if(i == (mt-1)){
					FatalError = true;
					System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:getAttribute");
					driver.close();
					driver.quit();
					System.exit(0); 
				}
				i++;


			}
		}
		return gt;

	}
	
	//Currently having issues with this method
	public String selectDropDownOption(String XPath, String CatchOutput, String OptionName) throws InterruptedException{

		xp = XPath;
		co = CatchOutput;
		on = OptionName;
		eoe = true;

		for(int i=0; i < (mt);){

			try{  
				Select option = new Select(driver.findElement(By.xpath(xp))); 
				option.selectByVisibleText(on);				
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);
				if(i == (mt-1)){
					FatalError = true;
					System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:getAttribute");
					driver.close();
					driver.quit();
					System.exit(0); 
				}
				i++;


			}
		}
		return gt;

	}
	
	
	public void click(String XPath, String CatchOutput) throws InterruptedException{

		xp = XPath;
		co = CatchOutput;		

		for(int i=0; i < (mt);){

			try{  
				driver.findElement(By.xpath(xp)).click(); 
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);
				if(i == (mt-1)){
					if (eoe == true){
						FatalError = true;
						System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:click");
						driver.close();
						driver.quit();
						System.exit(0);
					}
					else { 
						System.out.println("FATAL ERROR: " + CatchOutput + " | " + "Action:click");
						//					throw new Exception(CatchOutput + " | " + "Action:click") ; 
					}

				}
				if(i == mt/2){
					driver.navigate().refresh();
				}
				i++;


			}
		}
	}
	
	public void click(String XPath, String CatchOutput, boolean ExitOnError) throws Exception{

		xp = XPath;
		co = CatchOutput;

		for(int i=0; i < (mt);){

			try{  
				driver.findElement(By.xpath(xp)).click(); 
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);
				if(i == (mt-1)){
					if (eoe = ExitOnError){
						FatalError = true;
						System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:click");
						driver.close();
						driver.quit();
						System.exit(0);
					}
					else { 
						System.out.println("FATAL ERROR: " + CatchOutput + " | " + "Action:click");
						throw new Exception(CatchOutput + " | " + "Action:click") ; 
					}
				}
				if(i == mt/2){
					driver.navigate().refresh();
				}
				i++;


			}
		}
	}

	public void clear(String XPath, String CatchOutput) throws InterruptedException{

		xp = XPath;
		co = CatchOutput;
		eoe = true;

		for(int i=0; i < (mt);){

			try{  
				driver.findElement(By.xpath(xp)).clear(); 
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);
				if(i == (mt-1)){
					FatalError = true;
					System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:clear");
					driver.close();
					driver.quit();
					System.exit(0); 
				}
				i++;


			}
		}


	}

	
	public void sendKeys(String XPath, String CatchOutput, String KeysToSend) throws InterruptedException{

		xp = XPath;
		co = CatchOutput;
		kts = KeysToSend; 
		eoe = true;

		for(int i=0; i < (mt);){

			try{  
				driver.findElement(By.xpath(xp)).sendKeys(kts); 
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);
				if(i == (mt-1)){
					FatalError = true;
					System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:sendKeys");
					driver.close();
					driver.quit();
					System.exit(0); 
				}

			}
			//handles internet interruptions. Once variable i meet half of max attempts the page will be reloaded.
			if(i == mt/2){
				driver.navigate().refresh();
			}
			i++;
		}
	}

	
	public void sendKeys(String XPath, String CatchOutput, String KeysToSend, boolean ExitOnError) throws Exception{

		xp = XPath;
		co = CatchOutput;
		kts = KeysToSend; 

		for(int i=0; i < (mt);){

			try{  
				driver.findElement(By.xpath(xp)).sendKeys(kts); 
				i = mt;
			}
			catch (Exception e){
				System.out.println(co + ": try " + (i+1) + " out of " + mt);
				TimeUnit.SECONDS.sleep((long) SecondsToWait);

				if(i == (mt-1)){
					FatalError = true;
					if (eoe = ExitOnError){
						System.out.println("STOPPING PROCESS - FATAL ERROR: " + CatchOutput + " | " + "Action:sendKeys");
						driver.close();
						driver.quit();
						System.exit(0); 
					}
					else { 
						System.out.println("FATAL ERROR: " + CatchOutput + " | " + "Action:sendKeys");
						throw new Exception(CatchOutput + " | " + "Action:sendKeys") ; 
						}
				}
			}
			if(i == mt/2){
				driver.navigate().refresh();
			}
			i++;
		}

	}
	
	

}
