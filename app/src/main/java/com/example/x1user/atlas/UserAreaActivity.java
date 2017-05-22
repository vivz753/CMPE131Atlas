package com.example.x1user.atlas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        final TextView tvWelcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);
        tvWelcomeMessage.setText("Welcome");


        final Button bParty = (Button) findViewById(R.id.bParty);
        final Button bTextFeed = (Button) findViewById(R.id.bTextFeed);
        final ImageButton bAtlas = (ImageButton) findViewById(R.id.bAtlas);
        final ImageView bSettings = (ImageView) findViewById(R.id.bSettings);

        bTextFeed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent iTextFeed = new Intent(UserAreaActivity.this, TextFeedActivity.class);
                startActivity(iTextFeed);
            }
        });

        bParty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent iParty = new Intent(UserAreaActivity.this, PartyActivity.class);
                startActivity(iParty);
            }
        });

        bAtlas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMaps = new Intent(UserAreaActivity.this, MapsActivity.class);
                startActivity(iMaps);
            }
        });

        bSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent iSettings = new Intent(UserAreaActivity.this, SettingsActivity.class);
                startActivity(iSettings);
            }
        });

    }
}

