package com.training.checknetworkdownload;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    static  String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, NetworkStatus.networkName(getApplicationContext()), Toast.LENGTH_LONG).show();
        et=findViewById(R.id.urlEnterText);
    }
    public void download (View view){
        url=et.getText().toString();
        DownloadContent content=new DownloadContent();
        content.DownloadSettings(getApplicationContext());

    }
}