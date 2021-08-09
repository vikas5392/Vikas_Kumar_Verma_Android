package com.training.factorial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText m_EnterText;
 TextView m_Text;
 ProgressBar m_Progress;
 Button   m_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_EnterText=findViewById(R.id.editTextTextPersonName);
        m_Text=findViewById(R.id.textView);
        m_Progress=findViewById(R.id.progressBar);
        m_Button=findViewById(R.id.button);
        m_Progress.setVisibility(View.INVISIBLE);

    }
    public void calculateFact(View view){
        CalculateInBackground calcBack=new CalculateInBackground();
        calcBack.execute();
        }

//start backgrouond tread
    class CalculateInBackground extends AsyncTask<Void,Void,Long>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            m_Progress.setVisibility(View.VISIBLE);
            m_Button.setEnabled(false);
        }

        @Override
        protected Long doInBackground(Void... voids) {
           long num=Long.parseLong(m_EnterText.getText().toString());

            long factorial=1;
            for(int i=1;i<=num;i++){
                factorial=factorial*(long)i;
          }
            return factorial;

        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected void onPostExecute(Long aLong) {
           m_Text.setText(aLong.toString());
          m_Progress.setVisibility(View.INVISIBLE);
          m_Button.setEnabled(true);
        }
    }
}