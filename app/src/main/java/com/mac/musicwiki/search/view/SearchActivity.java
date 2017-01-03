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

import com.mac.musicwiki.MainActivity;
import com.mac.musicwiki.R;
import com.mac.musicwiki.search.adapter.ArtistSearchAdapter;
import com.mac.musicwiki.search.model.Datum;
import com.mac.musicwiki.search.model.SearchVO;
import com.mac.musicwiki.search.presenter.SearchPresenter;
import com.mac.musicwiki.search.presenter.SearchPresenterImpl;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchView {
    private SearchPresenter searchPresenter;
    private EditText artistText;
    private RecyclerView recyclerView;
    private ArtistSearchAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchPresenter = new SearchPresenterImpl();
        searchPresenter.attachView(this);
        artistText = (EditText) findViewById(R.id.searchInput);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
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
        sAdapter = new ArtistSearchAdapter(data);
        recyclerView.setAdapter(sAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        searchPresenter.detachView();
    }
}
