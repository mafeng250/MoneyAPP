package cn.edu.scujcc.moneyapp.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import cn.edu.scujcc.moneyapp.R;
import cn.edu.scujcc.moneyapp.adapter.OutpayAdapter;
import cn.edu.scujcc.moneyapp.bean.IncomeBean;
import cn.edu.scujcc.moneyapp.bean.OutpayBean;
import cn.edu.scujcc.moneyapp.db.MyDBHelper;

public class PayDetailActivity extends AppCompatActivity {
    //1 定义对象
    RecyclerView recy_view;
    MyDBHelper mhelper;
    SQLiteDatabase db;
    List<OutpayBean>arr1=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_detail);
        //2绑定挂件
        initView();
        //3准备数据
        initData();
        //4设计每一行的子布局

        //5创建适配器
        OutpayAdapter adapter=new OutpayAdapter(PayDetailActivity.this,arr1);
        //6将适配器和布局管理器加载到控件当中
        StaggeredGridLayoutManager st=new StaggeredGridLayoutManager(StaggeredGridLayoutManager.VERTICAL,1);
        recy_view.setLayoutManager(st);
        recy_view.setAdapter(adapter);
    }

    //2绑定挂件
    private void initView() {
        recy_view=findViewById(R.id.recy_view_indetail);
        mhelper=new MyDBHelper(PayDetailActivity.this);
        db=mhelper.getwritableDatabase();
    }
    //3准备数据
    private void initData() {
        //从数据库查询所有的新增信息
        Cursor cursor=db.rawQuery("select* from pay_out",null);
        while(cursor.moveToNext()) {
            int myid = Cursor.getInt(cursor.getColumnIndex("id"));
            double mymoney = cursor.getDouble(cursor.getColumnIndex("outmoney"));
            String mytime = cursor.getString(cursor.getColumnIndex("outtime"));
            String mytype = cursor.getString(cursor.getColumnIndex("outtype"));
            String mypayer = cursor.getString(cursor.getColumnIndex("outpayee"));
            String myremark = cursor.getString(cursor.getColumnIndex("outremark"));
            OutpayBean outpayBean = new OutpayBean(myid, mymoney, mytime, mytype, mypayer, myremark);
            arr1.add(outpayBean);
        }
}
