package bsl.co.ke.covidapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import bsl.co.ke.covidapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GetstartedActivity extends AppCompatActivity {

    @BindView(R.id.btngetstarted)
    Button btngetstarted;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);
        ButterKnife.bind(this);

        btngetstarted = findViewById(R.id.btngetstarted);



        btngetstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StartChatSmsActivity.class);
                startActivity(intent);
                finish();
                // User savedUser = null;


            }
        });
    }

}
