package com.example.fragmentmasterclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmasterclass.R;
import com.example.fragmentmasterclass.domain.Product;
import com.example.fragmentmasterclass.fragment.CatalogFragment;

import java.util.List;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder>{

    private List<Product> products;
    private Context context;
    private LayoutInflater layoutInflater;

    public BasketAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.basket_item, parent, false);
        return new BasketAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.cost.setText(product.getCost() + " P");
        holder.image.setImageDrawable(product.getImage());
        holder.name.setText(product.getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_basketItem);
            name = itemView.findViewById(R.id.tv_basketItem_name);
            cost = itemView.findViewById(R.id.tv_basketItem_cost);
        }
    }
}
