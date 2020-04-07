package bsl.co.ke.covidapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import bsl.co.ke.covidapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StartChatSmsActivity extends AppCompatActivity {
    @BindView(R.id.loginButton)
    Button loginButton;
  @BindView(R.id.btnchat)
    Button btnchat;
  @BindView(R.id.btncaalorsms)
    Button btncaalorsms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startchartorsms);
        ButterKnife.bind(this);



        loginButton = findViewById(R.id.loginButton);
        btnchat = findViewById(R.id.btnchat);
        btncaalorsms = findViewById(R.id.btncaalorsms);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

                // User savedUser = null;


            }
        }); btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);




            }
        }); btncaalorsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), EmergencyActivity.class);
                startActivity(intent);


            }
        });


    }
}
