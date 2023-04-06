package cn.chenzw.springboot.websocket.webssh.controllers;

import cn.chenzw.springboot.websocket.webssh.recorder.storage.WebSSHRecordLocalDiskStorage;
import cn.chenzw.springboot.websocket.webssh.recorder.storage.WebSSHRecordStorage;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/asciinema")
public class AsciinemaController {

    @CrossOrigin(value = "*")
    @GetMapping("/record-file")
    public void getRecord(HttpServletResponse response) throws IOException {
        WebSSHRecordStorage recordStorage = new WebSSHRecordLocalDiskStorage(new File(this.getClass().getResource("test.cast").getPath()));
        try (InputStream is = recordStorage.read(); OutputStream os = response.getOutputStream()) {
            IOUtils.copy(is, os);
        }
    }
}
