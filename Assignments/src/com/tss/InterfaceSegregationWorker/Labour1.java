package com.tss.InterfaceSegregationWorker;

public class Labour1 implements IWorker1 {

    @Override
    public void start() {
        System.out.println("Labour starting work.");
    }

    @Override
    public void stop() {
        System.out.println("Labour stopping work.");
    }

    @Override
    public void eat() {
        System.out.println("Labour taking lunch.");
    }

    @Override
    public void rest() {
        System.out.println("Labour taking rest.");
    }
}

