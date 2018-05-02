package com.example.mrtayyab.javajsonnew;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class heroAdapter extends RecyclerView.Adapter<heroAdapter.MyViewHolder> {

    private Context mContext ;
    private List<HeroesModel> mData;

    public heroAdapter(Context mContext, List newList) {

        this.mContext = mContext;
        this.mData = newList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.layout_list_view,parent,false);
        // click listener here
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.mContainter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i  = new Intent(mContext , DisplayActivity.class);
                i.putExtra("hero_name" , mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("hero_desc" , mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("hero_studio" , mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("hero_category" , mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("hero_episode" , mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("hero_img" , mData.get(viewHolder.getAdapterPosition()).getImage_url());
                mContext.startActivity(i);

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvname.setText(mData.get(position).getName());
        holder.tv_rate.setText(mData.get(position).getRating());
        holder.tvstudio.setText(mData.get(position).getStudio());
        holder.tvcat.setText(mData.get(position).getCategorie());

        // load image from the internet using Glide
//        Picasso.th.load(mData.get(position).getImage_url()).apply(options).into(holder.AnimeThumbnail);
        Picasso.get().load(mData.get(position).getImage_url()).into(holder.AnimeThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvname,tv_rate,tvstudio,tvcat;
        ImageView AnimeThumbnail;
        LinearLayout mContainter;


        public MyViewHolder(View itemView) {
            super(itemView);

            mContainter = itemView.findViewById(R.id.container);
            tvname = itemView.findViewById(R.id.nameDisplay);
            tvstudio = itemView.findViewById(R.id.studioListView);
            tv_rate = itemView.findViewById(R.id.ratingListView);
            tvcat = itemView.findViewById(R.id.categoreiesDisplay);
            AnimeThumbnail = itemView.findViewById(R.id.imageDisplay);
        }
    }


}
