package com.biji.api.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.biji.api.R;
import com.biji.api.model.plane;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyHolder> {
    private final Context context;
    private List<plane> planeList;

    public adapter(Context context){this.context = context;}

    @SuppressLint("notifyDataSetChanged")
    public void setPlaneList(List<plane> planeList){
        this.planeList = planeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.iata_code.setText(this.planeList.get(position).getIataCode());
        holder.name.setText(this.planeList.get(position).getName());
        holder.icao_code.setText(this.planeList.get(position).getIcaoCode());
    }

    @Override
    public int getItemCount() {
        if (planeList == null) {
            return 0;
        }
        return this.planeList.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView iata_code, name, icao_code;
        public MyHolder (@NonNull View itemView){
            super(itemView);

            iata_code = itemView.findViewById(R.id.iata_code);
            name = itemView.findViewById(R.id.name);
            icao_code = itemView.findViewById(R.id.icao_code);
        }
    }
}
