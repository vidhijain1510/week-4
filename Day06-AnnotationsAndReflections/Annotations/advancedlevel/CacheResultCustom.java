/*7️⃣ Implement a Custom Caching System with @CacheResult
✅ Problem Statement:
Define @CacheResult to store method return values and avoid repeated execution.
🔹 Requirements:
Apply @CacheResult to a computationally expensive method.
Implement a cache (HashMap) to store previously computed results.
If method is called with the same input, return cached result instead of re-computation.
*/
package com.capgeminitraining.week4.day6annotationsreflection.annotations.advancedlevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class CacheProxyHandler implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public CacheProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String key = method.getName() + "(" + (args != null ? args[0] : "") + ")";
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for: " + key);
                return cache.get(key);
            }
            Object result = method.invoke(target, args);
            cache.put(key, result);
            return result;
        }
        return method.invoke(target, args);
    }

    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class[]{interfaceType},
                new CacheProxyHandler(target)
        );
    }
}

interface ExpensiveComputation {
    @CacheResult
    int computeFactorial(int number);
}

class ExpensiveComputationImpl implements ExpensiveComputation {
    @Override
    public int computeFactorial(int number) {
        System.out.println("Computing factorial for: " + number);
        return factorial(number);
    }

    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

public class CacheResultCustom{
    public static void main(String[] args) {
        ExpensiveComputation computation = CacheProxyHandler.createProxy(new ExpensiveComputationImpl(), ExpensiveComputation.class);
        System.out.println("Factorial: " + computation.computeFactorial(5));
        System.out.println("Factorial: " + computation.computeFactorial(5));
        System.out.println("Factorial: " + computation.computeFactorial(6));
    }
}

