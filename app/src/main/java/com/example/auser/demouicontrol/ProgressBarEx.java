package com.example.auser.demouicontrol;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarEx extends AppCompatActivity {
ProgressBar progressBar;
    TextView tvPercent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        tvPercent=(TextView)findViewById(R.id.percent);
        //progressBar.setProgress(80);此可以設定一開始的進度
        new MyAsyncTask().execute("開始下載");///這裡用execute()代替start

    }

    private class MyAsyncTask extends AsyncTask<String,Integer,String> {




        @Override//////此為進度執行緒
        protected String doInBackground(String... params) {

            if (params[0].equals("開始下載"))
                for (int i = 0; i <= 100; i++) {

                    try {
                        Thread.sleep(100);
                        publishProgress(i);///此為要發佈出去的i值
                        //tvPercent.setText(i+"%");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            return "下載完成";///////////進度表跑完會跑出文字
        }
        @Override///////用來更新progress進度,此為背景執行緒
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvPercent.setText(values[0]+"%");////加這一行才能讓進度數字跑動
            progressBar.setProgress(values[0]);////加這一行才能讓進度跟著數字跑動

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Toast.makeText(ProgressBarEx.this,result,Toast.LENGTH_LONG).show();///這裡的參數來自於execute()
        }
    }
}
