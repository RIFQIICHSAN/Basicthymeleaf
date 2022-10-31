/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basicthymeleaf.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Rifqi Ichsan A
 */
@Controller
public class controller {
    @RequestMapping("/signin")
    public String getInfo(@RequestParam(value="fullname") String fullname,
                   @RequestParam(value="tgllahir") String tgllahir,
                   @RequestParam(value="image") MultipartFile image,
                   Model model)
        throws IOException{
        byte[] img = image.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imgLink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("kirimnm", fullname);
        model.addAttribute("kirimtgl", tgllahir);
        model.addAttribute("kirimimg", imgLink);
        return "Result";
    }
}