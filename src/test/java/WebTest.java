import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTest {

    @Test
    public static void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );
        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id = 'wrap']/div[@id = 'main']/h2"));
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public static void testMenuStartHeader() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement h1 = driver.findElement(By.xpath("//body/div[@id = 'wrap']/div[@id = 'header']/h1"));
        String actualResult = h1.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public static void testStartMenuSubmitNewLanguage() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "SUBMIT NEW LANGUAGE";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmitNewLanguage = driver.findElement(By.xpath(
            "//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/submitnewlanguage.html']"
        ));
        String actualResult = menuSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public static void testMenuSubmitNewLanguageIsTitleSubmitNewLanguage() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmitNewLanguage = driver.findElement(By.xpath(
          "//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/submitnewlanguage.html']")
        );
        menuSubmitNewLanguage.click();

        WebElement nameTitleIsSubmitNewLanguage = driver.findElement(By.xpath(
                "//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'submenu']/li/a")
        );
        String actualResult = nameTitleIsSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
