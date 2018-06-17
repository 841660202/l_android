package com.victor.c_hlg.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.victor.c_hlg.R;

public class CollapsingActivity2 extends AppCompatActivity {

    // 模仿RecyclerView的数据
    String[] mDatas = {"Each of us holds a unique place in the world. You are special,no matter what others say or what you may think. So forget about being replaced. You can’t be.",
            "How beautiful it was, falling so silently, all day long, all night long, on the mountains, on the meadows, on the roofs of the living, on the graves1) of the dead!",
            "All white save the river, that marked2) its course by a winding black line across the landscape3), and the leafless trees, that against the leaden4) sky now revealed more fully the wonderful beauty and intricacy5) of their branches!",
            "What silence, too, came with the snow, and what seclusion6)! Every sound was muffled7); every noise changed to something soft and musical.",
            "In the entire world there's nobody like me. Since the beginning of time, there has never been another person like me. Nobody has my smile. Nobody has my eyes, my nose, my hair, my hands, or my voice.",
            "If you give up when it's winter, you will miss the promise of your spring, the beauty of your summer, fulfillment of your fall. Don't let the pain of one season destroy the joy of all the rest.",
            "A burning desire is the starting point of all accomplishment. Just like a small fire cannot give much heat, a weak desire cannot produce great results.",
            "I have drunk the cup of life down to its very dregs7). They have only sipped the bubbles on top of it. I know things they will never know. I see things to which they are blind.",
            "It is only the women whose eyes have been washed clear with tears who get the broad vision that makes them little sisters to all the world."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        initToolBar();
        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctl_layout);
        //初始化RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        ctlLayout.setTitle("Victor");
        ctlLayout.setExpandedTitleColor(Color.WHITE);
        ctlLayout.setCollapsedTitleTextColor(Color.YELLOW);



        //创建LinearLayoutManager 对象 这里使用LinearLayoutManager 是线性布局的意思
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        StaggeredGridLayoutManager layoutmanager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //设置RecyclerView 布局
        recyclerView.setLayoutManager(layoutmanager);


        //设置Adapter
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setOnItemClickLitener(new OnItemClickLitener()
        {

            @Override
            public void onItemClick(View view, int position)
            {
                Toast.makeText(CollapsingActivity2.this, position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position)
            {
                Toast.makeText(CollapsingActivity2.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(getApplicationContext(), R.layout.list_item, null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
//            Log.i("'position'", String.valueOf(position));
//            holder.mTextView.setText(mDatas[position]);
            holder.mTextView.setText(mDatas[position]);

            // 如果设置了回调，则设置点击事件
            if (mOnItemClickLitener != null)
            {
                holder.itemView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        mOnItemClickLitener.onItemClick(holder.itemView, position);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
                {
                    @Override
                    public boolean onLongClick(View v)
                    {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                        return false;
                    }
                });
            }









        }

        @Override
        public int getItemCount() {
            return mDatas.length;
        }

        private OnItemClickLitener mOnItemClickLitener;

        public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
        {
            this.mOnItemClickLitener = mOnItemClickLitener;
        }




    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

}
