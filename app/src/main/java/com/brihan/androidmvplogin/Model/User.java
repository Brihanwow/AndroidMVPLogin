package com.brihan.androidmvplogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User implements IUser{

    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        //1. Revisar que el email esta vacio
        //2.Verificar que el email coincida con el patrón
        //3. Verificar que la contraseña > 6

        if(TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;

        else if (getPassword().length() <= 6)
            return 2;
        else
            return -1;

    }
}
