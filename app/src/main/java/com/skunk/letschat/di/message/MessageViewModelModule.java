package com.skunk.letschat.di.message;

import androidx.lifecycle.ViewModel;

import com.skunk.letschat.di.ViewModelKey;
import com.skunk.letschat.ui.message.MessageViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MessageViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MessageViewModel.class)
    public abstract ViewModel bindMessageViewModel(MessageViewModel viewModel);
}
