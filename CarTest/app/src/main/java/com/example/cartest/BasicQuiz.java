package com.example.cartest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BasicQuiz extends AppCompatActivity {

    // Переменные для хранения текста вопроса и ответов
    private TextView quizText, ans_1, ans_2, ans_3, ans_4;
    // Подготовка к видео
    private VideoView video;
    private Uri uri;

    // Массив класса Voprosiki
    List<Voprosiki> questionsItems;

    // Хранит в себе количество правильных ответов
    private int currentQuestions = 0,
            correct = 0,
            wrong = 0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Определение полей под:
        // Вопрос
        quizText = findViewById(R.id.quizText);
        // ответ 1
        ans_1 = findViewById(R.id.answer_1);
        // ответ 2
        ans_2 = findViewById(R.id.answer_2);
        // ответ 3
        ans_3 = findViewById(R.id.answer_3);
        // ответ 4
        ans_4 = findViewById(R.id.answer_4);


        // Определение для видео
        video = (VideoView) findViewById(R.id.VideoShower);
        // Определение ссылки
        uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback);
        video.setVideoURI(uri);




        loadAllQuestions();
        // Коллекция для тасовки вопрсов
        Collections.shuffle(questionsItems);
        setQuestionScreen(currentQuestions);

        // Определение нажатия для ответов
        ans_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions)
                        .getAns_1()
                        .equals(questionsItems
                                .get(currentQuestions).getCorrect())){
                    // Если ответ окащался верным
                    correct++;
                    // Смена цвета у ответа
                    // Цвет для фона взят из ресурсов color
                    ans_1.setBackgroundResource(R.color.CorrectAnswerColor);
                    // Смена цвета текста. Также взят из ресурсов color
                    ans_1.setTextColor(getResources().getColor(R.color.white));
                } else{
                    wrong++;
                    try {
                        video.start();
                        // Смена цвета у ответа
                        // Цвет для фона взят из ресурсов color
                        ans_1.setBackgroundResource(R.color.WrongAnswerColor);
                        // Смена цвета текста. Также взят из ресурсов color
                        ans_1.setTextColor(getResources().getColor(R.color.white));


                    } catch (Exception e){
                        // Ничего
                    }

                }

                // Если это не последний вопрос
                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    // Запуск нового процесса
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Изменение цвета обратно на белый
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            ans_1.setBackgroundResource(R.color.white);
                            // Изменение цвета текста
                            ans_1.setTextColor(getResources().getColor(R.color.SecondForeground));
                        }
                        // Установка задержки
                    }, 500);
                } else {
                    // Если тест окончен - открыть окно результата
                    Intent newWindow = new Intent(BasicQuiz.this, ResultActivity.class);
                    // Передаем рассчеты в следующие окно
                    newWindow.putExtra("Правильно", correct);
                    newWindow.putExtra("Ошибок", wrong);
                    startActivity(newWindow);
                    // Завершение работы действующего окна
                    finish();
                }
            }
        });
        ans_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions)
                        .getAns_2()
                        .equals(questionsItems
                                .get(currentQuestions).getCorrect())){
                    // Если ответ окащался верным
                    correct++;
                    // Смена цвета у ответа
                    // Цвет для фона взят из ресурсов color
                    ans_2.setBackgroundResource(R.color.CorrectAnswerColor);
                    // Смена цвета текста. Также взят из ресурсов color
                    ans_2.setTextColor(getResources().getColor(R.color.white));
                } else{

                    wrong++;
                    try {
                        video.start();
                        // Смена цвета у ответа
                        // Цвет для фона взят из ресурсов color
                        ans_2.setBackgroundResource(R.color.WrongAnswerColor);
                        // Смена цвета текста. Также взят из ресурсов color
                        ans_2.setTextColor(getResources().getColor(R.color.white));

                    } catch (Exception e){
                        // Ничего
                    }



                }

                // Если это не последний вопрос
                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    // Запуск нового процесса
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Изменение цвета обратно на белый
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            ans_2.setBackgroundResource(R.color.white);
                            // Изменение цвета текста
                            ans_2.setTextColor(getResources().getColor(R.color.SecondForeground));
                        }
                        // Установка задержки
                    }, 500);
                } else {
                    // Если тест окончен - открыть окно результата
                    Intent newWindow = new Intent(BasicQuiz.this, ResultActivity.class);
                    // Передаем рассчеты в следующие окно
                    newWindow.putExtra("Правильно", correct);
                    newWindow.putExtra("Ошибок", wrong);
                    startActivity(newWindow);
                    // Завершение работы действующего окна
                    finish();
                }
            }
        });
        ans_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions)
                        .getAns_3()
                        .equals(questionsItems
                                .get(currentQuestions).getCorrect())){
                    // Если ответ окащался верным
                    correct++;
                    // Смена цвета у ответа
                    // Цвет для фона взят из ресурсов color
                    ans_3.setBackgroundResource(R.color.CorrectAnswerColor);
                    // Смена цвета текста. Также взят из ресурсов color
                    ans_3.setTextColor(getResources().getColor(R.color.white));
                } else{
                    wrong++;
                    try {
                        video.start();
                        // Смена цвета у ответа
                        // Цвет для фона взят из ресурсов color
                        ans_3.setBackgroundResource(R.color.WrongAnswerColor);
                        // Смена цвета текста. Также взят из ресурсов color
                        ans_3.setTextColor(getResources().getColor(R.color.white));

                    } catch (Exception e){
                        // Ничего
                    }

                }

                // Если это не последний вопрос
                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    // Запуск нового процесса
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Изменение цвета обратно на белый
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            ans_3.setBackgroundResource(R.color.white);
                            // Изменение цвета текста
                            ans_3.setTextColor(getResources().getColor(R.color.SecondForeground));
                        }
                        // Установка задержки
                    }, 500);
                } else {
                    // Если тест окончен - открыть окно результата
                    Intent newWindow = new Intent(BasicQuiz.this, ResultActivity.class);
                    // Передаем рассчеты в следующие окно
                    newWindow.putExtra("Правильно", correct);
                    newWindow.putExtra("Ошибок", wrong);
                    startActivity(newWindow);
                    // Завершение работы действующего окна
                    finish();
                }
            }
        });
        ans_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions)
                        .getAns_4()
                        .equals(questionsItems
                                .get(currentQuestions).getCorrect())){
                    // Если ответ окащался верным
                    correct++;
                    // Смена цвета у ответа
                    // Цвет для фона взят из ресурсов color
                    ans_4.setBackgroundResource(R.color.CorrectAnswerColor);
                    // Смена цвета текста. Также взят из ресурсов color
                    ans_4.setTextColor(getResources().getColor(R.color.white));
                } else{
                    wrong++;
                    try {
                        video.start();
                        // Смена цвета у ответа
                        // Цвет для фона взят из ресурсов color
                        ans_4.setBackgroundResource(R.color.WrongAnswerColor);
                        // Смена цвета текста. Также взят из ресурсов color
                        ans_4.setTextColor(getResources().getColor(R.color.white));
                    } catch (Exception e){
                        // Ничего
                    }

                }

                // Если это не последний вопрос
                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    // Запуск нового процесса
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Изменение цвета обратно на белый
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            ans_4.setBackgroundResource(R.color.white);
                            // Изменение цвета текста
                            ans_4.setTextColor(getResources().getColor(R.color.SecondForeground));
                        }
                        // Установка задержки
                    }, 500);
                } else {
                    // Если тест окончен - открыть окно результата
                    Intent newWindow = new Intent(BasicQuiz.this, ResultActivity.class);
                    // Передаем рассчеты в следующие окно
                    newWindow.putExtra("Правильно", correct);
                    newWindow.putExtra("Ошибок", wrong);
                    startActivity(newWindow);
                    // Завершение работы действующего окна
                    finish();
                }
            }
        });

    }

    // Установка вопроса
    private void setQuestionScreen(int currentQuestions){
        // Установка в текстовые поля текста из класса Voprosiki
        quizText.setText(questionsItems.get(currentQuestions).getQuestions());
        ans_1.setText(questionsItems.get(currentQuestions).getAns_1());
        ans_2.setText(questionsItems.get(currentQuestions).getAns_2());
        ans_3.setText(questionsItems.get(currentQuestions).getAns_3());
        ans_4.setText(questionsItems.get(currentQuestions).getAns_4());
    }
    // Метод поздрузки вопроса
    private void loadAllQuestions(){
        questionsItems = new ArrayList<>();
        // Данные из json файла
        String jsonQuiz = loadJsonFromAsset("MarkupQuestions.json");
        try{
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray questions = jsonObject.getJSONArray("markupquestions");
            for(int QIndex = 0; QIndex < questions.length(); QIndex++){
                // Перебираем JSON
                // Помещение объекта JSON по индекссу
                JSONObject question = questions.getJSONObject(QIndex);
                // Запись в String переменные значений ячеек JSON по ключу
                // пример: Ключ "question" \ Значение "Разметка 1.10:" в Файде MarkupQuestions.json
                // файл лежит в папке assets
                String questionString = question.getString("question");
                String answer_1_String = question.getString("answer1");
                String answer_2_String = question.getString("answer2");
                String answer_3_String = question.getString("answer3");
                String answer_4_String = question.getString("answer4");
                String CorrectString = question.getString("correct");

                // Помещаем в массив ответ значения, используя конструктор класса Voprosiki
                questionsItems.add(new Voprosiki(questionString,
                        answer_1_String, answer_2_String, answer_3_String, answer_4_String, CorrectString));
            }
        } catch (JSONException e){
            // Если произошла ошибка при работе с JSON
            // Вывод ошибки (состояния)
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset(String s) {
        String json = "";
        try {
            // Попытка открыть файл JSON для считки данных
            InputStream inputStream = getAssets().open(s);
            // Определение размера
            int SIZE = inputStream.available();
            // Создание буффера
            byte[] buffer = new byte[SIZE];
            inputStream.read(buffer);
            inputStream.close();
            // Запись в строку переведенной в формат UTF-8 строки byte
            json = new String(buffer, "UTF-8");

        } catch (IOException e){
            // Вывод об ошибке
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void onBackPressed(){
        MaterialAlertDialogBuilder materialAlertDialogBuilder =
                new MaterialAlertDialogBuilder(BasicQuiz.this);
        // Установка в Title текста "ГИБДД Mobile"
        materialAlertDialogBuilder.setTitle(R.string.orgName);
        // Установка проверки дейсствий пользователя при выходе

        materialAlertDialogBuilder.setMessage("Готовы завершить?");
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
                // Если пользоавтель нажал "Да" - открываем результат
                startActivity(new Intent(BasicQuiz.this, MainActivity.class));
                finish();
            }
        });

        // Демонстрация сообщения
        materialAlertDialogBuilder.show();
    }
}