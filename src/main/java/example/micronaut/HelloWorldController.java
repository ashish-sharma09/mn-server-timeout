package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloWorldController {

    @Get("/hello/")
    public String helloWorld() throws InterruptedException {
        Thread.sleep(5000);
        return "Hello World";
    }
}
