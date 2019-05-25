package id.ac.umn.whizzie.main.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import id.ac.umn.whizzie.R;
import id.ac.umn.whizzie.main.Settings.SettingFragment;

public class SettingActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    boolean genieMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // Toolbar Initation
        Toolbar toolbarSetting = findViewById(R.id.toolbarSetting);
        setSupportActionBar(toolbarSetting);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        genieMode = getIntent().getBooleanExtra("genie_mode", false);

        frameLayout = findViewById(R.id.genie_profile_fragment_holder);
        Fragment fr = new SettingFragment();
        Bundle b = new Bundle();

        b.putBoolean("genieMode", genieMode);

        fr.setArguments(b);

        setFragment(fr);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}
