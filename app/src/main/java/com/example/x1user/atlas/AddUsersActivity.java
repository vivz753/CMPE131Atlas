package com.example.x1user.atlas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class AddUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users);

        final CheckBox cb1 = (CheckBox)findViewById(R.id.cb1);

        final Button bAdd = (Button)findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(cb1.isChecked()){
PartyActivity.party.add(new User("vivianleung@gmail.com", "poopoo", "Vivian Leung", "140812345678" ));
                }
                Intent iParty = new Intent(AddUsersActivity.this, PartyActivity.class);
                startActivity(iParty);
            }
        });

    }


}
