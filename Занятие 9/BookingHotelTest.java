import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BookingHotelTest {

    @Test
    public void highRatingTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Git/chromedriver.exe");//your own path
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        WebElement searchParish = driver.findElement(By.xpath(".//input[@id='ss']"));
        searchParish.sendKeys("Париж");
        searchParish.click();

        WebElement searchDate = driver.findElement(By.xpath(".//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"));
        searchDate.click();
        WebElement dateArrivedHotel = driver.findElement(By.xpath("(.//td[@class=\"bui-calendar__date\"])[3]"));
        dateArrivedHotel.click();
        WebElement dateDuraHotel = driver.findElement(By.xpath("(.//td[@class=\"bui-calendar__date\"])[9]"));
        dateDuraHotel.click();

        WebElement chooseCountPerson = driver.findElement(By.xpath(".//label [@class='xp__input']"));
        chooseCountPerson.click();
        WebElement searchHotel = driver.findElement(By.xpath(".//span[text()='Проверить цены']"));
        searchHotel.submit();

        WebElement scrollFilterHotel = driver.findElement(By.xpath(".//a [@data-id='pri-2']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", scrollFilterHotel);
        WebElement filterHotel = driver.findElement(By.xpath(".//a [@data-id='pri-2']"));
        filterHotel.click();

        List<WebElement> getListHotels = driver.findElements(By.xpath(".//div [@data-hotelid]"));
        Assert.assertNotNull(getListHotels);

        WebElement getBestRatingHotel = driver.findElement(By.xpath("//*[@id=\"sortbar_dropdown_button\"]"));
        Select bestRatingHotel = new Select(getBestRatingHotel);
        bestRatingHotel.selectByVisibleText("Оценка + кол-во отзывов");

        WebElement firstHotel = driver.findElement(By.xpath("(.//a[@class='hotel_name_link url'])[1]"));
        firstHotel.click();
        driver.switchTo();
        WebElement scrollPriceHotel = driver.findElement(By.xpath("(.//span[contains(text(), 'BYN')])[1]"));
        JavascriptExecutor execute = (JavascriptExecutor) driver;
        execute.executeScript("arguments[0].scrollIntoView()", scrollPriceHotel);
        WebElement validPrice = driver.findElement(By.xpath("(.//span[contains(text(), 'BYN')])[1]"));
        int beginIntPrice = 4;
        String validPriceText = validPrice.getText().substring(beginIntPrice);
        int countDays = 7;
        int actualResult = (Integer.parseInt(validPriceText)) / countDays;
        int endInterval = 230;
        Assert.assertTrue( actualResult <= endInterval);

        driver.quit();
    }

    @Test
    public void cheapHotelTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Git/chromedriver.exe");//your own path
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        WebElement searchParish = driver.findElement(By.xpath(".//input[@id='ss']"));
        searchParish.sendKeys("Париж");
        searchParish.click();

        WebElement searchDate = driver.findElement(By.xpath(".//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"));
        searchDate.click();
        WebElement dateArrivedHotel = driver.findElement(By.xpath("(.//td[@class=\"bui-calendar__date\"])[3]"));
        dateArrivedHotel.click();
        WebElement dateDuraHotel = driver.findElement(By.xpath("(.//td[@class=\"bui-calendar__date\"])[9]"));
        dateDuraHotel.click();

        WebElement chooseCountPerson = driver.findElement(By.xpath(".//label [@class='xp__input']"));
        chooseCountPerson.click();
        WebElement adults = driver.findElement(By.xpath(".//input [@id='group_adults']"));
        Select adultSelect = new Select(adults);
        adultSelect.selectByValue("4");
        WebElement room = driver.findElement(By.xpath(".//input [@id='no_rooms']"));
        Select roomSelect = new Select(room);
        roomSelect.selectByValue("2");
        WebElement searchHotel = driver.findElement(By.xpath(".//span[text()='Проверить цены']"));
        searchHotel.submit();

        WebElement scrollFilterHotel = driver.findElement(By.xpath(".//a [@data-id='pri-5']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", scrollFilterHotel);
        WebElement filterHotel = driver.findElement(By.xpath(".//a [@data-id='pri-5']"));
        filterHotel.click();

        WebElement getCheapHotel = driver.findElement(By.xpath(".//a [@data-category='price']"));
        getCheapHotel.click();

        WebElement firstHotel = driver.findElement(By.xpath("(.//a[@class='hotel_name_link url'])[1]"));
        firstHotel.click();
        driver.switchTo();
        WebElement scrollPriceHotel = driver.findElement(By.xpath("(.//span[contains(text(), 'BYN')])[1]"));
        JavascriptExecutor execute = (JavascriptExecutor) driver;
        execute.executeScript("arguments[0].scrollIntoView()", scrollPriceHotel);
        WebElement validPrice = driver.findElement(By.xpath("(.//span[contains(text(), 'BYN')])[1]"));
        int beginIntPrice = 4;
        String validPriceText = validPrice.getText().substring(beginIntPrice);
        int countDays = 7;
        int actualResult = (Integer.parseInt(validPriceText)) / countDays;
        int beginInterval = 920;
        Assert.assertTrue(beginInterval <= actualResult);

        driver.quit();
    }

    @Test
    public void reserveHotelTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Git/chromedriver.exe");//your own path
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        WebElement searchParish = driver.findElement(By.xpath(".//input[@id='ss']"));
        searchParish.sendKeys("Париж");
        searchParish.click();

        WebElement searchDate = driver.findElement(By.xpath(".//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']"));
        searchDate.click();
        WebElement dateArrivedHotel = driver.findElement(By.xpath("(.//td[@class=\"bui-calendar__date\"])[3]"));
        dateArrivedHotel.click();
        WebElement dateDuraHotel = driver.findElement(By.xpath("(.//td[@class=\"bui-calendar__date\"])[9]"));
        dateDuraHotel.click();

        WebElement chooseCountPerson = driver.findElement(By.xpath(".//label [@class='xp__input']"));
        chooseCountPerson.click();
        WebElement adults = driver.findElement(By.xpath(".//input [@id='group_adults']"));
        Select adultSelect = new Select(adults);
        adultSelect.selectByValue("4");
        WebElement room = driver.findElement(By.xpath(".//input [@id='no_rooms']"));
        Select roomSelect = new Select(room);
        roomSelect.selectByValue("2");
        WebElement searchHotel = driver.findElement(By.xpath(".//span[text()='Проверить цены']"));
        searchHotel.submit();

        WebElement scrollFilterHotel = driver.findElement(By.xpath(".//a [@data-id='pri-5']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", scrollFilterHotel);
        WebElement filterHotel = driver.findElement(By.xpath(".//a [@data-id='pri-5']"));
        filterHotel.click();

        WebElement getCheapHotel = driver.findElement(By.xpath(".//a [@data-category='price']"));
        getCheapHotel.click();

        WebElement firstHotel = driver.findElement(By.xpath("(.//a[@class='hotel_name_link url'])[1]"));
        firstHotel.click();
        driver.switchTo();
        WebElement scrollReserve = driver.findElement(By.xpath("(.//button [@type='submit'])[3]"));
        JavascriptExecutor execute = (JavascriptExecutor) driver;
        execute.executeScript("arguments[0].scrollIntoView()", scrollReserve);
        WebElement reserve = driver.findElement(By.xpath("(.//button [@type='submit'])[3]"));
        WebElement getTwoRoomHotel = driver.findElement(By.xpath(".//select [@class='hprt-nos-select']"));
        Select bestRatingHotel = new Select(getTwoRoomHotel);
        bestRatingHotel.selectByValue("2");
        reserve.click();

        driver.quit();
    }
}
