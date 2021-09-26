package com.yummy.blog.photo;

import com.yummy.blog.photo.service.PhotoService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class PhotoWebController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/blog/recipes/photo/{name}")
    public void getFile(HttpServletResponse response, @PathVariable String name) throws IOException {

        InputStream myStream = new FileInputStream(photoService.showPath(name));
        response.addHeader("Content-disposition", "name=" + photoService.showName(name));
        response.setContentType("image/png");
        IOUtils.copy(myStream, response.getOutputStream());
        response.flushBuffer();
    }
}
