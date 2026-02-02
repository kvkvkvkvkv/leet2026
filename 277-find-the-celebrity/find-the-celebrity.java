/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int l = 0;
        int h = n-1;

        while(l<h) {
            if(knows(l,h)) {
                l++;
            } else {
                h--;
            }
        }

        for(int i=0;i<n;i++) {
            if(l!=i && (knows(l,i) || !knows(i,l))) {
                return -1;
            }
        }
        return l;
    }
}