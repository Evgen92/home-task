package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import parse.model.User;

public class LoginPage {

    private WebDriver driver;

    private final int TIMEOUT = 10;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(id = "PH_logoutLink")
    private WebElement logoutLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MailboxPage login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.submit();
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(logoutLink));
        return new MailboxPage(driver);
    }

    public User getUser(int id, String login, String password, String name, String gender, String message) {
        User user = new User.Builder()
                .id(id)
                .login(login)
                .password(password)
                .name(name)
                .gender(gender)
                .message(message)
                .build();
        return user;
    }

    public boolean isLogoutLinkDisplayed() {
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(logoutLink));
        return logoutLink.isDisplayed();
    }
}
