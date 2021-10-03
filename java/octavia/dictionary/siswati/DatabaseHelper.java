package octavia.dictionary.siswati;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    //the name of the database in sqlite
    private static String DB_NAME = "Siswati.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;


    public DatabaseHelper(Context context){

        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH= myContext.getDatabasePath(DB_NAME).toString();
    }

    //empty database to create with my own database here

    public void createDataBase() throws IOException{

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing -database is already there
        }else{
            //this method will overwrite the database with our database
            this.getWritableDatabase();

            try{
                copyDataBase();
            }catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }

    private void copyDataBase() throws IOException {
        //opening the local db
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH;
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer byts from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //close the stream
        myInput.close();
        myOutput.close();
        myOutput.flush();
    }

    private boolean checkDataBase() {

        //this.getReadableDatabase();
      SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch (SQLException e){
            //database doesn't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    public void openDatabase() throws SQLException{
        //open the data
        String myPath = DB_PATH;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null,SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close(){
        if(myDataBase != null)
            myDataBase.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db){

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
