package com.example.qpc1.newquestion;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Question> mQuestions;
    private int mSecond = 0;
    private int mMinute = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListOfQuestions();
        initToolbar();
        initViews();
    }

    private void initViews() {
        ViewPager mViewPager = findViewById(R.id.viewPaper);
        FragmentManager fragmentManager = getSupportFragmentManager();
        PaperAdapter paperAdapter = new PaperAdapter(fragmentManager, mQuestions);
        mViewPager.setAdapter(paperAdapter);
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initListOfQuestions() {
        mQuestions = new ArrayList<>();
        Random random = new Random();
        String question = getString(R.string.question);
        String resultA = getString(R.string.resultA);
        String resultB = getString(R.string.resultB);
        String resultC = getString(R.string.resultC);
        String resultD = getString(R.string.resultD);
        String explain = getString(R.string.explain);
        for (int i = 1; i <= 20; i++) {
            mQuestions.add(new Question(i - 1, i + "." + question + " " + i, resultA + " " + i,
                    resultB + " " + i, resultC + " " + i,
                    resultD + " " + i, random.nextInt(3), explain));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main_action, menu);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSecond += 1;
                if (mSecond <= 59) {
                    if (mSecond <= 9) {
                        menu.getItem(0).setTitle("0" + mMinute + ":" + "0" + mSecond);
                    } else {
                        menu.getItem(0).setTitle("0" + mMinute + ":" + mSecond);
                    }
                } else {
                    mSecond = 0;
                    mMinute += 1;
                    if (mMinute <= 9) {
                        menu.getItem(0).setTitle("0" + mMinute + ":0" + mSecond);
                    } else {
                        menu.getItem(0).setTitle("" + mMinute + ":" + mSecond);
                    }
                }
                handler.postDelayed(this, 1000);
            }
        }, 1000);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.timer:
                Toast.makeText(this, "Time", Toast.LENGTH_SHORT).show();
            case R.id.logo:
                Toast.makeText(this, "Logo", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
