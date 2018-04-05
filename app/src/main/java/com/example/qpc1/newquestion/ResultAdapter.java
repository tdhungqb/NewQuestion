package com.example.qpc1.newquestion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class ResultAdapter  extends BaseAdapter{
    private List<Result> mResults;
    private Context mContext;
    private int mLayout;

    public ResultAdapter(List<Result> result, Context context, int layout) {
        this.mResults = result;
        this.mContext = context;
        this.mLayout = layout;
    }

    @Override
    public int getCount() {
        return mResults.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView tvResult;
    }
    @Override
    public View getView(int position, View mView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(mLayout,null);
            viewHolder = new ViewHolder();
            viewHolder.tvResult = mView.findViewById(R.id.tvResult);
            mView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) mView.getTag();
        }
        Result result = mResults.get(position);
        viewHolder.tvResult.setText(result.getResult());
        return mView;
   }
}
