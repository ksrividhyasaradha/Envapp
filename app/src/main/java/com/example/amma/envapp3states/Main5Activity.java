package com.example.amma.envapp3states;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Main5Activity extends AppCompatActivity implements TextToSpeech.OnInitListener, TextToSpeech.OnUtteranceCompletedListener {
    TextToSpeech textToSpeecht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        textToSpeecht = new TextToSpeech(Main5Activity.this, Main5Activity.this);
        final Button Speakbutton = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textview);

        Speakbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textToSpeecht.isSpeaking()) {
                    HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
                    stringStringHashMap.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "@string/mudhumalai");
                    textToSpeecht.speak(textView.getText().toString(), TextToSpeech.QUEUE_ADD, stringStringHashMap);
                    Speakbutton.setVisibility(Button.GONE);
                } else {
                    textToSpeecht.stop();
                }
            }
        });
    }

    @Override
    public void onInit(int status) {
         textToSpeecht.setOnUtteranceCompletedListener(this);
    }

    @Override
    public void onUtteranceCompleted(String utteranceId) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Main5Activity.this, "Utterance completed", Toast.LENGTH_SHORT).show();
                Button button = (Button) findViewById(R.id.button);
                button.setVisibility(Button.VISIBLE);
            }
        });
        {
        }
    }

    protected void onDestroy() {
        if (textToSpeecht != null) {
            textToSpeecht.stop();
            textToSpeecht.shutdown();
            textToSpeecht=null;

            }
       super.onDestroy();
    }
}
