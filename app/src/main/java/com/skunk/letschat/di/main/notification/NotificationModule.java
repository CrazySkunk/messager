package com.skunk.letschat.di.main.notification;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.skunk.letschat.adapter.RequestRecyclerAdapter;
import com.skunk.letschat.data.model.Request;
import com.skunk.letschat.data.repository.DatabaseRepository;
import com.skunk.letschat.utils.GetTimeAgo;

import dagger.Module;
import dagger.Provides;

@Module
public class NotificationModule {

    @Provides
    static FirestoreRecyclerOptions<Request> provideRequestOptions(DatabaseRepository databaseRepository){
        return databaseRepository.getRequestList();
    }

    @Provides
    static RequestRecyclerAdapter provideRequestAdapter(FirestoreRecyclerOptions<Request> options, DatabaseRepository databaseRepository, GetTimeAgo getTimeAgo){
        return new RequestRecyclerAdapter(options,databaseRepository,getTimeAgo);
    }
}
