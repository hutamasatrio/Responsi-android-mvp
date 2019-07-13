package com.responsi.mvp.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.responsi.mvp.R;
import com.responsi.mvp.model.ResultsItem;
import com.responsi.mvp.view.activity.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import static com.responsi.mvp.handler.GlideHandler.setImg;

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.MyViewHolder>  {

    private Context context;
    private List<ResultsItem> items = new ArrayList<>();

    public void setAct(Context context) {
        this.context = context;
    }

    public void setData(List<ResultsItem> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ResultsItem resultsItem = items.get(position);

        setImg(context, resultsItem.getPicture().getThumbnail(), holder.img);
        holder.nama.setText(resultsItem.getName().toString());
        holder.no.setText(resultsItem.getPhone().toString());
        holder.email.setText(resultsItem.getEmail().toString());
        click(holder.item, resultsItem);
    }

    private void click(CardView item, final ResultsItem resultsItem) {
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("nama", resultsItem.getName().toString());
                i.putExtra("no", resultsItem.getPhone().toString());
                i.putExtra("email", resultsItem.getEmail().toString());
                i.putExtra("gender", resultsItem.getGender().toString());
                i.putExtra("lokasi", resultsItem.getLocation().toString());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView nama;
        private TextView no;
        private TextView email;
        private CardView item;

        public MyViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_gbr);
            nama = itemView.findViewById(R.id.nama);
            no = itemView.findViewById(R.id.no);
            email = itemView.findViewById(R.id.email);
            item = itemView.findViewById(R.id.card);
        }

    }

}
