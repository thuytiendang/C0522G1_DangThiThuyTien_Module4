package com.book_borrowing.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LibraryAspect {
    private int count = 0;

    @Pointcut("within(com.book_borrowing.controller.LibraryController*)")
    public void allMethod() {
    }

    @After("allMethod()")
    public void afterAllMethod(JoinPoint joinPoint) {
        count++;
        System.err.println("Method name: " + joinPoint.getSignature().getName() +
                count + " times");
    }

    @Pointcut("execution(* com.book_borrowing.controller.LibraryController.save*(..))")
    public void payAndBorrowMethod() {
    }

    @After("payAndBorrowMethod()")
    public void afterPayAndBorrowMethod(JoinPoint joinPoint) {
        System.err.println("Method name: " + joinPoint.getSignature().getName() + " | Time: " + LocalDateTime.now());
    }

}
