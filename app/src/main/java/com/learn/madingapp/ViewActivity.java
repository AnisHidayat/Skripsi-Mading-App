package com.learn.madingapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.learn.madingapp.adapter.MadingAdapter;
import com.learn.madingapp.api.RegisterAPI;
import com.learn.madingapp.model.Mading;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewActivity extends AppCompatActivity {
    public static final String URL = "http://10.0.2.2/mading-online/api/";
    private List<Mading> listMading = new ArrayList<>();
    private MadingAdapter madingAdapter;
    @BindView(R.id.recycler_view)RecyclerView recyclerView;
    @BindView(R.id.progress_bar)ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("Mading SMP YASMI");
        }

        ButterKnife.bind(this);
        madingAdapter = new MadingAdapter(this, (ArrayList<Mading>) listMading) {
            @Override
            public void onClick(View v) {

            }
        };
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(madingAdapter);

        loadMading();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadMading();
    }

    private void loadMading() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<List<Mading>> call = api.view();
        call.enqueue(new Callback<List<Mading>>() {
            @Override
            public void onResponse(Call<List<Mading>> call, Response<List<Mading>> response) {
                progressBar.setVisibility(View.GONE);
                listMading = response.body();
                madingAdapter = new MadingAdapter(ViewActivity.this, (ArrayList<Mading>) listMading) {
                    @Override
                    public void onClick(View v) {

                    }
                };
                recyclerView.setAdapter(madingAdapter);
            }

            @Override
            public void onFailure(Call<List<Mading>> call, Throwable t) {
                t.printStackTrace();
                System.out.println("gagal nih");
            }
        });
    }
}
