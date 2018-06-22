package com.example.gian.harmonizagro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.gian.harmonizagro.Model.Item;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText edtPesq;
    private ListView listV_Pesquisa;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private List<Item> listItem = new ArrayList<Item>();
    private ArrayAdapter<Item> arrayAdapterItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initFirebase();
        initComponents();
        eventPesq();
    }

    private void eventPesq() {
        edtPesq.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String busca = edtPesq.getText().toString().trim();
                buscaCod(busca);
            }
        });
    }

    private void buscaCod(String busca) {
        Query query;
        if(busca.equals("")){
            query = databaseReference.child("Item").orderByChild("codigo");
        }else{
            query = databaseReference.child("Item").orderByChild("codigo").startAt(busca).endAt(busca+"\uf8ff");
        }

        listItem.clear();

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Item i = objSnapshot.getValue(Item.class);
                    listItem.add(i);
                }

                arrayAdapterItem = new ArrayAdapter<Item>(SearchActivity.this,android.R.layout.simple_list_item_1,listItem);
                listV_Pesquisa.setAdapter(arrayAdapterItem);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void initFirebase() {
        FirebaseApp.initializeApp(SearchActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void initComponents() {
        edtPesq = findViewById(R.id.edtPesq);
        listV_Pesquisa = findViewById(R.id.listV_Pesquisa);
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        buscaCod("");

    }
}
