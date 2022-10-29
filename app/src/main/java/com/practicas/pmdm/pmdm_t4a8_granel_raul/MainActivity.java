package com.practicas.pmdm.pmdm_t4a8_granel_raul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.practicas.pmdm.pmdm_t4a8_granel_raul.dao.OperatorDao;
import com.practicas.pmdm.pmdm_t4a8_granel_raul.model.Operator;
import com.practicas.pmdm.pmdm_t4a8_granel_raul.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private OperatorDao operatorDao = new OperatorDao();
    private Utility utility = new Utility();

    private Spinner spinner;
    ArrayAdapter<Operator> adapter = null;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private Button btnCalculate;
    private List<Operator> operatorList = null;
    private String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Components
        init();
        spinner.setOnItemSelectedListener(this);

        // Get the Spinner element selected.
        item = utility.getSelectedSpinnerItem(spinner);
    }

    public void init() {
        spinner = findViewById(R.id.sp1);
        operatorList = operatorDao.getOperatorsList();

        // Get EditText elements.
        et1 = (EditText) this.findViewById(R.id.et1);
        et2 = (EditText) this.findViewById(R.id.et2);
        et3 = (EditText) this.findViewById(R.id.et3);
        btnCalculate = (Button) this.findViewById(R.id.btnCalculate);

        adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operatorList);
        spinner.setAdapter(adapter);

        if (operatorList == null) {
            operatorList = new ArrayList<>();
            Operator operator = new Operator();
            operator.setId(0);
            operator.setName("No existen datos para mostrar.");

            operatorList.add(operator);
        }
    }

    public String operate(String num1, String num2, String item) {

        String etResult = "";
        int result = 0;

        int number1 = 0;
        int number2 = 0;

        boolean isNumber1 = utility.checkNumber(num1);
        boolean isNumber2 = utility.checkNumber(num2);


        // Check Integer numbers and get message.
        if (!isNumber1 && !isNumber2) {
            etResult = "Los números introducidos, no son un números. \n";
        } else {
            if (!isNumber1) {
                etResult = "El primer número introducido, no es un número. \n";
            } else {
                number1 = Integer.parseInt(et1.getText().toString());
            }
            if (!isNumber2) {
                etResult = "El segundo número introducido, no es un número.";
            } else {
                number2 = Integer.parseInt(et2.getText().toString());
            }
        }

        // Operate
        if (isNumber1 && isNumber2 && item != null & !"".equalsIgnoreCase(item)) {
            switch (item) {
                case "SUMAR":
                    result = number1 + number2;
                    break;
                case "RESTAR":
                    result = number1 - number2;
                    break;
                case "MULTIPLICAR":
                    result = number1 * number2;
                    break;
                case "DIVIDIR":
                    result = number1 / number2;
                    break;
            }
            etResult = Integer.toString(result);
        }
        return etResult;
    }

    public void buttonEvent(View view) {
        item = utility.getSelectedSpinnerItem(spinner);
        String res = operate(et1.getText().toString(), et2.getText().toString(), item).toString();
        et3.setText(res);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}