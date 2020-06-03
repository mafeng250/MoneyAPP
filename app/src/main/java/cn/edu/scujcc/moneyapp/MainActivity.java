package cn.edu.scujcc.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button newimcome, incomedetail, newpay, paydetail, dataanalyse, syssetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定控件
        initView();
        //绑定单击事件
        btnOnClick();
    }

    //绑定控件
    private void initView() {
        newimcome = findViewById(R.id.new_income_main);
        incomedetail = findViewById(R.id.income_detail_main);
        newpay = findViewById(R.id.new_pay_main);
        paydetail = findViewById(R.id.pay_detail_main);
        dataanalyse = findViewById(R.id.data_analyse_main);
        syssetting = findViewById(R.id.sys_setting_main);

    }

    //按钮单击事件
    private void btnOnClick() {
        newimcome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewInComeActivity.class);
                startActivity(intent);
            }
        });
        incomedetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InComeDetailActivity.class);
                startActivity(intent);
            }
        });
        newpay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewPayAcitivity.class);
                startActivity(intent);
            }
        });
        paydetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PayDetailActivity.class);
                startActivity(intent);
            }
        });
        dataanalyse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DataAnalyseActivity.class);
                startActivity(intent);
            }
        });
        syssetting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SysSettingActivity.class);
                startActivity(intent);
            }
        });
    }
}


