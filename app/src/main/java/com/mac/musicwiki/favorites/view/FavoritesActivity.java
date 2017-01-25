package com.mac.musicwiki.favorites.view;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.mac.musicwiki.App;
import com.mac.musicwiki.R;
import com.mac.musicwiki.adapter.ArtistFavoriteAdapter;
import com.mac.musicwiki.adapter.ArtistSearchAdapter;
import com.mac.musicwiki.album.model.FavoriteVO;
import com.mac.musicwiki.album.view.AlbumActivity;
import com.mac.musicwiki.database.DatabaseHandler;
import com.mac.musicwiki.favorites.presenter.FavoritesPresenter;
import com.mac.musicwiki.search.model.Datum;
import com.mac.musicwiki.search.view.SearchActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoritesActivity extends AppCompatActivity implements FavoritesView {
    @Inject
    FavoritesPresenter favoritesPresenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        App.getAppComponent(this).inject(this);
        ButterKnife.bind(this);
        favoritesPresenter.attachView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new ArtistFavoriteAdapter(getAllFavorites()));
    }

    @Override
    public List<FavoriteVO> getAllFavorites() {
        favoritesPresenter.attachDB(db);
        return favoritesPresenter.getAllFavorites();
    }
}
