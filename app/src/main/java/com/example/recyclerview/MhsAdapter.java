package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.MhsVH> {
    private ArrayList<Mhs> mhsList;

    public MhsAdapter(ArrayList<Mhs> mhsList) {
        this.mhsList = mhsList;
    }

    @NonNull
    @Override
    public MhsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);

        return new MhsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MhsVH holder, int position) {
        holder.tvNamaVal.setText(mhsList.get(position).getNama());
        holder.tvNimVal.setText(mhsList.get(position).getNim());
        holder.tvNoHPVal.setText(mhsList.get(position).getNoHP());

    }

    @Override
    public int getItemCount() {
        return mhsList.size();
    }

    public class MhsVH extends RecyclerView.ViewHolder {
        private final TextView tvNamaVal;
        private final TextView tvNimVal;
        private final TextView tvNoHPVal;

        public MhsVH(@NonNull View itemView) {
            super(itemView);
            tvNamaVal = itemView.findViewById(R.id.tvNamaVal);
            tvNimVal = itemView.findViewById(R.id.tvNimVal);
            tvNoHPVal = itemView.findViewById(R.id.tvNoHPVal);
        }
    }
}
