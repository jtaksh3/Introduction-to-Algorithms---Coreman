import java.util.Scanner;

public class MaximumSubarray {
    int max_crossing_subarray(int[] arr, int low, int mid, int high) {
        int left_sum = -214767324;
        int sum = 0;
        for(int i = mid; i >= low; i--) {
            sum = sum + arr[i];
            if(sum > left_sum)
                left_sum = sum;
        }
        int right_sum = -214767324;
        sum = 0;
        for(int j = mid+1; j <= high; j++) {
            sum = sum + arr[j];
            if(sum > right_sum)
                right_sum = sum;
        }
        return(left_sum+right_sum);
    }
    int max_subarray(int[] arr, int low, int high) {
        if(high == low)
            return arr[low];
        else {
            int mid = (low + high)/2;
            int left_sum = max_subarray(arr, low, mid);
            int right_sum = max_subarray(arr, mid+1, high);
            int cross_sum = max_crossing_subarray(arr, low, mid, high);
            if(left_sum >= right_sum && left_sum >= cross_sum)
                return (left_sum);
            else if(right_sum >= left_sum && right_sum >= cross_sum)
                return (right_sum);
            else
                return (cross_sum);
        }
    }
    public  static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of Array");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements to find Maximum values");
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        MaximumSubarray obj = new MaximumSubarray();
        int sum = obj.max_subarray(arr, 0, n-1);
        System.out.println("Maximum Sum = "+sum);
    }
}
