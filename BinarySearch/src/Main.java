import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] unSortedArray=generateUnsortedArray(8700);
        for(int i=0;i<unSortedArray.length;i++){
            System.out.print(unSortedArray[i]+"-");
        }
        System.out.println("////////////////////////////////");
        long startTime=System.nanoTime();
        System.out.println(binarySearch(unSortedArray,9230));
        long endTime=System.nanoTime();
        long duration=endTime-startTime;
        System.out.println("BinarhSearch time:"+duration);


        long startTime2=System.nanoTime();
        List<Integer> list = Arrays.stream(unSortedArray).boxed().toList();
        System.out.println(list.indexOf(9230));
        long endTime2=System.nanoTime();
        long duration2=endTime2-startTime2;
        System.out.println("Built-in time:"+duration2);


    }


    public static int binarySearch(int[] arr,int target){
        int[] sorted=selectionSort(arr);
        int leftIndex=0;
        int rightIndex=sorted.length-1;
        while(leftIndex<=rightIndex){
            int midIndex=(leftIndex+rightIndex)/2;
            if(sorted[midIndex]==target){
                return midIndex;
            }
            else if (sorted[midIndex]<target) {
                leftIndex=midIndex+1;
            }else{
                rightIndex=midIndex-1;
            }
        }
        return -1;
    }

    public static int[] generateUnsortedArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000); // Generating random numbers between 0 and 9999
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int index=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            int smallerNum=arr[index];
            arr[index]=arr[i];
            arr[i]=smallerNum;
        }
        return arr;
    }


}