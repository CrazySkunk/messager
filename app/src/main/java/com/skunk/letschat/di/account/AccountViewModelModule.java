package com.skunk.letschat.di.account;

import androidx.lifecycle.ViewModel;

import com.skunk.letschat.di.ViewModelKey;
import com.skunk.letschat.ui.account.AccountViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AccountViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AccountViewModel.class)
    public abstract ViewModel binViewModel(AccountViewModel viewModel);
}
