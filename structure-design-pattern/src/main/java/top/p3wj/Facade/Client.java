package top.p3wj.Facade;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 4:20 下午
 */
public class Client {
    // client
    public static void main(String[] args) {

    }

    // subsystem A
    static class SubSystemA {
        public void doA() {
            System.out.println("doing A stuff!");
        }
    }

    // subsystem B
    static class SubSystemB {
        public void doB() {
            System.out.println("doing B stuff!");
        }
    }

    // Facade
    static class Facade {
        private SubSystemA a = new SubSystemA();
        private SubSystemB b = new SubSystemB();

        // external interface
        public void doA() {
            this.a.doA();
        }

        // external interface
        public void doB() {
            this.b.doB();
        }
    }
}
