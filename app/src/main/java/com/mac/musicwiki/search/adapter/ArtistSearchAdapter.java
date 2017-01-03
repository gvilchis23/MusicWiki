package com.mac.musicwiki.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mac.musicwiki.R;
import com.mac.musicwiki.search.model.Datum;
import com.mac.musicwiki.search.model.SearchVO;

import java.util.List;

/**
 * Created by memoPilgrim on 29/11/16.
 */

public class ArtistSearchAdapter extends RecyclerView.Adapter<ArtistSearchAdapter.MyViewHolder> {

    private List<Datum> artistAllList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, album, cover;


        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            album = (TextView) view.findViewById(R.id.album);
            cover = (TextView) view.findViewById(R.id.cover);

        }
    }
    public ArtistSearchAdapter(List<Datum> artistAllList) {
        this.artistAllList = artistAllList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_artist_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Datum data = artistAllList.get(position);
        holder.name.setText(data.getArtist().getName());
        holder.album.setText(data.getAlbum().getTitle());
        holder.cover.setText(data.getAlbum().getTitle());
    }

    @Override
    public int getItemCount() {
        return artistAllList.size();
    }
}
