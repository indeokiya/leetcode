/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) return 1;
        int left = 1; //left는 항상 false
        int right = n; //right는 항상 true. left+1 == right면 right 반환
        int tmp = left/2;
        while (true) {
            //System.out.printf("while 시작, left는 %d, right는 %d\n", left, right);
            if (left == right - 1) {
                return right;
            }
            if (isBadVersion(tmp)) { // 중간이 bad이면, right를 당겨와서 더 왼쪽을 탐색
                right = tmp;
                tmp -= (right-left)/2;
                //System.out.printf("나쁨!, left는 %d, right는 %d\n", left, right);
            } else { //good이면 
                left = tmp;
                tmp += (right-left)/2;
                //System.out.printf("좋음!, left는 %d, right는 %d\n", left, right);
            }
        }

    }
}