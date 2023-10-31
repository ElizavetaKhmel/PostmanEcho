import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    public void shouldTestTheBody(){
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Ночь, улица, фонарь, аптека;") // отправляемые данные
          // Выполняемые действия
                .when()
                .post("/post")
          // Проверки
                .then()
                .statusCode(200)
                .body("data",equalTo("Ночь, улица, фонарь, аптека, бессмысленный и тусклый свет;"))
        ;
    }
}
