package com.coin.sphere;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * @ClassName HttpRequestTest
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-09 16:57
 * @Version V1.0
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greeting() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" , String.class)).contains("Hello. World");
    }
}
