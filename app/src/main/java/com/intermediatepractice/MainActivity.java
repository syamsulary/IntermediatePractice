package com.intermediatepractice;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mAdapter;
    private Context context = this;
    private RecyclerView recyclerView;
    private List<MainDao> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        mAdapter = new MainAdapter(data);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(layoutManager);

        ApiClient.service().getMovieList( "1f6463c49a537cbc08b1712f42546e6f")
                .enqueue(new Callback<MovieResponseDao>() {
                    @Override
                    public void onResponse(Call<MovieResponseDao> call, Response<MovieResponseDao> response) {
                        if (response.isSuccessful()) {
                            for (MovieResponseDao.MovieData movieData : response.body().getResults()) {
                                data.add(new MainDao( movieData.getTitle(), "https://image.tmdb.org/t/p/w185/"+movieData.getPoster_path()));
                            }
                        } mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<MovieResponseDao> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                data.add(new MainDao("1", "http://bennettmining.com/wp-content/uploads/2014/08/team3.jpg"));
//                data.add(new MainDao("2", "http://bennettmining.com/wp-content/uploads/2014/08/team3.jpg"));
//                data.add(new MainDao("3", "http://bennettmining.com/wp-content/uploads/2014/08/team3.jpg"));
//                data.add(new MainDao("4", "http://bennettmining.com/wp-content/uploads/2014/08/team3.jpg"));
//                data.add(new MainDao("5", "http://bennettmining.com/wp-content/uploads/2014/08/team3.jpg"));
//
//                mAdapter.notifyDataSetChanged();
//            }
//        }, 5000);

        Toast.makeText(context, "Loading 5 Detik", Toast.LENGTH_SHORT).show();
    }
}
