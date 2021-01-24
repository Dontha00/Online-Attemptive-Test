package com.example.onlineaptitudetest;



import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button register;
    EditText et_1,et_2,et_3,et_4;
    TextView text_v1;
    FirebaseAuth fba;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        register=findViewById(R.id.btn_register);
        text_v1=findViewById(R.id.textv1);
        et_1=findViewById(R.id.et1);
        et_2=findViewById(R.id.et2);
        et_3=findViewById(R.id.et3);
        et_4=findViewById(R.id.et4);

        db = FirebaseFirestore.getInstance();
        fba = FirebaseAuth.getInstance();






        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Name = et_1.getText().toString();
                final String Email = et_2.getText().toString();
                String Password = et_3.getText().toString();
                String pwd = et_4.getText().toString();

                if (Name.isEmpty()){
                    et_1.setError("please enter username");
                    et_1.requestFocus();
                }
                else if(Email.isEmpty()){
                    et_2.setError("please enter email");
                    et_2.requestFocus();
                }
                else if (Password.isEmpty()){
                    et_3.setError("please enter password");
                    et_3.requestFocus();
                }
                else if (pwd.isEmpty()){
                    et_4.setError("please re-enter password");
                    et_4.requestFocus();
                }
                else if (!(Password.equals(pwd))){
                    et_4.setError("please enter correct password");
                    et_4.requestFocus();
                }
                else if (Email.isEmpty() && Password.isEmpty()){
                    Toast.makeText(Signup.this, "enter email and password", Toast.LENGTH_SHORT).show();
                }
                else if (!(Email.isEmpty() && Password.isEmpty())) {

                    fba.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Signup.this, "Unsuccessful, Please try again", Toast.LENGTH_SHORT).show();


                                // Create a new user with a first and last name
                                Map<String, Object> user = new HashMap<>();
                                user.put("Name", Name);
                                user.put("Email", Email);

// Add a new document with a generated ID
                                db.collection("users")
                                        .add(user)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {


                                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());

                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error adding document", e);
                                            }
                                        });


                            }
                            else {
                                startActivity(new Intent(Signup.this, Loginpage.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Signup.this,"Error!!!",Toast.LENGTH_SHORT).show();
                }
                }
        });

        text_v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this, Loginpage.class);
                Toast.makeText(Signup.this,"login", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });

    }
}
