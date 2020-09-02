import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Ornek {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void amazonDropDownTest(){

        /*
        // 1. DropDown'da Books kategorisini seçelim.
// 2. Arama kutusuna JAVA yazalım.
// 3. Toplam sonuç sayısını ekrana yazdıralım.
// 4. İlk sıradaki ürüne tıklayalım.
// 5. Back to results linki varsa, testimiz TRUE yoksa FALSE
                                    //      pass        fail
         */
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByIndex(5);
        WebElement searc = driver.findElement(By.id("twotabsearchtextbox"));
        searc.sendKeys("JAVA"+ Keys.ENTER);

        WebElement ilkSuradakiKitap = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        ilkSuradakiKitap.click();
        WebElement backTo = driver.findElement(By.xpath("//*[.='Back to results'"));





    }
}
