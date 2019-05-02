package in.qbent.com.qbentrecclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EmployeeDetailsActivity extends AppCompatActivity {

    Button myButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        myButton2 = (Button) findViewById(R.id.goList);

        getIncomingIntent();
    }

    public void backList(View view)
    {
        Intent intent = new Intent(getApplicationContext(),RecycleClickActivity.class);
        startActivity(intent);
    }

    public void getIncomingIntent()
    {
        if(getIntent().hasExtra("emp_name") && getIntent().hasExtra("emp_mobile"))
        {
            String EmployeeName = getIntent().getStringExtra("emp_name");
            String EmployeeMobile = getIntent().getStringExtra("emp_mobile");
            //String CompanyName = getIntent().getStringExtra("emp_company");

            setDetails(EmployeeName, EmployeeMobile);
        }
    }

    public void setDetails(String EmployeeName, String EmployeeMobile)
    {
        TextView ename  = findViewById(R.id.employeeName);
        ename.setText(EmployeeName);

        TextView eaddr  = findViewById(R.id.employeeMobileNumber);
        eaddr.setText(EmployeeMobile);

//        TextView ecomp  = findViewById(R.id.employeeCompany);
//        ecomp.setText(CompanyName);
    }
}
