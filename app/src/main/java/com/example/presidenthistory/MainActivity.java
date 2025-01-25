package com.example.presidenthistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_view_presidents).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.main_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_toast) {
                    Toast.makeText(MainActivity.this, "This is a toast message", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.menu_exit) {
                    finish();  // Exit the app
                    return true;
                } else if (item.getItemId() == R.id.menu_president) {
                    Intent intent = new Intent(MainActivity.this, PresidentActivity.class);
                    startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }
}
