package com.skunk.letschat.di;

import com.skunk.letschat.di.account.AccountViewModelModule;
import com.skunk.letschat.di.account.AccountModule;
import com.skunk.letschat.di.login.LoginViewModelModule;
import com.skunk.letschat.di.main.MainFragmentBuildersModule;
import com.skunk.letschat.di.main.MainModule;
import com.skunk.letschat.di.main.MainViewModelModule;
import com.skunk.letschat.di.message.MessageModule;
import com.skunk.letschat.di.message.MessageViewModelModule;
import com.skunk.letschat.di.profile.ProfileViewModelModule;
import com.skunk.letschat.di.register.RegisterViewModelModule;
import com.skunk.letschat.ui.account.AccountActivity;
import com.skunk.letschat.ui.login.LoginActivity;
import com.skunk.letschat.ui.main.MainActivity;
import com.skunk.letschat.ui.message.MessageActivity;
import com.skunk.letschat.ui.profile.ProfileActivity;
import com.skunk.letschat.ui.register.RegisterActivity;
import com.skunk.letschat.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {
            RegisterViewModelModule.class
    })
    abstract RegisterActivity contributeAuthActivity();

    @ContributesAndroidInjector(modules = {
            LoginViewModelModule.class
    })
    abstract LoginActivity contributeLoginActivity();

    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();

    @ContributesAndroidInjector(modules = {
            MainFragmentBuildersModule.class,
            MainViewModelModule.class,
            MainModule.class
    })
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = {
            AccountViewModelModule.class,
            AccountModule.class
    })
    abstract AccountActivity contributeAccountActivity();

    @ContributesAndroidInjector(modules ={
            ProfileViewModelModule.class
    })
    abstract ProfileActivity contributeProfileActivity();

    @ContributesAndroidInjector(modules = {
            MessageViewModelModule.class,
            MessageModule.class
    })
    abstract MessageActivity contributeMessageActivity();
}
