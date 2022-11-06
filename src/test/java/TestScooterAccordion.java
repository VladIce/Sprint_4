import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScooterAccordion {
    private static WebDriver driver;

    @RunWith(Parameterized.class)
    public static class TestClass1 {
        // Поле в котором храниться локатор кнопки для....
        private final String arrowButton;
        private final String textContent;

        public TestClass1(String arrowButton, String textContent) {
            this.arrowButton = arrowButton;
            this.textContent = textContent;
        }


        // Входные тестовые данные
        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][]{
                    {".//div[@class='accordion__button' and text()='Сколько это стоит? И как оплатить?']", ".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']"},
                    {".//div[@class = 'accordion__button' and text()='Хочу сразу несколько самокатов! Так можно?']", ".//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']"},
                    {".//div[@class = 'accordion__button' and text()='Как рассчитывается время аренды?']", ".//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']"},
                    {".//div[@class = 'accordion__button' and text()='Можно ли заказать самокат прямо на сегодня?']", ".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']"},
                    {".//div[@class = 'accordion__button' and text()='Можно ли продлить заказ или вернуть самокат раньше?']", ".//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']"},
                    {".//div[@class = 'accordion__button' and text()='Вы привозите зарядку вместе с самокатом?']", ".//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']"},
                    {".//div[@class = 'accordion__button' and text()='Можно ли отменить заказ?']", ".//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']"},
                    {".//div[@class = 'accordion__button' and text()='Я жизу за МКАДом, привезёте?']", ".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']"},
            };
        }

        @Before
        // Открытие браузера перед началом теста.
        public void starUp() {
            driver = new ChromeDriver();
        }

        // Тест проверяет текст в выпадющем списке

        @Test
        public void testAccordion() {

            HomePage homePage = new HomePage(driver);
            homePage.openWebsite();
            homePage.scrollDown(arrowButton);
            homePage.clickButtonMainPage(arrowButton);
            Assert.assertTrue(driver.findElements(By.xpath(textContent)).size() != 0);

        }

        @After
        // Закрытие браузера после каждого теста проёденого теста.
        public void tearDown() {
            driver.quit();
        }
    }
}

