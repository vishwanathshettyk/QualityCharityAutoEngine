package org.automation.practices.utils;

import java.util.Arrays;
import java.util.List;

public class ControllersList {

    private final String[] click = new String[]{"clicks","click","press","presses"};

    public String getController(String input)
    {
       List<String> a =  Arrays.stream(click).filter(x -> x.equalsIgnoreCase(input)).toList();
       if(a.contains(input))
       {
           return "click";
       }
       return null;
    }


    public String getWebElement()
    {
        return "f";
    }
}
