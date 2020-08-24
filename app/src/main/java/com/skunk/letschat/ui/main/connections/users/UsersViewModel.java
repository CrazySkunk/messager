package com.skunk.letschat.ui.main.connections.users;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class UsersViewModel extends ViewModel {

    private static final String TAG = "UsersViewModel";

    @Inject
    public UsersViewModel() {
        Log.d(TAG, "UsersViewModel: working");
    }

}
