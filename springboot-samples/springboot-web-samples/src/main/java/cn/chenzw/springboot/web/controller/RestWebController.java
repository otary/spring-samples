package cn.chenzw.springboot.web.controller;

import cn.chenzw.springboot.web.advice.annotation.ResponseBodyBase64;
import cn.chenzw.springboot.web.annotation.ArrayParameter;
import cn.chenzw.springboot.web.constatns.Commons;
import cn.chenzw.springboot.web.domain.dto.ArrayQueryDTO;
import cn.chenzw.springboot.web.domain.dto.UserDTO;
import cn.chenzw.springboot.web.enums.UserState;
import cn.chenzw.springboot.web.enums.UserState2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest")
public class RestWebController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "hello!";
    }

    @PostMapping("/hello")
    public String hello2(@RequestBody Map<String, String> map, HttpServletRequest request) throws IOException {
        String requestParams = IOUtils.toString(request.getInputStream(), "UTF-8");
        log.info("request params => {}", requestParams);
        return "hello, " + MapUtils.getString(map, "userName");
    }

    @GetMapping("/arrayQuery")
    public ArrayQueryDTO arrayQuery(ArrayQueryDTO arrayQueryDTO) {
        return arrayQueryDTO;
    }


    /**
     * 数组参数解析器
     *
     * @param ids
     * @return
     */
    @GetMapping("/cust-arg-resolver")
    public String[] custArgResolverQuery(@ArrayParameter String[] ids) {
        return ids;
    }

    /**
     * Post Pojo数组
     *
     * @param userDTOS
     * @return
     */
    @PostMapping("/postArrayPojoQuery")
    public UserDTO[] postArrayPojoQuery(@RequestBody UserDTO[] userDTOS) {
        return userDTOS;
    }

    @PostMapping("/postPojo")
    public UserDTO postPojo(@Validated @RequestBody UserDTO userDTO) {
        return userDTO;
    }


    /**
     * Get Pojo数组 -- 不支持、报错
     *
     * @param userDTOS
     * @return
     */
    @GetMapping("/getArrayPojoQuery")
    public UserDTO[] getArrayPojoQuery(UserDTO[] userDTOS) {
        return userDTOS;
    }

    /**
     * Post Map示例
     *
     * @param maps
     * @return
     */
    @PostMapping("/postMapQuery")
    public Map<String, Object> postMapQuery(@RequestBody Map<String, Object> maps) {
        return maps;
    }

    /**
     * 列表参数
     *
     * @param ids
     * @return
     */
    @GetMapping("/getPathArrayVariable/{ids}")
    public List<String> getPathArrayVariable(@PathVariable List<String> ids) {
        return ids;
    }


    /**
     * 列表参数
     *
     * @param ids
     * @return
     */
    @GetMapping("/getListVariable")
    public List<String> getListVariable(@RequestParam("ids") List<String> ids) {
        log.info("ids => {}", ids);
        return ids;
    }

    /**
     * 使用UrlPathHelper工具类
     *
     * @param request
     */
    @GetMapping("/url-path-utils")
    public void urlPathUtils(HttpServletRequest request) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();

        log.info("getLookupPathForRequest => {}", urlPathHelper.getLookupPathForRequest(request));
        log.info("getPathWithinServletMapping => {}", urlPathHelper.getPathWithinServletMapping(request));
        log.info("getPathWithinApplication => {}", urlPathHelper.getPathWithinApplication(request));
        log.info("getRequestUri => {}", urlPathHelper.getRequestUri(request));
        log.info("getServletPath => {}", urlPathHelper.getServletPath(request));
        log.info("getContextPath => {}", urlPathHelper.getContextPath(request));
        log.info("getOriginatingQueryString => {}", urlPathHelper.getOriginatingQueryString(request));
        log.info("getOriginatingRequestUri => {}", urlPathHelper.getOriginatingRequestUri(request));
        log.info("getOriginatingServletPath => {}", urlPathHelper.getOriginatingServletPath(request));
        log.info("getOriginatingContextPath => {}", urlPathHelper.getOriginatingContextPath(request));
    }

    /**
     * 抛出异常
     */
    @GetMapping("/throw-exception")
    public void throwException() {
        throw new RuntimeException("抛出了异常!");
    }


    @ResponseBodyBase64
    @GetMapping("/base64-response")
    public UserDTO base64Response() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("张三");
        userDTO.setAge("20");
        return userDTO;
    }


    /**
     * Enum参数示例
     * GET /getUserState?userState=NORMAL
     *
     * @return "NORMAL"
     */
    @GetMapping("/getUserState")
    public UserState getUserState(UserState userState) {
        return userState;
    }

    /**
     * Enum参数示例
     * GET /getUserState2?userState2=NORMAL
     *
     * @return "NORMAL"
     */
    @GetMapping("/getUserState2")
    public UserState2 getUserState2(UserState2 userState2) {
        return userState2;
    }

    /**
     * 测试Enum参数
     *
     * @param status1
     * @return
     */
    @GetMapping("/getCommonsStatus")
    public Commons.Status1 getStatus1(Commons.Status1 status1) {
        return status1;
    }


    /**
     * Boolean测试
     *
     * @param b
     * @return
     */
    @GetMapping("/getBoolean")
    public Boolean getBoolean(Boolean b) {
        log.info("b => {}", b);

        // 不传时未null值，报错
        if (!b) {

        }
        return b;
    }
}
