package com.example.roomdbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    /**
     *
     */
    UserDataBase userDataBase;

    /**
     *
     */
    User user;

    /**
     *
     */
    EditText fname, lname, age;
    Button insert;
    TextView listOfNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /**
         *
         */
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        age = findViewById(R.id.age);
        insert = findViewById(R.id.insert);
        listOfNames = findViewById(R.id.listOfNames);

        /**
         * getting instance or object from the room-database
         * we will use the instance to access the dao..
         */
        userDataBase = UserDataBase.getINSTANCE(this);

        /**
         *
         */
        retrieve();


        /**
         *
         */
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 *
                 */
                String userfirstname = fname.getText().toString();
                String userlastname = lname.getText().toString();
               //int userage = Integer.parseInt(age.getText().toString());
                /**
                 *
                 */
               user = new User();
                /**
                 * Given user his details..
                 */
               user.FirstName = userfirstname;
               user.LastName = userlastname;
               //user.Age = userage;

                /**
                 * We have inserted user details to the database...
                 */
                userDataBase.userDao().insertUser(user);
            }
        });
    }


    private  void retrieve(){

        userDataBase.userDao().SelectFrom().observe(this, new Observer<List<User>>() {
            User allusers;
            @Override
            public void onChanged(List<User> users) {

                ListIterator<User> userListIterator = users.listIterator();

                while (userListIterator.hasNext()){
                    allusers = userListIterator.next();
                }
                listOfNames.append(allusers.LastName + "\n");
            }
        });


    }
}