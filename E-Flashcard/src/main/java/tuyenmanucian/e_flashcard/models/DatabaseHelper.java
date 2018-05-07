package tuyenmanucian.e_flashcard.models;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Admin on 3/25/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_Path="/data/data/tuyenmanucian.e_flashcard/";
    private static String DB_NAME="mydatabase.sqlite";
    private SQLiteDatabase myDatabase;
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    private boolean checkDatabase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = DB_Path + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READWRITE);

        }catch (SQLException e) {

        }
        if (checkDB != null) checkDB.close();
        return checkDB != null ? true : false;
    }
    private void copyDatabase() throws IOException {
        InputStream myInput=myContext.getAssets().open(DB_NAME);
        String outFileName;
        outFileName=DB_Path + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer,0,length);

        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void openDatabase() throws SQLException{
        String myPath=DB_Path+DB_NAME;
        myDatabase=SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);

    }
    public void ExeSQLData(String sql)throws SQLException{
        myDatabase.execSQL(sql);
    }
    public Cursor QueryData(String query) throws SQLException{
        return myDatabase.rawQuery(query,null);
    }
    @Override
    public synchronized void close(){
        if (myDatabase != null)
            myDatabase.close();
        super.close();
    }
    public void checkAndCopyData(){
        boolean dbExits=checkDatabase();
        if (dbExits){
            Log.d("TAG","Database already exits");
        }else {
            this.getReadableDatabase();
            try {
                copyDatabase();
            }catch (IOException e){
                Log.d("TAG","Error copying data");
            }
        }
    }
}
