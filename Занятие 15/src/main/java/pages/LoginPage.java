package pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "(.//span [@class='b-toolbar__btn__text b-toolbar__btn__text_pad'])[1]")
    private WebElement openMailForm;

    @FindBy(xpath = ".//textarea [@tabindex = '4']")
    private WebElement toTextField;

    @FindBy(tagName = "body")
    private WebElement body;

    @FindBy(xpath = "(.//span [@class = 'b-toolbar__btn__text'])[1]")
    private WebElement sendButton;

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

    public void openMailForm(){
        openMailForm.click();
    }

    public void sendEmails(String to, String message) throws InterruptedException {
        toTextField.sendKeys(to);
        driver.switchTo().frame((WebElement) driver.findElement(By.tagName("iframe")));
        body.sendKeys(message);
        driver.switchTo().defaultContent();
        sendButton.click();
    }

    public boolean isLogoutLinkDisplayed() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(logoutLink));
        return logoutLink.isDisplayed();
    }
}