package cn.chenzw.springcloud.basic.gateway;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GatewayFunctionsTests {

    @Autowired
    WebTestClient webTestClient;


    /**
     * 蓝绿发布
     */
    @Test
    public void testBlueGreenRoute() {
        // 20% => https://www.baidu.com/search?q=test
        // 80% => https://cn.bing.com/search?q=test
        webTestClient.get().uri("/search?q=test")
                .exchange().expectStatus().isOk();
    }

    /**
     * 熔断
     */
    @Test
    public void testHystrixRoute() {
        webTestClient.get().uri("/get")
                .header("error", "xxxx")
                .exchange().expectStatus().isOk()
                .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(new String(response.getResponseBody(), StandardCharsets.UTF_8)).isEqualTo("请稍后再试!"));
    }

    /**
     * 黑名单
     */
    @Test
    public void testBlackRoute() {
        webTestClient.get().uri("/get")
                .header("uid", "2222")
                .exchange().expectStatus().isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }


    /**
     * 日志记录
     */
    @Test
    public void testLogRoute() {
        webTestClient.get().uri("/log")
                .exchange().expectStatus().isNotFound();
    }

    /**
     * 用户鉴权
     */
    @Test
    public void testAuthRoute() {
        webTestClient.get().uri("/auth")
                .exchange().expectStatus().isFound();
              /*  .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(new String(response.getResponseBody(), StandardCharsets.UTF_8)).isEqualTo("请登录系统!"));*/
    }
}
