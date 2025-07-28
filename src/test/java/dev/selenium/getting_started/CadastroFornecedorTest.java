package dev.selenium.getting_started;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CadastroFornecedorTest {
    public static void main(String[] args) {
        // Configura o ChromeDriver automaticamente
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, java.util.concurrent.TimeUnit.SECONDS);

        driver.get("http://localhost:4200/fornecedores/create");

        // Preencher o formulário pelos atributos 'name' do input
        WebElement inputNome = driver.findElement(By.name("nome_for"));
        WebElement inputCnpj = driver.findElement(By.name("cnpj_for"));
        WebElement inputTelefone = driver.findElement(By.name("telefone_for"));
        WebElement inputEmail = driver.findElement(By.name("email_for"));

        inputNome.sendKeys("Fornecedor Selenium");
        inputCnpj.sendKeys("12.345.678/0001-00"); // com máscara
        inputTelefone.sendKeys("(11) 99999-9999"); // com máscara
        inputEmail.sendKeys("teste@selenium.com");

        // Encontrar botão "Salvar" pelo texto
        WebElement botaoSalvar = driver.findElement(By.xpath("//button[contains(text(),'Salvar')]"));
        botaoSalvar.click();

        System.out.println("Formulário enviado com sucesso.");

        driver.quit();
    }
}
