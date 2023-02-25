import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassA {

    private Integer number1;
    private String name1;
    private long number2;
    public ClassA() {
        System.out.println("ConstA");
    }

    public ClassA(int i) {
        System.out.println("ConstAWithParam");
    }

    List meth(List list) {
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassA classA = (ClassA) o;
        return number2 == classA.number2 && Objects.equals(number1, classA.number1) && Objects.equals(name1, classA.name1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number1, name1, number2);
    }
}
