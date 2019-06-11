package com.example.calculatorprojectakhir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner operasi;
    private EditText b1;
    private EditText b2;
    private TextView result;
    private Button calculate;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        setupDropdown();
        setupCalcBtn();
    }

    private void setupUI(){
        operasi = (Spinner)findViewById(R.id.op);
        b1 = (EditText)findViewById(R.id.bil1);
        b2 = (EditText)findViewById(R.id.bil2);
        result = (TextView)findViewById(R.id.output);
        calculate = (Button)findViewById(R.id.calcBtn);
    }

    private void setupDropdown(){
        arrayAdapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.operasi_array)
        );

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operasi.setAdapter(arrayAdapter);
    }

    private void setupCalcBtn(){
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ambil angka
                double num1;
                String tulisan1 = b1.getText().toString();
                        if(!tulisan1.isEmpty()){
                            num1 = Double.parseDouble(tulisan1);
                        }else {
                            num1=0;
                        }

                double num2;
                String tulisan2 = b2.getText().toString();
                        if(!tulisan2.isEmpty()){
                            num2 = Double.parseDouble(tulisan2);
                        }else{
                            num2=0;
                        }



                String op = operasi.getSelectedItem().toString();
                double hasil;

                switch(op){
                    case "+":
                        hasil = num1+num2;
                        break;
                    case "-":
                        hasil = num1-num2;
                        break;
                    case "/":
                        hasil = num1/num2;
                        break;
                    case "*":
                        hasil = num1*num2;
                        break;
                    case "%":
                        hasil = num1%num2;
                        break;
                    default:
                        hasil = 0;
                        break;
                }

                result.setText(hasil + "");
            }
        });
    }


}
