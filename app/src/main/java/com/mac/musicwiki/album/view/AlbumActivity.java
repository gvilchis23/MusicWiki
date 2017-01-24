package com.mac.musicwiki.album.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mac.musicwiki.App;
import com.mac.musicwiki.R;
import com.mac.musicwiki.album.model.FavoriteVO;
import com.mac.musicwiki.album.presenter.AlbumPresenter;
import com.mac.musicwiki.search.model.Datum;
import com.mac.musicwiki.search.presenter.SearchPresenter;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumActivity extends AppCompatActivity implements AlbumView {
    @BindView(R.id.imageAlbum) ImageView imgCover;
    @BindView(R.id.artis) TextView artist;
    @BindView(R.id.album) TextView album;
    @BindView(R.id.rating) RatingBar ratingBar;
    @BindView(R.id.btnCheckin) Button btnCheckin;
    @Inject
    AlbumPresenter albumPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        App.getAppComponent(this).inject(this);
        albumPresenter.attachView(this);
        ButterKnife.bind(this);
        Intent i = getIntent();
        Datum item =  (Datum) i.getSerializableExtra("album");
        artist.setText(item.getArtist().getName());
        album.setText(item.getAlbum().getTitle());
        Glide.with(AlbumActivity.this).load(item.getArtist().getPicture()).into(imgCover);
    }

    public FavoriteVO setFavoriteVO(Datum item){
        FavoriteVO vo = new FavoriteVO();
        vo.setName(item.getArtist().getName());
        vo.setAlbum(item.getAlbum().getTitle());
        vo.setRating(ratingBar.getNumStars());
        vo.setPicture(item.getAlbum().getCover());
        return vo;
    }

    public void checkIn(View view) {

    }

    @Override
    public boolean addToFavorite(String artist) {
        return false;
    }
}
