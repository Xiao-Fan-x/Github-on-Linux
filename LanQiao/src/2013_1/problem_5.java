public class problem_5 {
    public static void main(String[] args) {
        
        int[] a = new int[]{25,18,-2,0,16,-5,33,21,0,19,-16,25,-3,0};
        
        for (int i=0; i<a.length; i++ ) {
            System.out.print(a[i]+" ");
        }

        sort(a);

        System.out.println(" ");
        
        for (int i=0; i<a.length; i++ ) {
            System.out.print(a[i]+" ");
        }
        
    }

    static void sort(int[] x)
    {
        int p = 0;
        int left = 0;
        int right = x.length-1;

        while(p<=right){
            if(x[p]<0){
                int t = x[left];
                x[left] = x[p];
                x[p] = t;
                left++;
                p++;
            }
            else if(x[p]>0){
                int t = x[right];
                x[right] = x[p];
                x[p] = t;
                right--;
            }
            else{
                p++;  //代码填空位置
            }
        }
    }
}
