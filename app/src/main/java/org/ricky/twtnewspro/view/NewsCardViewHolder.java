package org.ricky.twtnewspro.view;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.ricky.twtnewspro.R;
import org.ricky.twtnewspro.bean.NewsSummaryDataBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ricky on 2017/3/17.
 */

public class NewsCardViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textview_subject)
    TextView mSubjectTextView;
    @BindView(R.id.textview_summary)
    TextView mSummaryTextView;
    @BindView(R.id.textview_visit)
    TextView mVisitTextView;
    @BindView(R.id.textview_comment)
    TextView mCommentTextView;
    @BindView(R.id.imageview)
    ImageView mImageView;
    @BindView(R.id.cardview_news)
    CardView mNewsCardView;
    private Activity mActivity;

    private NewsCardViewHolder(View itemView, Activity mActivity) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mActivity = mActivity;
    }

    public static NewsCardViewHolder create(LayoutInflater layoutInflater, ViewGroup parent, Activity activity) {
        return new NewsCardViewHolder(layoutInflater.inflate(R.layout.cardview_news, parent, false), activity);
    }

    public void setItem(NewsSummaryDataBean item) {
        mSubjectTextView.setText(item.getSubject());
        mSummaryTextView.setText(item.getSummary().replaceAll("(&nbsp;)|\\s", ""));
        mVisitTextView.setText(Integer.toString(item.getVisitcount()));
        mCommentTextView.setText(Integer.toString(item.getComments()));
        if (item.getPic() != null && !item.getPic().isEmpty()) {
            mImageView.setVisibility(View.VISIBLE);
            Glide.with(mActivity)
                    .load(item.getPic())
                    .centerCrop()
                    .crossFade()
                    .into(mImageView);
        } else {
            mImageView.setVisibility(View.GONE);
        }
        mNewsCardView.setOnClickListener(v -> DetailActivity.startActivity(mActivity, item.getIndex()));
    }

}
