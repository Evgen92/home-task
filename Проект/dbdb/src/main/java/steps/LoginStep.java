package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pages.LoginPage;
import parse.dom.DomParserUser;
import parse.model.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class LoginStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private List<User> users;
    private static String MAIN_URL = "https://mail.ru/";
    private static final String USER_XML = "users.xml";

    public LoginStep() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Git\\chromedriver.exe");
        driver = WebDriverSingleton.getInstance();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Given("^I am on main Mailru page$")
    public void openWebPage() {
        driver.get(MAIN_URL);
    }

    @When("^I enter login \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void positiveLogin(String login, String password) throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
        loginPage.login(login, password);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(USER_XML);
        users = new DomParserUser().parse(document);
        Assert.assertEquals(login, users.get(0).getLogin());
    }

    @Then("^I see home page$")
    public void checkMailboxPage() {
        Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
        WebDriverSingleton.close();
    }
}
