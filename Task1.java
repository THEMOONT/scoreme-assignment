import java.util.*;

public class Task1 {

    // FIX: Initialize result list to avoid NullPointerException
    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Null check for accounts list
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {
            // FIX: Check for null account and null dueDate
            if (account != null && account.getDueDate() != null
                    && account.getDueDate().before(new Date())) {

                // FIX: Ensure correct handling of zero/negative balance
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }
        return result;
    }
}

// Dummy class for compilation
class LoanAccount {
    private Date dueDate;
    private double outstandingBalance;

    public Date getDueDate() { return dueDate; }
    public double getOutstandingBalance() { return outstandingBalance; }
}
