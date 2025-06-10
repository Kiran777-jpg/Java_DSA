package Arrays.Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeEleBySign {

    // IT WORKS ONLY IF HAVE SAME NUMBER OF +VE & -VE NUMBERS

    public static void RearrangebySign(ArrayList<Integer> arr) {
        int n=arr.size();
        int it=0, pos=0, neg=1;
        while(it<n && pos<n && neg<n) {
            if(it%2==0) {
                if(arr.get(it)<0) {
                    int temp = arr.get(neg);
                    arr.set(neg, arr.get(it));
                    arr.set(it, temp);
                    neg += 2;
                }
                else {
                    if(it==pos)
                        pos+=2;
                    it++;
                }
            }
            else {
                if(arr.get(it)>=0) {
                  int temp = arr.get(pos);
                  arr.set(pos, arr.get(it));
                  arr.set(it, temp);
                  pos += 2;
                }
                else {
                    if(it==neg)
                        neg+=2;
                    it++;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, -3, 4));
        RearrangebySign(A);
        for (int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
    }
}
