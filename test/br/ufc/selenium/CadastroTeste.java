package br.ufc.selenium;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import br.ufc.model.Sexo;

public class CadastroTeste {

	@Test
    public void cadastraAluno() {
        //WebDriver driver = new FirefoxDriver();
		WebDriver driver = new HtmlUnitDriver();
        List<WebElement> linhas;
        boolean achou = false;
        
        driver.get("http://localhost:8080/SistAcademicoJSF/cadastro.xhtml");
       

        String nome = "Mario Bros.";
        String cpf = "022111";
        String sexo = "";
        String data = "02/09/2014";
        
        WebElement element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        element.sendKeys(nome);
        
        element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        element.sendKeys(cpf);
        
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/select")));
        dropdown.selectByVisibleText("Homem");
                   
        element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td/input"));
        element.click();
        
  
        linhas = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
/*
        for(int i = 2; i <= linhas.size(); i++){
        	if(matricula.equals(driver.findElement(By.xpath("/html/body/table/tbody/tr["+ i +"]/td[2]")).getText())){
		        Assert.assertEquals((driver.findElement(By.xpath("/html/body/table/tbody/tr["+ i +"]/td[1]"))).getText(), nome);
		        Assert.assertEquals((driver.findElement(By.xpath("/html/body/table/tbody/tr["+ i +"]/td[2]"))).getText(), matricula);
		        Assert.assertEquals((driver.findElement(By.xpath("/html/body/table/tbody/tr["+ i +"]/td[3]"))).getText(), cpf);
		        Assert.assertEquals((driver.findElement(By.xpath("/html/body/table/tbody/tr["+ i +"]/td[4]"))).getText(), sexo);
		        achou = true;
        	}
        }

        if(!achou){
        	Assert.fail("Matr�cula n�o cadastrada");
        }
         */
        driver.quit();
    }
}