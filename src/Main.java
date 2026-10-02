public class Main {
    static void main() {
        Account simple1 = new SimpleAccount(1_000);
        Account simple2 = new SimpleAccount(5_000);
        Account credit1 = new CreditAccount();
        credit1.pay(1_000);
        credit1.transfer(simple1, 1_000);
        simple2.transfer(credit1, 1_000);
        simple2.transfer(credit1, 3_000);
        credit1.pay(9_000);
    }
}