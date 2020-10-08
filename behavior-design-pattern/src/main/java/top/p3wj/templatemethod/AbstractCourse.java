package top.p3wj.templatemethod;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 13:19 2020/10/8 0008
 */
public abstract class AbstractCourse {
    public final void createCourse() {
        // 1.release preview materials
        postPreResource();

        // 2.make ppt courseware
        createPPT();

        // 3.live boardcast online
        liveVideo();

        // 4.upload after-school materials
        postResource();

        // 5.assign homework
        postHomework();

        if (needCheckHomework()) {
            checkHomework();
        }
    }

    /**
     * hook method
     * @return
     */
    protected boolean needCheckHomework() {
        return false;
    }

    protected abstract void checkHomework();

    protected void postHomework() {
        System.out.println("assign homework");
    }

    protected void postResource() {
        System.out.println("upload after-school materals");
    }

    protected void liveVideo() {
        System.out.println("live lectures");
    }

    protected void createPPT() {
        System.out.println("make courseware");
    }

    protected void postPreResource() {
        System.out.println("post preview materials");
    }
}
