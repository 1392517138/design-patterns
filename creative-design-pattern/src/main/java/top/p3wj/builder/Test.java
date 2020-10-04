package top.p3wj.builder;

/**
 * @author Aaron
 * @description
 * @date 2020/10/4 9:42 上午
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course.Builder()
                .addName("LittleMonitor")
                .addPpt("PPT")
                .addNote("Note")
                .builder();
    }
}
