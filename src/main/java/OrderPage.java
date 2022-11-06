import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private final WebDriver driver;

    // Поле хранит локатор поля ввода имени юзера
    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']");

    // Поле хранит локатор поля ввода фамилии юзера
    private final By firstNameInput = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле хранит локатор поля ввода адреса юзера
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле хранит локатор поля ввода станции метро юзера
    private final By undergroundInput = By.xpath(".//input[@placeholder='* Станция метро']");

    // Поле хранит локатор поля номера телефона
    private final By phoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Поле хранитлокатор кнопки "Далее"
    private final By buttonFurther = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Поле хранит локатора поля "Когда привезти самокат"
    private final By inputWhenToBringScooter = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Поле хранит локатор поля "Срок аренды"
    private final By divRentalPeriod = By.xpath(".//span[@class='Dropdown-arrow']");

    // Поле хранит локатор выбора срока аренды "Сутки"
    private final By choiceOfRentalPeriodDay = By.xpath(".//div[@class='Dropdown-option' and text() = 'сутки']");

    // Поле хранит локатор чекбокса "Чёрный жемчуг"
    private final By inputCheckboxBlack = By.xpath(".//input[@id='black']");

    // Поле хранит локатор поля "Комментарий для курьера"
    private final By inputCommentForTheCourier = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    // Поле хранить локатор кнопки "Заказать"
    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Поле хранит локатор кнопки "Да" для подтверждения заказа
    private final By buttonOrderYes = By.xpath(".// button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");

    // Поле хранит локатор всплывающего окна "Заказ оформлен"
    private final By checkOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()= 'Заказ оформлен']");


    // Констурктор драйвера
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    // Метод вводит в поле ввода фамилии фамилию юзера
    public void inputFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    // Метод вводит в поле ввода адреса адрес юзера
    public void inputAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    // Метод кликает на поле ввода станции метро
    public void clickInputUnderground() {
        driver.findElement(undergroundInput).click();
    }

    // Метод выбирает станцию метро, локатор станции мы передаём в двухмерном массиве с тестовыми данными
    public void chooseMetro(String underground) {
       /* WebElement element = driver.findElement(By.xpath(underground));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);*/
        driver.findElement(By.xpath(underground)).click();
    }

    // Метод вводит в поле ввода телефона телефон юзера
    public void inputPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    // Метод кликает на кнопку "Далее"
    public void clickButtonFurther() {
        driver.findElement(buttonFurther).click();
    }

    // Метод вводит в поле "Когда привезти самокат" дату
    public void inputWhenToBringScooter(String theData) {
        driver.findElement(inputWhenToBringScooter).sendKeys(theData);
    }

    // Метод кликает на поле "Срок аренды"
    public void clickRentalPeriod() {
        driver.findElement(divRentalPeriod).click();

    }

    // Метод выбирает срок аренды "Сутки"
    public void clickRentalPeriodDay() {
        driver.findElement(choiceOfRentalPeriodDay).click();
    }

    // Метод устонавливает чекбокс "Чёрный жемчуг"
    public void clickCheckboxBlack() {
        driver.findElement(inputCheckboxBlack).click();
    }

    // Метод вводит в поле "Комментарий для курьера" комментарий
    public void inputCommentForTheCourier(String comment) {
        driver.findElement(inputCommentForTheCourier).sendKeys(comment);
    }

    // Метод кликает на кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(buttonOrder).click();
    }

    // Метод кликает на кнопку "Да" для подтверждения заказа
    public void clickButtonOrderYes() {
        driver.findElement(buttonOrderYes).click();
    }

    // Метод проверяет что заказ оформлен
    public boolean  orderCheck() {
        return driver.findElements(checkOrder).size() !=0;
    }
}

