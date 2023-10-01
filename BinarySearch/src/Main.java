import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] sortedArray=generateSortedArray(200000);
        long startTime=System.nanoTime();
        System.out.println(Arrays.binarySearch(sortedArray,199999));
        long endTime=System.nanoTime();
        long duration=endTime-startTime;
        System.out.println(duration);

    }


    public static int binarySearch(int[] arr,int target){
        int leftIndex=0;
        int rightIndex=arr.length-1;
        while(leftIndex<=rightIndex){
            int midIndex=(leftIndex+rightIndex)/2;
            if(arr[midIndex]==target){
                return midIndex;
            }
            else if (arr[midIndex]<target) {
                leftIndex=midIndex+1;
            }else{
                rightIndex=midIndex-1;
            }
        }
        return -1;
    }

    public static int[] generateSortedArray(int size) {
        int[] sortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            sortedArray[i] = i;
        }
        return sortedArray;
    }
}