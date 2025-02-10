package app.birdlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import app.birdlist.repository.CharacterRepository;
import app.birdlist.repository.VersionRepository;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private CharacterRepository charaBase;

    @Autowired
    private VersionRepository verBase;

    @GetMapping("/profile/{id}")
    public void showProfileImage(@PathVariable String id, HttpServletResponse response) {
        byte[] r = charaBase.getImage(id);
        if(r != null){
            response.setContentType("image/jpeg");
            response.setContentLength(r.length);
            try {
                response.getOutputStream().write(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            response.setStatus(404);
        }
    }

    @GetMapping("/version/{id}")
    public void showVersionImage(@PathVariable Integer id, HttpServletResponse response) {
        byte[] r = verBase.getImage(id);
        if(r != null){
            response.setContentType("image/jpeg");
            response.setContentLength(r.length);
            try {
                response.getOutputStream().write(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            response.setStatus(404);
        }
    }
}
