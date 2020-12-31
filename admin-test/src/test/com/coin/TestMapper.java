package com.coin;

import com.coin.admintest.InfoBase;
import com.coin.admintest.InfoBaseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName TestMapper
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-31 10:44
 * @Version V1.0
 **/
@SpringBootTest
public class TestMapper {

    @Autowired
    private InfoBaseMapper infoBaseMapper;


    @Test
    public void test() {
        InfoBase infoBase = new InfoBase();
        infoBase.setAuthor("张");
        infoBaseMapper.insertSelective(infoBase);
    }

}
