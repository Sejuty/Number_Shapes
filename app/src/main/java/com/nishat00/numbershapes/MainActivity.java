package com.nishat00.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void check(View view) {

        EditText enterNumber = (EditText) findViewById(R.id.editTextNumber);
        String value = enterNumber.getText().toString();
        String message;
        if(value.isEmpty())
            message= "Enter a number!!";
        else {
            shapesNumber num = new shapesNumber();
            num.number = Integer.parseInt(value);

            if (num.isTriangular() && num.isSquare())
                message = "Triangular and Square!!";
            else if (!num.isTriangular() && num.isSquare())
                message = "Square!!";
            else if (num.isTriangular() && !num.isSquare())
                message = "triangular!!";
            else
                message = "Nope!!";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    class shapesNumber {
        int number;

        public boolean isTriangular() {

            int x = 1;
            int triNumber = 1;

            while (number > triNumber) {
                x++;
                triNumber += x;
            }
            if (number == triNumber)
                return true;
            else
                return false;
        }

        public boolean isSquare() {
            double squareNumber = Math.sqrt(number);
            if ((squareNumber == Math.floor(squareNumber)) && !Double.isInfinite(squareNumber))
                return true;
            else return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}