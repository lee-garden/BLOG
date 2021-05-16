package lee.garden.simpleapiserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 8081에 떠있는 API 서버
 * */
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
