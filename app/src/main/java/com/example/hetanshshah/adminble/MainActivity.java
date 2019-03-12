package com.example.hetanshshah.adminble;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextUserName,editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName=findViewById(R.id.edit_text_user_name);
        editTextPassword=findViewById(R.id.edit_text_password);
        findViewById(R.id.text_view_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* if(editTextUserName.getText().toString().equals("admin") && editTextPassword.getText().toString().equals("admin123")){
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }*/
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }
        });
    }
}
