package com.example.she;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.she.R;



public class helpline extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        ImageView backButton = findViewById(R.id.backButton2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void distress(View v){
        Intent i1 = new Intent(Intent.ACTION_DIAL);
        i1.setData(Uri.parse("tel:180"));
        startActivity(i1);
    }


    public void samu(View view) {
        Intent i2 = new Intent(Intent.ACTION_DIAL);
        i2.setData(Uri.parse("tel:192"));
        startActivity(i2);
    }

    public void police(View view) {
        Intent i3 = new Intent(Intent.ACTION_DIAL);
        i3.setData(Uri.parse("tel:190"));
        startActivity(i3);
    }

    public void bombeiros(View view) {
        Intent i4 = new Intent(Intent.ACTION_DIAL);
        i4.setData(Uri.parse("tel:193"));
        startActivity(i4);
    }
}
