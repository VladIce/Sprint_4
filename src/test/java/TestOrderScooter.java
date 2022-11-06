import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOrderScooter {

    private static WebDriver driver;

    @RunWith(Parameterized.class)
    public static class TestClass {

        private final String name;
        private final String firstName;
        private final String address;
        private final String underground;
        private final String phoneNumber;

        private final String theData;

        private final String theComment;


        public TestClass(String name, String firstName, String address, String underground, String phoneNumber, String theData, String theComment) {
            this.name = name;
            this.firstName = firstName;
            this.address = address;
            this.underground = underground;
            this.phoneNumber = phoneNumber;
            this.theData = theData;
            this.theComment = theComment;

        }



        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][]{
                    {"Владислав", "Ильин", "Севанская д4", ".//button[@value=237]", "79777970257", "04.11.2022", "Очень ждём ващ самокат"},
                    {"Александр", "Пушкин", "Нижняя Красносельска д40", ".//button[@value=55]", "79887970259", "05.11.2022", "Везите поскорее, хотим кататься"},
                    {"Лев", "Толстой", "Никольская д2", ".//button[@value=101]", "79287970259", "06.11.2022", "А у вас есть самокат красного цвета?"},
            };
        }

        @Before
        // Открытие браузера перед началом теста.
        public void startUp() {
            driver = new ChromeDriver();
        }


        @Test
        public void checkButtonOrderInHeader() {

            HomePage homepage = new HomePage(driver);
            homepage.openWebsite();
            homepage.clickButtonCookie();
            homepage.clickOrderInHeader();
            OrderPage pageWhoIsTheScooterFor = new OrderPage(driver);
            pageWhoIsTheScooterFor.inputName(name);
            pageWhoIsTheScooterFor.inputFirstName(firstName);
            pageWhoIsTheScooterFor.inputAddress(address);
            pageWhoIsTheScooterFor.clickInputUnderground();
            pageWhoIsTheScooterFor.chooseMetro(underground);
            pageWhoIsTheScooterFor.inputPhoneNumber(phoneNumber);
            pageWhoIsTheScooterFor.clickButtonFurther();
            OrderPage pageAboutRent = new OrderPage(driver);
            pageAboutRent.inputWhenToBringScooter(theData);
            pageAboutRent.clickRentalPeriod();
            pageAboutRent.clickRentalPeriodDay();
            pageAboutRent.clickCheckboxBlack();
            pageAboutRent.inputCommentForTheCourier(theComment);
            pageAboutRent.clickOrderButton();
            pageAboutRent.clickButtonOrderYes();
            pageAboutRent.orderCheck();
        }

        @Test
        public void checkButtonOrderInFuter(){

            HomePage homepage = new HomePage(driver);
            homepage.openWebsite();
            homepage.clickButtonCookie();
            homepage.scroll();
            homepage.clickOrderInFuter();
            OrderPage pageWhoIsTheScooterFor = new OrderPage(driver);
            pageWhoIsTheScooterFor.inputName(name);
            pageWhoIsTheScooterFor.inputFirstName(firstName);
            pageWhoIsTheScooterFor.inputAddress(address);
            pageWhoIsTheScooterFor.clickInputUnderground();
            pageWhoIsTheScooterFor.chooseMetro(underground);
            pageWhoIsTheScooterFor.inputPhoneNumber(phoneNumber);
            pageWhoIsTheScooterFor.clickButtonFurther();
            OrderPage pageAboutRent = new OrderPage(driver);
            pageAboutRent.inputWhenToBringScooter(theData);
            pageAboutRent.clickRentalPeriod();
            pageAboutRent.clickRentalPeriodDay();
            pageAboutRent.clickCheckboxBlack();
            pageAboutRent.inputCommentForTheCourier(theComment);
            pageAboutRent.clickOrderButton();
            pageAboutRent.clickButtonOrderYes();
            pageAboutRent.orderCheck();
        }

        @After
        // Закрытие браузера после каждого теста пройденого теста.
        public void tearDown() {
            driver.quit();
        }
    }
}
