package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_page_Object {


        WebDriver Rdr;

        public Login_page_Object(WebDriver Ldr)
        {
            Rdr=Ldr;
            PageFactory.initElements(Ldr,this);

        }



        @FindBy(xpath = "//div[@class='login-form']//h2")
        WebElement LoginText;

        @FindBy(xpath = "//input[@data-qa='login-email']")
        WebElement LoginEmail;

        @FindBy(xpath = "//input[@data-qa='login-password']")
        WebElement LoginPassword;

        @FindBy(xpath = "//button[@data-qa='login-button']")
        WebElement LoginButton;


        //Payment


        @FindBy(xpath = "//a[@href='/product_details/2']")
        WebElement ViewProduct;

        @FindBy(xpath = "//button[@class='btn btn-default cart']")
        WebElement Add_To_Cart;

        @FindBy(xpath = "//div[@class='product-information']//h2")
        WebElement VerifyName;

        @FindBy(xpath = "//a[@href='/view_cart']")
        WebElement View_Cart;

        @FindBy(className = "btn btn-default check_out")
        WebElement ProceedCheckout;

        @FindBy(xpath = "//h2[contains(text(),'Address Details')]")
        WebElement AddressDetails;

        @FindBy(xpath = "//a[@href='/payment']")
        WebElement PlaceOrder;

        @FindBy(xpath = "//h2[@class='heading']")
        WebElement Payment_text;

        @FindBy(name = "name_on_card")
        WebElement NameOnCard;

        @FindBy(name = "card_number")
        WebElement CardNumber;

        @FindBy(name = "cvc")
        WebElement Cvc;

        @FindBy(name = "expiry_month")
        WebElement MonthExpiry;

        @FindBy(name = "expiry_year")
        WebElement YearExpiry;

        @FindBy(id = "submit")
        WebElement PayAndConfirm;

        @FindBy(xpath = "//h2[@data-qa='order-placed']")
        WebElement OrderPlaced;



        public void LoginPageText(String Exp_Text)
        {
            String Actual_Text=LoginText.getText();
            if (Actual_Text.equals(Exp_Text))
            {
                Assert.assertTrue(true);
            }
            else
                Assert.assertFalse(false);

        }


        public void EnterLoginEmail(String LogEmail)
        {
            LoginEmail.sendKeys(LogEmail);
        }

        public void EnterLoginPass(String LogPass)
        {
            LoginPassword.sendKeys(LogPass);
        }

        public void ClickLoginButton()
        {
            LoginButton.click();
        }


        //Payment

        public void ClickOnViewProduct(String Exp)
        {
            ViewProduct.click();
            String Act=VerifyName.getText();
            if (Act.equals(Exp))
            {
                Assert.assertTrue(true);
            }
            else
                Assert.assertFalse(false);

        }

        public void AddProductToCart_And_Verify_productInCart(String Exp)
        {
            Add_To_Cart.click();
            View_Cart.click();
            String Act=ViewProduct.getText();
            if (Act.equals(Exp))
            {
                Assert.assertTrue(true);
            }
            else
                Assert.assertFalse(false);

        }

        public void ClickOnCheckout_And_Verify_Address()
        {
            ProceedCheckout.click();
            AddressDetails.isDisplayed();
        }

        public void ClickOnPlaceOrder_And_Enter_Card_Details(String name,String number,String cvc,String month,String year)

        {
            PlaceOrder.click();
            Payment_text.isDisplayed();
            NameOnCard.sendKeys(name);
            CardNumber.sendKeys(number);
            Cvc.sendKeys(cvc);
            MonthExpiry.sendKeys(month);
            YearExpiry.sendKeys(year);

        }

        public void ClickOnPay_And_Verify_OrderPlacedMessage()

        {
            PayAndConfirm.click();
            OrderPlaced.isDisplayed();
        }

    }


