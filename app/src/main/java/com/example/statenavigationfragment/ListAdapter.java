package com.example.statenavigationfragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<String> items;
    private LayoutInflater inflater;

    public ListAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ListViewHolder(inflater.inflate(R.layout.item_list,
                viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder viewHolder, int i) {
        viewHolder.bind(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setItems(List<String> items) {
        this.items = new ArrayList<>();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView;
        }

        public void bind(String item) {
            title.setText(item);
        }
    }
}
