package ru.geekbrains.notes;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Navigation navigation;
    private Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = new Navigation(getSupportFragmentManager());
        initToolbar();
        getNavigation().addFragment(NotesFragment.newInstance(), false);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.menu_search);
        SearchView searchText = (SearchView) search.getActionView();
        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        MenuItem sort = menu.findItem(R.id.menu_sort);
        sort.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, R.string.menu_sort, Toast.LENGTH_SHORT).show();
            return true;
        });
        MenuItem send = menu.findItem(R.id.menu_send);
        send.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, R.string.menu_send, Toast.LENGTH_SHORT).show();
            return true;
        });
        MenuItem addPhoto = menu.findItem(R.id.menu_add_photo);
        addPhoto.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, R.string.menu_add_photo, Toast.LENGTH_SHORT).show();
            return true;
        });
        return true;
    }
}



//1.	Создайте список ваших заметок.
//2.	Создайте карточку для элемента списка.
//3.	Класс данных, созданный на шестом уроке, используйте для заполнения карточки списка.
//4.	* Создайте фрагмент для редактирования данных в конкретной карточке. Этот фрагмент пока
// можно вызвать через основное меню.

/*public class MainActivity extends AppCompatActivity {
    private ru.geekbrains.lesson9.Navigation navigation;
    private Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = new ru.geekbrains.lesson9.Navigation(getSupportFragmentManager());
        initToolbar();
        getNavigation().addFragment(ListOfNotesFragment.newInstance(), false);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
*/
/*
public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {

    private Navigation navigation;
    private Publisher publisher = new Publisher();

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null) {
            initStartFragment();
        }

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_about) {
                Snackbar.make(findViewById(R.id.drawer_layout), "О приложении", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(findViewById(R.id.drawer_layout), "Настройки", Snackbar.LENGTH_SHORT).show();
            }
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });
        toggle.syncState();
    }

    private void initStartFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NotesFragment listFragment = new NotesFragment();
        fragmentTransaction.add(R.id.list_of_notes_fragment_container, listFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) search.getActionView();
        MenuItem sort = menu.findItem(R.id.menu_sort);
        MenuItem addPhoto = menu.findItem(R.id.menu_add_photo);
        MenuItem send = menu.findItem(R.id.menu_send);
        send.setOnMenuItemClickListener(this);
        addPhoto.setOnMenuItemClickListener(this);
        sort.setOnMenuItemClickListener(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Snackbar.make(findViewById(R.id.drawer_layout), query, Snackbar.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // код 9 урока
        if (item.getItemId() == R.id.menu_add_note) {

        } else if (item.getItemId() == R.id.menu_delete_note) {

        } else {
            return super.onOptionsItemSelected(item); // если ни чего не подошло, обращайтесь в родительский  обработчик
        }
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Snackbar.make(findViewById(R.id.drawer_layout), item.getTitle().toString(), Snackbar.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
*/

