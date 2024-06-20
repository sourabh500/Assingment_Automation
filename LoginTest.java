package Tests;

import PageObject.Login_page_Object;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {


    WebDriver driver;
    Login_page_Object Lp;


    @Test(priority = 1)
    public void LaunchBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/login");
        driver.manage().window().maximize();

        Lp=new Login_page_Object(driver);

    }



    @Test(priority = 2)
    public void Verifying_Text_Of_Login_page()
    {
        Lp.LoginPageText("Login to your account");
    }

    @Test(priority = 3)
    public void Enter_Login_Details_And_Click_Login()
    {
        Lp.EnterLoginEmail("shuklasourabh50@gmail.com");
        Lp.EnterLoginPass("Sourabh@1");
        Lp.ClickLoginButton();

    }


    @Test(priority = 4)
    public void Add_Product_To_Cart_And_Proceed_To_Checkout()
    {

        Lp.ClickOnViewProduct("Men Tshirt");
        Lp.AddProductToCart_And_Verify_productInCart("Men Tshirt");
        Lp.ClickOnCheckout_And_Verify_Address();

    }

    @Test(priority = 5)
    public void Place_Order_And_Enter_Payment_Details()
    {
        Lp.ClickOnPlaceOrder_And_Enter_Card_Details("Vivek","123456789","345","10","2028");

    }

    @Test(priority = 6)
    public void Verify_Message_Order_Placed()
    {
        Lp.ClickOnPay_And_Verify_OrderPlacedMessage();
    }


}

