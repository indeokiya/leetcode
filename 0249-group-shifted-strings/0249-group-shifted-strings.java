class Solution {
    private Map<String, List<String>> dict;

    public List<List<String>> groupStrings(String[] strings) {
        dict = new HashMap<>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            int offset = str.charAt(0) - 'a';
            for (int i=0, length=str.length(); i<length; i++) {
                char c = 'a';
                c += (str.charAt(i) - 'a' + 26 - offset) % 26;
                sb.append(c);
            }
            String converted = sb.toString();
            if (!dict.containsKey(converted)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                dict.put(converted, list);
                continue;
            }
            dict.get(converted).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrySet : dict.entrySet()) {
            ans.add(entrySet.getValue());
        }
        return ans;
    }
}