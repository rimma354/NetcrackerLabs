package com.netcracker.labs;

import javax.ejb.Local;

@Local
public interface CalculatorBeanLocal {
    void setX(double x);
    double getX();
    void setY(double y);
    double getY();
    double getResult();
    void add ();
    void substract ();
    void multiply ();
    void divide ();
    void saveInMemory();
    void setYFromMemory();
    void setXFromMemory();
    void clearMemory();
    public double getMemory();
}
