package com.doxx.rankershalt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

public class PdfView extends AppCompatActivity {
    private String link="";
    private String MyPdf = "";
    private AppCompatSeekBar seekBar;
    private ImageView imageView;
    private Button button;
    private TextView textViewBook;
    private PDFView pdfView;
    private TextView textView;
    private Boolean flag;
    TextView total,current;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        Doxx2 doxx = new Doxx2();
        flag=false;
//        ChipNavigationBar chipNavigationBar = findViewById(R.id.bottomNav2);
//        chipNavigationBar.showBadge(R.id.downloadsFragment);
        doxx.setStatusBarGradiant(this);
        textView=findViewById(R.id.textView);
        textViewBook=findViewById(R.id.PdfViewTitle);
        button=findViewById(R.id.PdfViewDownload);
        imageView=findViewById(R.id.PdfViewImg);
        current=findViewById(R.id.current);
        total=findViewById(R.id.total);
        link = getIntent().getStringExtra("link");
        //Toast.makeText(this,,Toast.LENGTH_SHORT).show();
        textViewBook.setText(getIntent().getStringExtra("title"));
        MyPdf = textViewBook.getText().toString();
        File[] file = getFilesDir().listFiles();
        for(int i=0;i<file.length;i++){
            if(file[i].toString().contains(MyPdf)) button.setText("open");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSeekbar();
                downloadPdf(MyPdf);
             }
        });


    }

    @Override
    public void onBackPressed() {
        if(flag==false) super.onBackPressed();
        else{
            Toast.makeText(this,"PLease wait",Toast.LENGTH_SHORT).show();
        }
    }

    private void initSeekbar(){
        seekBar=findViewById(R.id.seekbar);
        seekBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        current.setVisibility(View.VISIBLE);
        total.setVisibility(View.VISIBLE);
        seekBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.RED,PorterDuff.Mode.SRC_IN);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int val = (i*(seekBar.getWidth()-3 * seekBar.getThumbOffset()))/seekBar.getMax();
                textView.setText(""+i);
                textView.setX(seekBar.getX()+val+seekBar.getThumbOffset()/2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void downloadPdf(String fileName){
        new AsyncTask<Void,Integer,Boolean>(){

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if(aBoolean){
                    flag=false;
                    openPdf(fileName);

                }else {
                    Toast.makeText(PdfView.this,"Unable to download",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                seekBar.setProgress(values[0]);
                current.setText(df.format(values[1]/1024.0/1024.0) + "MB/");
                total.setText(df.format(values[2]/1024.0/1024.0) +"MB");
                Log.d("Mydoxx",values[1].toString()+"MB");
            }


            @Override
            protected Boolean doInBackground(Void... voids) {
                return downloadPdf();
            }
            @Nullable
            private Boolean downloadPdf(){
                try {
                    File file = getFileStreamPath(fileName);
                    if(file.exists()) return true;
                    try{
                        flag=true;
                        FileOutputStream fileOutputStream =openFileOutput(fileName, Context.MODE_PRIVATE);
                        URL url = new URL(link);
                        Log.d("Mydoxx",url.toString());
                        URLConnection urlConnection = url.openConnection();

                        urlConnection.connect();

                        int contentLen = urlConnection.getContentLength();
                        Log.d("Mydoxx",""+contentLen);

                        InputStream inputStream = new BufferedInputStream(url.openStream());

                        byte data[] = new byte[contentLen];
                        long total = 0;
                        int count;
                        while((count=inputStream.read(data))!=-1) {
                            total += count;
                            publishProgress(((int) ((total * 100) / contentLen)),(int)total,(int)contentLen);
                            fileOutputStream.write(data, 0, count);
                            Log.d("Mydoxx",""+total);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return  true;
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        return false;
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                return false;
            }
        }.execute();
    }
    private void openPdf(String fileName){
        try{

            //File file= getFileStreamPath(fileName);
            //Log.e("file","file" + file.getAbsolutePath());
            seekBar.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
            current.setVisibility(View.GONE);
            total.setVisibility(View.GONE);
            //pdfView.setVisibility(View.VISIBLE);
            Intent intent = new Intent(this,ViewBook.class);
            intent.putExtra("Filename",fileName);
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    class Doxx2{
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public void setStatusBarGradiant(Activity activity) {

            Window window= activity.getWindow();
            Drawable background = ContextCompat.getDrawable(activity, R.drawable.gradient);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(activity,android.R.color.transparent));
            window.setNavigationBarColor(ContextCompat.getColor(activity,android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }
}








