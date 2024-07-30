package org.example;

public class Client {
    private String idCompte;
    private String nom;
    private String prenom;
    private int balance;

    public Client(String idCompte, String nom, String prenom, int balance) {
        this.idCompte = idCompte;
        this.nom = nom;
        this.prenom = prenom;
        this.balance = balance;
    }

    public String getIdCompte() {
        return idCompte;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return idCompte + " " + nom + " " + prenom + " " + balance;
    }
}
