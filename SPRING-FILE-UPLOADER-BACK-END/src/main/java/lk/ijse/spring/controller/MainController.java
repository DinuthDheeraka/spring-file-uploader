/**
 * @author :  Dinuth Dheeraka
 * Created : 2/1/2023 4:22 PM
 */
package lk.ijse.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class MainController {

    public MainController() {
        System.out.println("CREATED : MAIN-CONTROLLER");
    }

    @GetMapping
    public String get(){
        return "Get";
    }
}
