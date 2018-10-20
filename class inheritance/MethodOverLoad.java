public class MethodOverLoad {
    public static void main(String args[]){
        System.out.println(5+7);
        int[] arr = {1,2,3,4,5,6,8};
        int sum = getSum(1,2,3,6,34,324);
        System.out.println(sum);
    }
    public  static int getSum(int a,int b){
        return a+b;
    }
    public static int getSum(int...a){
        int sum = 0;
        for (int i = 0;i < a.length;i++)
            sum+=a[i];
        return sum;
    }
}
