package Bob1ksProjects.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Currency {
    private static final Map<String, Currency> instances = new HashMap<>();
    private String code;
    public double exchangeRate;

    private Currency(String code, double exchangeRate) {
        this.code = code;
        this.exchangeRate = exchangeRate;
    }

    public static Currency getInstance(String code, double exchangeRate) {
        return instances.computeIfAbsent(code, k -> new Currency(code, exchangeRate));
    }

    public double convert(double amount, Currency targetCurrency) {
        return amount * (exchangeRate / targetCurrency.exchangeRate);
    }
}

interface ConversionStrategy {
    double convert(double amount, Currency targetCurrency);
}

class USDConversionStrategy implements ConversionStrategy {
    @Override
    public double convert(double amount, Currency targetCurrency) {
        return amount * (1 / targetCurrency.exchangeRate);
    }
}

class EURConversionStrategy implements ConversionStrategy {
    @Override
    public double convert(double amount, Currency targetCurrency) {
        return amount * targetCurrency.exchangeRate;
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

    @Override
    public String toString() {
        return "Bob1ksCompany.com.Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
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
        System.out.println("Regular Bob1ksProjects.com.User Info: " + user.toString() + ", Activity Level: " + activityLevel);
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
        System.out.println("Premium Bob1ksProjects.com.User Info: " + user.toString() + ", Premium Status: " + isPremium);
    }
}

class BankAccount {
    private User user;
    private Currency currency;
    private double balance;
    private double interestRate;
    private double creditLimit;
    private ConversionStrategy conversionStrategy;

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
    class ExchangeRateService {
        private static final Map<String, Double> exchangeRates = new HashMap<>();

        static {
            exchangeRates.put("USD_EUR", 0.85);
            exchangeRates.put("EUR_USD", 1.18); // Assuming a reciprocal exchange rate
        }

        public static double getExchangeRate(String fromCurrency, String toCurrency) {
            String key = fromCurrency + "_" + toCurrency;
            return exchangeRates.getOrDefault(key, 1.0); // Default to 1.0 if no exchange rate is found
        }
    }

    class AccountRegistry {
        private static final Map<String, BankAccount> accounts = new HashMap<>();

        public static void registerAccount(String email, BankAccount account) {
            accounts.put(email, account);
        }

        public static BankAccount getAccount(String email) {
            return accounts.get(email);
        }
    }

    public void setInterestRate(double newRate) {
        interestRate = newRate;
    }

    public void setCreditLimit(double newLimit) {
        creditLimit = newLimit;
    }

    public void setConversionStrategy(ConversionStrategy strategy) {
        this.conversionStrategy = strategy;
    }

    public void convertBalance(Currency targetCurrency) {
        if (conversionStrategy != null) {
            double convertedBalance = conversionStrategy.convert(balance, targetCurrency);
            System.out.println("Converted Balance: " + convertedBalance + " " + targetCurrency);
        } else {
            System.out.println("Conversion strategy not set.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Info: " + user.toString() + ", Balance: " + balance + " " + currency);
    }
}

public class SOLIDHW {
    public static void main(String[] args) {
        Currency usd = Currency.getInstance("USD", 1.0);
        Currency eur = Currency.getInstance("EUR", 0.85);

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
        System.out.println("Введите ваш email:");
        String userEmail = scanner.next();
        BankAccount userAccount = BankAccount.AccountRegistry.getAccount(userEmail);


        System.out.println("Введите ваш email:");
        userEmail = scanner.next();
        userAccount = BankAccount.AccountRegistry.getAccount(userEmail);

        if (userAccount == null) {
            System.out.println("Аккаунт не найден. Создание нового аккаунта.");

            System.out.println("Введите ваше имя:");
            String firstName = scanner.next();

            System.out.println("Введите вашу фамилию:");
            String lastName = scanner.next();

            User user = new User(firstName, lastName, userEmail);
            System.out.println("Введите начальный баланс:");
            double initialBalance = scanner.nextDouble();

            System.out.println("Введите процентную ставку:");
            double interestRate = scanner.nextDouble();

            System.out.println("Введите кредитный лимит:");
            double creditLimit = scanner.nextDouble();

            System.out.println("Введите код валюты (USD или EUR):");
            String currencyCode = scanner.next();
            Currency userCurrency = currencyCode.equals("USD") ? usd : eur;

            System.out.println("Аккаунт успешно зарегистрирован!");

            userAccount = new BankAccount(user, userCurrency, initialBalance, interestRate, creditLimit);
            BankAccount.AccountRegistry.registerAccount(userEmail, userAccount);
        }

        while (true) {
            System.out.println("Введите команду (1: Внести депозит, 2: Снять деньги, 3: Установить кредитный лимит,"
                    + " 4: Конвертировать баланс, 5: Показать информацию об аккаунте, 0: Выход):");

            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Введите сумму для депозита:");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Введите сумму для снятия:");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Введите новый кредитный лимит:");
                    double newCreditLimit = scanner.nextDouble();
                    userAccount.setCreditLimit(newCreditLimit);
                    break;
                case 4:
                    System.out.println("Введите целевую валюту (USD или EUR):");
                    String targetCurrencyCode = scanner.next();
                    Currency targetCurrency = targetCurrencyCode.equals("USD") ? usd : eur;
                    userAccount.convertBalance(targetCurrency);
                    break;
                case 5:
                    userAccount.displayAccountInfo();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                default:
                    System.out.println("Неверная команда.");
            }
        }
    }
}
