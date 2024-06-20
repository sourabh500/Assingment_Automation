package Tests;

import PageObject.Search_Page_Object;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Search_Test {


    WebDriver driver;
    Search_Page_Object Sp;


    @Test(priority = 1)
    public void LaunchBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/login");
        driver.manage().window().maximize();

        Sp=new Search_Page_Object(driver);

    }

    @Test(priority = 2)
    public void user_click_on_products_button()
    {
        Sp.ClickOnProducts();
    }

    @Test(priority = 3)
    public void verify_user_is_navigated_to_all_products_page_successfully()
    {
        Sp.VerifyAllProductsPage("All Products");
    }

    @Test(priority = 4)
    public void user_enter_product_name_in_search_as_and_click_on_search_button()
    {
        Sp.EnterProductName();
        Sp.ClickOnSearchButton();
    }


    @Test(priority = 5)
    public void verify_searched_products_is_visible() throws InterruptedException {

        Sp.VerifyProductName("Men Tshirt");

    }

}
