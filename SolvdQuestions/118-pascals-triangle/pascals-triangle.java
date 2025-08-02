class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<numRows; i++)
            res.add(new ArrayList<>());

        // add 1 to the first row
        res.get(0).add(1);

        // iterate for other rows and add the values
        for (int i=1; i<numRows; i++) {

            // first value will be one
            res.get(i).add(1);

            for (int j=1; j<i; j++) {
                res.get(i).add( res.get(i-1).get(j-1) + res.get(i-1).get(j) );
            }

            //last value will be one
            res.get(i).add(1);
        }

        return res;
    }
}