package com.example.x1user.atlas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PartyActivity extends AppCompatActivity {
    public static ArrayList<User> party = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iAddUsers = new Intent(PartyActivity.this, AddUsersActivity.class);
                startActivity(iAddUsers);
            }
        });

//        Button bAdd = (Button) findViewById(R.id.bAdd);
//        bAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent iAddUsers = new Intent(PartyActivity.this, AddUsersActivity.class);
//                startActivity(iAddUsers);
//            }
//        });


        if (!party.isEmpty()) {
//            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            View layout = inflater.inflate(R.layout.content_party,
//                    null);
            ImageView ivProfile = (ImageView) findViewById(R.id.ivProfile);
            TextView tvName = (TextView) findViewById(R.id.tvName);

            ivProfile.setImageResource(R.drawable.vivian_profilepic);
            ivProfile.setMaxWidth(100);
            ivProfile.setMaxHeight(100);
            tvName.setText("Vivian Leung");


            ImageButton ibCall = (ImageButton) findViewById(R.id.ibCall);
            ImageButton ibChat = (ImageButton) findViewById(R.id.ibChat);

            ibCall.setVisibility(View.VISIBLE);
            ibChat.setVisibility(View.VISIBLE);

            ibCall.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(PartyActivity.this, "still being developed, sorry D:", Toast.LENGTH_SHORT).show();
                }
            });

            ibChat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent iChat = new Intent(PartyActivity.this, ChatActivity.class);
                    startActivity(iChat);
                }
            });


        }
    }
}
