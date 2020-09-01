import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon  {
    // 1. Amazon.com'a gideceğiz.
    // 2. Arama kutusuna "baby stroller"
    // 3. 2. Sıradaki ürüne tıklayacağız.
    // 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
    // 5. Ürünün ortalama puanını (5 üzerinden) alacağız.




    @Test
    public void test1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller" + Keys.ENTER );
        WebElement ikinciSiradaUrun = driver.findElement(By.xpath("( //a[@class='a-link-normal a-text-normal'] )[2]"));
        ikinciSiradaUrun.click();
        WebElement urunFiyati = driver.findElement(By.id("priceblock_ourprice_row"));
        System.out.println(urunFiyati.getText());
        System.out.println("////////////////////////////////");

    }

    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        WebElement googleAramaKutusu = driver.findElement(By.name("q"));
        googleAramaKutusu.sendKeys("Kemal Ozden");
        googleAramaKutusu.submit();
        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());

    }
}