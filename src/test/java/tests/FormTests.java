package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testBases.RemoteTestBase;


public class FormTests extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("Smoke")
    @DisplayName("Проверка формы регистрации")
    void fillTestForm() {

        // Заполнение формы
        registrationPage.openPage()
                .hideBanner()
                .setFirstName("Andrey")
                .setLastName("Siluyanov")
                .setEmail("Siluyan_and@mail.ru")
                .setGender("Male")
                .setUserNumber("9011111111")
                .setDateOfBirth(11, "March", 91)
                .setSubjectValue("Maths")
                .subjectClick()
                .hobbiesClick()
//                .uploadPicture("b.jpg")
                .setAddress("Russia Yaroslavl")
                .setState("NCR")
                .setCity("Noida")
                .clickSubmit();


        //Проверка контента

        registrationPage.checkResult("Student Name", "Andrey Siluyanov")
                .checkResult("Student Email", "siluyan_and@mail.ru")
                .checkResult("Mobile", "9011111111")
                .checkResult("Gender", "Male")
                .checkResult("Date of Birth", "11 March,1991")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
//                .checkResult("Picture", "b.jpg")
                .checkResult("Address", "Russia Yaroslavl")
                .checkResult("State and City", "NCR Noida");
    }

}
