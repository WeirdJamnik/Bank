package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    public int stanBanku = 100000000;
    public  int stanKonta, kredytyKont;
    private String login, password;
    public List<Account> accounts = new ArrayList<>();

    Bank(){

    }

    public void Zalogowany(String login, String password){
        this.login = login;
        this.password = password;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void removeAccount(String login){
        accounts.removeIf(account -> account.getLogin().equals(login));
    }

    public boolean Logowanie(String login, String password){
        for(Account account: accounts){
            if (account.access == false) {
                if (account.getLogin().equals(login) && account.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }

    public void Wplac(int kwota){
        for(Account account: accounts){
            if (login.equals(account.getLogin())){
                account.Wplac(kwota);
            }
        }
    }
    public void Pobierz(int kwota){
        for(Account account: accounts){
            if (login.equals(account.getLogin())){
                account.Pobierz(kwota);
            }
        }
    }
    public void stanKonta(){
        for (Account account: accounts){
            if (login.equals(account.getLogin())){
                account.Stan();
            }
        }
    }
    public Object Tranzakcje(){
        StringBuilder stringBuilder = new StringBuilder("Account list: \n");
        for (Account account:accounts)
            if (login.equals(account.getLogin())) {
                stringBuilder.append(account.Tranzakcje() + "\n");
            }
        return String.valueOf(stringBuilder);
    }


    public void Kredyty(int kwota){
        for (Account account: accounts){
            if (login.equals(account.getLogin())){
                account.Kredyt(kwota);
            }
        }
    }
    public void splacKredyt() {
        for (Account account : accounts) {
            if (login.equals(account.getLogin())) {
                account.splacKredyt();
            }
        }
    }
    public void Podsumowanie() {
        for (Account account : accounts) {
            if (login.equals(account.getLogin())) {
                account.Podsumowanie();
            }
        }
    }

    public void Przelew(int kwota, Account account1){
        for (Account account : accounts) {
            if (login.equals(account.getLogin())) {
                account.Przelew(kwota, account1);
            }
        }
    }

    public void podsumowanieKont(){
        for(Account account: accounts){
            if (login.equals(account.getLogin())) {
                stanKonta += account.getStan();
            }
        }
        for (Account account: accounts){
            if (login.equals(account.getLogin())) {
                kredytyKont += account.getKredyt();
            }
        }
        System.out.println("Stan wszystkich kont: "+ stanKonta);
        System.out.println("Kredyty kont: "+ kredytyKont);
    }

    public Object showTab(){
        StringBuilder stringBuilder = new StringBuilder("Account list: \n");

        for (Account account:accounts)
            stringBuilder.append(account + "\n");

        return String.valueOf(stringBuilder);
    }

    public void Access(String login){
        for (Account account: accounts){
            if (login.equals(account.getLogin())){
                account.access = true;
                System.out.println("Użytkownik: "+login+"został zablokowany");
            }
        }
    }




}
