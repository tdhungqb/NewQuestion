package com.example.qpc1.newquestion;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Question> mQuestions;

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
        PaperAdapter paperAdapter = new PaperAdapter(fragmentManager,mQuestions);
        mViewPager.setAdapter(paperAdapter);
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initListOfQuestions() {
        mQuestions = new ArrayList<>();
        mQuestions.add(new Question(0,"1. 1111","A. aaaa","B. bbbb","C. cccc","D. dddd",2,"Giải thích"));
        mQuestions.add(new Question(1,"2. 2222","A. aaaaa","B. bbbbb","C. ccccc","D. ddddd",3,"Giải thích"));
        mQuestions.add(new Question(2,"3. 3333","A. aaaaa","B. bbbbb","C. ccccc","D. ddddd",2,"Giải thích"));
        mQuestions.add(new Question(3,"4. 4444","A. aaaaa","B. bbbbb","C. ccccc","D. ddddd",1,"Giải thích"));
        mQuestions.add(new Question(4,"5. 5555","A. aaaaa","B. bbbbb","C. ccccc","D. ddddd",0,"Giải thích"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_action,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logo:
                Toast.makeText(this, "Logo", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
