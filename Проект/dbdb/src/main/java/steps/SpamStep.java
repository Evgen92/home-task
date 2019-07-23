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
import pages.MailboxPage;
import parse.dom.DomParserUser;
import parse.model.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public class SpamStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private MailboxPage mailboxPage;
    private List<User> users;
    private static final Logger logger = Logger.getLogger(SpamStep.class);
    private static String MAIN_URL = "https://mail.ru/";
    private static final String USER_XML = "users.xml";
    private static final int COUNT_FLAGS_FIRST = 3;
    private static final int COUNT_FLAGS_SECOND = 0;

    public SpamStep() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Git\\chromedriver.exe");
        driver = WebDriverSingleton.getInstance();
        driver.get(MAIN_URL);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mailboxPage = new MailboxPage(driver);
        logger.info("WebDriver start");
    }

    @Given("^I am in home page$")
    public void openMailbox() throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(USER_XML);
        users = new DomParserUser().parse(document);
        String login = users.get(0).getLogin();
        String password = users.get(0).getPassword();
        mailboxPage = loginPage.login(login, password);
    }

    @When("^I add mail to spam$")
    public void addMailToSpam() {
        mailboxPage.sendToSpam();
    }

    @When("^I return mail from spam$")
    public void returnMailFromSpam() {
        mailboxPage.returnFromSpam();
    }

    @When("^I add 3 flags$")
    public void addFlags() {
        mailboxPage.markThreeMailsByFlag();
    }

    @When("^I remove 3 flags$")
    public void removeFlags() {
        mailboxPage.unmarkAllFlags();
    }

    @When("^I add letter to basket$")
    public void deleteLetterToBasket() {
        mailboxPage.sendToBasket();
    }

    @When("^I return letter from basket$")
    public void returnLetterFromBasket() {
        mailboxPage.returnFromBasket();
    }

    @When("^I add letter to archive$")
    public void moveLetterToArchive() {
        mailboxPage.sendToArchive();
    }

    @When("^I return letter from archive$")
    public void returnLetterFromArchive() {
        mailboxPage.returnFromArchive();
    }

    @When("^I click button sort Author$")
    public void sortAuthor() {
        mailboxPage.sortingAuthor();
    }

    @When("^I click button sort Date asc$")
    public void sortDateAsc() {
        mailboxPage.sortingDateAsc();
    }

    @When("^I click button sort Date desc$")
    public void sortDateDesc() {
        mailboxPage.sortingDateDesc();
    }

    @Then("^I see message send to spam$")
    public void checkMessageSendToSpam() {
        Assert.assertTrue(mailboxPage.isSendToSpamMessageDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see message return from spam$")
    public void checkMessageReturnFromSpam() {
        Assert.assertTrue(mailboxPage.isReturnToInboxMessageDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see 3 marked mails$")
    public void checkMarkedFlags() {
        Assert.assertTrue(mailboxPage.getCountMarkedByFlags() == COUNT_FLAGS_FIRST);
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see 0 marked mails$")
    public void checkUnmarkedFlags() {
        Assert.assertTrue(mailboxPage.getCountMarkedByFlags() == COUNT_FLAGS_SECOND);
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see message delete letter$")
    public void checkMessageSendToDelete() {
        Assert.assertTrue(mailboxPage.isSendToDeleteLetterMessageDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see message return from basket$")
    public void checkMessageReturnFromBasket() {
        Assert.assertTrue(mailboxPage.isSendReturnLetterMessageDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see sorting author list desc$")
    public void checkFirstAuthorLetterSort() {
        Assert.assertTrue(mailboxPage.isFirstAuthorLetterDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see sorting date list asc$")
    public void checkOldLetterSort() {
        Assert.assertTrue(mailboxPage.isOldLetterDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see sorting date list desc$")
    public void checkNewLetterSort() {
        Assert.assertTrue(mailboxPage.isNewLetterDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see message moved letter to archive$")
    public void checkMessageSendToArchive() {
        Assert.assertTrue(mailboxPage.isSendToMoveLetterMessageDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }

    @Then("^I see message return letter from archive$")
    public void checkMessageReturnFromArchive() {
        Assert.assertTrue(mailboxPage.isSendReturnLetterMessageFromArchiveDisplayed());
        WebDriverSingleton.close();
        logger.info("WebDriver quit");
    }
}
