package com.skunk.letschat.di.login;

import androidx.lifecycle.ViewModel;

import com.skunk.letschat.di.ViewModelKey;
import com.skunk.letschat.ui.login.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class LoginViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bindViewModel(LoginViewModel viewModel);

}
