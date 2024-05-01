package com.example.cartest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class ResultActivity extends AppCompatActivity {

    MaterialCardView home;
    TextView correctCount, wrongCount, resultInformation, resultScore;
    ImageView resultImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Определение элементов UI в коде
        home = findViewById(R.id.returnHome);
        correctCount = findViewById(R.id.correctScore);
        wrongCount = findViewById(R.id.wrongScore);
        resultInformation = findViewById(R.id.resultInfo);
        resultScore = findViewById(R.id.resultScore);
        resultImage = findViewById(R.id.resultImage);

        int correct = getIntent().getIntExtra("Правильно", 0);
        int wrong = getIntent().getIntExtra("Ошибок", 0);
        int score = correct;

        correctCount.setText(""+correct);
        wrongCount.setText(""+wrong);
        resultScore.setText(""+score);


        if (correct <= 2) {
            // Если колическто верных ответом меньше 3
            resultInformation.setText("Надо больше тренироватся!");
            resultImage.setImageResource(R.drawable.ic_sad);
        } else if (correct >= 3 && correct <= 5) {
            // Если количество верных от 3 до 5
            resultInformation.setText("Попробуй снова!");
            resultImage.setImageResource(R.drawable.ic_neutral);
        } else {
            // Если количество верных больше 6
            resultInformation.setText("Молодец!");
            resultImage.setImageResource(R.drawable.ic_smile);
        }

        // Действие на кнопку возврата
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    // Кнопка возврата (та что на нижней панеле телефона)
    @Override
    public void onBackPressed(){
        startActivity(new Intent(ResultActivity.this, MainActivity.class));
        finish();
    }
}