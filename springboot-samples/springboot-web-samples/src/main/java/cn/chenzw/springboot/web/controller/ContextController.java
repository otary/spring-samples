package cn.chenzw.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.context.Theme;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Predicate;

@Slf4j
@RestController
@RequestMapping("/context")
public class ContextController {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    Environment environment;

    @GetMapping("/findWebApplicationContext")
    public void findWebApplicationContext(HttpServletRequest request) {
        WebApplicationContext wac = RequestContextUtils.findWebApplicationContext(request);

        log.info("RequestContextUtils.findWebApplicationContext => {}", wac);  // => AnnotationConfigServletWebServerApplicationContext
        log.info("容器比对 => {}", wac == webApplicationContext);
    }


    @GetMapping("/getLocaleResolver")
    public void testGetLocaleResolver(HttpServletRequest request) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);

        log.info("GetLocaleResolver => {}", localeResolver); // => AcceptHeaderLocaleResolver
    }

    @GetMapping("/getLocale")
    public void testGetLocale(HttpServletRequest request) {
        Locale locale = RequestContextUtils.getLocale(request);

        log.info("GetLocale => {}", locale);
    }

    @GetMapping("/getTimeZone")
    public void testGetTimeZone(HttpServletRequest request) {
        TimeZone timeZone = RequestContextUtils.getTimeZone(request);

        log.info("GetTimeZone => {}", timeZone);
    }

    @GetMapping("/getThemeResolver")
    public void testGetThemeResolver(HttpServletRequest request) {
        ThemeResolver themeResolver = RequestContextUtils.getThemeResolver(request);

        log.info("GetThemeResolver => {}", themeResolver);  // => FixedThemeResolver
    }

    @GetMapping("/getTheme")
    public void testGetTheme(HttpServletRequest request) {
        Theme theme = RequestContextUtils.getTheme(request);

        log.info("GetTheme => {}", theme);
    }

    @GetMapping("/getRequestAttributes")
    public void testGetRequestAttributes() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        String[] attributeNames = requestAttributes.getAttributeNames(RequestAttributes.SCOPE_REQUEST);
        log.info("GetRequestAttributes SCOPE_REQUEST => {}", Arrays.toString(attributeNames));

        String[] attributeSessionNames = requestAttributes.getAttributeNames(RequestAttributes.SCOPE_SESSION);
        log.info("GetRequestAttributes SCOPE_SESSION => {}", Arrays.toString(attributeSessionNames));

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("获取Request => {}", request);

        HttpServletResponse response = ((org.springframework.web.context.request.ServletRequestAttributes)
                org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).getResponse();
        log.info("获取Response => {}", response);
    }

    @GetMapping("/env")
    public String getEnvironment(String key) {
        return environment.getProperty(key);
    }

    /**
     * 判断是否 dev profiles
     *
     * @return
     */
    @GetMapping("/isDev")
    public Boolean testIsDevProfiles() {
        return environment.acceptsProfiles(new Profiles() {
            @Override
            public boolean matches(Predicate<String> activeProfiles) {
                return activeProfiles.test("test");
            }
        });
    }

    @GetMapping("/jarPath")
    public String getJarPath() {
        log.info("java.class.path => {}", new File(System.getProperty("java.class.path")).getParent()); // => null
        log.info("codeSourceLocation => {}", new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()); // => file:\...\springboot-web-samples-0.0.1-SNAPSHOT.jar!\BOOT-INF
        log.info("thread resource path => {}", Thread.currentThread().getContextClassLoader().getResource("").getPath()); // =>  file:/.../springboot-web-samples-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/

        log.info("user.dir => {}", System.getProperty("user.dir")); // => jar包所在目录
        ApplicationHome ah = new ApplicationHome(getClass());
        return ah.getSource().getParentFile().getAbsolutePath(); // => jar包所在目录
    }

    @GetMapping("/classpath/file")
    public String getClassPathResourceContent() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("a.txt");
        log.info("path => {}", classPathResource.getPath());
        log.info("exists => {}", classPathResource.exists());

        return IOUtils.toString(classPathResource.getInputStream(), Charset.defaultCharset());
    }
}
