package com.tss.dip;

public class ShoppingCart {
    CreditCard payment = new CreditCard();

    public void checkOut() {
        payment.payment(300);
    }
}