package pages;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps
{
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "truhanzhenya@mail.ru";
    private static final String PASSWORD = "truhan";
    private LoginPage loginPage;
    private WebDriver webDriver;

    public LoginSteps()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Git/chromedriver.exe");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
    }

    @Given("^I am on main application page$")
    public void loadMainPage()
    {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser()
    {
        loginPage.enterLoginAndPass(LOGIN, PASSWORD);
        loginPage.clickEnterButton();
    }

    @When("^I am on home page$")
    public void spamLetters(){
        loginPage.spamLetters();
    }

    @When("^I am on spam page$")
    public void extractLettersSpam(){
        loginPage.extractLettersSpam();
    }

    @When("^I am on write letter page$")
    public void writeLetterGroup(){
        loginPage.writeLetterGroup();
    }

    @When("^I am on all letters page$")
    public void markThreeLetters(){
        loginPage.markThreeLetters();
    }

    @When("^I am on mark letters page$")
    public void deSelectFlagAllLetters(){
        loginPage.deSelectFlagAllLetters();
    }

    @Then("^I see logout link$")
    public void seeLogoutLink()
    {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }

    @After
    public void afterClass()
    {
        webDriver.quit();
    }
}
