package top.p3wj.chainofresponsibility;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @Author: Aaron
 * @Description:
 * @Date: Created in 15:02 2020/10/8 0008
 */
public abstract class Handler<T> {
    protected Handler chain;
    private void next(Handler handler) {
        this.chain = handler;
    }
    public abstract void doHandle(Member member);
    public static class Builder<T> {
        private Handler<T> head;
        private Handler<T> tail;
        public Builder<T> addHandler(Handler<T> handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }
        public Handler<T> build() {
            return this.head;
        }
    }
}
