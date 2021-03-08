package id.digitaltalent.smarthealth.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import id.digitaltalent.smarthealth.R;
import id.digitaltalent.smarthealth.fragments.LoginFragment;
import id.digitaltalent.smarthealth.fragments.RegisterFragment;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class LoginActivity extends AppCompatActivity {

    FrameLayout frame;

    private Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        frame = (FrameLayout)findViewById(R.id.frame);

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getInt("TYPE") == 0) {
                loadFragment(context, new LoginFragment());
            } else {
                loadFragment(context, new RegisterFragment());
            }
        }

    }

    public void loadFragment(Context context, Fragment fragment) {
        ((AppCompatActivity) context).getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(fragment.getTag())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
