class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        f(0, 0, n, "", res);
        return res;
    }

    public void f(int open, int close, int n, String s, List<String> res){
        if(open == n && close == n){
            res.add(s);
        }

        if(open < n){
            f(open + 1, close, n, s + "(", res);
        }

        if(close < n && close < open){
            f(open, close + 1, n, s + ")", res);
        }
    }
}
