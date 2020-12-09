package com.coin.sphere;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName SmokeTest
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-09 16:10
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
    @Autowired
    private HomeController homeController;

    @Test
    public void test() throws Exception {
        assertThat(homeController).isNotNull();
    }
}
