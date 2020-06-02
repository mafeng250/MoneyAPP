package cn.edu.scujcc.moneyapp.other;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import cn.edu.scujcc.moneyapp.R;

public class
OutManageActivity extends AppCompatActivity {
    //1 定义对象
    private EditText et_money, et_time, et_payer, et_remake;
    private Spinner sp_type;
    private Button btn_modify, btn_delete;
    private MyDBHelper mhelper;
    private SQLiteDatabase db;
    private OutpayBean outpayBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_manage);

        //2.绑定控件
        initView();

        //3.获取点击的哪条数据并显示出来
        getDataDisplay();

        //4.修改按钮功能的实现
        btnModify();

        //5.删除按钮功能实现
        btnDelete();

    }


    //2.绑定控件......代码
    private void initView() {
        et_money = findViewById(R.id.et_money_outmag);
        et_time = findViewById(R.id.et_time_outmag);
        sp_type = findViewById(R.id.sp_type_outmag);
        et_payer = findViewById(R.id.et_payer_outmag);
        et_remake = findViewById(R.id.et_remark_outmag);
        btn_modify = findViewById(R.id.bt_modify_outmag);
        btn_delete = findViewById(R.id.bt_delete_outmag);
        mhelper = new MyDBHelper(OutManageActivity.this);
        db = mhelper.getWritableDatabase();

    }

    //3.获取点击的哪条数据并显示出来......代码
    private void getDataDisplay() {
        outpayBean = (OutpayBean) getIntent().getSerializableExtra("sero");
        et_money.setText(outpayBean.getMoney() + "");
        et_time.setText(outpayBean.getTime());
//       sp_type.setPrompt(incomeBean.getType());
        if (outpayBean.getType().equals("电影-娱乐")) {
            sp_type.setSelection(1);
        } else if (outpayBean.getType().equals("美食—畅饮")) {
            sp_type.setSelection(2);
        } else if (outpayBean.getType().equals("欢乐—购物")) {
            sp_type.setSelection(3);
        } else if (outpayBean.getType().equals("手机-充值")) {
            sp_type.setSelection(4);
        } else if ( outpayBean.getType().equals("交通-出行")){
            sp_type.setSelection(5);
        }else if ( outpayBean.getType().equals("教育-培训")) {
            sp_type.setSelection(6);
        }else if ( outpayBean.getType().equals("社交-礼仪")) {
            sp_type.setSelection(7);
        }else if ( outpayBean.getType().equals("生活-日用")) {
            sp_type.setSelection(8);
        }else if ( outpayBean.getType().equals("其他")) {
            sp_type.setSelection(9);
        } else{
            sp_type.setSelection(0);
        }
        et_payer.setText(outpayBean.getPayer());
        et_remake.setText(outpayBean.getRemark());
    }

    //4..修改按钮功能的实现......代码
    private void btnModify(){
        btn_modify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //创建一个对象，封装一行数据
                ContentValues values = new ContentValues();
                values.put("outmoney",et_money.getText().toString());
                values.put("outime",et_time.getText().toString());
                values.put("outype",sp_type.getSelectedItem().toString());
                values.put("outayer",et_payer.getText().toString());
                values.put("outremark",et_remake .getText().toString());
                //把该行数据更新到支出表中
                db.update("pay_out",values,"id=?",new String[]{outpayBean.getId()+""});
                Toast.makeText(OutManageActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                //关闭本页面，重新打开收入明细界面，即可查询修改后的结果
                //创建Intent对象
                Intent intent=new Intent(OutManageActivity.this,PayDetailActivity.clas);
                startActivity(intent);//执行Intent操作
                finish();//退出当前程序，或关闭当前页面
            }
        });
    }

    //5.删除按钮功能实现......代码
    private void btnDelete() {
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从数据库中删除条记录即可
                db.delete("pay_out","id?",new String[]{outpayBean.getId()+""});
                Toast.makeText(OutManageActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                //关闭本页面，重新打开收入明细界面，即可查询删除后的结果
                //创建Intent对象
                Intent intent=new Intent(OutManageActivity.this,PayDetailActivity.clas);
                startActivity(intent);//执行Intent操作
                finish();//退出当前程序，或关闭当前页面
            }
        });
    }
}
