public class CreditAccount extends Account {
    private long creditLimit;

    public CreditAccount() {
        super(0);
        creditLimit = -10_000L;
    }


    @Override
    public boolean add(long amount) {
        if (amount <= 0) return false;
        long oldBalance = getBalance();
        if (oldBalance + amount > 0) {
            System.out.println("ОТМЕНА. Превышено нулевое значение баланса кредитной карты.");
            System.out.println("Текущий баланс: " + oldBalance);
            return false;
        }
        balance = oldBalance + amount;
        System.out.println("Успешно. Новый баланс кредитной карты: " + balance);
        return true;
    }

    @Override
    public boolean pay(long amount) {
        long oldBalance = getBalance();
        if (oldBalance == creditLimit || oldBalance - amount < creditLimit) {
            System.out.println("ОТМЕНА. Превышен кредитный лимит.");
            System.out.println("Текущий баланс: " + oldBalance);
            return false;
        }
        balance = oldBalance - amount;
        System.out.println("Успешно. Новый баланс кредитной карты: " + balance);
        return true;
    }

    @Override
    public boolean transfer(Account account, long amount) {
        pay(amount);
        return account.add(amount);
    }


}
