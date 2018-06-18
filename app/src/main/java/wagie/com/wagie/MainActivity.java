package wagie.com.wagie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText hRate;
    String hRateValue;

    TextView mError;

    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        hRate = findViewById(R.id.et_hourly_rate);
        hRate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mError.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        mError = findViewById(R.id.main_tv_error);
        mError.setVisibility(View.INVISIBLE);

        btnNext = findViewById(R.id.main_btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hRateValue = hRate.getText().toString();

                if (hRateValue.isEmpty()){
                    mError.setVisibility(View.VISIBLE);
                    mError.setText("הכנס ספרה תקינה");
                } else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("Hourly_Rate", hRate.getText().toString());
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent finish = new Intent(Intent.ACTION_MAIN);
        finish.addCategory(Intent.CATEGORY_HOME);
        finish.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(finish);
    }
}
