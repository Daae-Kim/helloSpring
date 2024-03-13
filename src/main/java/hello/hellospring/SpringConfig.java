package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

//컴포넌트 스캔방식을 선택하면 나중에 db를 바꾸어야하는 상황에서 코드 여러개를 손대야 할 수 있다.
//설정파일을 운영하면 config 파일 중 필요한 부분만 바꾸면 되기 때문에 변경가능한 웹 개발에서 유용하다.
//@Autowire의 경우 내가 직접 생성한 빈에서는 사용할 수 없다. 빈컨테이너에 올라간 것만 대상으로 하기 때문.
