package com.App.classnotification.models.User;

import com.App.classnotification.models.Noti.Noti;

import java.util.ArrayList;

public class User {

    private String firstName;

    private String lastName;

    private String userName;

    private String passWord;

    private ArrayList<Noti> notificationArrayList;

    public User( String firstName,
                 String lastName,
                 String userName,
                 String passWord ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;


    }

    public User( String firstName,
                 String lastName,
                 String userName,
                 String passWord,
                 ArrayList<Noti> notificationArrayList ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.notificationArrayList = notificationArrayList;


    }


}
