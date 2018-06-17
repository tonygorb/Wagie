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
    double dailySum;
    String dailyValue;

    TextView daily, weekly, mothly, yearly;

    Button btnDaily;

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_daily_result:

                break;

            case R.id.weekly_result:

                break;

            case R.id.monthly_result:

                break;

            case R.id.yearly_result:

                break;
        }
    }
}
