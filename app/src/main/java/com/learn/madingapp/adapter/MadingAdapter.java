package com.learn.madingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.learn.madingapp.DetailActivity;
import com.learn.madingapp.R;
import com.learn.madingapp.model.Mading;

import java.util.ArrayList;
import java.util.List;

public abstract class MadingAdapter extends RecyclerView.Adapter<MadingAdapter.ViewHolder> implements View.OnClickListener {
    private final Context context;
    private ArrayList<Mading> listMading;

    protected MadingAdapter(Context context, ArrayList<Mading> listMading) {
        this.context = context;
        this.listMading = listMading;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_view, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MadingAdapter.ViewHolder holder, int position) {
        Mading mading = listMading.get(position);
        Glide.with(holder.itemView.getContext())
                .load("http://192.168.43.214/mading-online/foto/"+mading.getFoto())
                .into(holder.imgInformasi);
        holder.txtTitle.setText(mading.getJudul());
        holder.txtDate.setText(mading.getTanggal());
        holder.txtContent.setText(mading.getKonten());

    }

    @Override
    public int getItemCount() {
        return listMading.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgInformasi;
        TextView txtTitle, txtDate, txtContent, txtAuthor;
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgInformasi = itemView.findViewById(R.id.img_informasi);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtContent = itemView.findViewById(R.id.txt_content);
        }

//        pake yg ini kalo ga pake parcelable
        public void onClick(View view){

            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION) {
                Mading mading = listMading.get(position);
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_SPACE_MADING, mading);
                context.startActivity(intent);
            }
        }
    }
}
