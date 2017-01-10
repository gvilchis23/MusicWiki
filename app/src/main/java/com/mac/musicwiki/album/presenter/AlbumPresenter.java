package com.mac.musicwiki.album.presenter;

import com.mac.musicwiki.BasePresenter;
import com.mac.musicwiki.album.view.AlbumView;
import com.mac.musicwiki.search.model.SearchVO;
import com.mac.musicwiki.search.view.SearchView;


/**
 * Created by memoPilgrim on 14/12/16.
 */

public interface AlbumPresenter extends BasePresenter<AlbumView> {
    boolean addToFavorite(String artist);

}
