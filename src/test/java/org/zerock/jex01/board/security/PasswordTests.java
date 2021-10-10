package org.zerock.jex01.board.security;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.jex01.common.config.RootConfig;
import org.zerock.jex01.security.config.SecurityConfig;
import org.zerock.jex01.security.domain.Member;
import org.zerock.jex01.security.mapper.MemberMapper;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
public class PasswordTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired(required = false)
    MemberMapper memberMapper;

    @Test
    public void testMember(){
        String mid = "admin0";

        Member member = memberMapper.findByMid(mid);

        log.warn("-------");
        log.warn(member);

    }

    @Test
    public void testEncode(){
        String str="member1";
        String enStr = passwordEncoder.encode(str);
        log.warn(enStr);
    }

    @Test
    public void testDecode(){
        String str="$2a$10$3ekxex0dPJs4uGsDfrHcSOl33PR3vm3dq/R7dWQDgmafw3RvfzD1q";

                boolean match = passwordEncoder.matches("member1", str);

                log.warn(match);
    }

    @Test
    public void insertMember(){

        //insert into tbl_member(mid, mpw, mname) values ('mid', 'mpw', 'mname');->문자열로 만들어야함.
        String query = "insert into tbl_member(mid, mpw, mname) values ('v1', 'v2', 'v3');";

        for(int i = 0; i < 10; i ++){

            String mid = "user"+i;//user0
            String mpw = passwordEncoder.encode("pw"+i);//pw0->Bcrypt시킨것.
            String mname= "유저"+i;//유저0

            String result=query;

            result=result.replace("v1", mid);//v1에 있는것을 mid로 변경!
            result=result.replace("v2", mpw);
            result=result.replace("v3",mname);
            System.out.println(result);
        }

    }


    @Test
    public void insertMemberRole(){
        //java 8 버전부터 문자열을 formatting 할 수 있음
        //예를들어 자바스크립트에서 벡틱 쓰는것처럼 문자열 포멧팅이 가능! -> String formatting 사용 가능
        //java string format 검색

        //멤버롤에 인설트문!
        String sql = "insert into tbl_member_role (mid, role) values ('%s','%s');";

        for(int i=0; i<10; i++){

            String result = String.format(sql,"user"+i, "ROLE_MEMBER");

            System.out.println(result);
        }


    }


    @Test
    public void insertAdminRole(){
        //java 8 버전부터 문자열을 formatting 할 수 있음
        //예를들어 자바스크립트에서 벡틱 쓰는것처럼 문자열 포멧팅이 가능! -> String formatting 사용 가능
        //java string format 검색

        //멤버롤에 인설트문!
        String sql = "insert into tbl_member_role (mid, role) values ('%s','%s');";
        //출력해서 콘솔에 직접 넣을것이기 때문에  ;이 필요하다.

        for(int i=0; i<10; i++){

            String result = String.format(sql,"admin"+i, "ROLE_MEMBER");

            System.out.println(result);

            String result2 = String.format(sql,"admin"+i, "ROLE_ADMIN");

            System.out.println(result2);
        }


    }

}
