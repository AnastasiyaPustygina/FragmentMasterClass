package com.example.fragmentmasterclass.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fragmentmasterclass.DBImitation;
import com.example.fragmentmasterclass.R;
import com.example.fragmentmasterclass.domain.Product;

public class ProductInfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.product_info_fragment, container, false);
         int id = getArguments().getInt("prod_id");
         Product product = DBImitation.findById(id);
        TextView tv_name = view.findViewById(R.id.tv_productInfo_name);
        ImageView image = view.findViewById(R.id.iv_productInfo);
        ImageView bt_back = view.findViewById(R.id.iv_productInfo_back);
        AppCompatButton bt_add = view.findViewById(R.id.bt_productInfo_add);
        TextView tv_description = view.findViewById(R.id.tv_productInfo_description);
        TextView tv_cost = view.findViewById(R.id.tv_productInfo_cost);
        tv_cost.setText("Цена: " + product.getCost() + " Р");
        tv_description.setText(product.getDescription());
        tv_name.setText(product.getName());
        image.setImageDrawable(product.getImage());
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBImitation.addToBasket(product);
            }
        });
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProductInfoFragment.this)
                        .navigate(R.id.action_productInfoFragment_to_catalogFragment);
            }
        });
        return view;
    }
}
