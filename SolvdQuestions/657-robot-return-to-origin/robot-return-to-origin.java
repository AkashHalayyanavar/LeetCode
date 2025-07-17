class Solution {
    public boolean judgeCircle(String moves) {

        int x=0, y=0;

        for (char ch: moves.toCharArray()) {
            switch(ch) {
                case 'L':
                    y-=1;
                    break;
                case 'U':
                    x-=1;
                    break;
                case 'R':
                    y+=1;
                    break;
                case 'D':
                    x+=1;
                    break;
            }
        }

        if (x==0 && y==0)
            return true;
        
        return false;
    }
}