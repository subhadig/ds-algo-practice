// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/  

//O(n)
class Solution {
    public void duplicateZeros(int[] arr) {
        int noOfZeros = 0;
        int i = 0;
        while(i + noOfZeros < arr.length) {
            if(arr[i] == 0) {
                noOfZeros++;
            }
            i++;
        }
        i--;
        
        while(i >= 0) {
            if(arr[i] == 0) {
                if(i + noOfZeros < arr.length) {
                    arr[i + noOfZeros--] = 0;
                } else {
                    noOfZeros--;
                }
                arr[i-- + noOfZeros] = 0;
            } else {
                arr[i + noOfZeros] = arr[i--];
            }
        }
    }
}
