package com.example.pfe.pages;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pfe.R;
import com.example.pfe.intrface.profileClickListener;
import com.example.pfe.models.user;
import com.firebase.ui.auth.data.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends Fragment {

    FirebaseUser users;
    private profileClickListener listener ;
    DatabaseReference Reference;
    TextView Edit;
    private  String userID;
//@Override
//public void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    users = FirebaseAuth.getInstance().getCurrentUser();
//    Reference= FirebaseDatabase.getInstance().getReference("User");
//    userID = users.getUid();
//    Reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot snapshot) {
//            user userP = snapshot.getValue(user.class);
//            if (userP!=null)
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    });
//
//}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView exits = (ImageView) v.findViewById(R.id.exit);
        exits.setOnClickListener(v1 -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getActivity(), home.class);
            startActivity(intent);


        });
        Edit = v.findViewById(R.id.updateProfile);
        users = FirebaseAuth.getInstance().getCurrentUser();
        Reference= FirebaseDatabase.getInstance().getReference("User");
        userID = users.getUid();
        Reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user userP = snapshot.getValue(user.class);
                if (userP!=null)
                {
                   TextView Full =  (TextView) v.findViewById(R.id.username);
                    String fullName = userP.fullName;
                    System.out.println(fullName);
                    Full.setText(fullName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Edit.setOnClickListener(
                v1 -> {
                    listener.onProfileClick();
                }
        );
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener = (profileClickListener) context;
    }
}