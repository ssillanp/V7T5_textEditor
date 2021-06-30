package com.example.v7t5_texteditor;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    EditText myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        myText = (EditText) findViewById(R.id.myText);

        System.out.println(context.getFilesDir());
    }

    public void loadText(View v) {
        try {
            InputStream inStream = context.openFileInput("testfile.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
            String myStr = "";
            while ((myStr = br.readLine()) != null) {
                System.out.println(myStr);
            }
        } catch (IOException e) {
            Log.e("LoadFileIOException", "Virhe striimissä");
        } catch (FileNotFoundException e) {
            Log.e("LoadFileNotFound", "Tiedostoa ei ole");
        }
    }

    public void saveText(View v) {
        System.out.println("SAVE: " + myText.getText());
    }

}