package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Git/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.mail.ru");
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void enterLogin() {
        loginPage.login("truhanzhenya", "truhan");
        Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
    }

    @Test
    public void spamLettes(){
        loginPage.spamLetters();
    }

    @Test
    public void extractLettersSpam(){
        loginPage.extractLettersSpam();
    }

    @Test
    public void writeLetterGroup(){
        loginPage.writeLetterGroup();
    }

    @Test
    public void markThreeLetters(){
        loginPage.markThreeLetters();
    }

    @Test
    public void deSelectFlagAllLetters(){
        loginPage.deSelectFlagAllLetters();
    }
}
