package com.example.qpc1.newquestion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private List<Result> mResults;
    private GridView mGvResult;
    private View mView;
    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_result, container, false);
        initListOfResults();
        initView();
        return mView;

    }

    private void initListOfResults() {
        mResults = new ArrayList<>();
        for (int i = 1; i<= 20 ; i++) {
            mResults.add(new Result("" + i));
        }
    }

    private void initView() {
        mGvResult = (GridView)mView.findViewById(R.id.gvResult);
        ResultAdapter resultAdapter = new ResultAdapter(mResults,getContext(),R.layout.gridview_result);
        mGvResult.setAdapter(resultAdapter);
    }
}
