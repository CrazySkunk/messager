package com.skunk.letschat.di.profile;

import androidx.lifecycle.ViewModel;

import com.skunk.letschat.di.ViewModelKey;
import com.skunk.letschat.ui.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ProfileViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindViewModel(ProfileViewModel profileViewModel);
}
