package com.skunk.letschat.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.skunk.letschat.HomeActivity;
import com.skunk.letschat.ui.main.MainActivity;
import com.skunk.letschat.data.repository.AuthRepository;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SplashActivity extends DaggerAppCompatActivity {

    @Inject
    AuthRepository authRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Change Activity
        if (authRepository.getCurrentUser() != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }

    }
}
