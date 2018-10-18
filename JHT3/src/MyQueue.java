import java.util.Stack;

public class MyQueue<E> implements Queue_interface<E> {
    private Stack<E> firstst = new Stack<>();
    private Stack<E> secondst = new Stack<>();


    public boolean add(E a,boolean first)
    {
        if(first || firstst.isEmpty() != true) {
            this.firstst.push(a);
            return true;
        }
        else{
            while (this.firstst.isEmpty() != true)
            {
                this.secondst.push(this.firstst.pop());
            }
            firstst.push(a);
            while (this.secondst.isEmpty() != true)
            {
                this.firstst.push(this.secondst.pop());
            }
            return true;
        }
    }

    public E poll(boolean first) throws Exception {
        if(firstst.isEmpty() != true) {
            if (first) {
                while (this.firstst.isEmpty() != true) {
                    this.secondst.push(this.firstst.pop());
                }
                E ret = this.secondst.pop();
                while (this.secondst.isEmpty() != true) {
                    this.firstst.push(this.secondst.pop());
                }
                return ret;
            }
            else{
                return firstst.pop();
            }
        }
        else {
            Exception e = new java.util.EmptyStackException();
            throw e;
        }
    }
}
