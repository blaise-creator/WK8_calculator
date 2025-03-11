package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Private variables for UI elements (input fields and result display)
    private EditText Number1;
    private EditText Number2;
    private TextView ResultBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Linking UI elements with their IDs in XML
        Number1 = findViewById(R.id.Number1);
        Number2 = findViewById(R.id.Number2);
        ResultBox = findViewById(R.id.ResultBox);
    }
    // Calculate method for handling the operation
    private void calculate(View view, String operator) {
        // Retrieving user input as strings from EditText fields
        String str1 = Number1.getText().toString();
        String str2 = Number2.getText().toString();

        // Parsing strings to double values for calculations
        double num1 = Double.parseDouble(str1);
        double num2 = Double.parseDouble(str2);
        double result;

        // Switch case to determine which operation to perform
        switch (operator) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                // Handling division by zero case
                if (num2 == 0) {
                    ResultBox.setText("Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                return;
        }

        ResultBox.setText("Result: "+result);
    }

    // These methods when the buttons are clicked in XML
    public void add(View view) { calculate(view, "add"); }
    public void subtract(View view) { calculate(view, "subtract"); }
    public void multiply(View view) { calculate(view, "multiply"); }
    public void divide(View view) { calculate(view, "divide"); }
}
