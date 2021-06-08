package com.example.whatsappnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText whatsappNo, whatsappMsg;
    Button whatsappSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whatsappNo = findViewById(R.id.whatsappFieldIn);
        whatsappMsg = findViewById(R.id.messageFieldIn);
        whatsappSend = findViewById(R.id.textButton);

        whatsappSend.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
//                        https://api.whatsapp.com/send?phone=917989227514&text=hellow%20Guru
                        String gNumber = whatsappNo.getText().toString();
                        String gMessage = whatsappMsg.getText().toString();

                        if (gNumber.trim().equals("")) {
                            Toast.makeText(MainActivity.this, "Whatsapp Number is Required", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            String wUrl = "https://api.whatsapp.com/send?phone=" + gNumber + "&text=" + gMessage;
                            Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                            myWebLink.setData(Uri.parse(wUrl));
                            startActivity(myWebLink);
                            Toast.makeText(MainActivity.this, "Start Chatting", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}