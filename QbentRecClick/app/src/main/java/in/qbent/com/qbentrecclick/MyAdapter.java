package in.qbent.com.qbentrecclick;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{

    private List<MyData> listItems;
    private Context context;

    public MyAdapter(List<MyData> listItems, Context context)
    {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.details_view,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder viewHolder, int i)
    {
        final MyData listItem = listItems.get(i);
        viewHolder.textViewName.setText(listItem.getName());
        viewHolder.textViewMobile.setText(listItem.getMobileNo());
        //viewHolder.textViewComp.setText(listItem.getCompany());

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context,"You Clicked "+listItem.getName(),Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(context,EmployeeDetailsActivity.class);
                intent3.putExtra("emp_name",listItem.getName());
                intent3.putExtra("emp_mobile",listItem.getMobileNo());
                //intent3.putExtra("emp_company",listItem.getCompany());
                context.startActivity(intent3);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textViewName;
        public TextView textViewMobile;
       // public TextView textViewComp;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewMobile = (TextView) itemView.findViewById(R.id.textViewMobile);
            //textViewComp = (TextView) itemView.findViewById(R.id.textViewComp);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.myLinear);
        }
    }
}


