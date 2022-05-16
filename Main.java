package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scan = new Scanner(System.in);
        Account account12 = new Account("konto1", "konto1", 200);
        bank.addAccount(account12);

        do {
            System.out.println("Wybierz opcje:");
            System.out.println("1. Admin");
            System.out.println("2. Użytkownik");
            System.out.println("3. Exit");
            int option = scan.nextInt();

            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Witam.");
                    System.out.println("1.Dodaj konto.");
                    System.out.println("2.Usuń konto.");
                    System.out.println("3.Odblokuj/zablokuj konto.");
                    System.out.println("4.Stan banku.");
                    System.out.println("5.Historia kredytowa.");
                    System.out.println("6.Powrót");
                    int option1 = scan.nextInt();
                    scan.nextLine();

                    switch (option1) {
                        case 1:
                            System.out.println("Podaj login: ");
                            String login = scan.nextLine();
                            System.out.println("Podaj hasło: ");
                            String haslo = scan.nextLine();
                            bank.addAccount(new Account(login, haslo, 0));
                            System.out.println("Konto utworzone");

                            break;
                        case 2:
                            System.out.println("Podaj login: ");
                            String deleteLogin = scan.nextLine();
                            bank.removeAccount(deleteLogin);
                            System.out.println("Konto usunięte");

                            break;
                        case 3:
                            System.out.println("Podaj nazwe konta: ");
                            String konto = scan.nextLine();
                            bank.Access(konto);
                            break;
                        case 4:
                            int stanBanku = bank.stanBanku;
                            System.out.println("Stan banku wynosi = " + stanBanku);
                            break;
                        case 5:

                            break;

                        case 6:

                            break;

                    }
                    break;

                case 2:
                    boolean tak = true;
                    String login;
                    String haslo;
                    while (tak) {
                        System.out.println("Witaj użytkowniku, wprowadź swój login:");
                        login = scan.nextLine();
                        System.out.println(login);
                        System.out.println("Wprowadź hasło:");
                        haslo = scan.nextLine();
                        System.out.println(haslo);
                        if (bank.Logowanie(login, haslo) == true) {
                            System.out.println("Witam, jaką akcję chcesz wykonać.");
                            tak = false;
                            bank.Zalogowany(login,haslo);
                            System.out.println("1.Wpłać:");
                            System.out.println("2.Pobierz: ");
                            System.out.println("3.Historia: ");
                            System.out.println("4.Podsumowanie: ");
                            System.out.println("5.Weź kredyt: ");
                            System.out.println("6.Spłać kredyt: ");
                            System.out.println("7.Przelew: ");
                            System.out.println("8.Stan Konta: ");
                            int option2 = scan.nextInt();
                            switch (option2) {

                                case 1:
                                    System.out.println("Ile chcesz wpłacić? ");
                                    int wplata = scan.nextInt();
                                    bank.Wplac(wplata);
                                    break;
                                case 2:
                                    System.out.println("Ile chcesz pobrać? ");
                                    int wyplata = scan.nextInt();
                                    bank.Pobierz(wyplata);
                                    break;
                                case 3:
                                    bank.Tranzakcje();
                                    break;
                                case 4:
                                    bank.Podsumowanie();
                                    break;
                                case 5:
                                    System.out.println("Ile chcesz wziąć kredytu: ");
                                    int kredyt = scan.nextInt();
                                    bank.Kredyty(kredyt);
                                    break;
                                case 6:
                                    bank.splacKredyt();
                                    break;
                                case 7:
                                    System.out.println("Ile chcesz wysłać?");
                                    int amount = scan.nextInt();
                                    String account1 = scan.nextLine();
                                    bank.Przelew(amount, account12);
                                    break;
                                case 8:
                                    bank.stanKonta();
                                    break;
                            }
                        } else {
                            System.out.println("Nieprawidłowy login albo hasło lub konto zostało zablokowane");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.exit(0);
                    break;
            }
        }while (true);
    }
}




