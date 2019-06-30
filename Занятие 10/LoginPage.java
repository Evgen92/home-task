package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"mailbox:login\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"mailbox:password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"PH_logoutLink\"]")
    private WebElement logoutLink;

    @FindBy(xpath = "(.//div [@class='b-dropdown__arrow'])[2]")
    private WebElement dropdownChooseListLetters;

    @FindBy(xpath = "(.//a [@data-name='unread'])[1]")
    private WebElement unReadLetters;

    @FindBy(xpath = "(.//span [@class='b-toolbar__btn__text b-toolbar__btn__text_pad'])[6]")
    private WebElement spamLetters;

    @FindBy(xpath = ".//div [@data-id='950']")
    private WebElement windowSpamLetters;

    @FindBy(xpath = "(.//div [@class='b-dropdown__arrow'])[8]")
    private WebElement ddChooseListLetters;

    @FindBy(xpath = "(.//span [@class='b-toolbar__btn__text b-toolbar__btn__text_pad'])[11]")
    private WebElement buttonNoSpamLetters;

    @FindBy(xpath = "(.//span [@class='b-toolbar__btn__text b-toolbar__btn__text_pad'])[1]")
    private WebElement buttonWriteLetter;

    @FindBy(xpath = ".//textarea [@tabindex='4']")
    private WebElement fieldChooseRecipient;

    @FindBy(xpath = "(.//div [@data-suggest-idx])[1]")
    private WebElement chooseRecipient;

    @FindBy(xpath = ".//div [@data-id='0']")
    private WebElement windowUnReadLetters;

    @FindBy(xpath = "(.//div [@data-act='flag'])[1]")
    private WebElement firstFlagLetter;

    @FindBy(xpath = "(.//div [@data-act='flag'])[2]")
    private WebElement secondFlagLetter;

    @FindBy(xpath = "(.//div [@data-act='flag'])[3]")
    private WebElement threeFlagLetter;

    @FindBy(xpath = "(.//i [@class='ico ico_filters ico_filters_flagged'])[1]")
    private WebElement listLettersFlag;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public void spamLetters() {
        dropdownChooseListLetters.click();
        unReadLetters.click();
        spamLetters.click();
    }

    public void extractLettersSpam() {
        windowSpamLetters.click();
        ddChooseListLetters.click();
        unReadLetters.click();
        buttonNoSpamLetters.click();
    }

    public void writeLetterGroup() {
        buttonWriteLetter.click();
        fieldChooseRecipient.click();
        chooseRecipient.click();
        fieldChooseRecipient.click();
        chooseRecipient.click();
        fieldChooseRecipient.click();
        chooseRecipient.click();
    }

    public void markThreeLetters() {
        windowUnReadLetters.click();
        firstFlagLetter.click();
        secondFlagLetter.click();
        threeFlagLetter.click();
    }

    public void deSelectFlagAllLetters() {
        listLettersFlag.click();
        firstFlagLetter.click();
        firstFlagLetter.click();
        firstFlagLetter.click();
    }

    public boolean isLogoutLinkDisplayed() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(logoutLink));
        return logoutLink.isDisplayed();
    }
}
