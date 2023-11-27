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

public class BotoesEspeciaisTest {
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
    public void botaoCETest() {
        // Localizando os elementos de entrada
        WebElement inputResultado = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoNumero5 = driver.findElement(By.xpath("//input[@value='5']"));
        WebElement botaoCE = driver.findElement(By.xpath("//input[@value='CE']"));

        // Inserindo um número na calculadora
        botaoNumero5.click();

        // Garantindo que o número foi inserido corretamente
        assertEquals("5", inputResultado.getAttribute("value"));

        // Pressionando o botão CE para apagar todos os números
        botaoCE.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando se todos os números foram apagados
        assertEquals("0", inputResultado.getAttribute("value"));

    }

    @Test
    public void botaoSetaTest() {
        // Localizando os elementos de entrada
        WebElement inputResultado = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoNumero2 = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement botaoNumero3 = driver.findElement(By.xpath("//input[@value='3']"));
        WebElement botaoBackspace = driver.findElement(By.xpath("//input[@value='←']"));

        // Inserindo dois números inteiros na calculadora
        botaoNumero2.click();
        botaoNumero3.click();

        // Garantindo que os números foram inseridos corretamente
        assertEquals("23", inputResultado.getAttribute("value"));

        // Pressionando o botão ← para apagar apenas um número
        botaoBackspace.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando se apenas um número foi apagado
        assertEquals("2", inputResultado.getAttribute("value"));

    }

    @After
    public void tearDown() {
        System.out.println("TearDown");
        // Fechando o navegador
        driver.quit();
    }

}

