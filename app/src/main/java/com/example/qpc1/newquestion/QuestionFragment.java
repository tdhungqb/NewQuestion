package com.example.qpc1.newquestion;

import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private Question mQuestion;
    private TextView mTvQuestion, mTvExplain;
    private RadioButton mRbResultA, mRbResultB, mRbResultC, mRbResultD;
    private View mView;

    public static QuestionFragment newInstance() {
        return new QuestionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_question, container, false);
        initViews();
        setData();
        return mView;
    }

    private void initViews() {
        mTvQuestion = mView.findViewById(R.id.tvQuestion);
        mTvExplain = mView.findViewById(R.id.tvExplain);
        RadioGroup mRadioGroup = mView.findViewById(R.id.radioGroupResult);
        mRbResultA = mView.findViewById(R.id.rbResultA);
        mRbResultB = mView.findViewById(R.id.rbResultB);
        mRbResultC = mView.findViewById(R.id.rbResultC);
        mRbResultD = mView.findViewById(R.id.rbResultD);
        mRadioGroup.setOnCheckedChangeListener(this);
        mTvExplain.setVisibility(View.GONE);
    }

    public void getQuestions(Question question) {
        mQuestion = question;
    }

    private void setData() {
        mTvQuestion.setText(mQuestion.getQuestion());
        mRbResultA.setText(mQuestion.getResultA());
        mRbResultB.setText(mQuestion.getResultB());
        mRbResultC.setText(mQuestion.getResultC());
        mRbResultD.setText(mQuestion.getResultD());
    }

    private String getAnswer() {
        int correctAnswer = mQuestion.getCorrectResult();
        switch (correctAnswer) {
            case 0:
                return mQuestion.getResultA();
            case 1:
                return mQuestion.getResultB();
            case 2:
                return mQuestion.getResultC();
            case 3:
                return mQuestion.getResultD();
        }
        return "";
    }

    private void setColor() {
        mRbResultA.setBackgroundResource(R.color.colorDefault);
        mRbResultB.setBackgroundResource(R.color.colorDefault);
        mRbResultC.setBackgroundResource(R.color.colorDefault);
        mRbResultD.setBackgroundResource(R.color.colorDefault);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        RadioButton rd = radioGroup.findViewById(checkedId);
        int index = radioGroup.indexOfChild(rd);
        setColor();
        mTvExplain.setVisibility(View.VISIBLE);
        mTvExplain.setText(mQuestion.getExplain());
        switch (index) {
            case 0:
                if (mRbResultA.getText().equals(getAnswer())) {
                    mRbResultA.setBackgroundResource(R.color.colorCorrect);
                } else {
                    mRbResultA.setBackgroundResource(R.color.colorIncorect);
                    switch (mQuestion.getCorrectResult()) {
                        case 1:
                            mRbResultB.setBackgroundResource(R.color.colorCorrect);
                            break;
                        case 2:
                            mRbResultC.setBackgroundResource(R.color.colorCorrect);
                            break;
                        case 3:
                            mRbResultD.setBackgroundResource(R.color.colorCorrect);
                            break;
                    }
                }
                break;
            case 2:
                if (mRbResultB.getText().equals(getAnswer())) {
                    mRbResultB.setBackgroundResource(R.color.colorCorrect);
                } else {
                    mRbResultB.setBackgroundResource(R.color.colorIncorect);
                    switch (mQuestion.getCorrectResult()) {
                        case 0:
                            mRbResultA.setBackgroundResource(R.color.colorCorrect);
                            break;
                        case 2:
                            mRbResultC.setBackgroundResource(R.color.colorCorrect);
                            break;
                        case 3:
                            mRbResultD.setBackgroundResource(R.color.colorCorrect);
                            break;
                    }
                }
                break;
            case 4:
                if (mRbResultC.getText().equals(getAnswer())) {
                    mRbResultC.setBackgroundResource(R.color.colorCorrect);
                } else {
                    mRbResultC.setBackgroundResource(R.color.colorIncorect);
                    switch (mQuestion.getCorrectResult()) {
                        case 0:
                            mRbResultA.setBackgroundResource(R.color.colorCorrect);
                            break;
                        case 1:
                            mRbResultB.setBackgroundResource(R.color.colorCorrect);
                            break;
                        case 3:
                            mRbResultD.setBackgroundResource(R.color.colorCorrect);
                            break;
                    }
                }
                break;
            case 6:
                if (mRbResultD.getText().equals(getAnswer())) {
                    mRbResultD.setBackgroundResource(R.color.colorCorrect);
                } else {
                    mRbResultD.setBackgroundResource(R.color.colorIncorect);
                    switch (mQuestion.getCorrectResult()) {
                        case 0:
                            mRbResultA.setBackgroundResource(R.color.colorCorrect);
                            break;
                        case 1:
                            mRbResultB.setBackgroundResource(R.color.colorCorrect);
                            break;
                        case 2:
                            mRbResultC.setBackgroundResource(R.color.colorCorrect);
                            break;
                    }
                }
                break;
        }
    }
}
