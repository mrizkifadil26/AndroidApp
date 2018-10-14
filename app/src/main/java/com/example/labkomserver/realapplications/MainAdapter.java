package com.example.labkomserver.realapplications;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private static final String TAG = "MainAdapter";

    ArrayList<Categories> mCategories;

    private Context mContext;

    public MainAdapter(Context mContext, ArrayList<Categories> mCategories) {
        this.mCategories = mCategories;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_main, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        viewHolder.imageGrid.setImageResource(mCategories.get(position).getImgId());
        viewHolder.textGrid.setText(mCategories.get(position).getCategoryName());
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on " + mCategories.get(position).getCategoryName());

                Intent intent = new Intent(mContext, ListView.class);
                intent.putExtra("categories", mCategories.get(position).getCategoryName());
                mContext.startActivity(intent);
                Toast.makeText(mContext, mCategories.get(position).getCategoryName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageGrid;
        CardView parentLayout;
        TextView textGrid;

        public ViewHolder(View itemView) {

            super(itemView);

            imageGrid = itemView.findViewById(R.id.imageGrid);
            parentLayout = itemView.findViewById(R.id.grid_parent);
            textGrid = itemView.findViewById(R.id.textGrid);

        }
    }

}
