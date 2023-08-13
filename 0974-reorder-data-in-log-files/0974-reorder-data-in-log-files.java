class Solution {
    private List<String> digits = new ArrayList<>();
    private List<String[]> letters = new ArrayList<>();

    private boolean isDigitLog(String log) {
        return Character.isDigit(log.charAt(log.length()-1));
    }

    public String[] reorderLogFiles(String[] logs) {
        for (String log : logs) {
            if (isDigitLog(log)) {
                digits.add(log);
            } else {
                letters.add(log.split(" "));
            }
        }

        Collections.sort(letters, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int idx1 = 1, idx2 = 1;
                while (idx1 < o1.length && idx2 < o2.length) {
                    if (o1[idx1].equals(o2[idx2])) {
                        idx1++;
                        idx2++;
                        continue;
                    }
                    return o1[idx1].compareTo(o2[idx2]);
                }
                return o1.length == o2.length ? o1[0].compareTo(o2[0])
                    : Integer.valueOf(o1.length).compareTo(o2.length);
            }
        });

        String[] reordered = new String[logs.length];
        for (int i=0, size=letters.size(); i<size; i++) {
            reordered[i] = String.join(" ", letters.get(i));
        }
        for (int i=letters.size(), j=0; i<logs.length; i++, j++) {
            reordered[i] = digits.get(j);
        }
        return reordered;
    }
}