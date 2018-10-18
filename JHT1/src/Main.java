public class Main {

    public static void recursion(int[] array, int iteration)
    {
        try{
            System.out.println(array[iteration]);
            recursion(array, iteration + 1);
            return;
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,0, 128};
        recursion(arr, 0);
        return;
    }
}
