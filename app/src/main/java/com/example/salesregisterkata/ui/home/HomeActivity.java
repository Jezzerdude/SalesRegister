package com.example.salesregisterkata.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.salesregisterkata.R;
import com.example.salesregisterkata.engine.PriceCalculatorImpl;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    private EditText etLabel;
    private EditText etQuantity;
    private EditText etUnitPrice;
    private EditText etStateCode;

    private Button btnCalculate;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLabel = findViewById(R.id.etLabel);
        etQuantity = findViewById(R.id.etQuantity);
        etUnitPrice = findViewById(R.id.etPrice);
        etStateCode = findViewById(R.id.etStateCode);

        btnCalculate = findViewById(R.id.btnCalculate);

        tvResult = findViewById(R.id.tvResult);

        HomeContract.Presenter presenter = new HomePresenter(new PriceCalculatorImpl(), this);

        btnCalculate.setOnClickListener(view -> { presenter.calculateTotal(etLabel.getText().toString(),
                etQuantity.getText().toString(),
                etUnitPrice.getText().toString(),
                etStateCode.getText().toString());
        });
    }

    @Override
    public void showResult(String result) {
        tvResult.setText(result);
    }
}
