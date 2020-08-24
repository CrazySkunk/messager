package com.skunk.letschat.di.main.chat;

import com.bumptech.glide.RequestManager;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.skunk.letschat.adapter.ChatRecyclerAdapter;
import com.skunk.letschat.data.model.Request;
import com.skunk.letschat.data.repository.DatabaseRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class ChatModule {

    @Provides
    static FirestoreRecyclerOptions<Request> provideRequestOptions(DatabaseRepository databaseRepository){
        return databaseRepository.getFriendList();
    }

    @Provides
    static ChatRecyclerAdapter provideRecyclerAdapter(FirestoreRecyclerOptions<Request> options, DatabaseRepository databaseRepository, RequestManager requestManager){
        return new ChatRecyclerAdapter(options,databaseRepository,requestManager);
    }
}
