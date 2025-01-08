package com.example.artikelkampus;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Article article = getIntent().getParcelableExtra("ARTICLE");

        if (article != null) {
            ImageView imageView = findViewById(R.id.detail_image);
            TextView titleView = findViewById(R.id.detail_title);
            TextView descriptionView = findViewById(R.id.detail_description);
            TextView foundingYearView = findViewById(R.id.detail_founding_year);

            imageView.setImageResource(article.getImageResource());
            titleView.setText(article.getTitle());
            descriptionView.setText(article.getDescription());
            foundingYearView.setText(String.format("Didirikan sejak tahun %d", article.getFoundingYear()));
        }
    }
}
