package com.akqa;

import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class loginFormCheck {

    @Test
    public void userCanNotLoginWithEmptyCredentials() {
        open("http://outlook.com");
        $("#idSIButton9").click();
        $("#idTd_PWD_ErrorMsg_Username").shouldBe(present);
        $("#idTd_PWD_ErrorMsg_Password").shouldBe(present);
    }

    @Test
    public void userCanNotLoginWithEmptyLogin() {
        open("http://outlook.com");
        login("", "Global18");
        $("#idSIButton9").click();
        $("#idTd_PWD_ErrorMsg_Username").shouldBe(present);
    }


    @Test
    public void userCanNotLoginWithEmptyPassword() {
        open("http://outlook.com");
        login("elaides1@outlook.com", "");
        $("#idSIButton9").click();
        $("#idTd_PWD_ErrorMsg_Password").shouldBe(present);
    }


    @Test
    public void userCanNotLoginWithIncorrectPassword() {
        open("http://outlook.com");
        login("elaides1@outlook.com", "Glob18");
        $("#idSIButton9").click();
        $("#idTd_Tile_ErrorMsg_Login").shouldBe(present);
    }


    @Test
    public void userCanLogin(){
        open("http://outlook.com");
        login("elaides1@outlook.com", "Global18");
        $("#idSIButton9").click();
        $(".c_meun").shouldHave(text("Elad Elad"));
        $("#c_meun").click();
        $("#c_signout").click();
    }
    public void login(String login, String pass){
        $("#i0116").val(login);
        $("#i0118").val(pass);
    }
}


