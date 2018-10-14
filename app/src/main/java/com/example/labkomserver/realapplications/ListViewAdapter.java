package com.example.labkomserver.realapplications;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    private static final String TAG = "ListViewAdapter";

    ArrayList<Species> mSpecies;

    private Context mContext;

    public ListViewAdapter(Context mContext, ArrayList<Species> mSpecies) {
        this.mSpecies = mSpecies;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_list_view, viewGroup, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        viewHolder.image.setImageResource(mSpecies.get(position).getImg());
        viewHolder.name.setText(mSpecies.get(position).getName());
        viewHolder.species.setText(mSpecies.get(position).getSpecies());
        viewHolder.location.setText(mSpecies.get(position).getLocation());
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on" + mSpecies.get(position).getName());

                Intent intent = new Intent(mContext, Articles.class);
                intent.putExtra("img", mSpecies.get(position).getImg());
                intent.putExtra("name", mSpecies.get(position).getName());
                intent.putExtra("species", mSpecies.get(position).getSpecies());
                intent.putExtra("location", mSpecies.get(position).getLocation());
                intent.putExtra("desc", mSpecies.get(position).getDesc());

                mContext.startActivity(intent);

//                Toast.makeText(mContext, mSpecies.get(position).getName(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return mSpecies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        CardView parentLayout;
        TextView name, species, location;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageList);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            name = itemView.findViewById(R.id.nameList);
            species = itemView.findViewById(R.id.speciesList);
            location = itemView.findViewById(R.id.locationList);

        }
    }

}
