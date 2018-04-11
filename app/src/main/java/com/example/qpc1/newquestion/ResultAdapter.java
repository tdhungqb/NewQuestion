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

    public ResultAdapter(List<Result> results, Context context, int layout) {
        this.mResults = results;
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
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(mLayout,null);
            viewHolder = new ViewHolder();
            viewHolder.tvResult = view.findViewById(R.id.tvResult);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Result result = mResults.get(position);
        viewHolder.tvResult.setText(result.getResult());
        return view;
   }
}
