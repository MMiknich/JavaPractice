import java.util.Stack;

public class MyQueue<E> implements Queue_interface<E> {
    private Stack<E> first = new Stack<>();
    private Stack<E> second = new Stack<>();


    public boolean add(E a)
    {
        this.first.push(a);
        if (first.firstElement() == a)
            return true;
        else return false;
    }

    public E poll() throws Exception {
        if(!first.isEmpty()) {
            while (!this.first.isEmpty())
            {
                this.second.push(this.first.pop());
            }
            E ret = this.second.pop();
            while (!this.second.isEmpty())
            {
                this.first.push(this.second.pop());
            }
            return ret;
        }
        else {
            Exception e = new java.util.EmptyStackException();
            throw e;
        }
    }
}
