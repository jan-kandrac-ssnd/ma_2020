package xyz.kandrac.smajlici;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.output);
        EditText day = findViewById(R.id.day);
        EditText month = findViewById(R.id.month);


        findViewById(R.id.button).setOnClickListener(view -> {

                Calendar now = Calendar.getInstance();
                Calendar birthday = Calendar.getInstance();
                birthday.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day.getText().toString()));
                birthday.set(Calendar.MONTH, Integer.parseInt(month.getText().toString()) - 1);

                if (now.after(birthday)) {
                    birthday.add(Calendar.YEAR, 1);
                }

                long diff = birthday.getTimeInMillis() - now.getTimeInMillis();
                long days = diff / (1000 * 60 * 60 * 24);

                text.setText("Do narodenin ti ostava: " + days + " dni");
            }
        );
    }
}
