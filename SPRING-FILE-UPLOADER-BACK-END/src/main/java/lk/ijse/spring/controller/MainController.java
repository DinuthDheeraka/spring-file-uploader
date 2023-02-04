/**
 * @author :  Dinuth Dheeraka
 * Created : 2/1/2023 4:22 PM
 */
package lk.ijse.spring.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        byte[] bytes = new byte[0];
        try {
            bytes = image.getBytes();
            Path path = Paths.get("E:\\upload\\" + image.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return ResponseEntity.ok("Image uploaded successfully.");
    }

    @GetMapping("get")
    public ResponseEntity<byte[]> getImage() {
        System.out.println("GET");
        try {
            // Read the image file from the specified directory.
            Path path = Paths.get("E:\\upload\\" + "Screenshot 2021-09-22 184206.png");
            byte[] imageBytes = Files.readAllBytes(path);

            // Set the content type and return the image in the response body.
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
