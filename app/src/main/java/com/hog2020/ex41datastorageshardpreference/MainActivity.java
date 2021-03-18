package com.hog2020.ex41datastorageshardpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etname,etage;
    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname=findViewById(R.id.et_name);
        etage=findViewById(R.id.et_age);
        tv=findViewById(R.id.tv);
        iv =findViewById(R.id.iv);
    }

    public void clickBtn(View view) {

        //저장할 데이터
        String name= etname.getText().toString();
        int age=0;
        try{
            age =Integer.parseInt(etage.getText().toString());
        }catch (Exception e){
            age=0;
        }

        //ShardPreference 로 저장하기
        //Data.xml 파일에 데이터를 저장하기
        //ShardPreference 객체 얻어오기
        SharedPreferences pref= getSharedPreferences("Data",MODE_PRIVATE);

        //저장작업시작
        SharedPreferences.Editor editor= pref.edit();

        editor.putString("name",name);
        editor.putInt("age",age);

        //이미지리소스 번호도 저장가능함
        editor.putInt("imgid",R.drawable.green);

        //반드시 작성작업이 종료되었다고 명시해야됨
        editor.commit();
    }

    public void clickLoad(View view) {

        SharedPreferences pref= getSharedPreferences("Data", MODE_PRIVATE);

        String name= pref.getString("name","");
        int age= pref.getInt("age",0);

        tv.setText(name+":"+age);

        //이미지 리소스 ID얻어오기
        int imgid = pref.getInt("imgid",R.drawable.green);

        iv.setImageResource(R.drawable.green);

    }
}