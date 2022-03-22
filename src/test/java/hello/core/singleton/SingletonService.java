package hello.core.singleton;

public class SingletonService {

    //싱글톤 객체를 딱 한개만 생성해 둔다.
    private static final SingletonService instance = new SingletonService();

    //객체는 오직 public 으로 공개된 객체 인스턴스를 사용하려면 static 메서드를 통해서만 허용하도록 한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private으로 막아 외부에서 new 키워드를 통한 생성을 막는다.
    private SingletonService() { }

    public void logic() {
        System.out.println("싱글톤으로 생성된 객체 로직 호출");
    }
}
