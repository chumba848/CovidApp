package bsl.co.ke.covidapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

import bsl.co.ke.covidapp.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {

    private CircleImageView mGitImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

       // mGitImageview = findViewById(R.id.git);

        Drawable upArrow = getResources().getDrawable(R.drawable.ic_chevron_left_white_24dp);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("About");

       /* mGitImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/gajendrapandeya";
                Intent gitInent = new Intent(Intent.ACTION_SEND);
                gitInent.setData(Uri.parse(url));
                startActivity(gitInent);

            }
        });*/


    }


    @Override
    public boolean onSupportNavigateUp()
    {

        onBackPressed();

        finish();
        return true;
    }
}
