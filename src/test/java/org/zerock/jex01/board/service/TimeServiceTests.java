package org.zerock.jex01.board.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.jex01.board.config.BoardRootConfig;
import org.zerock.jex01.common.config.RootConfig;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {BoardRootConfig.class, RootConfig.class})
public class TimeServiceTests {
    //타임서비스 주입 부터 먼저 받기
    //트랜잭션 없을때 문제점 부터 확인

    @Autowired
    TimeService timeService;

    @Test
    public void testAdd(){

        String str = " Starry, starry night" +
                "paint your pallette blue and gray" +
                "Look out on a summers'day" +
                "with eyes that know the darkness in my soul ";

        timeService.addString(str);
        //이제 50자 넘으니까 하나에는 들어가고 하나에는 못들어가는것을 확인!

    }
}
