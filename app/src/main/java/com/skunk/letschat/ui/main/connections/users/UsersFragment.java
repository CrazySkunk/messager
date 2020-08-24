package com.skunk.letschat.ui.main.connections.users;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.skunk.letschat.R;
import com.skunk.letschat.adapter.UsersRecyclerAdapter;
import com.skunk.letschat.ui.profile.ProfileActivity;
import com.skunk.letschat.viewModels.ViewModelProviderFactory;
import com.google.firebase.firestore.DocumentSnapshot;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends DaggerFragment implements UsersRecyclerAdapter.UserListener {

    private static final String TAG = "UsersFragment_Tag";

    private UsersViewModel usersViewModel;
    private RecyclerView recyclerView;

    @Inject
    UsersRecyclerAdapter recyclerAdapter;
    @Inject
    RequestManager requestManager;
    @Inject
    ViewModelProviderFactory providerFactory;

    public UsersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        usersViewModel = new ViewModelProvider(getViewModelStore(),providerFactory).get(UsersViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerView);
        setRecyclerView();
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setClickListener(this);
        recyclerAdapter.startListening();
    }


    @Override
    public void onStop() {
        super.onStop();
        recyclerAdapter.stopListening();
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerAdapter.startListening();
    }

    @Override
    public void onUserClick(DocumentSnapshot documentSnapshot) {
        moveToProfileActivity(documentSnapshot.getId());
    }

    private void moveToProfileActivity(String id) {
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        intent.putExtra("key_uid",id);
        startActivity(intent);
    }
}
