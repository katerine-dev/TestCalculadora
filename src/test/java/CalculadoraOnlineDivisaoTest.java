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

public class CalculadoraOnlineDivisaoTest {
    private WebDriver driver;
    private final int waitTime = 1500;

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
    public void divisaoDoisInteirosTest() {
        // Localizando os elementos de entrada
        WebElement botaoNumero6 = driver.findElement(By.xpath("//input[@value='6']"));
        WebElement botaoDivisao = driver.findElement(By.xpath("//input[@value='÷']"));
        WebElement botaoNumero2 = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação: 6 ÷ 2
        botaoNumero6.click();
        botaoDivisao.click();
        botaoNumero2.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("3", resultado.getAttribute("value"));
    }
    @Test
    public void divisaoPorZeroTest() {
        // Localizando os elementos de entrada
        WebElement botaoNumero5 = driver.findElement(By.xpath("//input[@value='5']"));
        WebElement botaoDivisao = driver.findElement(By.xpath("//input[@value='÷']"));
        WebElement botaoNumero0 = driver.findElement(By.xpath("//input[@value='0']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));


        // Executando a operação: 5 ÷ 0
        botaoNumero5.click();
        botaoDivisao.click();
        botaoNumero0.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("Infinity", resultado.getAttribute("value"));
    }

    @Test
    public void divisaoNegativosTest() {
        // Localizando os elementos de entrada
        WebElement botaoNumero5 = driver.findElement(By.xpath("//input[@value='5']"));
        WebElement botaoDivisao = driver.findElement(By.xpath("//input[@value='÷']"));
        WebElement botaoNumero2 = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));
        WebElement botaoNegativo = driver.findElement(By.xpath("//input[@value='±']"));

        // Executando a operação: -5 ÷ 2
        botaoNumero5.click();
        botaoNegativo.click();
        botaoDivisao.click();
        botaoNumero2.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("-2.5", resultado.getAttribute("value"));
    }

    @Test
    public void divisaoFloatTest() {
        // Localizando os elementos de entrada
        WebElement botaoNumero4 = driver.findElement(By.xpath("//input[@value='4']"));
        WebElement botaoDivisao = driver.findElement(By.xpath("//input[@value='÷']"));
        WebElement botaoNumero5 = driver.findElement(By.xpath("//input[@value='5']"));
        WebElement botaoNumero1 = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement botaoPonto = driver.findElement(By.xpath("//input[@value=',']")); // Ponto decimal
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação: 4.5 ÷ 1.5
        botaoNumero4.click();
        botaoPonto.click();
        botaoNumero5.click();
        botaoDivisao.click();
        botaoNumero1.click();
        botaoPonto.click();
        botaoNumero5.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("3", resultado.getAttribute("value"));
    }
    @Test
    public void divisaoDizimaPeriodicaTest() {
        // Localizando os elementos de entrada
        WebElement botaoNumero1 = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement botaoDivisao = driver.findElement(By.xpath("//input[@value='÷']"));
        WebElement botaoNumero3 = driver.findElement(By.xpath("//input[@value='3']"));
        WebElement botaoIgual = driver.findElement(By.xpath("//input[@value='=']"));

        // Executando a operação: 1 ÷ 3
        botaoNumero1.click();
        botaoDivisao.click();
        botaoNumero3.click();
        botaoIgual.click();

        // Aguardando um curto período para exibir o resultado
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verificando o resultado
        WebElement resultado = driver.findElement(By.id("calc1_resultat"));
        assertEquals("0.3333333333333333", resultado.getAttribute("value"));
    }

    @After
    public void tearDown() {
        System.out.println("TearDown");
        // Fechando o navegador
        driver.quit();
    }
}
