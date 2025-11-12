package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var08PlayActivity extends AppCompatActivity {

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();

    private String answerText2;

    private EditText answerEditText2;

    private final ButtonClickListener buttonClickListener1 = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.check_button) {
                String answerText3 = answerEditText2.getText().toString();
                if (answerText3.equals(answerText2)) {
                    Toast.makeText(PracticalTest01Var08PlayActivity.this, "Victory!", Toast.LENGTH_LONG).show();
                    setResult(RESULT_OK);
                } else {
                    Toast.makeText(PracticalTest01Var08PlayActivity.this, "Fail!", Toast.LENGTH_LONG).show();
                }
            } else if (id == R.id.back_button) {
                Toast.makeText(PracticalTest01Var08PlayActivity.this, "Fail!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var08_play);

        answerEditText2 = findViewById(R.id.answer2_edit_text);

        TextView riddleTextView = findViewById(R.id.riddle_text);
        Intent intent = getIntent();
        if (intent != null) {
            String riddleText = intent.getStringExtra(Constants.RIDDLE_TEXT);
            answerText2 = intent.getStringExtra(Constants.ANSWER_TEXT);
            riddleTextView.setText(String.valueOf(riddleText));
        }

        Button checkButton = findViewById(R.id.check_button);
        Button backButton = findViewById(R.id.back_button);

        checkButton.setOnClickListener(buttonClickListener1);
        backButton.setOnClickListener(buttonClickListener1);
    }
}