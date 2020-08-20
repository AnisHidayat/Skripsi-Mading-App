package com.learn.madingapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String URL = "http://192.168.43.214/mading-online/api/";
//    public static final String URL = "http://127.0.0.1/mading-online/api/";
    String nim,nama,jurusan;

    @BindView(R.id.btn_profil_sekolah)
    CardView btnProfilSekolah;
    @BindView(R.id.btn_mading)
    CardView btnMading;
    @BindView(R.id.btn_sejarah)
    CardView btnSejarah;
    @BindView(R.id.btn_visi_misi)
    CardView btnVisiMisi;
    @BindView(R.id.btn_fasilitas)
    CardView btnFasilitas;
    @BindView (R.id.btn_sambutan)
    CardView btnSambutan;

    @OnClick(R.id.btn_mading)void lihat(){
        Intent mading = new Intent(MainActivity.this, ViewActivity.class);
        startActivity(mading);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_profil_sekolah:
                Intent profil = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(profil);
                break;

            case R.id.btn_sejarah:
                Intent sejarah = new Intent(MainActivity.this, SejarahActivity.class);
                startActivity(sejarah);
                break;

            case R.id.btn_visi_misi:
                Intent visiMisi = new Intent(MainActivity.this, VisiMisiActivity.class);
                startActivity(visiMisi);
                break;

            case R.id.btn_fasilitas:
                Intent fasilitas = new Intent(MainActivity.this, FasilitasActivity.class);
                startActivity(fasilitas);
                break;

            case R.id.btn_sambutan:
                Intent sambutan = new Intent(MainActivity.this, SambutanActivity.class);
                startActivity(sambutan);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnProfilSekolah.setOnClickListener(this);
        btnVisiMisi.setOnClickListener(this);
        btnFasilitas.setOnClickListener(this);
        btnSejarah.setOnClickListener(this);
        btnSambutan.setOnClickListener(this);

    }
}