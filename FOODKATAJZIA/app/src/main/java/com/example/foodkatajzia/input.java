package com.example.foodkatajzia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class input extends AppCompatActivity {
    DatabaseReference refdata;
    Member member;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        member = new Member();
        refdata = FirebaseDatabase.getInstance().getReference().child("Member");
        refdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        final RatingBar ratingBar = findViewById(R.id.rating);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(input.this, retrieve.class);
                startActivity(intent);
                EditText edit = findViewById(R.id.edittxt);
                EditText txt=findViewById(R.id.edit_txt);
                float rating = ratingBar.getRating();
                int rate=(int)rating;
                int star1 = rate;
                member.setResturant(txt.getText().toString().trim());
                member.setResturantComment(edit.getText().toString().trim());
                member.setRestStar(star1);
                refdata.child(String.valueOf(maxid + 1)).setValue(member);
                refdata.child("member").setValue(member);
            }
        });

    }
}
