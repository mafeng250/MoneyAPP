package cn.edu.scujcc.moneyapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.scujcc.moneyapp.R;
import cn.edu.scujcc.moneyapp.bean.IncomeBean;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.ViewHolder> {
    Context mcontext;
    List<IncomeBean> arr2;

    public IncomeAdapter(Context mcontext, List<IncomeBean> arr2) {
        this.mcontext = mcontext;
        this.arr2 = arr2;
    }

    //用于创建ViewHolder实例
    @Override
    public IncomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.recy_item_in,parent,false);
        ViewHolder mholder=new ViewHolder(view);
        return mholder;
    }

    //对RecyclerView子项进行赋值的
    @Override
    public void onBindViewHolder(@NonNull IncomeAdapter.ViewHolder mholder, int position) {
    IncomeBean incomeBean=arr2.get(position);
    mholder.item_payer.setText("收款—来自"+incomeBean.getPlayer());
    mholder.item_type.setText(incomeBean.getType());
    mholder.item_time.setText(incomeBean.getTime());
    mholder.item_remark.setText(incomeBean.getRemark());
    mholder.item_money.setText("+"+incomeBean.getMoney());

    }
    //recyclerView一共有多少子项
    @Override
    public int getItemCount() {
        return arr2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_payer,item_type,item_time,item_remark,item_money;
        public ViewHolder(View itemView) {
            super(itemView);
            item_payer=itemView.findViewById(R.id.item_payer_in);
            item_type=itemView.findViewById(R.id.item_type_in);
            item_time=itemView.findViewById(R.id.item_time_in);
            item_remark=itemView.findViewById(R.id.item_remark_in);
            item_money=itemView.findViewById(R.id.item_money_in);

        }
    }
}
