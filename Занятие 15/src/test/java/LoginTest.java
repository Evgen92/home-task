import com.applitools.eyes.exceptions.TestFailedException;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private Eyes eyes;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Git/chromedriver.exe");
        driver = new ChromeDriver();
        eyes = new Eyes();
        eyes.setApiKey("eDVQgNkCQzsA109p7nB7go5iTSRRWeGszDL2os510404yYU110");
        driver.get("http://www.mail.ru");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void enterLogin() throws InterruptedException {
        try {
            eyes.open(driver, "appName","mailruName");
            eyes.checkWindow("Login page");
            loginPage.login("truhanzhenya@mail.ru", "truhan");
            loginPage.isLogoutLinkDisplayed();
            eyes.checkWindow("Home page");
            loginPage.openMailForm();
            eyes.checkWindow("Send letter page");
            loginPage.sendEmails("fant1969@list.ru", "Hello");
            eyes.close();
        } catch (TestFailedException e) {
            System.out.println("\n" + e + "\n");
        } finally {
            driver.quit();
            eyes.abortIfNotClosed();
            System.exit(0);
        }
    }
}
