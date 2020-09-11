import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy("자동차", 10000);
        Toy toy2 = new Toy("자동차", 10000);

        // equals로 객체의 값 비교하기
        System.out.println("toy1.equals(toy2) = " + toy1.equals(toy2));

        // set 있는 객체 비교 하기
        Set<Toy> toySet = new HashSet<>();
        toySet.add(toy1);
        toySet.add(toy2);

        // 사이즈는 1이 나온다. toy1과 toy2는 set에서 같은 객체로 분류! hashcode가 같으니까!!
        System.out.println("toySet.size() = " + toySet.size());
    }
}
