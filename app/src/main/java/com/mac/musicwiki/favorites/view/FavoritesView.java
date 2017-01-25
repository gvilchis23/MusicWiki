package com.mac.musicwiki.favorites.view;


import com.mac.musicwiki.BaseView;
import com.mac.musicwiki.album.model.FavoriteVO;
import com.mac.musicwiki.search.model.Datum;
import com.mac.musicwiki.search.model.SearchVO;

import java.util.List;

/**
 * Created by memoPilgrim on 14/12/16.
 */

public interface FavoritesView extends BaseView {
    List<FavoriteVO> getAllFavorites();


}
