package com.mac.musicwiki.album.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mac.musicwiki.MainActivity;
import com.mac.musicwiki.R;
import com.mac.musicwiki.search.model.Datum;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumActivity extends AppCompatActivity {
    @BindView(R.id.imageAlbum) ImageView imgCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ButterKnife.bind(this);
        Intent i = getIntent();
        Datum item =  (Datum) i.getSerializableExtra("album");
        Glide.with(AlbumActivity.this).load(item.getAlbum().getCover()).into(imgCover);
    }
}
