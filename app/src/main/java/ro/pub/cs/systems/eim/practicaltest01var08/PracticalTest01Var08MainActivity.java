package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ro.pub.cs.systems.eim.practicaltest01var08.Constants;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private EditText riddleEditText;
    private EditText answerEditText;

    private final IntentFilter intentFilter = new IntentFilter();

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String riddleText = riddleEditText.getText().toString();
            String answerText = answerEditText.getText().toString();

            if (view.getId() == R.id.play_button) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08PlayActivity.class);
                if (!riddleText.isBlank() && !answerText.isBlank()) {
                    intent.putExtra(Constants.RIDDLE_TEXT, riddleText);
                    intent.putExtra(Constants.ANSWER_TEXT, answerText);
                    startActivity(intent);
                } else {
                    Toast.makeText(PracticalTest01Var08MainActivity.this, "Must fill out forms!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var08_main);

        riddleEditText = findViewById(R.id.riddle_edit_text);
        answerEditText = findViewById(R.id.answer_edit_text);
        Button playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(buttonClickListener);


    }
}