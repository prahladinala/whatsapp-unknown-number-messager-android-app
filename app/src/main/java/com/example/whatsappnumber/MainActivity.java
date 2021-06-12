package com.example.whatsappnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText whatsappNo, whatsappMsg;
    Button whatsappSend, whatsappCopy, whatsappShare;
    TextView prahladinala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whatsappNo = findViewById(R.id.whatsappFieldIn);
        whatsappMsg = findViewById(R.id.messageFieldIn);
        whatsappSend = findViewById(R.id.textButton);
        whatsappCopy = findViewById(R.id.copyButton);
        whatsappShare =  findViewById(R.id.shareButton);
        prahladinala = findViewById(R.id.prahladinala);

        whatsappSend.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String gNumber = whatsappNo.getText().toString();
                        String gMessage = whatsappMsg.getText().toString();

                        if (gNumber.trim().equals("")) {
                            Toast.makeText(MainActivity.this, "Whatsapp Number is Required", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            if(gMessage.trim().equals("")){
                                String wUrl = "https://api.whatsapp.com/send?phone=" + gNumber;
                                wUrl = wUrl.trim();
                                wUrl = wUrl.replaceAll("\\s", "%20");
                                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                                myWebLink.setData(Uri.parse(wUrl));
                                startActivity(myWebLink);
                            } else{
                                String wUrl = "https://api.whatsapp.com/send?phone=" + gNumber + "&text=" + gMessage;
                                wUrl = wUrl.trim();
                                wUrl = wUrl.replaceAll("\\s", "%20");
                                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                                myWebLink.setData(Uri.parse(wUrl));
                                startActivity(myWebLink);
                            }
                            Toast.makeText(MainActivity.this, "Start Chatting", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        whatsappCopy.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String gNumber = whatsappNo.getText().toString();
                        String gMessage = whatsappMsg.getText().toString();
                        if (gNumber.trim().equals("")) {
                            Toast.makeText(MainActivity.this, "Whatsapp Number is Required", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            ClipData myClip;
                            if(gMessage.trim().equals("")){
                                String wUrl = "https://api.whatsapp.com/send?phone=" + gNumber ;
                                wUrl = wUrl.trim();
                                wUrl = wUrl.replaceAll("\\s", "%20");
                                myClip = ClipData.newPlainText("text", wUrl);
                            } else{
                                String wUrl = "https://api.whatsapp.com/send?phone=" + gNumber + "&text=" + gMessage;
                                wUrl = wUrl.trim();
                                wUrl = wUrl.replaceAll("\\s", "%20");
                                myClip = ClipData.newPlainText("text", wUrl);
                            }

                            clipboard.setPrimaryClip(myClip);
                            Toast.makeText(MainActivity.this, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        whatsappShare.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String gNumber = whatsappNo.getText().toString();
                        String gMessage = whatsappMsg.getText().toString();
                        if (gNumber.trim().equals("")) {
                            Toast.makeText(MainActivity.this, "Whatsapp Number is Required", Toast.LENGTH_SHORT).show();
                            return;
                        }else {
                            if(gMessage.trim().equals("")){
                                String wUrl = "https://api.whatsapp.com/send?phone=" + gNumber ;
                                wUrl = wUrl.trim();
                                wUrl = wUrl.replaceAll("\\s", "%20");
                                Intent myIntent = new Intent(Intent.ACTION_SEND);
                                myIntent.setType("text/plain");
                                String body = wUrl;
                                String sub = "Your Subject";
                                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                                startActivity(Intent.createChooser(myIntent, "Share Using"));
                            } else{
                                String wUrl = "https://api.whatsapp.com/send?phone=" + gNumber + "&text=" + gMessage;
                                wUrl = wUrl.trim();
                                wUrl = wUrl.replaceAll("\\s", "%20");
                                Intent myIntent = new Intent(Intent.ACTION_SEND);
                                myIntent.setType("text/plain");
                                String body = wUrl;
                                String sub = "Your Subject";
                                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                                startActivity(Intent.createChooser(myIntent, "Share Using"));
                            }
                            Toast.makeText(MainActivity.this, "Happy Sharing !!", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

        prahladinala.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                        myWebLink.setData(Uri.parse("https://prahladinala.com"));
                        startActivity(myWebLink);
                        Toast.makeText(MainActivity.this, "Hey!! Happy to see you here", Toast.LENGTH_SHORT).show();
                    }



                });
    }
}