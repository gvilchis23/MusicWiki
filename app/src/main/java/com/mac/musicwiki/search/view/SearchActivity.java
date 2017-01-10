package com.mac.musicwiki.search.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mac.musicwiki.App;
import com.mac.musicwiki.MainActivity;
import com.mac.musicwiki.R;
import com.mac.musicwiki.album.view.AlbumActivity;
import com.mac.musicwiki.search.adapter.ArtistSearchAdapter;
import com.mac.musicwiki.search.model.Datum;
import com.mac.musicwiki.search.model.SearchVO;
import com.mac.musicwiki.search.presenter.SearchPresenter;
import com.mac.musicwiki.search.presenter.SearchPresenterImpl;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements SearchView {
    @Inject
    SearchPresenter searchPresenter;
    @BindView(R.id.searchInput) EditText artistText;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        App.getAppComponent(this).inject(this);
        searchPresenter.attachView(this);
        ButterKnife.bind(this);
    }

    public void searchArtist(View view) {
        showAllSearchArtist(artistText.getText().toString());
    }

    @Override
    public SearchVO showAllSearchArtist(String artist) {
        return searchPresenter.getAllSearchArtist(artist);
    }

    @Override
    public void createRecycler(List<Datum> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new ArtistSearchAdapter(data, new ArtistSearchAdapter.OnItemClickListener() {
            @Override public void onItemClick(Datum item) {
                Intent i = new Intent(SearchActivity.this, AlbumActivity.class);
                i.putExtra("album", item);
                startActivity(i);
            }
        }));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        searchPresenter.detachView();
    }
}
