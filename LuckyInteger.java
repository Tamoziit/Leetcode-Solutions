import java.util.Arrays;
import java.util.HashMap;

class LuckyInteger {
    /* 
     * Approach 1:
     * O(NlgN) [sorting] + 2.O(MAX) [MAX = max integer in array] + O(N) [HashMap building]
     * = O(NlgN + MAX) --> Time
     * O(MAX) --> Space
     */
    public int findLucky1(int[] arr) {
        Arrays.sort(arr);
        int max = -1, l = arr.length, i;
        int hashMap[] = new int[arr[l - 1] + 1];

        for (i = 1; i < hashMap.length; i++) {
            hashMap[i] = 0;
        }

        for (i = 0; i < l; i++) {
            hashMap[arr[i]]++;
        }

        for (i = 1; i < hashMap.length; i++) {
            if (hashMap[i] == i) {
                if (i > max)
                    max = i;
            }
        }

        return max;
    }

    /* 
     * Hash Map:
     * O(N) --> Time
     * O(N) --> Space
     */
    public int findLucky2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int luckyInteger = -1;

        for (int key : map.keySet()) {
            if (map.get(key) == key) {
                luckyInteger = key; 
            }
        }
        return luckyInteger;  
    }

    public static void main(String[] args) {
        LuckyInteger ob = new LuckyInteger();
        int arr[] = {1, 2, 2, 3, 3};
        System.out.println("Lucky Integer by Approach 1 = " + ob.findLucky1(arr));
        System.out.println("Lucky Integer by Approach 2 = " + ob.findLucky2(arr));
    }
}