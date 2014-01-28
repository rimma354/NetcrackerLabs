package com.netcracker.labs;

import javax.ejb.Stateless;

@Stateless (name="CalcBean")
public class CalculatorBean implements CalculatorBeanLocal {
    private double x;
    private double y;
    private double result;
    private double  memory;
    
    public CalculatorBean(){
        
    }
    
    @Override 
    public void setX(double x){
        this.x=x;
    }
    
    @Override  
    public double getX(){
        return this.x;
    }
    
    @Override
    public void setY(double y){
        this.y=y;
    }
    
    @Override 
    public double getY(){
        return this.y;
    }
    
    @Override
    public double getResult(){
        return result;
    }
    
    @Override
    public void add() {
        result= x+y;
    }

    @Override
    public void substract() {
        result= x-y;
    }

    @Override
    public void multiply() {
        result= x*y;
    }

    @Override
    public void divide() {
        result= x/y;
    }

    @Override
    public void saveInMemory() {
        this.memory=this.result;
    }

    @Override
    public void setYFromMemory() {
        this.y=memory;
    }

    @Override
    public void setXFromMemory() {
        this.x=memory;
    }

    @Override
    public void clearMemory() {
        this.memory=0;
    }
    public double getMemory(){
        return memory;
    }

}
