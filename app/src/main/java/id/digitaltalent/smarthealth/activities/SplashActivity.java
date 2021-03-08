package id.digitaltalent.smarthealth.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import id.digitaltalent.smarthealth.R;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class SplashActivity extends AppCompatActivity {
    /**
     * Called when the activity is first created.
     */

    protected boolean _active = true;
    protected int _splashTime = 2500; // time to display the splash screen in ms

    Thread splashTread;
    LottieAnimationView splashAnimation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        splashAnimation = findViewById(R.id.animationView);
        splashAnimation.playAnimation();

        // thread for displaying the SplashScreen
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }

                    Intent intent = new Intent(SplashActivity.this,
                            LoginActivity.class);
                    intent.putExtra("TYPE", 0);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        };
        splashTread.start();
    }

    @Override
    public void onBackPressed() {
        if (splashTread != null)
            splashTread.interrupt();
        super.onBackPressed();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}