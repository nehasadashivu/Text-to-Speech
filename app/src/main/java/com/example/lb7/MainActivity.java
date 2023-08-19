package com.example.lb7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.VoicemailContract;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import javax.net.ssl.SSLEngineResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    Button btnSpeak;
    EditText txtSpeak;
    TextToSpeech textToSpeech;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSpeak=(EditText)findViewById(R.id.edt_txt);
        btnSpeak=(Button) findViewById(R.id.btn_speech);
        btnSpeak.setOnClickListener(this);
        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);
    }

    @Override
    public void onClick(View view) {
        String text=txtSpeak.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onInit(int i) {
        if(i!=TextToSpeech.ERROR) {
            Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_LONG).show();

        }

    }
}