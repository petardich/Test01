import java.util.ArrayList;
import java.util.List;

public class ClassB extends ClassA{
    public ClassB() {
        System.out.println("ConstB");
    }

    public ClassB(int i) {
        super(i);
        System.out.println("ConstBWithParam");
    }

    @Override
    protected ArrayList meth(List list) {
        return new ArrayList<>();
    }
}
