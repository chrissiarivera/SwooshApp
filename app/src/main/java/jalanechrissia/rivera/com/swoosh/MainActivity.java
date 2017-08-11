package jalanechrissia.rivera.com.swoosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        mButton = (Button) findViewById(R.id.button);
    }

    public void onClick (View view){
        mButton.setAlpha(.8f);
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
