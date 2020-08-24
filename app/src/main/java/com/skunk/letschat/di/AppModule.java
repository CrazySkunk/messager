package com.skunk.letschat.di;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.skunk.letschat.R;
import com.skunk.letschat.data.repository.AuthRepository;
import com.skunk.letschat.data.repository.DatabaseRepository;
import com.skunk.letschat.dataSource.remote.FirebaseAuthSource;
import com.skunk.letschat.dataSource.remote.FirebaseDataSource;
import com.skunk.letschat.utils.GetTimeAgo;
import com.skunk.letschat.utils.LoadingDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    static FirebaseAuth getAuthInstance(){
        return FirebaseAuth.getInstance();
    }

    @Singleton
    @Provides
    static FirebaseFirestore provideFirebaseInstance(){
        return FirebaseFirestore.getInstance();
    }

    @Singleton
    @Provides
    static FirebaseAuthSource getAuthSource(FirebaseAuth firebaseAuth, FirebaseFirestore firebaseFirestore){
        return new FirebaseAuthSource(firebaseAuth,firebaseFirestore);
    }
    @Singleton
    @Provides
    static AuthRepository provideAuthRepository(FirebaseAuthSource authSource){
        return  new AuthRepository(authSource);
    }

    @Singleton
    @Provides
    static StorageReference provideStorageReference(){
        return FirebaseStorage.getInstance().getReference();
    }

    @Singleton
    @Provides
    static LoadingDialog provideLoadingDialog(){
        return new LoadingDialog();
    }

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions(){
        return RequestOptions.placeholderOf(R.drawable.avater)
                .error(R.drawable.avater);
    }
    @Singleton
    @Provides
    static RequestManager provideGlideInstance(Application application, RequestOptions requestOptions){
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Provides
    static FirebaseDataSource provideFirebaseDataSource(FirebaseAuthSource firebaseAuthSource, FirebaseFirestore firebaseFirestore, StorageReference storageReference){
        return new FirebaseDataSource(firebaseAuthSource,firebaseFirestore,storageReference);
    }

    @Provides
    static DatabaseRepository provideDatabaseRepository(FirebaseDataSource firebaseDataSource){
        return new DatabaseRepository(firebaseDataSource);
    }

    @Provides
    static GetTimeAgo provideGetTimeAgo(){
        return new GetTimeAgo();
    }
}
