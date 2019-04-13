package id.ac.umn.whizzie;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class TimelineActivity extends AppCompatActivity {
    BottomNavigationView btmNavView;
    RecyclerView rvTimelineItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        btmNavView = findViewById(R.id.btmNavTimeline);

        final IntentMovement im = new IntentMovement(TimelineActivity.this);

        btmNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.home_bottom_menu: im.moveToTargetNormal(HomeActivity.class);
                    case R.id.timeline_bottom_menu: im.moveToTargetNormal(TimelineActivity.class);
                    case R.id.post_bottom_menu: im.moveToTargetNormal(PostActivity.class);
                    case R.id.notification_bottom_menu: im.moveToTargetNormal(NotificationActivity.class);
                    case R.id.profile_bottom_menu: im.moveToTargetNormal(ProfileActivity.class);
                }

                return true;
            }
        });

        rvTimelineItems = findViewById(R.id.rvTimelineItems);

        rvTimelineItems.setHasFixedSize(true);

        List<TimelineItems> tiList = new ArrayList<>();

        tiList.add(new TimelineItems("Ellianto", "Cuma coba coba", 100000));
        tiList.add(new TimelineItems("Alexander", "Tes Test testing", 25000));
        tiList.add(new TimelineItems("Ellianto", "Cek cek cek", 10101));

        TimelineItemsAdapter tiAdapter = new TimelineItemsAdapter(this, tiList);
        rvTimelineItems.setAdapter(tiAdapter);
    }
}
