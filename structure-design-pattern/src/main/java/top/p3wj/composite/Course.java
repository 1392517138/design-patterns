package top.p3wj.composite;

/**
 * @author Aaron
 * @description
 * @date 2020/10/6 7:21 下午
 */
public class Course extends CouseComponent {
    private String name;
    private Double price;

    public Course(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CouseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CouseComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(name + "(¥ :" + price + "yuan");
    }
}
