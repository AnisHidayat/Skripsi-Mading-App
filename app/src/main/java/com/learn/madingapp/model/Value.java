package com.learn.madingapp.model;

import java.util.List;

public class Value {
    String value;
    String message;
    List<Mading> result;

    public String getValue(){
        return value;
    }
    public String getMessage(){
        return message;
    }

    public List<Mading> getResult(){
        return result;
    }
}
