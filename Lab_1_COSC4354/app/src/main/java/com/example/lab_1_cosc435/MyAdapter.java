package com.example.lab_1_cosc435;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[];
    int images[];
    Context context;

    public MyAdapter(Context ct, String s1[], int img[]){
        context = ct;
        data1 = s1;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mytxt1.setText(data1[position]);
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mytxt1;
        ImageView myImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytxt1 = itemView.findViewById(R.id.mytxt1);
            myImage = itemView.findViewById(R.id.myImage);
        }
    }
}
