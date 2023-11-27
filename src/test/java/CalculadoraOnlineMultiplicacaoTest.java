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


public class CalculadoraOnlineMultiplicacaoTest {
    
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
    public void MultiplicaDoisNumeros()  {
    
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoMultiplica = driver.findElement(By.xpath("//input[@value='x']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 1 x 1
        inputNumero1.sendKeys("1");
        botaoMultiplica.click();
        inputNumero1.sendKeys("1");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("1", resultado.getAttribute("value"));
    }
    
    
    @Test
    public void MultiplicaPorZero()  {
    
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoMultiplica = driver.findElement(By.xpath("//input[@value='x']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 4 x 0
        inputNumero1.sendKeys("4");
        botaoMultiplica.click();
        inputNumero1.sendKeys("0");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("0", resultado.getAttribute("value"));
    }
    
    @Test
    public void MultiplicaDoisNumerosNegativos()  {
    
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoMultiplica = driver.findElement(By.xpath("//input[@value='x']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação -23 x -7
        inputNumero1.sendKeys("-23");
        botaoMultiplica.click();
        inputNumero1.sendKeys("-7");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("161", resultado.getAttribute("value"));
    }
    
    @Test
    public void MultiplicaNumerosPositivoNegativo()  {
    
        // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoMultiplica = driver.findElement(By.xpath("//input[@value='x']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));
        WebElement botaoNegativo = driver.findElement(By.xpath("//input[@value='±']"));

        // Executando a operação 35 x -16 
        inputNumero1.sendKeys("35");
        botaoMultiplica.click();
        inputNumero1.sendKeys("16");
        botaoNegativo.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("-560", resultado.getAttribute("value"));
    }
    
    @Test
    public void MultiplicaDoisNumerosGrandes()  {
    
    // Localizando os elementos de entrada
        WebElement inputNumero1 = driver.findElement(By.id("calc1_resultat"));
        WebElement botaoMultiplica = driver.findElement(By.xpath("//input[@value='x']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação 5489 x 28496
        inputNumero1.sendKeys("5489");
        botaoMultiplica.click();
        inputNumero1.sendKeys("28496");
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        Utils.espera();

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("156414544", resultado.getAttribute("value"));
    }
    
     @After
    public void tearDown() {
        System.out.println("TearDown");
        // Fechando o navegador
        driver.quit();
    }

    
}
