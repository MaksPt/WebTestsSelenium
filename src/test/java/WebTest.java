import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    @Test
    public void testMenuStartTitle() throws InterruptedException {

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
    public void testMenuStartHeader() {

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
    public void testStartMenuSubmitNewLanguage() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmitNewLanguage = driver.findElement(By.xpath(
            "//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'menu']/li[last()]" //В задании сказано что последний пункт меню, я решил сделать такой поиск
        ));
        String actualResult = menuSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    @Test
    public void testSubmitNewLanguageSubmenuSubmitNewLanguage() {

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
    public void testBrowseLanguagesFirstSubmenu() {

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

        WebElement firstSubmenu = driver.findElement(By.xpath(
                "//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'submenu']/li[1]"
        )); //В задании сказано что первый пункт подменюменю, я решил сделать такой поиск
        String actualResult = firstSubmenu.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public void testTheTeam() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultOliver = "Oliver Schade";
        String expectedResultGregor = "Gregor Scheithauer";
        String expectedResultStefan = "Stefan Scheler";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submenuTeam = driver.findElement(By.xpath(
                "//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id = 'submenu']/li/a[@href = 'team.html']"
        ));
        submenuTeam.click();

//        WebElement testOliver = driver.findElement(By.xpath("//h3[text () = 'Oliver Schade']"));
//        WebElement testGregor = driver.findElement(By.xpath("//h3[text () = 'Gregor Scheithauer']"));
//        WebElement testStefan = driver.findElement(By.xpath("//h3[text () = 'Stefan Scheler']"));
        WebElement testOliver = driver.findElement(By.xpath("//body/div[@id = 'wrap']/div[@id = 'main']/h3[1]"));
        WebElement testGregor = driver.findElement(By.xpath("//body/div[@id = 'wrap']/div[@id = 'main']/h3[2]"));
        WebElement testStefan = driver.findElement(By.xpath("//body/div[@id = 'wrap']/div[@id = 'main']/h3[3]"));

        String actualResultOliver = testOliver.getText();
        String actualResultGregor = testGregor.getText();
        String actualResultStefan = testStefan.getText();

        Assert.assertEquals(actualResultOliver,expectedResultOliver);
        Assert.assertEquals(actualResultGregor,expectedResultGregor);
        Assert.assertEquals(actualResultStefan,expectedResultStefan);

        driver.quit();
    }

    @Test
    public void testHistoricInformation() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "History";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement historicInformation = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id = 'submenu']/li/a[@href = 'info.html']")
        );
        historicInformation.click();

        WebElement history = driver.findElement(By.xpath("//body/div[@id = 'wrap']/div[@id = 'main']/h2"));

        String actualResult = history.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public void testSubmitLanguageEmptyValue() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='navigation']/ul[@ id = 'menu']/li/a[@href = '/submitnewlanguage.html']"
                ));
        submitNewLanguage.click();

        WebElement buttonSubmitLanguage = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']" +
                "/form[@id='addlanguage']/p/input[@type = 'submit'][@name = 'submitlanguage']")
        );
        buttonSubmitLanguage.click();

        WebElement errorText = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id = 'main']/p"));
        String actualResult = errorText.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public void testSubmitLanguageError() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultError = "Error";
        String expectedResultPrecondition = "Precondition";
        String expectedResultInput = "Input";
        String expectedResultFailed = "failed";
        String expectedResultSymbolOne = ":";
        String expectedResultSymbolTwo = "-";
        String expectedResultSymbolThree = ".";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='navigation']/ul[@ id = 'menu']/li/a[@href = '/submitnewlanguage.html']"
                ));
        submitNewLanguage.click();

        WebElement buttonSubmitLanguage = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type = 'submit']" +
                        "[@name = 'submitlanguage']")
        );
        buttonSubmitLanguage.click();

        WebElement errorText = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id = 'main']/p"));
        String actualResult = errorText.getText();

        Assert.assertTrue(actualResult.contains(expectedResultError));
        Assert.assertTrue(actualResult.contains(expectedResultPrecondition));
        Assert.assertTrue(actualResult.contains(expectedResultInput));
        Assert.assertTrue(actualResult.contains(expectedResultFailed));
        Assert.assertTrue(actualResult.contains(expectedResultSymbolOne));
        Assert.assertTrue(actualResult.contains(expectedResultSymbolTwo));
        Assert.assertTrue(actualResult.contains(expectedResultSymbolThree));

        driver.quit();
    }

//    @Test
//    public static void testSubmitLanguageError() {
//
//        String chromeDriver = "webdriver.chrome.driver";
//        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
//        String url = "http://www.99-bottles-of-beer.net/";
//        String expectedResult = "Error: Precondition failed - Incomplete Input.";
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
//        WebElement errorText = driver.findElement(By.xpath("//*[.= 'Error: Precondition failed - Incomplete Input.']"));
//        String actualResult = errorText.getText();
//
//        Assert.assertEquals(actualResult,expectedResult);
//
//        driver.quit();
//    }

    @Test
    public void testSubmitLanguageText() {

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

        WebElement submitNewLanguage = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='navigation']/ul[@id = 'menu']/li/a[@href = '/submitnewlanguage.html']"
                ));
        submitNewLanguage.click();

        WebElement buttonSubmitLanguage = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type = 'submit']" +
                        "[@name = 'submitlanguage']"
                ));
        buttonSubmitLanguage.click();

        WebElement text = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id = 'main']/ul/li[1]")
        );
        String actualResult = text.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public void testBrowseLanguagesTable() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultСolumnOne = "Language";
        String expectedResultСolumnTwo = "Author";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id = 'menu']/li/a[@href = '/abc.html']")
        );
        menuBrowseLanguages.click();

        WebElement tableСolumnOne = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id = 'category']/tbody/tr/th[1]")
        );
        String actualResultСolumnOne = tableСolumnOne.getText();
        WebElement tableСolumnTwo = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id = 'category']/tbody/tr/th[2]")
        );
        String actualResultСolumnTwo = tableСolumnTwo.getText();

        Assert.assertEquals(actualResultСolumnOne,expectedResultСolumnOne);
        Assert.assertEquals(actualResultСolumnTwo,expectedResultСolumnTwo);

        driver.quit();
    }

    @Test
    public void newComments() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement topList = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='navigation']/ul[@id = 'menu']/li/a[@href = '/toplist.html']"
        ));
        topList.click();

        WebElement newComments = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='navigation']/ul[@id = 'submenu']/li/a[@href = './newcomments.html']"
                ));
        newComments.click();

        WebElement newCommentsIsEmpty = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id = 'main']/p"));
        String actualResult = newCommentsIsEmpty.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }

    @Test
    public void styleImportant() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:/Users/79044/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResultStyle = "background-color: red; color: white;";
        String expectedResultBolt = "b";
//        String expectedResultBolt = "700";
        String expectedResultCapital = "IMPORTANT:";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitNewLanguage = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='navigation']/ul[@id = 'menu']/li/a[@href='/submitnewlanguage.html']"
                ));
        submitNewLanguage.click();

        WebElement submitNewLanguageImportantStyle = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id='main']/ul/li/span"));
        String actualResultStyle = submitNewLanguageImportantStyle.getAttribute("style");

        WebElement submitNewLanguageImportantBolt = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id = 'main']/ul/li/span/b"));
        String actualResultBolt = submitNewLanguageImportantBolt.getTagName();
//        String actualResultBolt = submitNewLanguageImportantBolt.getCssValue("font-weight");

        WebElement submitNewLanguageImportantCapital = driver.findElement(By.xpath(
                "//body/div[@id='wrap']/div[@id = 'main']/ul/li/span/b"));
        String actualResultCapital = submitNewLanguageImportantCapital.getText();

        Assert.assertEquals(actualResultStyle,expectedResultStyle);
        Assert.assertEquals(actualResultBolt,expectedResultBolt);
        Assert.assertEquals(actualResultCapital,expectedResultCapital.toUpperCase());

        driver.quit();
    }
}
