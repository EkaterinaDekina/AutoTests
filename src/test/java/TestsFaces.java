import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.SelectOptionByValue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestsFaces {

    @BeforeClass
    public static void before() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void test1() {  //Input of standard correct data
        open("http://localhost:7000");
        $(By.id("login")).sendKeys("user");
        $(By.id("pwd")).sendKeys("user");
        $(By.id("signIn")).click();
        $("#edit-employee-form > button").click();
        $(By.id("firstName")).sendKeys("Elena&^&^&");
        $("#employee-sample-data > div > button.btn.btn-primary.mt-3").click();
        $("body").shouldHave(exactText("В поле Имя введены недопустимые символы"));
    }

    @Test
    public void test2() {  //Input of standard correct data
        open("http://localhost:7000");
        $(By.id("login")).sendKeys("user");
        $(By.id("pwd")).sendKeys("user");
        $(By.id("signIn")).click();
        $("#edit-employee-form > button").click();
        $(By.id("lastName")).sendKeys("Ivanova^&");
        $("#employee-sample-data > div > button.btn.btn-primary.mt-3").click();
        $("body").shouldHave(exactText("В поле Фамилия введены недопустимые символы"));
    }

    @Test
    public void test3() {  //Input of spaces in the field Имя
        open("http://localhost:7000");
        $(By.id("login")).sendKeys("user");
        $(By.id("pwd")).sendKeys("user");
        $(By.id("signIn")).click();
        $("#edit-employee-form > button").click();
        $(By.id("secondName")).sendKeys("Ivanovna98&");
        $("#employee-sample-data > div > button.btn.btn-primary.mt-3").click();
        $("body").shouldHave(exactText("В поле Отчество введены недопустимые символы"));
    }

    @Test
    public void test4() {  //Input of spaces in the field Имя
        open("http://localhost:7000");
        $(By.id("login")).sendKeys("user");
        $(By.id("pwd")).sendKeys("user");
        $(By.id("signIn")).click();
        $("#edit-employee-form > button").click();
        $(By.id("titleForNewEmployee")).selectOptionByValue("17f623fd-05b1-4acd-a8ec-d787098aecc6");
        $("#employee-sample-data > div > button.btn.btn-primary.mt-3").click();

    }

    @Test
    public void test5() {  //Input of spaces in the field Имя
        open("http://localhost:7000");
        $(By.id("login")).sendKeys("user");
        $(By.id("pwd")).sendKeys("user");
        $(By.id("signIn")).click();
        $("#employees-sort > div > button:nth-child(1)").click();
    }

    @Test
    public void test6() {  //Input of spaces in the field Имя
        open("http://localhost:7000");
        $(By.id("login")).sendKeys("user");
        $(By.id("pwd")).sendKeys("user");
        $(By.id("signIn")).click();
        $("#employees-sort > div > button:nth-child(3)").click();
    }
}

