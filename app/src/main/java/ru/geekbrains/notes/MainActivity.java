package ru.geekbrains.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

//1.	Подумайте о функционале вашего приложения заметок. Какие экраны там могут быть, помимо основного со списком заметок?
// Как можно использовать меню и всплывающее меню в вашем приложении? Не обязательно сразу пытаться реализовать весь этот функционал,
// достаточно создать макеты и структуру, а реализацию пока заменить на заглушки или всплывающие уведомления (Toast).
// Используйте подход Single Activity для отображения экранов.
// В качестве примера: на главном экране приложения у вас список всех заметок, при нажатии на заметку открывается экран
// с этой заметкой. В меню главного экрана у вас есть иконка поиска по заметкам и сортировка. В меню «Заметки» у вас
// есть иконки «Переслать» (или «Поделиться»), «Добавить ссылку или фотографию к заметке».
//  2.	Создайте боковое навигационное меню для своего приложения и добавьте туда хотя бы один экран, например «Настройки»
//  или «О приложении».
//  3.	* Создайте полноценный заголовок для NavigationDrawer’а. К примеру, аватарка пользователя, его имя и какая-то дополнительная
//  информация.


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_for_notes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null) {
            initStartFragment();
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
    }


    private void initStartFragment() {
            ImageForNotesFragment details = new ImageForNotesFragment();
            details.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, details).commit();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}


