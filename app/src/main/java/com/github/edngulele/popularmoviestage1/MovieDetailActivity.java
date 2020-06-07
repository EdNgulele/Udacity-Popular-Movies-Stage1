package com.github.edngulele.popularmoviestage1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.edngulele.popularmoviestage1.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {


    private ImageView backdrop;
    private ImageView poster;
    private TextView title;
    private TextView rating;
    private TextView plot;
    private TextView releaseDate;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        backdrop = findViewById(R.id.iv_movie_backdrop);
        poster = findViewById(R.id.iv_movie_poster_detail);
        title = findViewById(R.id.tv_movie_title);
        rating = findViewById(R.id.tv_movie_rating);
        plot = findViewById(R.id.tv_movie_overview);
        releaseDate = findViewById(R.id.tv_movie_release_date);


        //Receive the Movie data from MainActivity
        Bundle bundle = getIntent().getExtras();
        Movie movie = (Movie) bundle.getSerializable(getApplicationContext().getString(R.string.bundle_key));
        getMovieData(movie);

    }

    private void getMovieData(Movie movie) {
        Glide.with(this)
                .load(imagePath(movie.getBackdropPath()))
                .into(backdrop);

        Glide.with(this)
                .load(imagePath(movie.getPosterPath()))
                .into(poster);

        title.setText(movie.getTitle());
        rating.setText(String.format("%s/10", movie.getVoteAverage()));
        plot.setText(movie.getOverview());
        releaseDate.setText(movie.getReleaseDate());
    }

    public static String imagePath(String path) {
        return "https://image.tmdb.org/t/p/" +
                "w500" +
                path;
    }
}
