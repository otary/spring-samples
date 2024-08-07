package cn.chenzw.springboot.web.controller;

import cn.chenzw.springboot.web.annotation.ArrayParameter;
import cn.chenzw.springboot.web.annotation.RequestBodyBase64;
import cn.chenzw.springboot.web.domain.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenzw
 */
@RestController
@RequestMapping("/method-argument-resolver")
public class MethodArgumentResolverController {


    /**
     * 数组参数解析器
     *
     * @param ids
     * @return
     */
    @GetMapping("/array-parameter")
    public String[] arrayArgResolver(@ArrayParameter String[] ids) {
        return ids;
    }


    /**
     * Base64参数解析
     */
    @PostMapping("/base64-body")
    public UserDTO base64ArgResolver(@RequestBodyBase64 UserDTO user) {
        return user;
    }


}
