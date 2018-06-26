package com.example.gian.harmonizagro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.gian.harmonizagro.Model.Item;

public class DisplayActivity extends AppCompatActivity {
    private Item item;
    private TextView codPai, desc, nivel, codigo;
    private CheckBox subCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        initComponents();
        func();
    }

    private void func() {
        item = (Item) getIntent().getSerializableExtra("codigo");
        codigo.setText(item.getCodigo());
        codPai.setText(item.getCodigoPai());
        desc.setText(item.getDescricao());
        nivel.setText(String.valueOf(item.getNivel()));
        subCategoria.setChecked(item.isEhFolha());
    }

    private void initComponents() {
        codigo = findViewById(R.id.txtCod);
        codPai = findViewById(R.id.txtCodPai);
        desc = findViewById(R.id.txtDesc);
        nivel = findViewById(R.id.txtNivel);
        subCategoria = findViewById(R.id.chkSub);
    }
}
