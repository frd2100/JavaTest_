import java.util.ArrayList;
import java.util.List;

public class Atm {
    private List<Account> accounts;

    public Atm() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account authenticate(String accountNumber, String name) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber) &&
                    acc.getAccountHolderName().equalsIgnoreCase(name)) {
                return acc;
            }
        }
        return null;
    }
}
