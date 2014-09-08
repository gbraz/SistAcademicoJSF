package br.ufc.selenium;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastroTeste {

	@Test
    public void cadastraAluno() {
        WebDriver driver = new FirefoxDriver();
        List<WebElement> linhas;
        boolean achou = false;
        
        driver.get("http://localhost:8080/SistAcademicoJSF/cadastro.xhtml");
       

        String nome = "Mario Bros.";
        String matricula = "10";
        String cpf = "022111";
        String sexo = "HOMEM";
        
        WebElement element = driver.findElement(By.xpath("/html/body/form/input[2]"));
        element.sendKeys(nome);

        element = driver.findElement(By.xpath("//*[@id='j_idt5:matricula']"));
        element.sendKeys(matricula);
        
        element = driver.findElement(By.xpath("//*[@id='j_idt5:cpf']"));
        element.sendKeys(cpf);
        
        element = driver.findElement(By.xpath("/html/body/form/select"));
        element.sendKeys(sexo);;
        
        element = driver.findElement(By.xpath("/html/body/form/input[5]"));
        element.click();
        
        
        linhas = driver.findElements(By.xpath("/html/body/table/tbody/tr"));

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
        	Assert.fail("Matrícula não cadastrada");
        }

        driver.quit();
    }
}