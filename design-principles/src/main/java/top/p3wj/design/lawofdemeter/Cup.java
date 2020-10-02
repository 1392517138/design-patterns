package top.p3wj.design.lawofdemeter;

/**
 * @author Aaron
 * @description
 * @date 2020/10/2 12:44 下午
 */
public class Cup {
    private boolean full;
    private Material material;

    public Cup(boolean full, Material material) {
        this.full = full;
        this.material = material;
    }

    public Object getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

}
