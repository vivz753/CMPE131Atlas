package com.example.x1user.atlas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        final TextView tvWelcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);

        final Button bParty = (Button) findViewById(R.id.bParty);
        final Button bChat = (Button) findViewById(R.id.bChat);
        final ImageButton bAtlas = (ImageButton) findViewById(R.id.bAtlas);
        final ImageView bSettings = (ImageView) findViewById(R.id.bSettings);

        bChat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent iChat = new Intent(UserAreaActivity.this, ChatActivity.class);
                startActivity(iChat);
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

