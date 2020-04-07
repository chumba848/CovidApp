package bsl.co.ke.covidapp.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Objects;

import bsl.co.ke.covidapp.R;

public class EmergencyActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive;
    public static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        initWidgets();

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Emergency Numbers");
     /*   getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Emergency Numbers");*/


    }


    @Override
    public boolean onSupportNavigateUp()
    {

        onBackPressed();

        finish();
        return true;
    }

    private void initWidgets() {

       buttonOne = findViewById(R.id.button_one);
       buttonTwo = findViewById(R.id.button_two);
       buttonThree = findViewById(R.id.button_three);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_one:
                String numOne = "0720000000";
                makePhoneDial(numOne);
                break;

            case R.id.button_two:
                String numTwo = "0721000000";
               makePhoneDial(numTwo);
                break;

            case R.id.button_three:
                String numThree = "0722000000";
                makePhoneDial(numThree);
                break;

        }
    }


    private void makePhoneDial(String number) {

        Intent i = new Intent(Intent.ACTION_DIAL);
        if(number.isEmpty()) {

            i.setData(Uri.parse("tel:0720000000"));
        } else {
            i.setData(Uri.parse("tel:"+number));
        }
        startActivity(i);
    }
}
