class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        
        for (int i=1; i<=n; i++) {
            list.add(help(i));    
        }
        
        return list;
    }
    
    public String help(int n) {
        StringBuilder sb = new StringBuilder();
        if (n%3 == 0) {
            sb.append("Fizz");
        }
        if (n%5 == 0) {
            sb.append("Buzz");
        }
        if (sb.length() == 0) {
            sb.append(String.valueOf(n));
        }
        
        return sb.toString();
    }
}