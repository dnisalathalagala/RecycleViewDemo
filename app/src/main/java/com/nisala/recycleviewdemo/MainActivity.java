package com.nisala.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.nisala.recycleviewdemo.adapters.ContactsAdapter;
import com.nisala.recycleviewdemo.models.Contact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ContactsAdapter.ContactsEventListner {

    private ContactsAdapter mAdapter;
    private List<Contact> mContactsList = new ArrayList<>();

    @BindView(R.id.rv_contacts)
    RecyclerView mRVContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        addContacts();

        mAdapter = new ContactsAdapter(this, mContactsList, this);
        mRVContacts.setLayoutManager(new LinearLayoutManager(this));
        mRVContacts.setAdapter(mAdapter);
    }

    @Override
    public void onClickContact(Contact contact) {
        Toast.makeText(this, "Contact name : " + contact.getName(), Toast.LENGTH_SHORT).show();
    }

    private void addContacts() {
        for (int i = 0; i < 10; i++) {
            Contact contact = new Contact();
            contact.setName("Name : " + i);
            contact.setPhone("Phone : " + i);
            contact.setEmail("Email : " + i);
            mContactsList.add(contact);
        }
    }
}
