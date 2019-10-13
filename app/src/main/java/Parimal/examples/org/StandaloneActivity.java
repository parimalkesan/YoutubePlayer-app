package Parimal.examples.org;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button btnPlayVideo=(Button)findViewById(R.id.buttonPlayVideo);
        Button btnPlaylist=(Button)findViewById(R.id.buttonPlaylist);

        btnPlayVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);

//        View.OnClickListener onClickListener=new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        };
//
//        btnPlayVideo.setOnClickListener(onClickListener);
//        btnPlaylist.setOnClickListener(onClickListener);
//
//        btnPlayVideo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch(view.getId())
        {
            case R.id.buttonPlayVideo:
                intent= YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_VIDEO_ID,0,true,false);
                break;
            case R.id.buttonPlaylist:
                intent=YouTubeStandalonePlayer.createPlaylistIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_PLAYLIST,0,0,true,true);
                break;
            default:
        }
        if(intent!=null)
        {
            startActivity(intent);
        }
    }
}
