package com.example.suitcase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registeration extends AppCompatActivity {
    private EditText userName,userPassword1,userPassword2,userEmail;
    private Button registerbtn;
    private TextView userLogin1,userLogin2;
    private FirebaseAuth FBA ;
    private ProgressDialog process;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        setupViews();
        FBA= FirebaseAuth.getInstance();
        process = new ProgressDialog(this);
        userLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registeration.this, MainActivity.class);
                startActivity(intent);
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process.setMessage("Wait A Moment");
                process.show();
               if(validate()) {
                   String Uemail = userEmail.getText().toString().trim();
                   String Upassword = userPassword1.getText().toString();
                   FBA.createUserWithEmailAndPassword(Uemail,Upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               process.dismiss();
                               Toast.makeText(registeration.this,"Registration Complete",Toast.LENGTH_SHORT).show();
                               Intent intent = new Intent(registeration.this, MainActivity.class);
                               startActivity(intent);
                           }
                           else{
                               process.dismiss();
                               Exception exception = task.getException();
                               String reason = exception.getMessage();
                               Toast.makeText(registeration.this, reason, Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
               else{
                   process.dismiss();
               }
            }
        });
    }
    private void setupViews(){
        userName=(EditText)findViewById(R.id.userName);
        userEmail=(EditText)findViewById(R.id.userEmail);
        userPassword1=(EditText)findViewById(R.id.edUserPassword);
        userPassword2=(EditText)findViewById(R.id.Rpassword);
        registerbtn=(Button)findViewById(R.id.bRegBut);
        userLogin1 = (TextView)findViewById(R.id.tvGoBack);
        userLogin2 = (TextView)findViewById(R.id.tvGoBack2);
    }

    private Boolean validate(){
        String name=userName.getText().toString();
        String password1=userPassword1.getText().toString();
        String password2=userPassword2.getText().toString();
        String email= userEmail.getText().toString();
        if (name.isEmpty() || password1.isEmpty() || email.isEmpty() || password2.isEmpty()){
            Toast.makeText(this,"You Have To Fill All The Fields",Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((password1.isEmpty()==false)&&(password2.isEmpty()==false)&&(password1.equals(password2))==false){
            Toast.makeText(this,"Your Password Is Incorrect",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
