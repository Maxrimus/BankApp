package com.ex;

public enum  User {
    Customer(0),
    Employee(1),
    Admin(2);

    int i;

    public int getI() {
        return i;
    }

    User(int i){
        this.i = i;
    }
}
