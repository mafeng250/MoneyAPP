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
import cn.edu.scujcc.moneyapp.bean.OutpayBean;

public class OutpayAdapter extends RecyclerView.Adapter<OutpayAdapter.ViewHolder> {
    Context mcontext;
    List<OutpayBean> arr2;

    public OutpayAdapter(Context mcontext, List<OutpayBean> arr2) {
        this.mcontext = mcontext;
        this.arr2 = arr2;
    }

    //用于创建ViewHolder实例
    @Override
    public OutpayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.recy_item_out,parent,false);
        ViewHolder mholder=new ViewHolder(view);
        return mholder;
    }

    //对RecyclerView子项进行赋值的
    @Override
    public void onBindViewHolder(@NonNull OutpayAdapter.ViewHolder mholder, int position) {
        OutpayBean outpayBean=arr2.get(position);
    mholder.item_payee.setText("付款-给"+outpayBean.getPlayer());
    mholder.item_type.setText(outpayBean.getType());
    mholder.item_time.setText(outpayBean.getTime());
    mholder.item_remark.setText(outpayBean.getRemark());
    mholder.item_money.setText("-"+outpayBean.getMoney());

    }
    //recyclerView一共有多少子项
    @Override
    public int getItemCount() {
        return arr2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_payee,item_type,item_time,item_remark,item_money;
        public ViewHolder(View itemView) {
            super(itemView);
            item_payee=itemView.findViewById(R.id.item_payee_out);
            item_type=itemView.findViewById(R.id.item_type_out);
            item_time=itemView.findViewById(R.id.item_time_out);
            item_remark=itemView.findViewById(R.id.item_remark_out);
            item_money=itemView.findViewById(R.id.item_money_out);

        }
    }
}
