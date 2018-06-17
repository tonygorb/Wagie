package wagie.com.wagie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SecondActivity";

    String hValue;
    double hourlyRate;

    double dailyHours = 8.36;
    double dailySum, weeklySum, monthlySum, yearlySum;
    String dailyValue, weeklyValue, monthlyValue, yearlyValue;

    TextView daily, weekly, monthly, yearly;
    Button btnDaily, btnWeekly, btnMonthly, btnYearly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        hValue = intent.getStringExtra("Hourly_Rate");
        daily = findViewById(R.id.daily_result);
        daily.setVisibility(View.INVISIBLE);
        hourlyRate = Double.parseDouble(hValue);

        dailySum = hourlyRate * dailyHours;
        dailyValue = String.valueOf(dailySum);

        btnDaily = findViewById(R.id.btn_daily_result);
        btnDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daily.setVisibility(View.VISIBLE);
                daily.setText(dailyValue);

                Toast.makeText(SecondActivity.this, "שכר שעתי : " + hValue, Toast.LENGTH_SHORT).show();
            }
        });



        weekly = findViewById(R.id.weekly_result);
        weekly.setVisibility(View.INVISIBLE);

        weeklySum = dailySum * 5;
        weeklyValue = String.valueOf(weeklySum);

        btnWeekly = findViewById(R.id.btn_weekly_result);
        btnWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weekly.setVisibility(View.VISIBLE);
                weekly.setText(weeklyValue);
            }
        });


        monthly = findViewById(R.id.monthly_result);
        monthly.setVisibility(View.INVISIBLE);

        monthlySum = weeklySum * 4;
        monthlyValue = String.valueOf(monthlySum);

        btnMonthly = findViewById(R.id.btn_monthly_result);
        btnMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthly.setVisibility(View.VISIBLE);
                monthly.setText(monthlyValue);
            }
        });


        yearly = findViewById(R.id.yearly_result);
        yearly.setVisibility(View.INVISIBLE);

        yearlySum = monthlySum * 12;
        yearlyValue = String.valueOf(yearlySum);

        btnYearly = findViewById(R.id.btn_yearly_result);
        btnYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearly.setVisibility(View.VISIBLE);
                yearly.setText(yearlyValue);
            }
        });


    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_daily_result:
//
//                break;
//
//            case R.id.weekly_result:
//
//                break;
//
//            case R.id.monthly_result:
//
//                break;
//
//            case R.id.yearly_result:
//
//                break;
//        }
    }
}
