import java.util.Scanner;

public class SOLIDHW {
    public static void main(String[] args) {
        Currency usd = new Currency("USD", 1.0);
        Currency eur = new Currency("EUR", 0.85);
        User user1 = new User("John", "Doe", "john.doe@email.com");
        User user2 = new User("Jane", "Smith", "jane.smith@email.com");
        BankAccount account1 = new BankAccount(user1, usd, 1000.0, 0.03, -500.0);
        BankAccount account2 = new BankAccount(user2, eur, 500.0, 0.02, -300.0);
        account1.deposit(200.0);
        account1.withdraw(150.0);
        account1.setInterestRate(0.04);
        account1.setCreditLimit(-1000.0);
        account2.deposit(100.0);
        account2.withdraw(50.0);
        account2.setInterestRate(0.03);
        account2.setCreditLimit(-400.0);
        account1.convertBalance(eur);
        account2.convertBalance(usd);
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        account2.setCreditLimit(800);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a command (1: Deposit, 2: Withdraw, 3: Set Credit Limit, 4: Convert Balance, 5: Display Account Info, 0: Exit):");
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Enter the amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    account1.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter the new credit limit:");
                    double newCreditLimit = scanner.nextDouble();
                    account1.setCreditLimit(newCreditLimit);
                    break;
                case 4:
                    System.out.println("Enter the target currency (USD or EUR):");
                    String targetCurrencyCode = scanner.next();
                    Currency targetCurrency = targetCurrencyCode.equals("USD") ? usd : eur;
                    account1.convertBalance(targetCurrency);
                    break;
                case 5:
                    account1.displayAccountInfo();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
    }

    class Currency {
        private String code;
        private double exchangeRate;

        public Currency(String code, double exchangeRate) {
            this.code = code;
            this.exchangeRate = exchangeRate;
        }

        public double convert(double amount, Currency targetCurrency) {
            return amount * (exchangeRate / targetCurrency.exchangeRate);
        }
    }

    class User {
        private String firstName;
        private String lastName;
        private String email;

        public User(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }

    abstract class UserType {
        protected User user;

        public UserType(User user) {
            this.user = user;
        }

        public abstract void displayUserInfo();
    }

    class RegularUser extends UserType {
        private int activityLevel;

        public RegularUser(User user, int activityLevel) {
            super(user);
            this.activityLevel = activityLevel;
        }

        public void changeActivityLevel(int newLevel) {
            this.activityLevel = newLevel;
        }

        @Override
        public void displayUserInfo() {
            System.out.println("Regular User Info: " + user.toString() + ", Activity Level: " + activityLevel);
        }
    }
    class PremiumUser extends UserType {
        private boolean isPremium;

        public PremiumUser(User user, boolean isPremium) {
            super(user);
            this.isPremium = isPremium;
        }

        @Override
        public void displayUserInfo() {
            System.out.println("Premium User Info: " + user.toString() + ", Premium Status: " + isPremium);
        }
    }

     class BankAccount {
        private User user;
        private Currency currency;
        private double balance;
        private double interestRate;
        private double creditLimit;

        public BankAccount(User user, Currency currency, double balance,
                           double interestRate, double creditLimit) {
            this.user = user;
            this.currency = currency;
            this.balance = balance;
            this.interestRate = interestRate;
            this.creditLimit = creditLimit;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount <= balance + creditLimit) {
                balance -= amount;
            } else {
                System.out.println("Insufficient funds or exceeded credit limit.");
            }
        }

        public void setInterestRate(double newRate) {
            interestRate = newRate;
        }

        public void setCreditLimit(double newLimit) {
            creditLimit = newLimit;
        }

        public void displayAccountInfo() {
            System.out.println("Account Info: " + user.toString() + ", Balance: " + balance + " " + currency);
        }

        public void convertBalance(Currency targetCurrency) {
            double convertedBalance = currency.convert(balance, targetCurrency);
            System.out.println("Converted Balance: " + convertedBalance + " " + targetCurrency);
        }
    }

