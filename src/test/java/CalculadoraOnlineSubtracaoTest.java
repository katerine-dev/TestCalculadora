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

public class CalculadoraOnlineSubtracaoTest {
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
    public void subtracaoDoisInteirosTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSub = driver.findElement(By.xpath("//input[@value='-']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 2 - 1
        inputNumero.sendKeys("2");
        botaoSub.click();
        inputNumero.sendKeys("1");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("1", resultado.getAttribute("value"));
    }

    @Test
    public void subtracaoZeroTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSub = driver.findElement(By.xpath("//input[@value='-']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 2 - 0
        inputNumero.sendKeys("2");
        botaoSub.click();
        inputNumero.sendKeys("0");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("2", resultado.getAttribute("value"));
    }

    @Test
    public void subtracaoNegativoTest() {
        // Localizando os elementos de entrada
        WebElement inputNumero = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSub = driver.findElement(By.xpath("//input[@value='-']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));
        WebElement botaoNegativo = driver.findElement(By.xpath("//input[@value='±']"));

        // Executando a operação 4 - (-2)
        inputNumero.sendKeys("4");
        botaoSub.click();
        inputNumero.sendKeys("2");
        botaoNegativo.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("6", resultado.getAttribute("value"));
    }

    @Test
    public void subtracaoLimiteInferior() {
        // Localizando os elementos de entrada
        WebElement inputNumero = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoSub = driver.findElement(By.xpath("//input[@value='-']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));


        // Executando a operação 2 - 4
        inputNumero.sendKeys("2");
        botaoSub.click();
        inputNumero.sendKeys("4");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("-2", resultado.getAttribute("value"));
    }


    @After
    public void tearDown() {
        System.out.println("TearDown");
        // Fechando o navegador
        driver.quit();
    }
}
