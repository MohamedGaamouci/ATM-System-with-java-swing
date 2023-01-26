/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easy.bank;

public class user {
String name;
int pin ,balance;
double card_num ;

    public user(String name, double card_num ,int pin ,int balance) {
    this.name = name;
    this.card_num = card_num;
    this.pin = pin;
    this.balance = balance;
    }
String getname(){
    return name;
}
    double getcard_num(){return card_num;}
    int getpin(){return pin;}
    int getbalance(){return balance;}
}
