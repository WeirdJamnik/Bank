package Bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    String login, password;
    int stan, wplaty, wyplaty, kredyt, mozliwoscKredytowa;
    List<Integer> tranzakcje = new ArrayList<Integer>();
    List<String> kredyty = new ArrayList<String>();
    boolean access = false;
    Bank bank;

    public Account(String login, String password, int stan) {
        this.login = login;
        this.password = password;
        this.stan = stan;
        this.wplaty = 0;
        this.wyplaty = 0;
        this.mozliwoscKredytowa = 0;
        this.access = false;
        tranzakcje = new ArrayList<Integer>();
        kredyty = new ArrayList<String>();
    }

    public List<Integer> getTranzakcje() {
        return tranzakcje;
    }

    public List<String> getKredyty() {
        return kredyty;
    }

    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public int getStan(){
        return stan;
    }
    public int getKredyt(){
        return kredyt;
    }

    public void Stan(){
        System.out.println("Stan: " + stan);
    }

    public void Wplac(int kwota){
        stan += kwota;
        wplaty += kwota;
        tranzakcje.add(kwota);
        System.out.println("Wpłaciłeś: " + kwota);

    }

    public void Pobierz(int kwota){
        if(stan - kwota >= 0) {
            stan -= kwota;
            wyplaty += kwota;
            tranzakcje.add(-kwota);
            System.out.println("Wypłaciłeś: " + kwota);

        }else{
            System.out.println("Nie posiadasz: " + kwota);
        }
    }

    public void Kredyt(int kwota){
        if (mozliwoscKredytowa == 0) {
            stan += kwota;
            kredyt += kwota;
            mozliwoscKredytowa++;
            wyplaty += kwota;
            tranzakcje.add(kwota);
            System.out.println("Pobrano kredyt w wysokości: "+kwota);
        }else {
            System.out.println("Musisz najepirw splacić poprzedni kredyt w wysokości: " + kredyt);
        }
    }

    public void splacKredyt(){
        if(stan >= kredyt) {
            stan -= kredyt;
            wyplaty += kredyt;
            tranzakcje.add(-kredyt);
            mozliwoscKredytowa--;
            System.out.println("Spłaciłeś kredyt o wielkości: " + kredyt);
        }
        else {
            System.out.println("Nie można spłacic kredytu");
        }
    }

    public void Przelew(int kwota, Account account){
        if(this.stan < kwota){
            System.out.println("Nie ma wystarczającej gotówki");
        }
        else{
            this.stan -= kwota;
            account.stan += kwota;
            System.out.println("Stan konta tego uzytkownika: " + this.login + " wynosi teraz: "+
                    this.stan);
            System.out.println("Stan konta tego użytkownika: " + account.login + " wynosi teraz: "+
                    account.stan);
        }
    }

    public void Podsumowanie(){
        System.out.println("Suma wszystkich wpłat: " + wplaty + "\n" + "Suma wszystkich wyplat: " + wyplaty);
    }


    public List<Integer> Tranzakcje(){
        return tranzakcje;
    }

    public String toString()
    {
        return "Login: "+ login + " password: " + password;
    }



}

