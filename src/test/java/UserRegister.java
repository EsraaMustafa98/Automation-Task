import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserRegister {
    WebDriver driver;
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String firstname = faker.name().firstName();
    String lastName = faker.name().lastName();
    String Password = faker.internet().password(5,8);
    String Company = faker.company().name();
    String Address = faker.address().streetAddress();
    String Address2 = faker.address().secondaryAddress();
    String AddressCity = faker.address().city();
    String postalCode = "12345" ;
    String AdditionalInformation = faker.hobbit().toString();
    String HomePhone = faker.phoneNumber().cellPhone();
    String MobilePhone = faker.phoneNumber().cellPhone();
    String AliasAddress = "Cairo,Egypt";


    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() {
         driver.quit();
    }

    @Test
    public void userRegister() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement SignInButton = driver.findElement(By.linkText("Sign in"));
        SignInButton.click();


        WebElement EmailTextBox = driver.findElement(By.id("email_create"));
        EmailTextBox.sendKeys(email);
        System.out.println(email);


        WebElement CreateAccountButton = driver.findElement(By.name("SubmitCreate"));
        CreateAccountButton.click();


        WebElement RadioButtonFemale = driver.findElement(By.id("id_gender2"));
        RadioButtonFemale.click();


        WebElement FirstnameTextBox = driver.findElement(By.name("customer_firstname"));
        FirstnameTextBox.sendKeys(firstname);


        WebElement LastnameTextBox = driver.findElement(By.name("customer_lastname"));
        LastnameTextBox.sendKeys(lastName);


        WebElement PasswordTextBox = driver.findElement(By.name("passwd"));
        PasswordTextBox.sendKeys(Password);


        WebElement DaysDropDown = driver.findElement(By.id("days"));
        Select selectdays = new Select(DaysDropDown);
        selectdays.selectByValue("18");

        WebElement MonthsDropDown = driver.findElement(By.id("months"));
        Select selectmonths = new Select(MonthsDropDown);
        selectmonths.selectByIndex(10);



        WebElement YearsDropDown = driver.findElement(By.id("years"));
        Select selectYears = new Select(YearsDropDown);
        selectYears.selectByVisibleText("1998  ");

        WebElement FirstCheckBox = driver.findElement(By.id("uniform-newsletter"));
        FirstCheckBox.click();

        WebElement SecondCheckBox = driver.findElement(By.id("uniform-optin"));
        SecondCheckBox.click();


      WebElement CompanyName = driver.findElement(By.id("company"));
       CompanyName.sendKeys(Company);



        WebElement CompanyAddrees = driver.findElement(By.id("address1"));
        CompanyAddrees.sendKeys(Address);


        WebElement CompanyAddrees2 = driver.findElement(By.id("address2"));
        CompanyAddrees2.sendKeys(Address2);


        WebElement City = driver.findElement(By.id("city"));
        City.sendKeys(AddressCity);


        WebElement SelectState = driver.findElement(By.id("id_state"));
        Select selectstate = new Select(SelectState);
        selectstate.selectByValue("2");


        WebElement PostalCode = driver.findElement(By.id("postcode"));
        PostalCode.sendKeys(postalCode);


        WebElement SelectCountry = driver.findElement(By.id("id_country"));
        Select selectCountry = new Select(SelectCountry) ;
        selectCountry.selectByValue("21");


        WebElement Other = driver.findElement(By.id("other"));
        Other.sendKeys(AdditionalInformation);


        WebElement Home = driver.findElement(By.id("phone"));
        Home.sendKeys(HomePhone);

        WebElement Phone = driver.findElement(By.name("phone_mobile"));
        Phone.sendKeys(MobilePhone);


        WebElement alias = driver.findElement(By.id("alias"));
        alias.sendKeys(AliasAddress);


        WebElement SubmitAccountButton = driver.findElement(By.id("submitAccount")) ;
       SubmitAccountButton.click();

       WebElement SignOutButton = driver.findElement(By.xpath("(//a[contains(text(),'Sign out')])[1]"));
       SignOutButton.click();


    }
}
