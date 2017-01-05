package com.mac.musicwiki;

import com.mac.musicwiki.search.presenter.SearchPresenter;
import com.mac.musicwiki.search.presenter.SearchPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by memoPilgrim on 1/5/17.
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }



    @Provides
    @Singleton
    SearchPresenter provideSearchPresenter() {
        return new SearchPresenterImpl();
    }

}
