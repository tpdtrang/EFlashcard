package tuyenmanucian.e_flashcard;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import tuyenmanucian.e_flashcard.Adapter.AdapterVerb;
import tuyenmanucian.e_flashcard.models.DatabaseHelper;
import tuyenmanucian.e_flashcard.models.VerbsBQT;

public class IrregularActivity extends AppCompatActivity {

    ListView listView;
    private DatabaseHelper dbhelper;
    AdapterVerb adapterVerb;
    ArrayList<VerbsBQT> arrayList = new ArrayList<VerbsBQT>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irregular);
        listView = (ListView) findViewById(R.id.lvVerbs);

//        dbhelper = new DatabaseHelper(this);
        try {
            dbhelper = new DatabaseHelper(this);
            dbhelper.checkAndCopyData();
            dbhelper.openDatabase();
        } catch (SQLException e) {

        }
        try {
            Cursor cursor = dbhelper.QueryData("select * from VerbsE");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        VerbsBQT verbsBQT = new VerbsBQT();
                        verbsBQT.setSTT(cursor.getString(0));
                        verbsBQT.setTuNguyenMau(cursor.getString(1));
                        verbsBQT.setQuaKhuDon(cursor.getString(2));
                        verbsBQT.setQuaKhuPhanTu(cursor.getString(3));
                        verbsBQT.setNghiaCuaTu(cursor.getString(4));
                        arrayList.add(verbsBQT);
                    } while (cursor.moveToNext());

                }
            }
            dbhelper.close();
        } catch (SQLException e) {
        }
        adapterVerb = new AdapterVerb(this, R.layout.custorn_list_verbs, arrayList);

        listView.setAdapter(adapterVerb);
        adapterVerb.notifyDataSetChanged();
    }
}