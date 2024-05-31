package com.sifu.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView quantityTextView;
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView cappuccinoImage = findViewById(R.id.cappuccinoImage);
        TextView productName = findViewById(R.id.productName);
        TextView productPrice = findViewById(R.id.productPrice);
        RatingBar productRating = findViewById(R.id.productRating);
        TextView reviewCount = findViewById(R.id.reviewCount);
        TextView productDescription = findViewById(R.id.productDescription);
        quantityTextView = findViewById(R.id.quantity);
        Button decreaseQuantity = findViewById(R.id.decreaseQuantity);
        Button increaseQuantity = findViewById(R.id.increaseQuantity);
        Button addToCart = findViewById(R.id.addToCart);

        decreaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) {
                    quantity--;
                    updateQuantity();
                }
            }
        });

        increaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                updateQuantity();
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateQuantity() {
        quantityTextView.setText(String.format("%02d", quantity));
    }
}
