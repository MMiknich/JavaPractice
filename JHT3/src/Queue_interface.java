public interface Queue_interface<E> {

    boolean add(E a, boolean first);
    E poll(boolean first) throws Exception;
}
