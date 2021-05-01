package lee.garden.simpleapiserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/data")
    public String success(String key) {
        if (key.equals("fail")) {
            throw  new RuntimeException();
        }
        return "data";
    }
}
