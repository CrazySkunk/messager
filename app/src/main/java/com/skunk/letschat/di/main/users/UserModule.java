package com.skunk.letschat.di.main.users;

import android.app.Application;

import com.bumptech.glide.RequestManager;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.skunk.letschat.adapter.UsersRecyclerAdapter;
import com.skunk.letschat.data.model.User;
import com.skunk.letschat.data.repository.DatabaseRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {


    @Provides
    static FirestoreRecyclerOptions<User> provideOption(DatabaseRepository databaseRepository){
        return databaseRepository.getUserList();
    }

    @Provides
    static UsersRecyclerAdapter provideAdapter(FirestoreRecyclerOptions<User> options, RequestManager requestManager, Application application){
        return new UsersRecyclerAdapter(options,requestManager);
    }
}
