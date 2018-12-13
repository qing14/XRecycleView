package asus.com.bwie.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;


import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.Map;

import asus.com.bwie.week3.adapter.MyMainAdapter;
import asus.com.bwie.week3.bean.UsersBean;
import asus.com.bwie.week3.persenter.IPersenterImpl;
import asus.com.bwie.week3.view.IView;

public class MainActivity extends AppCompatActivity implements IView {
    private XRecyclerView xRecyclerView;
    private int mPage=1;
    private IPersenterImpl iPersenter;
    private MyMainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xRecyclerView=findViewById(R.id.XRecyclerView);
        iPersenter=new IPersenterImpl(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);

        adapter = new MyMainAdapter(this);
        xRecyclerView.setAdapter(adapter);

        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPage=1;
                loadData();
            }

            @Override
            public void onLoadMore() {
                mPage++;
                loadData();
            }
        });
        loadData();
        mPage++;

        adapter.setClickListenter(new MyMainAdapter.Click() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void onLongClick(int position) {
                adapter.delmDatas(position);
                adapter.notifyDataSetChanged();

            }
        });


    }

    private void loadData() {
        Map<String,String> params=new HashMap<>();
        //  params.put("type","");
        params.put("page",mPage+"");
        iPersenter.getRequest(Apks.TYPE_TITLE,params,UsersBean.class);

    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof UsersBean){
            UsersBean userBean= (UsersBean) data;
            if(mPage==1){
                adapter.setmDatas(userBean.getData());
            }
                adapter.addmDatas(userBean.getData());

            mPage++;
            xRecyclerView.refreshComplete();
            xRecyclerView.loadMoreComplete();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPersenter.deteach();
    }
}
