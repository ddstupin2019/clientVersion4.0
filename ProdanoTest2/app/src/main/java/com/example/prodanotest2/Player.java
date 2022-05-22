package com.example.prodanotest2;

import java.util.ArrayList;

public class Player {
    private int id;
    private int nam;
    private int maxPlayer;
    private int balance;
    private ArrayList<Integer> nedCol,carts;

    public ArrayList<Integer> getCarts() {
        return carts;
    }

    public void setCarts(ArrayList<Integer> carts) {
        this.carts = carts;
    }

    public ArrayList<Integer> getNedCol() {
        return nedCol;
    }

    public void setNedCol(ArrayList<Integer> nedCol) {
        this.nedCol = nedCol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }
}
