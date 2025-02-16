/*Method Execution Timing: Use Reflection to measure the execution time of methods in a given class dynamically.*/
package com.capgeminitraining.week4.day6annotationsreflection.reflections.advancedlevel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class TimingProxyHandler implements InvocationHandler {
    private final Object target;

    public TimingProxyHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime(); // Start time measurement
        Object result = method.invoke(target, args);
        long endTime = System.nanoTime(); // End time measurement

        long executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println("Method " + method.getName() + " executed in " + executionTime + " ms");

        return result;
    }
}

class TimingProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class[]{interfaceType},
                new TimingProxyHandler(target)
        );
    }
}

interface Task {
    void execute();
}

// Step 2: Implement the interface
class TaskImpl implements Task {
    @Override
    public void execute() {
        try {
            Thread.sleep(500); // Simulating a time-consuming task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task executed.");
    }
}

public class ExecutionTiming {
    public static void main(String[] args) {
        Task realTask = new TaskImpl();
        Task timedTask = TimingProxyFactory.createProxy(realTask, Task.class);
        timedTask.execute();
    }
}


