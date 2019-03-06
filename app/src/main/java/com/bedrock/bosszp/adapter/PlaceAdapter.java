package com.bedrock.bosszp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bedrock.bosszp.R;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {

    Context context;
    List<String> stringList;

    public PlaceAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_place,viewGroup,false);

        return new PlaceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder placeHolder, int i) {

        placeHolder.textView.setText(stringList.get(i));

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    class PlaceHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public PlaceHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_place);

        }
    }
}
