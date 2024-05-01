package com.example.cartest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

// При старте работы приложения открывается Данное окнр и идет "подключение" к главному окну
// При удачном "подключении" - Открывается окно
// При ошибке - ничего не происходит
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Подключение многопоточности
        Thread mSplashThread;
        // Создание новго потока
        mSplashThread = new Thread(){ // Вот этот код будет работать при запуске потока
            // Код нового потока
            @Override public void run(){
                try {
                    // Попытка синхронизировать
                    synchronized (this){
                        // Задержка 2 сек
                        wait(2000);
                    };
                } catch (InterruptedException ignored){
                    // Если возникла ошибка - ничего не делать
                } finally {
                    // Если все прошло удачно
                    // Открытие окна MainActivity
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    // Закрываем окно Splash
                    finish();
                }
            }
        };
        // Запуск потока (начинает работать код написанный после new Thread())
        mSplashThread.start();
    }
}