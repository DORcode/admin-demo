package com.coin;

import com.coin.admintest.InfoBase;
import com.coin.admintest.InfoBaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @ClassName TestMapper
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-31 10:44
 * @Version V1.0
 **/
@SpringBootTest
@Slf4j
public class TestMapper {

    @Autowired
    private InfoBaseMapper infoBaseMapper;


    @Test
    public void test() {
        List<InfoBase> infoBases = infoBaseMapper.selectList("1");

        log.debug(infoBases.toString());

    }

}
