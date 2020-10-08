package top.p3wj.delegate;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 13:04 2020/10/8 0008
 */
public class Test {
    public static void main(String[] args) {
        new Boss().command("posters figure",new Leader());
        new Boss().command("scrapy",new Leader());
        new Boss().command("sell phones",new Leader());
    }
}
