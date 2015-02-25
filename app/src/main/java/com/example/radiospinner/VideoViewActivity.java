package com.example.radiospinner;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

/**
 * Created by Manjinder singh on 12-02-2015.
 */
public class VideoViewActivity extends Activity implements TextureView.SurfaceTextureListener{
    private MediaPlayer mMediaPlayer;

    private static final String TAG = VideoViewActivity.class.getName();

    // Asset video file name.
    private static final String FILE_NAME = "sheeshe.mp4";
    VideoView videoView;
    Uri video=Uri.parse("android.resource://com.example.radiospinner/raw/sheeshe");

    TextureView textureView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view_layout);
        initViews();
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.setVideoURI(video);
        videoView.requestFocus();

        videoView.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void initViews(){
        videoView=(VideoView) findViewById(R.id.videoView);
        textureView=(TextureView) findViewById(R.id.textureView);
        textureView.setSurfaceTextureListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        try {
            AssetFileDescriptor afd = getAssets().openFd(FILE_NAME);
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mMediaPlayer.setSurface(surface);
            mMediaPlayer.setLooping(true);
            mMediaPlayer.prepareAsync();

            // Play video when the media source is ready for playback.
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

        } catch (IllegalArgumentException e) {
            Log.d(TAG, e.getMessage());
        } catch (SecurityException e) {
            Log.d(TAG, e.getMessage());
        } catch (IllegalStateException e) {
            Log.d(TAG, e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }
}
