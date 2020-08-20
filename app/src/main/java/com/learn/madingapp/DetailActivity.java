package com.learn.madingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.learn.madingapp.model.Mading;

import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_SPACE_MADING = "DetailActivity.SPACE_PHOTO";
    Mading mading = new Mading();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Mading mading = getIntent().getParcelableExtra(EXTRA_SPACE_MADING);

        final String image = mading.getFoto();
        String txtJudul = mading.getJudul();
        String txtTanggal = mading.getTanggal();
        String txtTema = mading.getTema();
        String txtKonten = mading.getKonten();
        String txtAuthor = mading.getPenulis();
        String txtFile = mading.getFile();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle(txtJudul);
        }

        ImageView imgInformasi = findViewById(R.id.img_informasi_detail);
        ImageView iconPdf = findViewById(R.id.icon_pdf);
        TextView tvTitle = findViewById(R.id.txt_title_detail);
        TextView tvDate = findViewById(R.id.txt_date_detail);
        TextView tvTheme = findViewById(R.id.txt_theme_detail);
        TextView tvContent = findViewById(R.id.txt_content_detail);
        TextView tvAuthor = findViewById(R.id.txt_author_detail);
        TextView tvFile = findViewById(R.id.txt_file_detail);

        Glide.with(this)
                .load("http://10.0.2.2/mading-online/foto/"+image)
                .apply(new RequestOptions().override(350, 450))
                .skipMemoryCache(true)
                .into(imgInformasi);
        tvTitle.setText(txtJudul);
        tvDate.setText(txtTanggal);
        tvTheme.setText("Tema : "+txtTema);
        tvContent.setText(txtKonten);
        tvAuthor.setText(txtAuthor);
//        tvFile.setText(txtFile);

        tvFile.setOnClickListener(this);
        if (!mading.getFile().equals("")){
//            Toast.makeText(getApplicationContext(), "ada file", Toast.LENGTH_SHORT).show();
            tvFile.setText("Link File");
            iconPdf.setVisibility(View.VISIBLE);
        }else {
//            Toast.makeText(getApplicationContext(), "ga ada file nya", Toast.LENGTH_SHORT).show();
            tvFile.setText("");
            iconPdf.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction(intent.ACTION_VIEW);
        intent.addCategory(intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://10.0.2.2/mading-online/pages/file/coding migrasi data"+mading.getFile()));
        startActivity(intent);
    }
}
