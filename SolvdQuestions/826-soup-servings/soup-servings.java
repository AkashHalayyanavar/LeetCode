class Solution {
    double solve(int x, int y, HashMap<Pair, Double> mp) {

        if (x <=0 && y<=0) {
            mp.put(new Pair(x,y), 0.5);
            return 0.5;
        }

        if (x <= 0) {
            mp.put(new Pair(x,y), 1.0);
            return 1;
        }

        if (y <= 0) {
            mp.put(new Pair(x,y), 0.0);
            return 0;
        }

        if (mp.containsKey(new Pair(x,y))) {
            return mp.get(new Pair(x,y));
        } 
            
        double op1 = solve(x-100, y, mp);
        double op2 = solve(x-75, y-25, mp);
        double op3 = solve(x-50, y-50, mp);
        double op4 = solve(x-25, y-75, mp);

        double result = 0.25 * (op1 + op2 + op3 + op4);
        mp.put(new Pair(x,y), result);

        return result;
    }

    public double soupServings(int n) {
        if (n > 5000)
            return 1;

        HashMap<Pair, Double> mp = new HashMap<>();
        return solve(n, n, mp);
        
    }
}