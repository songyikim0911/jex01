package org.zerock.jex01.board.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.jex01.board.config.BoardRootConfig;
import org.zerock.jex01.board.domain.Reply;
import org.zerock.jex01.common.config.RootConfig;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {BoardRootConfig.class, RootConfig.class})
public class ReplyMapperTests {

    //replymapper는 mapperscan으로 이루어지고,
    //bean을 통해 이루어지지않는다.

    @Autowired(required = false)
    ReplyMapper replyMapper;//그래서 required가 false임

    @Test
    public void insertDummies(){
        long[] arr = {217L, 216L, 215L, 214L, 213L};//bno
        //랜덤한 값을 따서 rno번호를써야함.

        //intstream은 루프로 생각하면된다.
        IntStream.rangeClosed(1,100).forEach(num -> {

            long bno = arr[(int)(Math.random()*arr.length* 1000) %5];

            Reply reply = Reply.builder()
                    .bno(bno)
                    .reply("댓글..."+num)
                    .replyer("user" + (num % 100))
                    .build();

            replyMapper.insert(reply);

        });


    }


    @Test
    public void testList(){

        Long bno = 217L;

        replyMapper.getListWithBoard(bno).forEach(reply -> log.info(reply));

    }


}
