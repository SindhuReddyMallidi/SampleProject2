package com.example.sindhu.sampleproject2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class MainActivity extends AppCompatActivity {
    SimpleExoPlayerView xo;
    SimpleExoPlayer qw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xo=findViewById(R.id.id1);
        BandwidthMeter bm=new DefaultBandwidthMeter();
        TrackSelector ts=new DefaultTrackSelector( new AdaptiveTrackSelection.Factory(bm));
        qw= ExoPlayerFactory.newSimpleInstance(this,ts);
        Uri uri=Uri.parse("\n" + getString(R.string.link));
        DefaultHttpDataSourceFactory defaultHttpDataSourceFactory=new DefaultHttpDataSourceFactory("player");
        ExtractorsFactory ef=new DefaultExtractorsFactory();
        MediaSource ms=new ExtractorMediaSource(uri,defaultHttpDataSourceFactory,ef,null,null);
        xo.setPlayer(qw);
        qw.prepare(ms);
        qw.setPlayWhenReady(true);
    }
    @Override
    protected void onStop() {
        super.onStop();
        qw.stop();
    }
}

