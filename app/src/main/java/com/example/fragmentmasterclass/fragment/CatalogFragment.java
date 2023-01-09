package com.example.fragmentmasterclass.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmasterclass.DBImitation;
import com.example.fragmentmasterclass.R;
import com.example.fragmentmasterclass.adapter.CatalogAdapter;
import com.example.fragmentmasterclass.domain.Product;

import java.util.List;

public class CatalogFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catalog_fragment, container, false);
        List<Product> products = List.of(new Product(1, "фотопленка", 600,
                        getResources().getDrawable(R.drawable.ic_baseline_camera_roll_24)),
                new Product(2, "баклажан", 30, getResources().getDrawable(R.drawable.ic_baseline_camera_roll_24)),
                new Product(3, "ноутбук", 60000, getResources().getDrawable(R.drawable.ic_baseline_camera_roll_24)));
        DBImitation.setAllProducts(products);
        RecyclerView recyclerView = view.findViewById(R.id.rv_catalog);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        CatalogAdapter adapter = new CatalogAdapter(DBImitation.getAllProducts(), getContext(), CatalogFragment.this);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
