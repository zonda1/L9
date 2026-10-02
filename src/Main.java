import logger.SimpleLogger;
import logger.SmartLogger;

public class Main {
    static void main() {
        Account simple1 = new SimpleAccount(1_000);
        Account simple2 = new SimpleAccount(5_000);
        Account credit1 = new CreditAccount();

        credit1.pay(1_000);
        credit1.transfer(simple1, 1_000); // credit -2000, s1 2000,
        simple2.transfer(credit1, 1_000);  //credit -1000, s2 4000
        simple2.transfer(credit1, 3_000); // credit -10000
        credit1.pay(9_000);
        System.out.println(simple1.getBalance());
        System.out.println(simple2.getBalance());
        System.out.println(credit1.getBalance());
//
//        SimpleLogger simpleL = new SimpleLogger();
//        simpleL.log("Some message");
//
//        SmartLogger smartL = new SmartLogger();
//        smartL.log("Some error message");
//        smartL.log("Warning identified, check logs");
//        smartL.log("Some Error message");
    }
}