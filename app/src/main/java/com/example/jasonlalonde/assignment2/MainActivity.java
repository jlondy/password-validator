package com.example.jasonlalonde.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count=0;
                input= (EditText) findViewById(R.id.password);
                output= (TextView) findViewById(R.id.prompt);
                String myString= input.getText().toString();
                Validator myValidator= new Validator(myString);
                if(myValidator.isLength()){
                    count++;
                }
                if(myValidator.isCorrect()){
                    count++;
                }
                if(count==5){
                    output.setText("Very Strong");
                }
                else if(count==4){
                    output.setText("Strong");
                }
                else if(count==3){
                    output.setText("Good");
                }
                else if(count==2){
                    output.setText("Weak");
                }
                else if(count==1){
                    output.setText("Very Weak");
                }
                else{
                    output.setText("Bad");
                }
            }
        });
    }
}

