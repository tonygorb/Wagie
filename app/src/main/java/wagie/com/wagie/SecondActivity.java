package wagie.com.wagie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    String hValue;
    double hourlyRate;

    double dailyHours = 8.36;
    double dailySum, weeklySum, monthlySum, yearlySum;
    String dailyValue, weeklyValue, monthlyValue, yearlyValue;

    TextView daily, weekly, monthly, yearly;
    Button btnDaily, btnWeekly, btnMonthly, btnYearly, btnStartOver;

    boolean showFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Intent intent = getIntent();
        hValue = intent.getStringExtra("Hourly_Rate");
        daily = findViewById(R.id.daily_result);
        daily.setVisibility(View.GONE);

        hourlyRate = Double.parseDouble(hValue);

        dailySum = hourlyRate * dailyHours;
        dailyValue = String.format("%.2f", dailySum);

        btnDaily = findViewById(R.id.btn_daily_result);
        btnDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showFirst == true){
                    daily.setVisibility(View.VISIBLE);
                    daily.setText(dailyValue + " ₪");
                    showFirst = false;
                } else {
                    daily.setVisibility(View.GONE);
                    daily.setText("");
                    showFirst = true;
                }
            }
        });



        weekly = findViewById(R.id.weekly_result);
        weekly.setVisibility(View.GONE);

        weeklySum = dailySum * 5;
        weeklyValue = String.format("%.2f", weeklySum);

        btnWeekly = findViewById(R.id.btn_weekly_result);
        btnWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showFirst == true){
                    weekly.setVisibility(View.VISIBLE);
                    weekly.setText(weeklyValue + " ₪");
                    showFirst = false;
                } else {
                    weekly.setVisibility(View.GONE);
                    weekly.setText("");
                    showFirst = true;
                }
            }
        });


        monthly = findViewById(R.id.monthly_result);
        monthly.setVisibility(View.GONE);

        monthlySum = weeklySum * 4;
        monthlyValue = String.format("%.2f", monthlySum);

        btnMonthly = findViewById(R.id.btn_monthly_result);
        btnMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showFirst == true){
                    monthly.setVisibility(View.VISIBLE);
                    monthly.setText(monthlyValue + " ₪");
                    showFirst = false;
                } else {
                    monthly.setVisibility(View.GONE);
                    monthly.setText("");
                    showFirst = true;
                }
            }
        });


        yearly = findViewById(R.id.yearly_result);
        yearly.setVisibility(View.GONE);

        yearlySum = monthlySum * 12;
        yearlyValue = String.format("%.2f", yearlySum);

        btnYearly = findViewById(R.id.btn_yearly_result);
        btnYearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showFirst == true){
                    yearly.setVisibility(View.VISIBLE);
                    yearly.setText(yearlyValue + " ₪");
                    showFirst = false;
                } else {
                    yearly.setVisibility(View.GONE);
                    yearly.setText("");
                    showFirst = true;
                }
            }
        });

        btnStartOver = findViewById(R.id.third_btn_start_over);
        btnStartOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(main);
                overridePendingTransition(0,0);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
