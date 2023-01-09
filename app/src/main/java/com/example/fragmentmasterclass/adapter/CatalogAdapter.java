package com.example.fragmentmasterclass.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmasterclass.R;
import com.example.fragmentmasterclass.domain.Product;
import com.example.fragmentmasterclass.fragment.CatalogFragment;

import java.util.List;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {

    private List<Product> products;
    private Context context;
    private LayoutInflater layoutInflater;
    private CatalogFragment fragment;

    public CatalogAdapter(List<Product> products, Context context, CatalogFragment fragment) {
        this.products = products;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.catalog_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.image.setImageDrawable(product.getImage());
        holder.name.setText(product.getName());
        holder.bt_add.setText(String.valueOf(product.getCost()));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("prod_id", product.getId());
                NavHostFragment.findNavController(fragment).navigate(
                        R.id.action_catalogFragment_to_productInfoFragment, bundle);
            }
        });
        holder.bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "add " + product.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        AppCompatButton bt_add;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_catalogItem);
            name = itemView.findViewById(R.id.tv_catalogItem_name);
            bt_add = itemView.findViewById(R.id.bt_catalogItem_add);
        }
    }

}
