import java.util.Objects;

public class ColoredAndLightingPoint2D extends ColoredPoint2D{

    private int lightingPower;

    public ColoredAndLightingPoint2D(int x, int y, String color, int lightingPower) {
        super(x, y, color);
        this.lightingPower = lightingPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredAndLightingPoint2D that = (ColoredAndLightingPoint2D) o;
        return lightingPower == that.lightingPower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lightingPower);
    }
}
