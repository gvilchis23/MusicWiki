package com.mac.musicwiki;

import com.mac.musicwiki.search.view.SearchActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by memoPilgrim on 1/5/17.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    SearchActivity inject(SearchActivity activity);
}

