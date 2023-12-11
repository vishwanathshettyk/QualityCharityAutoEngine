package org.automation.practices.pages;

import org.junit.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BasePage {

    public Object initPage(Class clazz) throws InstantiationException, IllegalAccessException {
        Object clz = clazz.newInstance();
        return clz;
    }
    public void getInstanceOfPage(Object testPage,String methodName, String... arg) {
        // TestPage testPage = new TestPage();
        try {
            Class obj = testPage.getClass();
            Method[] methods = obj.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equalsIgnoreCase(method.getName())) {
                    method.invoke(testPage, arg);
                }
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Throwable t = e.getCause();
            System.out.println(t.getMessage());
            String fx = e.getMessage();

            e.printStackTrace();
            Assert.fail(String.format("Method '%s' or locator not found",methodName));
            // throw new RuntimeException();
        }
    }

}
