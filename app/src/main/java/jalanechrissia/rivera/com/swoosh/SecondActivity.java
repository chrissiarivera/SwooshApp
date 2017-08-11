package jalanechrissia.rivera.com.swoosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String PASS_STRING = "btnValue";
    public static final int REQ_CODE = 818;
    private Button mBtnMen;
    private Button mBtnWomen;
    private Button mBtnCoed;
    private Button mBtnNext;
    private TextView mTVleague;
    private TextView mTVleague2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViews();

        mBtnMen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mBtnMen.getAlpha() != mBtnNext.getAlpha()){
                    mBtnMen.setAlpha(.8f);
                    mBtnNext.setAlpha(.8f);
                    mBtnNext.setEnabled(true);
                }else if(mTVleague2.getText().toString().isEmpty()){
                    mBtnNext.setEnabled(false);
                }
            }
        });
        mBtnWomen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mBtnWomen.getAlpha() != mBtnNext.getAlpha()){
                    mBtnWomen.setAlpha(.8f);
                    mBtnNext.setAlpha(.8f);
                    mBtnNext.setEnabled(true);
                }else if(mTVleague2.getText().toString().isEmpty()){
                    mBtnNext.setEnabled(false);
                }
            }
        });
        mBtnCoed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mBtnCoed.getAlpha() != mBtnNext.getAlpha()){
                    mBtnCoed.setAlpha(.8f);
                    mBtnNext.setAlpha(.8f);
                    mBtnNext.setEnabled(true);
                }else if(mTVleague2.getText().toString().isEmpty()){
                    mBtnNext.setEnabled(false);
                }
            }
        });
        mBtnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), ThirdActivity.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });

    }

    private void findViews() {
        mBtnMen = (Button) findViewById(R.id.mens);
        mBtnWomen = (Button) findViewById(R.id.womens);
        mBtnCoed = (Button) findViewById(R.id.coed);
        mBtnNext = (Button) findViewById(R.id.next);
        mTVleague = (TextView) findViewById(R.id.leagueTV);
        mTVleague2 = (TextView) findViewById(R.id.leagueTV2);
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data){
        super.onActivityResult(reqCode,resultCode,data);

        if(resultCode == RESULT_OK){
            if(reqCode == REQ_CODE){
                String replyMsg = data.getStringExtra(ThirdActivity.PASS_STRING);
                mTVleague.setVisibility(View.VISIBLE);
                mTVleague2.setVisibility(View.VISIBLE);
                mTVleague2.setText(replyMsg);
                mBtnNext.setVisibility(View.GONE);
                if(mBtnMen.getAlpha() != .5)
                    mBtnMen.setEnabled(false);
                if(mBtnWomen.getAlpha() != .5)
                    mBtnWomen.setEnabled(false);
                if(mBtnCoed.getAlpha() != .5)
                    mBtnCoed.setEnabled(false);
            }
        }
    }

}
