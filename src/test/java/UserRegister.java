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
    String AliasAddress = faker.address().streetAddress();


    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() {
        //  driver.quit();
    }

    @Test
    public void userRegister() throws InterruptedException {

        WebElement SignInButton = driver.findElement(By.linkText("Sign in"));
        SignInButton.click();
        Thread.sleep(3000);

        WebElement EmailTextBox = driver.findElement(By.id("email_create"));
        EmailTextBox.sendKeys(email);
        System.out.println(email);
        Thread.sleep(2000);

        WebElement CreateAccountButton = driver.findElement(By.name("SubmitCreate"));
        CreateAccountButton.click();
        Thread.sleep(5000);

        WebElement RadioButtonFemale = driver.findElement(By.id("id_gender2"));
        RadioButtonFemale.click();
        Thread.sleep(2000);

        WebElement FirstnameTextBox = driver.findElement(By.name("customer_firstname"));
        FirstnameTextBox.sendKeys(firstname);
        Thread.sleep(2000);

        WebElement LastnameTextBox = driver.findElement(By.name("customer_lastname"));
        LastnameTextBox.sendKeys(lastName);
        Thread.sleep(2000);

        WebElement PasswordTextBox = driver.findElement(By.name("passwd"));
        PasswordTextBox.sendKeys(Password);
        Thread.sleep(2000);

        WebElement DaysDropDown = driver.findElement(By.id("days"));
        Select selectdays = new Select(DaysDropDown);
        selectdays.selectByValue("18");
        Thread.sleep(2000);
        WebElement MonthsDropDown = driver.findElement(By.id("months"));
        Select selectmonths = new Select(MonthsDropDown);
        selectmonths.selectByIndex(10);
        Thread.sleep(2000);


        WebElement YearsDropDown = driver.findElement(By.id("years"));
        Select selectYears = new Select(YearsDropDown);
        selectYears.selectByVisibleText("1998  ");

        WebElement FirstCheckBox = driver.findElement(By.id("uniform-newsletter"));
        FirstCheckBox.click();
        Thread.sleep(2000);
        WebElement SecondCheckBox = driver.findElement(By.id("uniform-optin"));
        SecondCheckBox.click();
        Thread.sleep(2000);

       WebElement CompanyName = driver.findElement(By.id("company"));
       CompanyName.sendKeys(Company);
        Thread.sleep(2000);


        WebElement CompanyAddrees = driver.findElement(By.id("address1"));
        CompanyAddrees.sendKeys(Address);
        Thread.sleep(2000);

        WebElement CompanyAddrees2 = driver.findElement(By.id("address2"));
        CompanyAddrees2.sendKeys(Address2);
        Thread.sleep(2000);


        WebElement City = driver.findElement(By.id("city"));
        City.sendKeys(AddressCity);
        Thread.sleep(2000);


        WebElement SelectState = driver.findElement(By.id("id_state"));
        Select selectstate = new Select(SelectState);
        selectstate.selectByValue("2");
        Thread.sleep(2000);

        WebElement PostalCode = driver.findElement(By.id("postcode"));
        PostalCode.sendKeys(postalCode);
        Thread.sleep(2000);

        WebElement SelectCountry = driver.findElement(By.id("id_country"));
        Select selectCountry = new Select(SelectCountry) ;
        selectCountry.selectByValue("21");
        Thread.sleep(2000);

        WebElement Other = driver.findElement(By.id("other"));
        Other.sendKeys(AdditionalInformation);
        Thread.sleep(2000);

        WebElement Home = driver.findElement(By.id("phone"));
        Home.sendKeys(HomePhone);
        Thread.sleep(2000);

        WebElement Phone = driver.findElement(By.name("phone_mobile"));
        Phone.sendKeys(MobilePhone);
        Thread.sleep(2000);

        WebElement alias = driver.findElement(By.id("alias"));
        alias.sendKeys(AliasAddress);
        Thread.sleep(2000);

        WebElement SubmitAccountButton = driver.findElement(By.id("submitAccount")) ;
       SubmitAccountButton.click();

       WebElement SignOutButton = driver.findElement(By.xpath("(//a[contains(text(),'Sign out')])[1]"));
       SignOutButton.click();


    }
}
