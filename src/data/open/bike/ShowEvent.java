package data.open.bike;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowEvent extends Activity
{
    private String TITLE = "TITLE_EVENT";

    private String BEGIN_TIME = "BEGIN_TIME_EVENT";

    private String END_TIME = "END_TIME_EVENT";

    private String CURRENT_MEMBER = "CURRENT_MEMBER_EVENT";

    private String ALL_MEMBER = "ALL_MEMBER_EVENT";

    private String TO = "TO_EVENT";

    private String FROM = "FROM_EVENT";
    
    TextView mTitle;
    TextView mTime;
    TextView mTo;
    TextView mIntro;
    TextView mMember;
    TextView mDetail;
    ImageView mImage;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_showevent);
        initialUI();
    }
    
    private void initialUI () {
        Intent intent = getIntent();
        String title = intent.getStringExtra(TITLE);
        String begin_time = intent.getStringExtra(BEGIN_TIME);
        String end_time = intent.getStringExtra(END_TIME);
        String to = intent.getStringExtra(TO);
        String from = intent.getStringExtra(FROM);
        int current_member = intent.getIntExtra(CURRENT_MEMBER, -1);
        int all_member = intent.getIntExtra(ALL_MEMBER, -1);
        mTitle = (TextView) findViewById(R.id.title_show);
        mTime = (TextView) findViewById(R.id.time_show);
        mTo = (TextView) findViewById(R.id.to_show);
        mIntro = (TextView) findViewById(R.id.intro_show);
        mDetail = (TextView) findViewById(R.id.detail_show);
        mMember = (TextView) findViewById(R.id.member_show);
        mTitle.setText(title);
        mTime.setText("出發時間: " + begin_time + "~" + end_time);
        mTo.setText("從" + from + "到" + to);
        mIntro.setText("簡介");
        mIntro.setTypeface(null, Typeface.BOLD);
        mDetail.setText(this.getString(R.string.detail_lon));
        mMember.setText("目前人數: " + current_member + "    " + "所有人數: " + all_member);
        mImage = (ImageView) findViewById(R.id.image_show);
        mImage.setImageResource(R.drawable.lon2);
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
            Intent upIntent = NavUtils.getParentActivityIntent(this);
            if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                // This activity is NOT part of this app's task, so create a new task
                // when navigating up, with a synthesized back stack.
                TaskStackBuilder.create(this)
                        // Add all of this activity's parents to the back stack
                        .addNextIntentWithParentStack(upIntent)
                        // Navigate up to the closest parent
                        .startActivities();
            } else {
                // This activity is part of this app's task, so simply
                // navigate up to the logical parent activity.
                NavUtils.navigateUpTo(this, upIntent);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
