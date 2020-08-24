package com.skunk.letschat.di;

import androidx.lifecycle.ViewModelProvider;

import com.skunk.letschat.viewModels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory binViewModelFactory(ViewModelProviderFactory factory);
}
