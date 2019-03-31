package com.example.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtSex, mEdtAge;
    private Button mBtnOK;
    private TextView mtxtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_linear);


        //findViewById(R.id.id_name)」會取出該物件的記憶體位置。由於findViewById只會傳回記憶體位置而已，所以必需要先做型別轉換才可以使用。
        mEdtSex = findViewById(R.id.editSex);
        mEdtAge = findViewById(R.id.editAge);

        mBtnOK = findViewById(R.id.btnOK);
        mtxtR = findViewById(R.id.result);

        mBtnOK.setOnClickListener(btnOKonClick);
    }

    private View.OnClickListener btnOKonClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String strSex = mEdtSex.getText().toString();  //此時的getText()是去取得EditText的輸入值，但是取得的text是EditText資料型態，所以要用toString()轉成字串型態
            int iAge = Integer.parseInt(mEdtAge.getText().toString());

            String strSug = getString(R.string.suggestion);

            if(strSex.equals(getString(R.string.sex_male))){
                if(iAge < 28)
                    strSug += getString(R.string.sug_not_hurry);
                else if(iAge > 33)
                    strSug += getString(R.string.sug_get_married);
                else
                    strSug += getString(R.string.sug_find_couple);
            }
            else if(strSex.equals(getString(R.string.sex_female))){
                if(iAge < 25)
                    strSug += getString(R.string.sug_not_hurry);
                else if(iAge > 30)
                    strSug += getString(R.string.sug_get_married);
                else
                    strSug += getString(R.string.sug_find_couple);
            }
            else {
                strSug = "請輸入男女";
            }
            mtxtR.setText(strSug);
        }
    };
}
