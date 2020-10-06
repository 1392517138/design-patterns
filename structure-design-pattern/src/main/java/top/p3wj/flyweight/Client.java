package top.p3wj.flyweight;

import top.p3wj.factorymethod.IFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 8:33 下午
 */
public class Client {

    interface IFlyweight {
        void operation(String extrinsicState);
    }

    // concrete flyweight role
    static class ConcreteFlyweight implements IFlyweight {
        private String intrinsicState;

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }

        public void operation(String extrinsicState) {
            System.out.println("Object address:" + System.identityHashCode(this));
            System.out.println("IntrinsicStateA:" + this.intrinsicState);
            System.out.println("ExtrinsicState:" + extrinsicState);
        }

        // flyweight factory
        static class FlyweightFactory {
            private static Map<String, IFlyweight> pool = new HashMap<String, IFlyweight>();

            // because the internal state is invariant,it serves as a key for caching
            public static IFlyweight getFlyweight(String intrinsicState) {
                if (!pool.containsKey(intrinsicState)) {
                    ConcreteFlyweight concreteFlyweight = new ConcreteFlyweight(intrinsicState);
                    pool.put(intrinsicState, concreteFlyweight);
                }
                return pool.get(intrinsicState);
            }
        }
    }
}
