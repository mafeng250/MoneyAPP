package cn.edu.scujcc.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SysSettingActivity extends AppCompatActivity {
    //定义对象
    TextView txt_user;
    TextInputEditText yspwd,newpwd,zrpwd;
    Button bt_modify,bt_cancel;
    MyDBHelper mhelper;
    SQLiteDatabase db;
    String name;
    String pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_setting);
        //绑定控件
        initView();
        //第三步：显示当前登录的用户名
        displayInfo();
        //修改按钮功能
        btnModify();
        //取消按钮功能
        btncancel();
    }
    private void initView(){
        txt_user = findViewById(R.id.sys_name);
        yspwd = findViewById(R.id.sys_yuanshi_password);
        newpwd = findViewById(R.id.sys_new_password);
        zrpwd = findViewById(R.id.sys_queren_password);
        bt_modify = findViewById(R.id.sys_qr_btn);
        bt_cancel = findViewById(R.id.sys_cancel_btn);
        mhelper = new MyDBHelper(SysSettingActivity.this);
        db = mhelper.getWritableDatabase();
    }
    private void displayInfo(){
        name = getSharedPreferences("userinfo",0).getString("username","");
        pwd = getSharedPreferences("userinfo",0).getString("userpwd","");
        txt_user.setText(name);
    }
    private  void btnModify(){
        bt_modify.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //获取三个输入框的内容
                String ypwd = yspwd.getText().toString();
                String xpwd = newpwd.getText().toString();
                String zpwd = zrpwd.getText().toString();
                //对每个密码进行判断
                if(ypwd.equals("")){
                    Toast.makeText(SysSettingActivity.this,"请输入原始密码",Toast.LENGTH_SHORT).show();
                }else if (!ypwd.equalsIgnoreCase(pwd)){
                    Toast.makeText(SysSettingActivity.this,"输入的密码与原密码不一致",Toast.LENGTH_SHORT).show();
                }else if(xpwd.equals("")){
                    Toast.makeText(SysSettingActivity.this,"请输入新密码",Toast.LENGTH_SHORT).show();
                }else if(xpwd.equalsIgnoreCase(ypwd)){
                    Toast.makeText(SysSettingActivity.this,"请输入新密码与原始密码不一致",Toast.LENGTH_SHORT).show();
                }else if(zpwd.equals("")){
                    Toast.makeText(SysSettingActivity.this,"请从新输入新密码",Toast.LENGTH_SHORT).show();
                }else if(!zpwd.equalsIgnoreCase(xpwd)){
                    Toast.makeText(SysSettingActivity.this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
                }else{
                    ContentValues values = new ContentValues();
                    values.put("pwd",xpwd);
                    db.update("tb_userinfo",values,"name=?",new String[]{name});
                    Toast.makeText(SysSettingActivity.this,"密码修改成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SysSettingActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    private void btncancel(){
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SysSettingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
