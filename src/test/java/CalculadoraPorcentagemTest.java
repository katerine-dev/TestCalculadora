import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class CalculadoraPorcentagemTest {
     private WebDriver driver;

    @Before
    public void setUp() {
        // Configurando o driver do Selenium
        System.out.println("SetUp");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        // Navegando até o site
        driver.get("https://calculadora-digital.com.br/");

    }

    @Test
    public void porcentagemPositivaTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoPorcentagem = driver.findElement(By.xpath("//input[@value='%']"));

        // Executando a operação 100%
        inputNumero1.sendKeys("100");
        botaoPorcentagem.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("1", resultado.getAttribute("value"));
    }

    @Test
    public void porcentagemZeroTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoPorcentagem = driver.findElement(By.xpath("//input[@value='%']"));

        // Executando a operação 1 + 1
        inputNumero1.sendKeys("0");
        botaoPorcentagem.click();


        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("0", resultado.getAttribute("value"));
    }

 @Test
    public void porcentagemNegativosTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoPorcentagem = driver.findElement(By.xpath("//input[@value='%']"));
        WebElement botaoNegativo = driver.findElement(By.xpath("//input[@value='±']"));


        // Executando a operação -100%
        inputNumero1.sendKeys("100");
        botaoNegativo.click();
        botaoPorcentagem.click();


     // Aguardando um curto período para exibir o resultado
     Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("-1", resultado.getAttribute("value"));
    }


    @After
    public void tearDown() {
        System.out.println("TearDown");
        // Fechando o navegador
        driver.quit();
    }

}

