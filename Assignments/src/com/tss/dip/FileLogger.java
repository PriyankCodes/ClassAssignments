package com.tss.dip;

public class FileLogger implements ILogger {
    @Override
    public void log(String err) {
        System.out.println("FileLogger: Logged to file -> " + err);
    }
}