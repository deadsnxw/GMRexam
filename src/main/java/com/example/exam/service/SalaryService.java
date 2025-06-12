package com.example.exam.service;

import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    private int salary = 0;

    public void reset() {
        salary = 0;
    }

    public void unsafeIncrement() {
        for (int i = 0; i < 1000; i++) {
            int temp = salary;
            Thread.yield(); // cuz of the speed of execution, this line is added to give a chance for context switching
            salary = temp + 1;
        }
    }

    public synchronized void safeIncrement() {
        for (int i = 0; i < 1000; i++) {
            salary++;
        }
    }

    public int getSalary() {
        return salary;
    }
}
