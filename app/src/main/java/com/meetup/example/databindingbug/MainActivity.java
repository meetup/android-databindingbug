package com.meetup.example.databindingbug;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.meetup.example.databindingbug.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Button decr, incr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setFoo(new Foo());
        binding.setC(0);
        decr = (Button) findViewById(R.id.decr);
        incr = (Button) findViewById(R.id.incr);
        decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.setC(binding.getC() - 1);
            }
        });
        incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.setC(binding.getC() + 1);
            }
        });
    }

    @BindingAdapter("bind:present")
    public static void setPresent(View view, boolean present) {
        view.setVisibility(present ? View.VISIBLE : View.GONE);
    }
}
