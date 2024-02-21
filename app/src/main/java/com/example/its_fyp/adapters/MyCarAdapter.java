package com.example.its_fyp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.its_fyp.R;
import com.example.its_fyp.models.MyCar;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class MyCarAdapter extends RecyclerView.Adapter<MyCarAdapter.MyCarViewHolder> {
    private Context context;
    private ArrayList<MyCar> myCars;

    public MyCarAdapter(Context context, ArrayList<MyCar> myCars) {
        this.context = context;
        this.myCars = myCars;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyCarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_car, parent, false);
        return new MyCarViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyCarViewHolder holder, int position) {
        MyCar myCar = this.myCars.get(position);
        holder.logo.setImageResource(myCar.getLogo());
        holder.txtName.setText(myCar.getCarName());
        holder.txtModelNo.setText(myCar.getModelNo());
        holder.txtGenre.setText(myCar.getGenre());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.myCars.size();
    }

    /* loaded from: classes5.dex */
    public class MyCarViewHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView txtGenre;
        TextView txtModelNo;
        TextView txtName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyCarViewHolder(View itemView) {
            super(itemView);
            this.logo = (ImageView) itemView.findViewById(R.id.img_logo);
            this.txtName = (TextView) itemView.findViewById(R.id.txt_carname);
            this.txtModelNo = (TextView) itemView.findViewById(R.id.txt_model_no);
            this.txtGenre = (TextView) itemView.findViewById(R.id.txt_genre);
        }
    }
}