package com.example.qpc1.newquestion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

public class PaperAdapter extends FragmentStatePagerAdapter {
    private List<Question> mQuestions ;

    public PaperAdapter(FragmentManager fm, List<Question> questions) {
        super(fm);
        this.mQuestions = questions;
    }

    @Override
    public Fragment getItem(int position) {
        if (position < 20) {
            QuestionFragment questionFragment = QuestionFragment.newInstance();
            questionFragment.getQuestions(mQuestions.get(position));
            return questionFragment;
        } else
            return new ResultFragment();
    }

    @Override
    public int getCount() {
        return 21;
    }
}
