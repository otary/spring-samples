package cn.chenzw.springboot.web.controller;

import cn.chenzw.springboot.web.domain.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formatter")
public class FormatterController {

    /**
     * @link {cn.chenzw.springboot.web.formatter.UserFormatter}
     * @param userDto
     * @return
     */
    @GetMapping("/users/{userId}")
    public UserDTO getUserInfo(@PathVariable("userId") UserDTO userDto) {
        return userDto;
    }
}
