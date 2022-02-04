package com.rohanbari.loopdecision;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rohanbari.loopdecision.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        IntegerNumber number = new IntegerNumber(0);

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.textNumber.setText(String.valueOf(number.getNumber()));

        // Adding the onClick listeners
        binding.buttonIncrement.setOnClickListener(v -> {
            number.increment();
            displayNumberOnScreen(binding, number.getNumber());

            Log.d(TAG, "onCreate: buttonIncrement() by one");
        });

        binding.buttonDecrement.setOnClickListener(v -> {
            int value = number.getNumber();

            if (value > 0)
                number.decrement();
            else
                Toast.makeText(getApplicationContext(),
                        "Cannot go more less!",
                        Toast.LENGTH_SHORT).show();

            displayNumberOnScreen(binding, number.getNumber());
            Log.d(TAG, "onCreate: buttonDecrement() by one");
        });

        binding.buttonIncrementBy10.setOnClickListener(v -> {
            // Loop to repeat ten times
            for (int i = 0; i < 10; i++) {
                number.increment();
                displayNumberOnScreen(binding, number.getNumber());
            }
        });

        binding.buttonDecrementBy10.setOnClickListener(v -> {
            int value = number.getNumber();

            // Checking whether the value is less than zero, or the subtraction of 10 from the value
            // is negative. If it is, then safely show the Toast and exit.
            if (value < 0 || (value - 10) < 0) {
                Toast.makeText(getApplicationContext(),
                        "Cannot go more less!",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Loop to repeat ten times
            for (int i = 0; i < 10; i++) {
                number.decrement();
                displayNumberOnScreen(binding, number.getNumber());
            }
        });
    }

    /**
     * Method to set the text of the textNumber widget.
     *
     * @param binding Name of the binding activity
     * @param number  The number in integer
     */
    void displayNumberOnScreen(ActivityMainBinding binding, int number) {
        binding.textNumber.setText(String.valueOf(number));
    }
}