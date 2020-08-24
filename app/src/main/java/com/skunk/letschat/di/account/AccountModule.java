package com.skunk.letschat.di.account;

import com.skunk.letschat.utils.InputDialog;

import dagger.Module;
import dagger.Provides;

@Module
public class AccountModule {

    @Provides
    static InputDialog provideDialog(){
        return new InputDialog();
    }
}
