package top.p3wj.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/10/6 7:24 下午
 */
public class CoursePackage extends CouseComponent {
    private List<CouseComponent> items = new ArrayList<CouseComponent>();
    private String name;
    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CouseComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void removeChild(CouseComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public String getName(CouseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CouseComponent catalogComponent : items
        ) {
            // control display format
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    // print space control format
                    System.out.println(" ");
                }
                for (int i = 0; i < this.level; i++) {
                    // start printing a '+' each line
                    if (i == 0) {
                        System.out.println("+");
                    }
                    System.out.println("-");
                    // print title
                }
            }
            catalogComponent.print();
        }
    }
}
