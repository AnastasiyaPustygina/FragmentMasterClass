package com.example.fragmentmasterclass.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmasterclass.DBImitation;
import com.example.fragmentmasterclass.R;
import com.example.fragmentmasterclass.adapter.BasketAdapter;
import com.example.fragmentmasterclass.domain.Product;

import java.util.List;

public class BasketFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basket_fragment, container, false);
        RecyclerView rv = view.findViewById(R.id.rv_basket);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new BasketAdapter(DBImitation.getBasket(), getContext()));
        TextView textView = view.findViewById(R.id.tv_basket_cost);
        int amount = 0;
        List<Product> products = DBImitation.getBasket();
        for (int i = 0; i < products.size(); i++) {
            amount += products.get(i).getCost();
        }
        textView.setText("Итого: " + amount + " P");
        return view;
    }
}
