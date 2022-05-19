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
            "//ul[@id = 'menu']/li[last()]" //В задании сказано что последний пункт меню, я решил сделать такой поиск
        ));
        String actualResult = menuSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public static void testSubmitNewLanguageSubmenuSubmitNewLanguage() {

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

        WebElement nameSubmenuIsSubmitNewLanguage = driver.findElement(By.xpath(
                "//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'submenu']/li/a")
        );
        String actualResult = nameSubmenuIsSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public static void testBrowseLanguagesFirstSubmenu() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );
        menuBrowseLanguages.click();

        WebElement firstSubmenu = driver.findElement(By.xpath("//ul[@id = 'submenu']/li[1]")); //В задании сказано что первый пункт подменюменю, я решил сделать такой поиск
        String actualResult = firstSubmenu.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public static void testTheTeam() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultOliver = "Oliver Schade";
        String expectedResultGregor = "Gregor Scheithauer";
        String expectedResultStefan = "Stefan Scheler";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submenuTeam = driver.findElement(By.xpath("//ul[@id = 'submenu']/li/a[@href = 'team.html']"));

        submenuTeam.click();

        WebElement testOliver = driver.findElement(By.xpath("//*[text() = 'Oliver Schade']"));
        WebElement testGregor = driver.findElement(By.xpath("//*[text() = 'Gregor Scheithauer']"));
        WebElement testStefan = driver.findElement(By.xpath("//*[text() = 'Stefan Scheler']"));
        String actualResultOliver = testOliver.getText();
        String actualResultGregor = testGregor.getText();
        String actualResultStefan = testStefan.getText();

        Assert.assertEquals(actualResultOliver,expectedResultOliver);
        Assert.assertEquals(actualResultGregor,expectedResultGregor);
        Assert.assertEquals(actualResultStefan,expectedResultStefan);

        driver.quit();
    }

//    @Test
//    public static void testInputSearch() {
//
//        String chromeDriver = "webdriver.chrome.driver";
//        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
//        String url = "http://www.99-bottles-of-beer.net/";
//        String expectedResult = "search";
//
//        System.setProperty(chromeDriver,driverPath);
//        WebDriver driver = new ChromeDriver();
//
//        driver.get(url);
//
//        WebElement searchLanguages = driver.findElement(By.xpath("//ul[@id = 'menu']/li/a[@href = '/search.html']"));
//
//        searchLanguages.click();
//
//        WebElement inputName = driver.findElement(By.xpath("//input[@name = 'search']"));
//
//        String actualResult = inputName.getText();
//
//        Assert.assertEquals(actualResult,expectedResult);
//
//        driver.quit();
//    }

    @Test
    public static void testSubmitLanguageEmptyValue() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//ul[@ id = 'menu']/li/a[@href = '/submitnewlanguage.html']")
        );
        submitNewLanguage.click();

        WebElement buttonSubmitLanguage = driver.findElement(
                By.xpath("//form[@id='addlanguage']/p/input[@type = 'submit'][@name = 'submitlanguage']")
        );
        buttonSubmitLanguage.click();

        WebElement errorText = driver.findElement(By.xpath("//div[@id = 'main']/p"));
        String actualResult = errorText.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

//    @Test
//    public static void testSubmitLanguageError() {
//
//        String chromeDriver = "webdriver.chrome.driver";
//        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
//        String url = "http://www.99-bottles-of-beer.net/";
//        String expectedResultError = "Error";
//        String expectedResultPrecondition = "Precondition";
//        String expectedResultInput = "Input";
//        String expectedResultFailed = "failed";
//        String expectedResultSymbolOne = ":";
//        String expectedResultSymbolTwo = "-";
//        String expectedResultSymbolThree = ".";
//
//        System.setProperty(chromeDriver,driverPath);
//        WebDriver driver = new ChromeDriver();
//
//        driver.get(url);
//
//        WebElement submitNewLanguage = driver.findElement(
//                By.xpath("//ul[@ id = 'menu']/li/a[@href = '/submitnewlanguage.html']")
//        );
//        submitNewLanguage.click();
//
//        WebElement buttonSubmitLanguage = driver.findElement(
//                By.xpath("//form[@id='addlanguage']/p/input[@type = 'submit'][@name = 'submitlanguage']")
//        );
//        buttonSubmitLanguage.click();
//
//        WebElement errorText = driver.findElement(By.xpath("//div[@id = 'main']/p"));
//        String actualResult = errorText.getText();
//
//        Assert.assertTrue(actualResult.contains(expectedResultError));
//        Assert.assertTrue(actualResult.contains(expectedResultPrecondition));
//        Assert.assertTrue(actualResult.contains(expectedResultInput));
//        Assert.assertTrue(actualResult.contains(expectedResultFailed));
//        Assert.assertTrue(actualResult.contains(expectedResultSymbolOne));
//        Assert.assertTrue(actualResult.contains(expectedResultSymbolTwo));
//        Assert.assertTrue(actualResult.contains(expectedResultSymbolThree));
//
//        driver.quit();
//    }

    @Test
    public static void testSubmitLanguageError() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//ul[@ id = 'menu']/li/a[@href = '/submitnewlanguage.html']")
        );
        submitNewLanguage.click();

        WebElement buttonSubmitLanguage = driver.findElement(
                By.xpath("//form[@id='addlanguage']/p/input[@type = 'submit'][@name = 'submitlanguage']")
        );
        buttonSubmitLanguage.click();

        WebElement errorText = driver.findElement(By.xpath("//*[.= 'Error: Precondition failed - Incomplete Input.']"));
        String actualResult = errorText.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public static void testSubmitLanguageText() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form " +
                "(especially the language name and description), the easier it will be for us and the faster your " +
                "language will show up on this page. We don't have the time to mess around with fixing your " +
                "descriptions etc. Thanks for your understanding.";
        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(
                By.xpath("//ul[@ id = 'menu']/li/a[@href = '/submitnewlanguage.html']")
        );
        submitNewLanguage.click();

        WebElement buttonSubmitLanguage = driver.findElement(
                By.xpath("//form[@id='addlanguage']/p/input[@type = 'submit'][@name = 'submitlanguage']")
        );
        buttonSubmitLanguage.click();

        WebElement text = driver.findElement(
                By.xpath("//div[@id = 'main']/ul/li[1]")
        );
        String actualResult = text.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public static void testBrowseLanguagesTable() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultСolumnOne = "Language";
        String expectedResultСolumnTwo = "Author";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );
        menuBrowseLanguages.click();

        WebElement tableСolumnOne = driver.findElement(
                By.xpath("//table[@id = 'category']/tbody/tr/th[1]")
        );
        String actualResultСolumnOne = tableСolumnOne.getText();
        WebElement tableСolumnTwo = driver.findElement(
                By.xpath("//table[@id = 'category']/tbody/tr/th[2]")
        );
        String actualResultСolumnTwo = tableСolumnTwo.getText();

        Assert.assertEquals(actualResultСolumnOne,expectedResultСolumnOne);
        Assert.assertEquals(actualResultСolumnTwo,expectedResultСolumnTwo);

        driver.quit();
    }








}
