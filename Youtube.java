package com.example.evi.mobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
public class Youtube extends YouTubeBaseActivity {
    public static final String API_KEY = "AIzaSyBq_Ug0LiimVLnGlUrQ-QFkJgXZZDrSza4";
    Button b_euronews, b_amea;
    private YouTubePlayerView euronews, newsit;
    private YouTubePlayer.OnInitializedListener listener1, listener2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);


        euronews= (YouTubePlayerView)findViewById(R.id.youtube_player1); //euronews
        newsit = (YouTubePlayerView)findViewById(R.id.youtube_player2);  //newsit



        listener1= new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("euronewsGreek");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        listener2= new YouTubePlayer.OnInitializedListener(){

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("UCKSy_Ozn_Crr2CN-QUVNETw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        b_euronews = (Button)findViewById(R.id.play);   //euronews
        b_euronews.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                euronews.initialize(API_KEY, listener1);
            }
        });


        b_amea = (Button)findViewById(R.id.news_button);   //newsitamea
        b_amea.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                newsit.initialize(API_KEY, listener2);
            }
        });


    }
}
