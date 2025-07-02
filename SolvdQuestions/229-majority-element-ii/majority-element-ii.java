class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        
        if (n==1) {
            list.add(nums[0]);
            return list;   
        }
        
        int num1=nums[0], num2=Integer.MIN_VALUE, count1=1, count2=0;
        
        for (int i=1; i<n; i++) {
            
            // case1: equal to num1
            if (nums[i] == num1) {
                count1++;
            }
            
            // case2: nums[i] equals to num2
            else if (nums[i] == num2) {
                count2++;
            }
            
            // case3: num1 equals to min value
            else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            }
            
            // case4: num2 equals to min value
            else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            }
            
            // case5: nums[i] not equal to both num1 and num2
            else {
                count1--;
                count2--;
            }
        }
        
        int reqLen = n/3;
        count1=0; 
        count2=0;
        
        for (int num: nums) {
            count1 += (num == num1) ? 1 : 0;
            count2 += (num == num2) ? 1 : 0;
        }
        
        if (count1 > reqLen)
            list.add(num1);
            
        if (count2 > reqLen)
            list.add(num2);
            
        return list;
    }
}
