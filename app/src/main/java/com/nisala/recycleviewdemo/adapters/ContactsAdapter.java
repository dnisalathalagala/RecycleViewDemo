package com.nisala.recycleviewdemo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nisala.recycleviewdemo.R;
import com.nisala.recycleviewdemo.models.Contact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nisala on 10,October,2018
 */
public class ContactsAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Contact> mContactList;
    private ContactsEventListner mListner;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_contact, viewGroup, false);
        return new ContactsViewHolder(view);
    }

    public ContactsAdapter(Context context, List<Contact> contactList, ContactsEventListner listner) {
        this.mContext = context;
        this.mContactList = contactList;
        this.mListner = listner;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((ContactsViewHolder) viewHolder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        int mIndex;

        @BindView(R.id.tv_name)
        TextView mTVName;

        @BindView(R.id.tv_phone)
        TextView mTVPhone;

        @BindView(R.id.tv_email)
        TextView mTVEmail;


        public ContactsViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        public void bindView(int position) {

            mIndex = position;

            mTVName.setText(mContactList.get(position).getName());
            mTVPhone.setText(mContactList.get(position).getPhone());
            mTVEmail.setText(mContactList.get(position).getEmail());
        }

        @Override
        public void onClick(View view) {
            mListner.onClickContact(mContactList.get(mIndex));
        }
    }

    public interface ContactsEventListner {
        void onClickContact(Contact contact);
    }
}
