package com.brihan.androidmvplogin.Presenter;

import com.brihan.androidmvplogin.MainActivity;
import com.brihan.androidmvplogin.Model.User;
import com.brihan.androidmvplogin.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter (MainActivity loginView) {
        this.loginView = loginView;

    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User (email,password);
        int loginCode = user.isValidData ();

        if(loginCode == 0)
            loginView.onLoginError("Debe ingresar su Email");
        else if (loginCode == 1)
            loginView.onLoginError("Debe ingresar un email valido");
        else if (loginCode == 2)
            loginView.onLoginError("La contraseña debe tener mas de 6 caracteres");
        else
            loginView.onLoginSuccess("Ingreso correcto");
    }
}
