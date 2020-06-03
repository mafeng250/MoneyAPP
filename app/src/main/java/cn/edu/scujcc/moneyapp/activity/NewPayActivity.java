package cn.edu.scujcc.moneyapp.activity;

public class NewPayActivity extends AppCompatActivity {
    // 定 义对 象
    EditText et_money,et_time,et_payer,et_remark;
        Spinner sp_type;
        Button bt_sava,bt_cancel;
        MyDBHelper mhelper;
        SQLiteDatabase db;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_pay);

            //2 绑 定控件
            initView();
            //3 保存按 钮 功能的 实现
            btnSave();

            //4 取消按 钮 功能的 实现
            btnCancel();
        }

        //2 绑 定控件 ------------------代 码
        private void initView() {
            et_money=findViewById(R.id.et_money_newout);
            et_time=findViewById(R.id.et_time_newout);
            sp_type=findViewById(R.id.sp_type_newout);
            et_payer=findViewById(R.id.et_payer_newout);
            et_remark=findViewById(R.id.et_remark_newout);
            bt_sava=findViewById(R.id.bt_save_newout);
            bt_cancel=findViewById(R.id.bt_cancel_newout);
            mhelper=new MyDBHelper(NewPayActivity.this);
            db=mhelper.getWritableDatabase();
        }

    //3保存按 钮 功能的 实现 -------代 码
    private void btnSave() {
            bt_sava.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 获 取 输 入的 内 容保存到 数 据 库 的收入表中
                    ContentValues values=new ContentValues();
                    values.put("outmoney",et_money.getText().toString());
                    values.put("outtime",et_time.getText().toString());
    values.put("outtype",sp_type.getSelectedItem().toString());
                    values.put("outpayee",et_payer.getText().toString());
                    values.put("outremark",et_remark.getText().toString());
                    db.insert("pay_out",null,values);
                    Toast.makeText(NewPayActivity.this,"保存成功 ",Toast.LENGTH_SHORT).show();
                    // 刷新本 页 面
                    Intent intent=new Intent(NewPayActivity.this, NewPayActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        //4 取消按 钮 功能的 实现 -------代 码
        private void btnCancel() {
            bt_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(NewPayActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }


    }