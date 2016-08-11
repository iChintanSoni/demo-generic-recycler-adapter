package com.android.genericrecycleradapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ContactViewHolder.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        onClickListener = new ContactViewHolder.OnClickListener() {
            @Override
            public void onClick(Object tag) {
                Contact contact = (Contact) tag;
                Toast.makeText(MainActivity.this, contact.getName(), Toast.LENGTH_SHORT).show();
            }
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        AbstractRecyclerAdapter abstractRecyclerAdapter = new AbstractRecyclerAdapter<Contact, ContactViewHolder>(Contact.class, ContactViewHolder.class, R.layout.list_item) {
            @Override
            protected void populateViewHolder(ContactViewHolder viewHolder, Contact model, int position) {
                viewHolder.setmOnClickListener(onClickListener);
                viewHolder.getmLinearLayout().setTag(model);
                viewHolder.getmAppCompatTextView().setText(model.getName());
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(abstractRecyclerAdapter);
        abstractRecyclerAdapter.setItems(getItems());
    }

    private List<Contact> getItems() {
        List<Contact> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Contact("Contact " + (i + 1)));
        }
        return list;
    }
}
