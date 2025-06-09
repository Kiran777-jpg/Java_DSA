package Arrays.Easy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UnionTwoSortedArrs {

    public static ArrayList findUnionUsingMap(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int num : arr1)
            hashmap.put(num, hashmap.getOrDefault(num, 0)+1);
        for(int num : arr2)
            hashmap.put(num, hashmap.getOrDefault(num, 0)+1);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int it : hashmap.keySet())
            ans.add(it);
        return ans;
    }

    public static ArrayList findUnionUsingSet(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        HashSet<Integer> hashset = new HashSet<>();
        for(int num : arr1)
            hashset.add(num);
        for(int num : arr2)
            hashset.add(num);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int it :hashset)
            ans.add(it);
        return ans;
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int i=0, j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < n && j < m) {
            if(arr1[i] <= arr2[j]) {
                if(ans.size() == 0 || ans.get(ans.size()-1) != arr1[i])
                        ans.add(arr1[i]);
                i++;
            }
            else {
                if(ans.size() == 0 || ans.get(ans.size()-1) != arr2[j])
                    ans.add(arr2[j]);
                j++;
            }
        }

        while(i < n) {
            if(ans.size() == 0 || ans.getLast() != arr1[i])
                ans.add(arr1[i]);
            i++;
        }
        while(j < m) {
            if(ans.size() == 0 || ans.get(ans.size()-1) != arr2[j])
                ans.add(arr2[j]);
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};

        ArrayList<Integer> ans = findUnionUsingMap(arr1, arr2); // TC: O(n+m)log(n+m), SC:O(n+m)
        for(int it : ans)
            System.out.print(it + ", ");
        System.out.println();

        ans = findUnionUsingSet(arr1, arr2); // TC: O(n+m)log(n+m), SC:O(n+m)
        for(int it : ans)
            System.out.print(it + ", ");
        System.out.println();

        ans = findUnion(arr1, arr2); // TC: O(n), SC: O(1)
        for(int it : ans)
            System.out.print(it + ", ");
        System.out.println();
    }
}
