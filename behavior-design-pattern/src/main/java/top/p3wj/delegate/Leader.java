package top.p3wj.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 13:01 2020/10/8 0008
 */
public class Leader implements IEmployee {
    private Map<String, IEmployee> employee = new HashMap<String, IEmployee>();

    public Leader() {
        employee.put("scrapy", new EmplyeeA());
        employee.put("posters figure", new EmplyeeB());
    }

    public void doing(String task) {
        if (!employee.containsKey(task)) {
            System.out.println("this " + task + " is beyond my capacity!");
            return;
        }
        employee.get(task).doing(task);
    }
}
