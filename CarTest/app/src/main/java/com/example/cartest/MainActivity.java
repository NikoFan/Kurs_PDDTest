package com.example.cartest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    // Для карточки "Разметка", "Знаки", "Помощь"
    private MaterialCardView markupCard, signsCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Определение каждой переменной свою карточку по ID
        markupCard = findViewById(R.id.MarkupTypeCard);
        signsCard = findViewById(R.id.SignsTypeCard);


        // Вешаем на "кнопку" разметка возможность перейти к тесту через OnClick
        markupCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Код для открытия теста
                startActivity(new Intent(MainActivity.this, BasicQuiz.class));
                finish();
            }
        });

        signsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Код для открытия теста
                startActivity(new Intent(MainActivity.this, SignsQuiz.class));
                finish();
            }
        });
    }


    @Override
    public void onBackPressed(){
        MaterialAlertDialogBuilder materialAlertDialogBuilder =
                new MaterialAlertDialogBuilder(MainActivity.this);
        // Установка в Title текста "ГИБДД Mobile"
        materialAlertDialogBuilder.setTitle(R.string.orgName);
        // Установка проверки дейсствий пользователя при выходе

        materialAlertDialogBuilder.setMessage("Готовы выйти?");
        // Если пользователь нажал "Нет"
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Если пользователь нажал "Нет" - оставляем все как есть
                dialogInterface.dismiss();
            }
        });
        // Если пользователь нажал "Да"
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Если пользоавтель нажал "Да" - закрываем окно
                finish();
            }
        });

        // Демонстрация сообщения
        materialAlertDialogBuilder.show();
    }
}