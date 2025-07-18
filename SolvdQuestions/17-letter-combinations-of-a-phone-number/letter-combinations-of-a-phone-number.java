class Solution {
    void getAllCombinations(StringBuilder sb, int index, int len, String digits, List<String> result, List<String> num) {
        if (index == len) {
            result.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index)-'2';
        for (int i=0; i<num.get(digit).length(); i++) {
            sb.append(num.get(digit).charAt(i));
            getAllCombinations(sb, index+1, len, digits, result, num);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> num = new ArrayList<>();

        num.add("abc");
        num.add("def");
        num.add("ghi");
        num.add("jkl");
        num.add("mno");
        num.add("pqrs");
        num.add("tuv");
        num.add("wxyz");

        List<String> result = new ArrayList<>();
        int n = digits.length();

        if (n == 0)
            return result;

        getAllCombinations(new StringBuilder(), 0, n, digits, result, num);
        
        return result;
    }
}