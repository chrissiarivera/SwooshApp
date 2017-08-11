package jalanechrissia.rivera.com.swoosh;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    public static final String PASS_STRING = "Darna";
    private Button mBtnBeginner;
    private Button mBtnBaller;
    private Button mBtnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        findViews();

        mBtnBeginner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mBtnBeginner.getAlpha() != mBtnFinish.getAlpha()){
                    mBtnBeginner.setAlpha(.8f);
                    mBtnFinish.setAlpha(.8f);
                    mBtnFinish.setEnabled(true);
                }else{
                    mBtnFinish.setEnabled(false);
                }
            }
        });

        mBtnBaller.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mBtnBaller.getAlpha() != mBtnFinish.getAlpha()){
                    mBtnBaller.setAlpha(.8f);
                    mBtnFinish.setAlpha(.8f);
                    mBtnFinish.setEnabled(true);
                }else{
                    mBtnFinish.setEnabled(false);
                }
            }
        });

        mBtnFinish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String text = "";
                if(mBtnBeginner.getAlpha() == .8f){
                    text = mBtnBeginner.getText().toString();
                }else if(mBtnBaller.getAlpha() == .8f){
                    text = mBtnBaller.getText().toString();
                }

                Intent data = new Intent();
                data.putExtra(PASS_STRING, text);
                setResult(Activity.RESULT_OK, data);

                finish();
            }
        });

    }

    private void findViews() {
        mBtnBeginner = (Button) findViewById(R.id.beginner);
        mBtnBaller = (Button) findViewById(R.id.baller);
        mBtnFinish = (Button) findViewById(R.id.finish);
    }

}
