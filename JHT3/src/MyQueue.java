import java.util.Stack;

public class MyQueue<E> implements Queue_interface<E> {
    private Stack<E> firstst = new Stack<>();
    private Stack<E> secondst = new Stack<>();


    public boolean add(E a,boolean first)
    {
        if(!first || firstst.isEmpty()) {
            this.firstst.push(a);
            return true;
        }
        else{
            while (!this.firstst.isEmpty())
            {
                this.secondst.push(this.firstst.pop());
            }
            firstst.push(a);
            while (!this.secondst.isEmpty())
            {
                this.firstst.push(this.secondst.pop());
            }
            return true;
        }
    }

    public E poll(boolean first) throws Exception {
        if(!firstst.isEmpty()) {
            if (first) {
                while (!this.firstst.isEmpty()) {
                    this.secondst.push(this.firstst.pop());
                }
                E ret = this.secondst.pop();
                while (!this.secondst.isEmpty()) {
                    this.firstst.push(this.secondst.pop());
                }
                return ret;
            }
            else{
                return firstst.pop();
            }
        }
        else {
            throw  new java.util.EmptyStackException();
        }
    }
}
