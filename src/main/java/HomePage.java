import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    // Поле со ссылкой на тестирумый веб-сайт
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    // Поле хранит локатор кнопки "Заказать" в хедере сайта
    private final By buttonOrderHeader =  By.xpath(".//button[@class = 'Button_Button__ra12g']");

    // Поле хранит локатор кнопки "Заказать" в футере сайта
    private final By buttonOrderFuter = By.xpath(".//div[@class='Home_FinishButton__1_cWm']");

    // Поле хранит локатор кнопки "Да все привыкли" в всплывающем уведомлении про куки
    private final By buttonCookie = By.xpath(".//button[@id='rcc-confirm-button']");

    // Конструктор драйвера браузера
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод открывает веб-сайт
    public void openWebsite() {
        driver.get(url);
    }

    // Метод кликает на кнопку "Заказать" в хедере сайта
    public void clickOrderInHeader() {
        driver.findElement(buttonOrderHeader).click();
    }

    // Метод кликает на кнопку "Заказать" в футере сайта
    public void clickOrderInFuter() {
        driver.findElement(buttonOrderFuter).click();
    }

    // Метод скроллит вниз до искомого элемента
    public void scrollDown(String firstElement) {
        WebElement element = driver.findElement(By.xpath(firstElement));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scroll() {
        WebElement element = driver.findElement(buttonOrderFuter);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }



    // Метод кликает на кнопки на главной странице;
    public void clickButtonMainPage(String buttonLocator) {
        driver.findElement(By.xpath(buttonLocator)).click();
    }

    // Метод кликает на кнопку "Да все привыкли" в всплывающем уведолмении про куки
    public void clickButtonCookie() {
        driver.findElement(buttonCookie).click();
    }
}
