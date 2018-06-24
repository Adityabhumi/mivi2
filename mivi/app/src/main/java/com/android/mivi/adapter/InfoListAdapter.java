package com.android.mivi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.mivi.R;
import com.android.mivi.model.Info;

import java.util.List;

public class InfoListAdapter extends RecyclerView.Adapter<InfoListAdapter.MyViewHolder> {

    private List<Info> infoList;
    private Context context;

    public InfoListAdapter(List<Info> infoList, Context context) {
        this.infoList = infoList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView key;
        TextView value;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.key = (TextView) itemView.findViewById(R.id.key);
            this.value = (TextView) itemView.findViewById(R.id.value);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.info_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        holder.key.setText(infoList.get(listPosition).getKey());
        holder.value.setText(infoList.get(listPosition).getValue());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }
}
