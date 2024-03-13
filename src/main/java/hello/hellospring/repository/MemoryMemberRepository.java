package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
// 데이터베이스에 접근하는 메서드를 사용하기 위한 인터페이스 이다.
// db 의 연결, 해제, 자원을 관리하고 crud 작업을 처리한다.
//MemberRepository interface 의 메소드를 구현한다.
//추상화, 확장성을 돕는다. jpa를 사용하게되면 interface를 사용하지는 않음.
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); //저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //null일 가능성이 있는경우 optional 로 감싸서 반환해준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
