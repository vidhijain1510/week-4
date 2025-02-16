/*5️⃣ Implement a Role-Based Access Control with @RoleAllowed
✅ Problem Statement:
Define a class-level annotation @RoleAllowed to restrict method access based on roles.
🔹 Requirements:
@RoleAllowed("ADMIN") should only allow ADMIN users to execute the method.
Simulate user roles and validate access before invoking the method.
If a non-admin tries to access it, print Access Denied!
*/
package com.capgeminitraining.week4.day6annotationsreflection.annotations.advancedlevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) //Available at runtime for reflection
@Target(ElementType.METHOD) //Can only be applied to methods
@interface RoleAllowed {
    String value();
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class SecureService {

    @RoleAllowed("ADMIN") //Only ADMIN can execute this
    public void performAdminTask() {
        System.out.println("Admin task executed!");
    }

    public void performGeneralTask() {
        System.out.println("General task executed!");
    }
    public static void executeMethod(User user, Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (!roleAllowed.value().equals(user.getRole())) {
                    System.out.println("❌ Access Denied for " + user.getRole() + " to execute " + methodName);
                    return;
                }
            }
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) {
        SecureService service = new SecureService();

        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        //Admin can execute performAdminTask
        SecureService.executeMethod(adminUser, service, "performAdminTask");

        //Normal user should be denied access
        SecureService.executeMethod(normalUser, service, "performAdminTask");

        //Both can execute performGeneralTask
        SecureService.executeMethod(normalUser, service, "performGeneralTask");
    }
}

