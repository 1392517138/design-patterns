package top.p3wj.singleton.enumsingleton;

/**
 * @author Aaron
 * @description
 * @date 2020/10/3 4:19 下午
 */
public enum EnumSingleton {
    INSTANCE;
    private Object data;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
