package com.example.suitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.suitcase.R.id.activity_log_btn;

public class MyProfile extends AppCompatActivity {

    private Button my_lugs_btn;
    private Button activity_log_btn;
    private Button log_out_btn;
    private TextView personal_name_TV;
    private TextView details_tv;
    private ImageView image_iv;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my_profile);

            my_lugs_btn = (Button) findViewById(R.id.my_lugs_btn);
            activity_log_btn = (Button) findViewById(R.id.activity_log_btn);
            log_out_btn = (Button) findViewById(R.id.log_out_btn);
            personal_name_TV = (TextView) findViewById(R.id.personal_name_TV);
            details_tv = (TextView) findViewById(R.id.details_tv);
            image_iv = (ImageView) findViewById(R.id.image_iv);


            log_out_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyProfile.this, MainActivity.class);
                    startActivity(intent);
                }
            });


            activity_log_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyProfile.this, UserAct.class);
                    startActivity(intent);
                }
            });

            my_lugs_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyProfile.this, LuggageActivity.class);
                    startActivity(intent);
                }
            });

            /*

            log_out_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText editPersonalName=(EditText) findViewById(R.id.personal_name_TV);
                }
            });  */

        }
    }

