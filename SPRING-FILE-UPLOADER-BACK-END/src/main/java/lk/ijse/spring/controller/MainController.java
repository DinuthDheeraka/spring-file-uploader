/**
 * @author :  Dinuth Dheeraka
 * Created : 2/1/2023 4:22 PM
 */
package lk.ijse.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/upload")
@CrossOrigin
@ResponseBody
public class MainController {

    public MainController() {
        System.out.println("CREATED : MAIN-CONTROLLER");
    }

    @PostMapping("/post")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image) {
        // Perform the image upload operation.
        System.out.println(image.getName());
        return ResponseEntity.ok("Image uploaded successfully.");
    }
}
