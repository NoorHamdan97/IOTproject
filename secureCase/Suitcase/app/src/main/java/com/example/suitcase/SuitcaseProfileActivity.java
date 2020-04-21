package com.example.suitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SuitcaseProfileActivity extends AppCompatActivity {
    private Switch Vacuum;
    private Button Log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suitcase_profile);
        Vacuum = (Switch)findViewById(R.id.sw_vacuum);
        Log = (Button)findViewById(R.id.btn_log);
        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuitcaseProfileActivity.this, SuitcaseActActivity.class);
                startActivity(intent);
            }
        });
    }
}
