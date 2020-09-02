import com.google.gson.internal.bind.util.ISO8601Utils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void ass() {
        driver.get("http://www.amazon.com");
        String titleActual = driver.getTitle();
        String expectedTitle = "car";
        if (titleActual.contains(expectedTitle)) {
            System.out.println("GECIYOR");
        } else
            System.out.println("GECMIYOR");
        System.out.println(titleActual);
    }

    @Test
    public void test2() {
        driver.get("http://www.amazon.com");
        String titleActual = driver.getTitle();
        String expectedTitle = "google";
        if (!titleActual.contains(expectedTitle)) {
            System.out.println("GECIYOR");
        } else {
            System.out.println("GECMIYOR");
            System.out.println(titleActual);
        }

        boolean falseMi= titleActual.contains("Google");
        Assert.assertFalse(falseMi);
    }
















}