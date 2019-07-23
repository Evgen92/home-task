package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mysql.DBIndex;
import mysql.QuaryUtil;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;
import pages.ComposePage;
import pages.LoginPage;
import pages.MailboxPage;
import parse.facade.DomParserFacade;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class SendMessageStep {

    private WebDriver driver;
    private MailboxPage mailboxPage;
    private LoginPage loginPage;
    private ComposePage composePage;
    private static final Logger logger = Logger.getLogger(SpamStep.class);
    private static String MAIN_URL = "https://mail.ru/";
    private static final String USER_XML = "users.xml";

    public SendMessageStep() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Git\\chromedriver.exe");
        driver = WebDriverSingleton.getInstance();
        driver.get(MAIN_URL);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mailboxPage = new MailboxPage(driver);
        composePage = new ComposePage(driver);
        logger.info("WebDriver start");
    }

    @Given("^I am in home page$")
    public void openWebPage(String login, String password) {
        mailboxPage = loginPage.login(QuaryUtil.getInstance().get(DBIndex.LOGIN), QuaryUtil.getInstance().get(DBIndex.PASSWORD));
    }

    @When("^I click to write message$")
    public void clickWriteMessage() {
        composePage.clickWriteMessageButton();
    }

    @When("^I change subject$")
    public void addSubject(String subject) {
        composePage.writeSubject(QuaryUtil.getInstance().get(DBIndex.ADDRESSEE));
    }

    @When("^I write message$")
    public void sendMessage(String message) throws SAXException, XMLStreamException, ParserConfigurationException, IOException {
        DomParserFacade domParserFacade = new DomParserFacade();
        composePage.writeMessage(domParserFacade.convertXml(USER_XML).get(1).getMessage());
        composePage.sendMessage();
    }

    @Then("^I see message to deliver my message$")
    public void checkMessageWriteLetter() {
        Assert.assertTrue(composePage.isSendMessageDisplayed());
    }
}
