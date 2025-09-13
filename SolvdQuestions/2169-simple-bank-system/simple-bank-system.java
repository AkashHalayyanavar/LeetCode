class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    private boolean accountExists(int account) {
        return (account >= 1 && account <= balance.length);
    }

    private boolean isValidWithdrawal(int account, long money) {
        return (balance[account-1] >= money);
    }

    public boolean transfer(int account1, int account2, long money) {

        if ( accountExists(account1) && accountExists(account2)) {
            boolean withdrawStatus = withdraw(account1, money);
        
            if (withdrawStatus) {
                deposit(account2, money);
                return true;
            }
        }

        return false;
    }
    
    public boolean deposit(int account, long money) {
        if (!accountExists(account))
            return false;

        balance[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (!accountExists(account) || !isValidWithdrawal(account, money))
            return false;

        balance[account-1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */