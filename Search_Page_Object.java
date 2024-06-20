package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Search_Page_Object {

    WebDriver Rdr;

    public Search_Page_Object(WebDriver Ldr)
    {
        Rdr=Ldr;
        PageFactory.initElements(Ldr,this);
    }


    @FindBy(xpath = "//a[@href='/products']")
    WebElement ProductsButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement AllProductsText;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement SearchProduct;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement SearchButton;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p[contains(text(),'Men')]")
    WebElement ProductName;


    public void ClickOnProducts()
    {
        ProductsButton.click();
    }

    public void VerifyAllProductsPage(String Expected_text)
    {
        String Actual=AllProductsText.getText();
        if (Actual.equals(Expected_text))
        {
            Assert.assertTrue(true);
        }
        else
            Assert.assertFalse(false);
    }

    public void EnterProductName()
    {
        SearchProduct.sendKeys("Tshirt");
    }

    public void ClickOnSearchButton()
    {
        SearchButton.click();
    }

    public void VerifyProductName(String Exp_name)
    {
        String Act_name=ProductName.getText();
        System.out.println(Act_name);
        if(Act_name.equals(Exp_name))
        {
            Assert.assertTrue(true);
        }
        else
            Assert.assertFalse(false);

    }


}
