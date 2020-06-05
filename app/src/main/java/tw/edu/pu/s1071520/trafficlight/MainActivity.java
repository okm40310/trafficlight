package tw.edu.pu.s1071520.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);




        Button sg = (Button) findViewById(R.id.btnStart);
        sg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText TTn1 = (EditText) findViewById(R.id.TTN1);
                EditText TTn2 = (EditText) findViewById(R.id.TTN2);
                EditText TTn3 = (EditText) findViewById(R.id.TTN3);
                if(TTn1.getText().toString().matches("")||
                        TTn2.getText().toString().matches("")||
                        TTn3.getText().toString().matches("")){
                    toast = Toast.makeText(MainActivity.this, "燈號的秒數不能為空白", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(TTn1.getText().toString().matches("0")||
                         TTn2.getText().toString().matches("0")||
                         TTn3.getText().toString().matches("0")){
                    toast = Toast.makeText(MainActivity.this, "燈號的秒數不能為0", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
    //開始遊戲 結束遊戲
    public void StartGame(View v){
        Intent it = new Intent();
        it.setClass(this, GameActivity.class);
        startActivity(it);
        finish();
    }

    public void EndApp(View v){
        finish();
    }






}