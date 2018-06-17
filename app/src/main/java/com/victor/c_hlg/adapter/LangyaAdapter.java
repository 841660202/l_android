package com.victor.c_hlg.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.victor.c_hlg.bean.LangyaSimple;
import com.victor.c_hlg.R;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class LangyaAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private LayoutInflater inflater;

    private List<LangyaSimple> mPlanDetails;

    public LangyaAdapter(Activity context, List<LangyaSimple> mPlanDetails) {
        inflater = LayoutInflater.from(context);
        this.mPlanDetails = mPlanDetails;

    }

    @Override
    public int getCount() {
        return mPlanDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlanDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item_proj_plan, parent, false);

            holder.img_plan = (ImageView) convertView.findViewById(R.id.img_plan);

            holder.text_plan_name = (TextView) convertView.findViewById(R.id.text_plan_name);
            holder.text_plan_info = (TextView) convertView.findViewById(R.id.text_plan_info);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        LangyaSimple planDetail = this.mPlanDetails.get(position);

        if (planDetail != null) {

//            ImageLoaderUtil.getInstance().displayListItemImage(imgUrl, holder.img_plan);
            holder.img_plan.setBackgroundResource(R.drawable.me);
            holder.text_plan_name.setText(planDetail.getTitle());
            holder.text_plan_info.setText(planDetail.getDesc());
        }

        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = inflater.inflate(R.layout.proj_plans_header, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }
        //set proj_plans_header text as first char in name
        String headerText = this.mPlanDetails.get(position).getProject_title();
        holder.text.setText(headerText);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        //return the first character of the country as ID because this is what headers are based upon
        return Long.parseLong(this.mPlanDetails.get(position).getProj_id());
    }

    class HeaderViewHolder {
        TextView text;
    }

    class ViewHolder {
        ImageView img_plan;

        TextView text_plan_name;

        TextView text_plan_info;
    }
}
