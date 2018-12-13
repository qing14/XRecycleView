package asus.com.bwie.week3.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import asus.com.bwie.week3.R;
import asus.com.bwie.week3.bean.UsersBean;

/**
 * @author Lenovo
 */
public class MyMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    //private List<UserBean.ResultBean.DataBean> mData;
    private List<UsersBean.DataBean> mData;

    public MyMainAdapter(Context mContext) {
        this.mContext = mContext;
        mData=new ArrayList<>();
    }

    public void setmDatas(List<UsersBean.DataBean> mDatas) {
        mData.clear();
        mData.addAll(mDatas);
        notifyDataSetChanged();
    }

    public void addmDatas(List<UsersBean.DataBean> mDatas) {
        mData.addAll(mDatas);
        notifyDataSetChanged();
    }
    public void delmDatas(int mDatas) {
        mData.remove(mDatas);
        notifyDataSetChanged();
    }
    private static final int TYPE_TITIE_ONE=0;
    private static final int TYPE_TITIE_TWO=1;
    private static final int TYPE_TITIE_THREE=2;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder=null;
        if(i==TYPE_TITIE_ONE){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_one, viewGroup, false);
            viewHolder=new ViewHolderOne(view);
        }else if(i==TYPE_TITIE_TWO){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_two, viewGroup, false);
            viewHolder=new ViewHolderTwo(view);
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_three, viewGroup, false);
            viewHolder=new ViewHolderThree(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        int type = getItemViewType(i);
        switch (type){
            case TYPE_TITIE_ONE:
                final ViewHolderOne holderOne= (ViewHolderOne) viewHolder;
                Glide.with(mContext).load(mData.get(i).getThumbnail_pic_s()).into(holderOne.imageView);
                holderOne.textView.setText(mData.get(i).getTitle());
                holderOne.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ObjectAnimator alpha = ObjectAnimator.ofFloat(holderOne.imageView, "alpha", 1f, 0f,1f);
                        alpha.setDuration(2000);
                        alpha.setRepeatCount(0);
                        alpha.start();
                    }
                });
                break;
            case TYPE_TITIE_TWO:
                final ViewHolderTwo holderTwo= (ViewHolderTwo) viewHolder;
                Glide.with(mContext).load(mData.get(i).getThumbnail_pic_s()).into(holderTwo.imageView1);
                Glide.with(mContext).load(mData.get(i).getThumbnail_pic_s02()).into(holderTwo.imageView2);
                holderTwo.textView.setText(mData.get(i).getTitle());
                holderTwo.imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ObjectAnimator alpha = ObjectAnimator.ofFloat(holderTwo.imageView1, "alpha", 1f, 0f,1f);
                        alpha.setDuration(2000);
                        alpha.setRepeatCount(0);
                        alpha.start();
                    }
                });
                holderTwo.imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ObjectAnimator alpha = ObjectAnimator.ofFloat(holderTwo.imageView2, "alpha", 1f, 0f,1f);
                        alpha.setDuration(2000);
                        alpha.setRepeatCount(1);
                        alpha.start();
                    }
                });
                break;
            case TYPE_TITIE_THREE:
                final ViewHolderThree holderThree= (ViewHolderThree) viewHolder;
                Glide.with(mContext).load(mData.get(i).getThumbnail_pic_s()).into(holderThree.imageView1);
                Glide.with(mContext).load(mData.get(i).getThumbnail_pic_s02()).into(holderThree.imageView2);
                Glide.with(mContext).load(mData.get(i).getThumbnail_pic_s03()).into(holderThree.imageView3);
                holderThree.textView.setText(mData.get(i).getTitle());
                holderThree.imageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ObjectAnimator alpha = ObjectAnimator.ofFloat(holderThree.imageView1, "alpha", 1f, 0f,1f);
                        alpha.setDuration(2000);
                        alpha.setRepeatCount(0);
                        alpha.start();
                    }
                });
                holderThree.imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ObjectAnimator alpha = ObjectAnimator.ofFloat(holderThree.imageView2, "alpha", 1f, 0f,1f);
                        alpha.setDuration(2000);
                        alpha.setRepeatCount(1);
                        alpha.start();
                    }
                });
                holderThree.imageView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ObjectAnimator alpha = ObjectAnimator.ofFloat(holderThree.imageView3, "alpha", 1f, 0f,1f);
                        alpha.setDuration(2000);
                        alpha.setRepeatCount(2);
                        alpha.start();
                    }
                });



                break;
            default:
                break;

        }
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mclick!=null){
                    mclick.onLongClick(i);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        UsersBean.DataBean bean = mData.get(position);
        String pic_s = bean.getThumbnail_pic_s();
        String thumbnail_pic_s02 = bean.getThumbnail_pic_s02();
        String thumbnail_pic_s03 = bean.getThumbnail_pic_s03();
        if(pic_s!=null&&thumbnail_pic_s02==null&&thumbnail_pic_s03==null){
            return TYPE_TITIE_ONE;
        }else if(pic_s!=null&&thumbnail_pic_s02!=null&&thumbnail_pic_s03==null){
            return TYPE_TITIE_TWO;
        }else{
            return TYPE_TITIE_THREE;
        }
    }

    class ViewHolderOne extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_one);
            textView=itemView.findViewById(R.id.textView_one);
        }
    }
    class ViewHolderTwo extends RecyclerView.ViewHolder{

        private ImageView imageView1,imageView2;
        private TextView textView;
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            imageView1=itemView.findViewById(R.id.image1_two);
            imageView2=itemView.findViewById(R.id.image2_two);
            textView=itemView.findViewById(R.id.text_two);
        }
    }
    class ViewHolderThree extends RecyclerView.ViewHolder{

        private ImageView imageView1,imageView2,imageView3;
        private TextView textView;
        public ViewHolderThree(@NonNull View itemView) {
            super(itemView);
            imageView1=itemView.findViewById(R.id.image1_three);
            imageView2=itemView.findViewById(R.id.image2_three);
            imageView3=itemView.findViewById(R.id.image3_three);
            textView=itemView.findViewById(R.id.text_three);
        }
    }

    Click mclick;
    public void setClickListenter(Click click){
        mclick=click;
    }

    public interface Click{
        void onClick(int position);
        void onLongClick(int position);
    }

}
