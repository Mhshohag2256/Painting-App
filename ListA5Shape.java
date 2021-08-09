package sample;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class ListA5Shape {
    @XmlElement(name="shape")
    private List<A5Shape> shape;

    {
        shape = new ArrayList<>();
    }

    public void setShape(List<A5Shape> shape) {
        this.shape = shape;
    }

    public List<A5Shape> getShape() {
        return shape;
    }
    ListA5Shape(){
        shape.add(new A5Shape());
    }
}
