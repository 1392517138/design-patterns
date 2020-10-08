package top.p3wj.templatemethod;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 13:41 2020/10/8 0008
 */
public class JavaCourse extends AbstractCourse {
    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }
    @Override
    protected boolean needCheckHomework() {
        return this.needCheckHomework;
    }

    @Override
    protected void checkHomework() {
        System.out.println("check the java job");
    }
}
