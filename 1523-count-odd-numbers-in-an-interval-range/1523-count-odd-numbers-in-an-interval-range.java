class Solution {
    public int countOdds(int low, int high) {
        return (high+1)/2 - low/2;
        //2와 3은 같은 취급. 7과 8은 같은 취급.
    }
}