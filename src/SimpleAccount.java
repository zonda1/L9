public class SimpleAccount extends Account {

    public SimpleAccount(long balance) {
        super(balance);
    }

    @Override
    public boolean add(long amount) {
        if (amount <= 0) return false;
        long oldBalance = getBalance();
        balance = oldBalance + amount;
        System.out.println("Успешно. Новый баланс карты: "+balance);
        return true;
    }

    @Override
    public boolean pay(long amount) {
        long oldBalance = getBalance();
        if (oldBalance == 0 || oldBalance - amount < 0) {
            System.out.println("ОТМЕНА. Недостаточно денег для оплаты.");
            return false;
        }
        balance = oldBalance - amount;
        System.out.println("Успешно. Новый баланс карты: "+balance);
        return true;
    }

    @Override
    public boolean transfer(Account account, long amount) {
        pay(amount);
        return account.add(amount);
    }
}
