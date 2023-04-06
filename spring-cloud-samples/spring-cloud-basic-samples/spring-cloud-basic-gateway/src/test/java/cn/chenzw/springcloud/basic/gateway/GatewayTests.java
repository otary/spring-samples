package cn.chenzw.springcloud.basic.gateway;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GatewayTests {

    @Autowired
    WebTestClient webTestClient;

    /**
     * 基于路径请求
     */
    @Test
    public void testPathRoute() {
        webTestClient.get().uri("/path/result")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(response ->
                        Assertions.assertThat(new String(response.getResponseBody(), StandardCharsets.UTF_8)).isEqualTo("hello"));
    }

    /**
     * 基于路径请求2
     */
    @Test
    public void testPathRoute2() {
        webTestClient.get().uri("/path/test")
                .exchange()
                .expectStatus().isOk();
    }

    /**
     * 基于路径请求3
     *
     * @throws Exception
     */
    @Test
    public void testPathRoute3() {
        webTestClient.get().uri("/path/redirect")
                .exchange()
                .expectStatus().isOk();
    }


    /**
     * 基于Host主机名匹配转发
     */
    @Test
    public void testHostRoute() {
        webTestClient.get().uri("/host/redirect")
                .exchange()
                .expectStatus().isOk();
    }

    /**
     * 基于cookie转发
     *
     * @throws Exception
     */
    @Test
    public void testCookieRoute() throws Exception {
        // 实际请求 => https://www.baidu.com/search?q=test
        webTestClient.get().uri("/search?q=test")
                .header("Cookie", "redirect=baidu")
                .exchange()
                .expectStatus().isOk();
    }


}
