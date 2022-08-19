class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        
        for (int i=1; i<=rowIndex; i++) {
            for (int j=i-2; j>=0; j--) {
                list.set(j+1, list.get(j)+list.get(j+1));
            }
            list.add(1);
        }
        
        return list;
    }
}

// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1

//   1 3 3 1
// 1 3 3 1