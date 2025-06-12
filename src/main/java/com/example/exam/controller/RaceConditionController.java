package com.example.exam.controller;

import com.example.exam.service.SalaryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/race")
public class RaceConditionController {
    private final SalaryService salaryService;

    public RaceConditionController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping("/unsafe") // race condition simulation
    public String simulateUnsafe() throws InterruptedException {
        salaryService.reset();

        Thread t1 = new Thread(salaryService::unsafeIncrement);
        Thread t2 = new Thread(salaryService::unsafeIncrement);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        return "Final salary after unsafe deduction: " + salaryService.getSalary();
    }

    @PostMapping("/safe") // safe operation simulation
    public String simulateSafe() throws InterruptedException {
        salaryService.reset();

        Thread t1 = new Thread(salaryService::safeIncrement);
        Thread t2 = new Thread(salaryService::safeIncrement);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        return "Final salary after safe deduction: " + salaryService.getSalary();
    }
}
