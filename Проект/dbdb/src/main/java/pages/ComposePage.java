package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class ComposePage {

    private WebDriver driver;

    private final int TIMEOUT = 10;

    @FindBy(name = "Subject")
    private WebElement subjectInput;

    @FindBy(xpath = "(.//a [@data-name='compose'])[1]")
    private WebElement buttonWriteMessage;

    @FindBy(xpath = "(//span[text()='Отправить'])[1]")
    private WebElement sendButton;

    @FindBy(xpath = "//div[text()='Ваше ']")
    private WebElement sendEmailMessage;

    public ComposePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeSubject(String subject) {
        subjectInput.sendKeys(subject);
    }

    public void writeMessage(String message) {
        WebElement frameElement = driver.findElement(By.xpath("//iframe[starts-with(@id,'toolkit')]"));
        driver.switchTo().frame(frameElement);
        driver.findElement(By.id("tinymce")).click();
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys(message);
        driver.switchTo().defaultContent();
    }

    public void sendMessage() {
        sendButton.click();
    }

    public boolean isSendMessageDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(sendEmailMessage)).isDisplayed();
    }

    public void clickWriteMessageButton() {
        buttonWriteMessage.click();
    }
}
