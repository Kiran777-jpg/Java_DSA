package DynamicProgramming.dpOnSubsequences;

import binaryTrees.traversals.InorderTraversal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AssignCookies {
    private static void findContentChildren(List<Integer> g, List<Integer> s) {
        Collections.sort(g);
        Collections.sort(s);
        int i=0, j=0;
        while(i<g.size() && j<s.size())
        {
            if(g.get(i)<=s.get(j))
                i++;
            j++;
        }
        System.out.println(i);
    }

    private static void findContentChildrenPriorityQueue(List<Integer> g, List<Integer> s) {
        PriorityQueue<Integer> minHeap_g = new PriorityQueue<>(g);
        PriorityQueue<Integer> minHeap_s = new PriorityQueue<>(s);
        int ans=0;

        while(!minHeap_g.isEmpty() && !minHeap_s.isEmpty()) {
            if(minHeap_g.peek() <= minHeap_s.peek()) {
                ans++;
                minHeap_g.poll();
            }
            minHeap_s.poll();
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        List<Integer> g = Arrays.asList(1,2,3);
//        List<Integer> s = Arrays.asList(1,1);

        List<Integer> g = Arrays.asList(1,2,3);
        List<Integer> s = Arrays.asList(2,3);
        findContentChildren(g,s);
        findContentChildrenPriorityQueue(g,s);

        PriorityQueue<Integer> minHeap_s = new PriorityQueue<>(Collections.reverseOrder());
    }
}
