package br.ufc.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


// TODO: finalizar
public class CadastroTeste  {
	
	@Test
    public void cadastraAluno() {
        WebDriver driver = new FirefoxDriver();
        
        driver.get("http://localhost:8080/SistAcademicoJSF/cadastro.xhtml");
       

        String nome = "Mario Bros.";
        String matricula = "1";
        String cpf = "022111";
        String sexo = "h";
        
        WebElement element = driver.findElement(By.xpath(":nome"));
        element.sendKeys(nome);

        element = driver.findElement(By.name("j_idt7:matricula"));
        element.sendKeys(matricula);
        
        element = driver.findElement(By.name("j_idt7:cpf"));
        element.sendKeys(cpf);
        
        element = driver.findElement(By.name("j_idt7:sexo"));
        element.sendKeys(sexo);
        
        element = driver.findElement(By.name("j_idt7:j_idt25"));
        element.click();

        /*
        if(!linhas.isEmpty()){
	        for(WebElement linha : linhas){
	        	coluna = linha.findElement(By.tagName("td"));
	        }
	    }
        */
        Assert.assertEquals(driver.findElements(By.name("nome")).toString(), nome);
        
        driver.quit();
    }
}