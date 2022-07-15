package com.biji.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.biji.api.adapter.adapter;
import com.biji.api.api.endpoint;
import com.biji.api.api.service;
import com.biji.api.model.plane;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = BuildConfig.API_KEY;
    private adapter viewAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    viewAdapter = new adapter (this);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView = findViewById(R.id.planes);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(viewAdapter);

    dataPlanes();
    }

    private void dataPlanes(){
        service api = endpoint.getClient().create(service.class);
        Call<List<plane>>Call = api.groupList(API_KEY);
        Call.enqueue(new Callback<List<plane>>() {
            @Override
            public void onResponse(retrofit2.Call<List<plane>> call, Response<List<plane>> response) {
                viewAdapter.setPlaneList(response.body());
            }

            @Override
            public void onFailure(retrofit2.Call<List<plane>> call, Throwable t) {

            }
        });
    }
}