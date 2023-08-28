class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int M = num1.length(), N = num2.length();
        int[] nums = new int[M+N];
        char[] rev1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] rev2 = new StringBuilder(num2).reverse().toString().toCharArray();

        for (int i=0; i<rev1.length; i++) {
            for (int j=0; j<rev2.length; j++) {
                int product = (rev1[i] - '0') * (rev2[j] - '0');
                nums[i+j] += product % 10;
                nums[i+j+1] += product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M+N-1; i++) {
            nums[i+1] += nums[i] / 10;
            sb.append(nums[i] % 10);
        }
        sb.append(nums[M+N-1]);
        String ans = sb.reverse().toString();
        int leadingZeros = 0;
        while (ans.charAt(leadingZeros) == '0') {
            leadingZeros++;
        }

        return ans.substring(leadingZeros);
    }
}

/*
min: M-N-2의 0
max: M+N개의 0 - 1

*/