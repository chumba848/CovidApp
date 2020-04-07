package bsl.co.ke.covidapp.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import bsl.co.ke.covidapp.R;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

 /*   @BindView(R.id.loginButton)
    Button loginButton;
*/
    int PERMISSION_ALL = 1;
    public ProgressDialog mprogress;
    private static int SPLASH_TIME_OUT = 3000;


    Thread splashTread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ButterKnife.bind(this);
        StartAnimations();

    }
    private void StartAnimations() {


        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 2500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashActivity.this, GetstartedActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashActivity.this.finish();
                }

            }
        };
        splashTread.start();

    }

}
