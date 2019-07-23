package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailboxPage {

    private WebDriver driver;

    private final int TIMEOUT = 10;

    @FindBy(xpath = "(.//div [@class='b-dropdown__ctrl'])[1]")
    private WebElement ddSort;

    @FindBy(xpath = "(.//a [@data-name='sort_from_desc'])[1]")
    private WebElement sortAuthorAsc;

    @FindBy(xpath = "(.//a [@data-name='sort_date_asc'])[1]")
    private WebElement sortDateAsc;

    @FindBy(xpath = "(.//a [@data-name='sort_date_desc'])[1]")
    private WebElement sortDateDesc;

    @FindBy(xpath = ".//div [@style='background-image: url(\"https://filin.mail.ru/pic?user=truhanzhenya@mail.ru&email=info@promo.wildberries.ru&trust=true&sign=8a9857b494513e2da6c4d9c468901df16ad89a86&&&width=45&height=45&name=WILDBERRIES&version=4&build=7\");']")
    private WebElement oldLetterSort;

    @FindBy(xpath = ".//div [@style='background-image: url(\"https://filin.mail.ru/pic?user=truhanzhenya@mail.ru&email=uliana.yeryksonava@gmail.com&trust=true&sign=738031ea02cf6ce109907d5d4c92ca61ac878697&&&width=45&height=45&name=Ulyana%20Yeryksonava&version=4&build=7\");']")
    private WebElement newLetterSort;

    @FindBy(xpath = ".//div [@style='background-image: url(\"https://filin.mail.ru/pic?user=truhanzhenya@mail.ru&email=dmitriyzake6@mail.ru&trust=true&sign=2ed21c308fc6bb6a53bb4f0a1c6bef274a6f8599&&&width=45&height=45&name=%EF%BF%BD%EF%BF%BD%EF%BF%BD&version=4&build=7\");']")
    private WebElement firstAuthorLetterSort;

    @FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span")
    private WebElement notifySendToSpamMessage;

    @FindBy(xpath = "(.//span [@class='b-toolbar__btn__text b-toolbar__btn__text_pad'])[11]")
    private WebElement buttonNoSpamLetters;

    @FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]")
    private WebElement notifyReturnToInboxMessage;

    @FindBy(xpath = "(//div[contains(@class,'b-datalist__item__cbx')]//div[@class='b-checkbox__box'])[26]")
    private WebElement mailCheckbox;

    @FindBy(xpath = "(.//div [@class='b-dropdown__arrow'])[2]")
    private WebElement dropdownChooseListLetters;

    @FindBy(xpath = "(.//a [@data-name='unread'])[1]")
    private WebElement unReadLetters;

    @FindBy(xpath = "//div[@data-name='spam'][1]")
    private WebElement spamButton;

    @FindBy(xpath = "//div[@data-name='remove'][1]")
    private WebElement deleteButton;

    @FindBy(xpath = "(//div[contains(@class,'b-datalist__item__cbx')]//div[@class='b-checkbox__box'])[1]")
    private WebElement deleteLetter;

    @FindBy(xpath = "(.//div [@class='b-dropdown__ctrl js-shortcut'])[5]")
    private WebElement ddMovingLetter;

    @FindBy(xpath = "(.//a [@data-text='Входящие'])[1]")
    private WebElement movingPackage;

    @FindBy(xpath = "(.//div [@class='b-checkbox__box'])[30]")
    private WebElement letterFromBasket;

    @FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span")
    private WebElement sendDeleteLetterMessage;

    @FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span")
    private WebElement sendReturnLetterMessage;

    @FindBy(xpath = "(.//span [@class='b-toolbar__btn__text b-toolbar__btn__text_pad'])[6]")
    private WebElement spamLetters;

    @FindBy(xpath = ".//div [@data-id='500002']")
    private WebElement basket;

    @FindBy(xpath = "//div[@data-name='archive'][1]")
    private WebElement archiveButton;

    @FindBy(xpath = "(//div[contains(@class,'b-datalist__item__cbx')]//div[@class='b-checkbox__box'])[1]")
    private WebElement archiveLetter;

    @FindBy(xpath = "(.//div [@class='b-checkbox__box'])[30]")
    private WebElement letterFromArchive;

    @FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span")
    private WebElement sendMoveArchiveLetterMessage;

    @FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[1]/div[1]/div/span")
    private WebElement sendReturnArchiveLetterMessage;

    @FindBy(xpath = ".//div [@data-id='500010']")
    private WebElement archiveWindow;

    @FindBy(xpath = ".//div [@data-id='950']")
    private WebElement windowSpamLetters;

    @FindBy(xpath = "(//a[@data-name='compose'])[1]")
    private WebElement writeMessageButton;

    public MailboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendToSpam() {
        dropdownChooseListLetters.click();
        unReadLetters.click();
        spamButton.click();
    }

    public boolean isSendToSpamMessageDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(notifySendToSpamMessage)).isDisplayed();
    }

    public void returnFromSpam() {
        windowSpamLetters.click();
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(mailCheckbox)).click();
        buttonNoSpamLetters.click();
    }

    public boolean isReturnToInboxMessageDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(notifyReturnToInboxMessage)).isDisplayed();
    }

    public void markThreeMailsByFlag() {
        int selectCount = 3;
        for (int i = 1; i <= selectCount; i++) {
            driver.findElement(By.xpath("(//div[@data-act='flag'])[" + i + "]")).click();
        }
    }

    public void unmarkAllFlags() {
        List<WebElement> mailsFlag = driver.findElements(By.xpath("//div[contains(@class,'b-flag_yes')]"));
        for (WebElement flagElement : mailsFlag) {
            flagElement.click();
        }
    }

    public int getCountMarkedByFlags() {
        return driver.findElements(By.xpath("//div[contains(@class,'b-flag_yes')]")).size();
    }

    public void sortingAuthor() {
        ddSort.click();
        sortAuthorAsc.click();
    }

    public boolean isFirstAuthorLetterDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(firstAuthorLetterSort)).isDisplayed();
    }

    public void sortingDateAsc() {
        ddSort.click();
        sortDateAsc.click();
    }

    public void sortingDateDesc() {
        ddSort.click();
        sortDateDesc.click();
    }

    public boolean isOldLetterDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(oldLetterSort)).isDisplayed();
    }

    public void sendToBasket() {
        deleteLetter.click();
        deleteButton.click();
    }

    public void returnFromBasket() {
        basket.click();
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(letterFromBasket)).click();
        ddMovingLetter.click();
        movingPackage.click();
    }

    public boolean isSendToDeleteLetterMessageDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(sendDeleteLetterMessage)).isDisplayed();
    }

    public boolean isSendReturnLetterMessageDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(sendReturnLetterMessage)).isDisplayed();
    }

    public void sendToArchive() {
        archiveLetter.click();
        archiveButton.click();
    }

    public void returnFromArchive() {
        archiveWindow.click();
        (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(letterFromArchive)).click();
        ddMovingLetter.click();
        movingPackage.click();
    }

    public boolean isSendToMoveLetterMessageDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(sendDeleteLetterMessage)).isDisplayed();
    }

    public boolean isSendReturnLetterMessageFromArchiveDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(sendReturnLetterMessage)).isDisplayed();
    }

    public boolean isNewLetterDisplayed() {
        return (new WebDriverWait(driver, TIMEOUT)).until(ExpectedConditions.visibilityOf(newLetterSort)).isDisplayed();
    }
}
