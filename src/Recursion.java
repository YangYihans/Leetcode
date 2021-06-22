public class Recursion {
    public static int recursion(int a, int b ){
        if(a > b){
            return 0;
        }
        if(a == b){
            return b;
        }
        return a + recursion(a+1, b);
    }

    public static void main(String[] args) {
        System.out.println(recursion(3, 6));
    }
}
