package com.cadastroelogin;

//import junit.framework.Assert;
//import static org.junit.Assert.assertEquals;

import java.io.File;
//import java.io.IOException;
//import java.io.PrintStream;
//import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
//import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import com.google.common.io.Files;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;




public class CadastroeLogin {

	public static void main(String[] args) throws Exception {
		
		String currentDirectory = System.getProperty("user.dir");
		System.out.println("The current working directory is " + currentDirectory);
		
		System.setProperty("webdriver.chrome.driver", currentDirectory+"\\chromedriver.exe");

		
		//AQUI CRIA AUTOMATICAMENTE UMA PASTA COM NOME DO DIA DE HOJE, QUE FICA LOCALIZADA DENTRO DA PASTA DO PROJETO 
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		String time = dateFormat.format(now);
		File dir1= new File(time);
		if(!dir1.exists())
			dir1.mkdir(); 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Luana\\Desktop\\z\\chromedriver.exe");
		
		// AQUI ABRE O GERADOR PARA GERAR E COPIAR UM EMAIL
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://theonegenerator.com/pt/geradores/documentos/gerador-de-email/"); 
		
		String titulogeradoremail = null; 
		titulogeradoremail = driver.getTitle();
		System.out.println(titulogeradoremail);
		
	
	
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		String gerarXpath = "/html/body/div/div/section/div[2]/section/div[2]/div/div[2]/div[1]/div/div/div/div[2]/form/button";
		WebElement gerar = driver.findElement(By.xpath(gerarXpath)); 
		
		if(gerar != null) {
			gerar.click();
    
		}
		
		String copiarXpath = "/html/body/div/div/section/div[2]/section/div[2]/div/div[2]/div[1]/div/div/div/div[2]/form/div[2]/button";
		WebElement copiar = driver.findElement(By.xpath(copiarXpath)); 
		
		if(copiar != null) {
			copiar.click();
			
		}
		
		try {
        Thread.sleep(5*1000);
			} catch (InterruptedException e) {
        e.printStackTrace();
        
			}
		
		//AQUI ABRE O SITE ZENKLUB E DIRECIONA PARA TELA DE CADASTRO
		
		
		driver.get("https://zenklub.com.br/busca/psicologos/?utm_source=google&utm_medium=cpc&utm_campaign=Professionals%20Online%20%7C%20Brazil%20-%20Most%20relevants%20kw~Psicologo%20Online%20-%20Most%20Relevants%20KW&kw=psicologia%20online&gclid=EAIaIQobChMInOz2wbaA8AIVFAaRCh3vMwDnEAAYASAAEgJ0o_D_BwE"); 
		driver.manage().window().maximize();
		
		try {
	        Thread.sleep(10*1000);
				} catch (InterruptedException e) {
	        e.printStackTrace();
				}
		
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 	FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot.png"));
		 		
			
		}
		
		String titulozenklub = null; 
		titulozenklub = driver.getTitle();
		System.out.println(titulozenklub);
		
		try {
        Thread.sleep(10*1000);
			} catch (InterruptedException e) {
        e.printStackTrace();
        
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot00.png"));
	 	
			}
		
		// AQUI CLICA NO BOT?O CADASTRAR GRATIS E DIRECIONA PARA A TELA DE CADASTRO
		
		String cadastrargratisXpath = "/html/body/app-root/app-landing/app-search-screen/div/app-header/header/app-header-desktop/div/div/div/nav/ul/li[4]/button/span";
		WebElement cadastrargratis = driver.findElement(By.xpath(cadastrargratisXpath)); 
		
		if(cadastrargratis != null) {
			cadastrargratis.click();
			
			try {
		        Thread.sleep(5*1000);
					} catch (InterruptedException e) {
		        e.printStackTrace();
		        
					}		
		}
		
		// AQUI CLICA NO BOT?O CRIAR CONTA SEM TER PREENCHIDO NENHUM CAMPO
		
		String criarcontaXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-signup-screen/div/form/div/button/span";
		WebElement criarconta = driver.findElement(By.xpath(criarcontaXpath)); 
		
		if(criarconta != null) {
			criarconta.click();
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 	FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot0.png"));	
		 	
		
			
		 // AQUI REALIZA O ASSERT DA MENSAGEM DE PREENCHIMENTO DO CAMPO NOME
		 	
		 	{
				
				String msg1 = "Favor preencher seu nome completo";
			 	String msgnome = driver.findElement(By.cssSelector("body > app-root > app-authentication > div > div:nth-child(1) > div > app-signup-screen > div > form > zk-input:nth-child(1) > span")).getText();
		        assertEquals(msg1, msgnome); 
			 	
		        if (!msg1.equals(msgnome)){
		            driver.quit();
		            throw new Exception("Cadastro: A mensagem de valida??o do campo nome esta incorreta");  }
		        
		        else {
		        	
		        System.out.println("Cadastro: A mensagem de valida??o do campo nome esta OK");
			 }
			 }
			 {
				
				String msg2 = "Favor preencher um email v?lido";
				String msgemail = driver.findElement(By.cssSelector("body > app-root > app-authentication > div > div:nth-child(1) > div > app-signup-screen > div > form > zk-input:nth-child(2) > span")).getText();
				assertEquals(msg2, msgemail); 
				
				if (!msg2.equals(msgemail)){
		            driver.quit();
		            throw new Exception("Cadastro: A mensagem de valida??o do campo email esta incorreta");  }
		        
		        else {
		        	
		        System.out.println("Cadastro: A mensagem de valida??o do campo email esta OK");
			 }
			 }
			 {
				 String msg3 = "Favor preencher uma senha (m?nimo de 6 caracteres)";
				 String msgsenha = driver.findElement(By.cssSelector("body > app-root > app-authentication > div > div:nth-child(1) > div > app-signup-screen > div > form > zk-input:nth-child(3) > span")).getText();
				 assertEquals(msg3, msgsenha); 
				 
				 if (!msg3.equals(msgsenha)){
			         driver.quit();
			         throw new Exception("Cadastro: A mensagem de valida??o do campo senha esta incorreta");  }
			        
			     else {
			        	
			     System.out.println("Cadastro: A mensagem de valida??o do campo senha esta OK");
				}
    			
        	}
  
        	try {
            	Thread.sleep(2*1000);
            	} catch (InterruptedException e) {
            	e.printStackTrace();

            	}
		 
		
		// AQUI PREENCHE O CAMPO NOME
			
		String nomeXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-signup-screen/div/form/zk-input[1]/label/input";
		WebElement nome = driver.findElement(By.xpath(nomeXpath)); 
		
		if(nome != null) {
			nome.sendKeys("Luana Silva"); 
			
		}
			
			try {
		        Thread.sleep(5*1000);
					} catch (InterruptedException e) {
		        e.printStackTrace(); }
		}
		
		// AQUI PREENCHE O CAMPO EMAIL
		
		String emailXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-signup-screen/div/form/zk-input[2]/label/input";
		WebElement email = driver.findElement(By.xpath(emailXpath)); 
		
		if(email != null) {
			CharSequence text = null;
			email.sendKeys(Keys.chord(Keys.CONTROL, "v", text));
		}
		
		// AQUI PREENCHE O CAMPO SENHA
		
		String senhaXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-signup-screen/div/form/zk-input[3]/label/input";
		WebElement senha = driver.findElement(By.xpath(senhaXpath)); 
		
		if(senha != null) {
			senha.sendKeys("123456");
			
		}
		
		// AQUI PREENCHE O CAMPO TERMOS
		
		String termosXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-signup-screen/div/form/zk-input[5]/label/div/span";
		WebElement termos = driver.findElement(By.xpath(termosXpath)); 
		
		if(termos != null) {
			termos.click();	
			
			try {
		        Thread.sleep(5*1000);
					} catch (InterruptedException e) {
		        e.printStackTrace(); }
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 	FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot1.png"));	
		}
		
		// AQUI CLICA NO BOT?O CRIAR A MINHA CONTA PARA CONCLUIR O CADASTRO
		
		String cadastrarXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-signup-screen/div/form/div/button/span";
		WebElement cadastrar = driver.findElement(By.xpath(cadastrarXpath)); 
		
		if(cadastrar != null) {
			cadastrar.click();	
			
			try {
		        Thread.sleep(15*1000);
					} catch (InterruptedException e) {
		        e.printStackTrace(); }
			
			// AQUI CLICA NO MENU USU?RIO
			
			String sairXpath = "#user_menu > div.user_info";
			WebElement sair = driver.findElement(By.cssSelector(sairXpath)); 
			
			if(sair != null) {
				sair.click();	
				
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 	FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot2.png"));	
				
			}
			
			// AQUI CLICA NO BOT?O SAIR
			
			String sair1Xpath = "#user_menu > div.user-links > ul > li:nth-child(5) > a > div";
			WebElement sair1 = driver.findElement(By.cssSelector(sair1Xpath)); 
			
			if(sair1 != null) {
				sair1.click();
				
				try {
			        Thread.sleep(5*1000);
						} catch (InterruptedException e) {
							
						}
				
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot3.png"));	
				
				try {
			        Thread.sleep(10*1000);
						} catch (InterruptedException e) {	
							
							
			
			}	
			}
			// AQUI CLICA NO BOT?O ENTRAR E DIRECIONA PARA A TELA DE LOGIN
			
			String entrarXpath = "/html/body/app-root/app-landing/app-new-home-screen/app-header/header/app-header-desktop/div/div/div/nav/ul/li[3]/a";
			WebElement entrar = driver.findElement(By.xpath(entrarXpath)); 
			
			if(entrar != null) {
				entrar.click();
				
					
				
				try {
			        Thread.sleep(5*1000);
						} catch (InterruptedException e) {
			        e.printStackTrace(); }
				
						}

				// AQUI CLICA NO BOT?O ENTRAR SEM TER PREENCHIDO NENHUM CAMPO
				
				String acessarXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-login-screen/div[1]/form/div/button/span";
				WebElement acessar = driver.findElement(By.xpath(acessarXpath)); 
				
				if(acessar!= null) {
					acessar.click();
					
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 	FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot4.png"));	
					
				 // AQUI REALIZA O ASSERT DA MENSAGEM DE PREENCHIMENTO DE CAMPO
				 	{
				 		String msg4 = "E-mail inv?lido";
						String msgemail1 = driver.findElement(By.cssSelector("body > app-root > app-authentication > div > div:nth-child(1) > div > app-login-screen > div.zk-max-w-sm.zk-mx-auto.zk-space-y-6 > form > zk-input:nth-child(1) > span")).getText();
						assertEquals(msg4, msgemail1); 
						
						if (!msg4.equals(msgemail1)){
				            driver.quit();
				            throw new Exception("Login: A mensagem de valida??o do campo email esta incorreta");  }
				        
				        else {
				        	
				        System.out.println("Login: A mensagem de valida??o do campo email esta OK");
					 }
					 
				 	}
				 	{
				 	
				 	String msg5 = "Senha ? necess?ria";
					String msgemail1 = driver.findElement(By.cssSelector("body > app-root > app-authentication > div > div:nth-child(1) > div > app-login-screen > div.zk-max-w-sm.zk-mx-auto.zk-space-y-6 > form > zk-input:nth-child(2) > span")).getText();
					assertEquals(msg5, msgemail1); 
					
					if (!msg5.equals(msgemail1)){
			            driver.quit();
			            throw new Exception("Login: A mensagem de valida??o do campo email esta incorreta");  }
			        
			        else {
			        	
			        System.out.println("Login: A mensagem de valida??o do campo senha esta OK"); }
				 	
				 	
				}			
				}
				}
				
				// AQUI PREENCHE O CAMPO EMAIL
				
				String loginemailXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-login-screen/div[1]/form/zk-input[1]/label/input";
				WebElement loginemail = driver.findElement(By.xpath(loginemailXpath)); 
				
				if(loginemail != null) {
					CharSequence text = null;
					loginemail.sendKeys(Keys.chord(Keys.CONTROL, "v", text));
				}
				
				// AQUI PREENCHE O CAMPO SENHA
				
				String loginsenhaXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-login-screen/div[1]/form/zk-input[2]/label/input";
				WebElement loginsenha = driver.findElement(By.xpath(loginsenhaXpath)); 
				
				if(loginsenha != null) {
					loginsenha.sendKeys("123456");
					
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 	FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot5.png"));	
				}
				
				// AQUI CLICA NO BOT?O ENTRAR E AUTENTICA O USUARIO
				
				String autenticarXpath = "/html/body/app-root/app-authentication/div/div[1]/div/app-login-screen/div[1]/form/div/button/span";
				WebElement autenticar = driver.findElement(By.xpath(autenticarXpath)); 
				
				if(autenticar != null) {
					autenticar.click();	
					
					try {
				        Thread.sleep(10*1000);
							} catch (InterruptedException e) {
								
							}
					
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 	FileUtils.copyFile(scrFile, new File("C:\\Users\\Luana\\Automacaodecadastroelogin\\AutomacaoZenklub\\16042021\\screenshot6.png"));	
		}
		
	}

	private static void assertEquals(String string, String text) {
		// TODO Auto-generated method stub
		
	}

}
