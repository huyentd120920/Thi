package com.example.thi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.menu_addSach:
                fragment = new ThemRauFragment();
                this.setTitle("Thêm Rau");
                fragmentTransaction.replace(R.id.frameContent, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.menu_DSSach:
                fragment = new DanhSachRauFragment();
                this.setTitle("Danh sách rau");
                fragmentTransaction.replace(R.id.frameContent, fragment);
                fragmentTransaction.commit();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
