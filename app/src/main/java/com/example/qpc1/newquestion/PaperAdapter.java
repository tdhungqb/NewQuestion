package com.example.qpc1.newquestion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

public class PaperAdapter extends FragmentStatePagerAdapter {
    public List<Question> mQuestion ;

    public PaperAdapter(FragmentManager fm, List<Question> mQuestion) {
        super(fm);
        this.mQuestion = mQuestion;
    }

    @Override
    public Fragment getItem(int position) {
        if (position < 5) {
            QuestionFragment questionFragment = QuestionFragment.newInstance();
            questionFragment.getQuestions(mQuestion.get(position));
            return questionFragment;
        } else
            return new ResultFragment();
    }

    @Override
    public int getCount() {
        return 6;
    }

}
