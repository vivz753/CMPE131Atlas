package com.example.x1user.atlas;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        final EditText etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        final EditText etMessage = (EditText)findViewById(R.id.etMessage);
        final Button bSend = (Button)findViewById(R.id.bSend);

        bSend.setOnClickListener(new View.OnClickListener(){

//            String phoneNumber = etPhoneNumber.getText().toString();
//            String message = etMessage.getText().toString();
//            String message = ((EditText)findViewById(R.id.etMessage)).getText().toString();

            private void sendSMS(String phoneNumber, String message)
            {
                PendingIntent pi = PendingIntent.getActivity(MessageActivity.this, 0,
                        new Intent(MessageActivity.this, MessageActivity.class), 0);
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phoneNumber, null, message, pi, null);
            }

//            private void sendSMSMessage() {
//
//
//                try {
//                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
//                    Toast.makeText(getApplicationContext(), "SMS sent.",
//                            Toast.LENGTH_LONG).show();
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(),
//                            "SMS faild, please try again.",
//                            Toast.LENGTH_LONG).show();
//                    e.printStackTrace();
//                }
//            }

            @Override
            public void onClick(View v) {
                String phoneNumber = (String)etPhoneNumber.getText().toString();
                String message = (String)etMessage.getText().toString();
                if (phoneNumber.length()>0 && message.length()>0)
                    sendSMS(phoneNumber, message);
                else
                    Toast.makeText(getBaseContext(),
                            "Please try again",
                            Toast.LENGTH_SHORT).show();

                //sendSMSMessage();
            }
        });





    }












}
