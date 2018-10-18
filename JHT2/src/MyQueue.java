import java.util.Stack;

public class MyQueue<E> implements Queue_interface<E> {
    private Stack<E> first = new Stack<>();
    private Stack<E> second = new Stack<>();


    public boolean add(E a)
    {
        this.first.push(a);
        return true;
    }

    public E poll() throws Exception {
        //      throw Instant;
        if(first.isEmpty() != true) {
            while (this.first.isEmpty() != true)
            {
                this.second.push(this.first.pop());
            }
            E ret = this.second.pop();
            while (this.second.isEmpty() != true)
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
