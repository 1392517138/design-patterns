package top.p3wj.composite;

/**
 * @author Aaron
 * @description
 * @date 2020/10/6 7:16 下午
 */
public abstract class CouseComponent {
    public void addChild(CouseComponent catalogComponent) {
        throw new UnsupportedOperationException("add operation are not supported");
    }

    public void removeChild(CouseComponent catalogComponent) {
        throw new UnsupportedOperationException("remove operation are not supported");
    }

    public String getName(CouseComponent catalogComponent) {
        throw new UnsupportedOperationException("get name operation are not supported");
    }

    public double getPrice(CouseComponent catalogComponent) {
        throw new UnsupportedOperationException("get price operation are not supported");
    }

    public void print() {
        throw new UnsupportedOperationException("print operation are not supported");
    }
}
