package com.practice_thread_pool;

import java.util.concurrent.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;


public class practice_thread_pool {
    static int count = 0;
    public static void main(String [] args){
        ExecutorService es = Executors.newFixedThreadPool(2);
        System.out.println("Hello, thread pool!");
        while(count<100){

            Runnable job = new Runnable() {
                public void run() {

                    ThreadPoolExecutor tpe = (ThreadPoolExecutor) es;
                    int poolSize = tpe.getPoolSize();
                    String tName = Thread.currentThread().getName();
                    count = count + 1;
                    System.out.println("The number of Thread : " + poolSize);
                    System.out.println("Thread Name : " + tName);
                    System.out.println("count : " + count);
                }
            }; // Runnable instance_name = new Runnable(){}; << semicolon is required.
            es.execute(job);

        }
    }
}
