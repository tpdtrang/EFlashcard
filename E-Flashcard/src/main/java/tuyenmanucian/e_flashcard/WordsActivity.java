package tuyenmanucian.e_flashcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class WordsActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        listview=findViewById(R.id.listview);
        arrayList = new ArrayList<>();
        arrayList.add("mother");
        arrayList.add("father");
        arrayList.add("son");
        arrayList.add("daughter");
        arrayList.add("family");

        ArrayAdapter adapter = new ArrayAdapter(WordsActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listview.setAdapter(adapter);
    }
}
