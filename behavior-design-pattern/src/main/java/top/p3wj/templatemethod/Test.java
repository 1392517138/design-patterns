package top.p3wj.templatemethod;

import com.sun.xml.internal.ws.server.provider.ProviderInvokerTube;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 13:44 2020/10/8 0008
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("======Architect Course======");
        JavaCourse javaCourse = new JavaCourse();
        javaCourse.setNeedCheckHomework(false);
        javaCourse.createCourse();

        System.out.println("======Python Course======");
        PythonCourse pythonCourse = new PythonCourse();
        pythonCourse.createCourse();
    }
}
