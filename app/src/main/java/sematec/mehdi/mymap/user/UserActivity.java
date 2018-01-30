package sematec.mehdi.mymap.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

import sematec.mehdi.mymap.R;

public class UserActivity extends AppCompatActivity implements UserContract.View{

    private MaterialEditText email;

    private MaterialEditText password;

    private MaterialEditText passwordConfirm;

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passwordConfirm = findViewById(R.id.passwordConfirm);
        register = findViewById(R.id.register);

        //Set click listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
