// https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/

//In progress
class Solution {
    public String reverseWords(String str) {
        char[] sc = str.toCharArray();
        
        reverse(sc, 0, sc.length - 1);
        
        int s = -1, f = 0;
        while(f < sc.length) {
            if(sc[f] == ' ' ) {
                if(s != -1 && sc[s] != ' ') {
                    sc[++s] = ' ';
                }
            } else {
                sc[++s] = sc[f];
            }
            f++;
        }
        f--;
        
        if(sc[f - 1] == ' ') {
            f--;
        }
        
        return new String(sc, 0, f);
    }
    
    void reverse(char[] arr, int left, int right) {
        while(left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
