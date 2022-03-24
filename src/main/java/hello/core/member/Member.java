package hello.core.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;

    //@Autowired //의존관계 자동 주입은 스프링 컨테이너가 관리하는 스프링 빈이어야 동작한다. member는 빈으로 관리되고 있지 않으니까 @Autowired 자동 주입 안된다.
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
