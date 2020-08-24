package com.skunk.letschat.di.main;

import com.skunk.letschat.di.main.chat.ChatModule;
import com.skunk.letschat.di.main.notification.NotificationModule;
import com.skunk.letschat.di.main.users.UserModule;
import com.skunk.letschat.ui.main.connections.chat.ChatFragment;
import com.skunk.letschat.ui.main.connections.notification.NotificationFragment;
import com.skunk.letschat.ui.main.connections.users.UsersFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector(modules = {
            UserModule.class
    })
    abstract UsersFragment contributeUsersFragment();

    @ContributesAndroidInjector(modules = {
            NotificationModule.class
    })
    abstract NotificationFragment contributeNotificationFragment();

    @ContributesAndroidInjector(modules = {
            ChatModule.class
    })
    abstract ChatFragment contributeChatFragment();
}
