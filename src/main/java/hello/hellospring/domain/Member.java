package hello.hellospring.domain;
//스프링에서 도메인은 프로젝트에서 사용되는 데이터를 추상화하고, 서비스와 데이터 베이스 간의 중개자 역할을 한다.
public class Member {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
