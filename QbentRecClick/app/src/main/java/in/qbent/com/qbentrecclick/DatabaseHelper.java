package in.qbent.com.qbentrecclick;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper
{
    RecycleClickActivity recycleClickActivity;
    //Database version//
    private static final int DATABASE_VERSION = 1;

    //Database Name//
    private static final String DATABASE_NAME = "user.db";

    //Table name//
    private static final String TABLE_USER = "myUser";

    //Table Columns name//
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_TOKEN = "user_token";

    //Create SQL query//
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + " (user_name TEXT PRIMARY KEY,user_token TEXT)";

    //Drop SQL query//
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    //Constructor//
    public DatabaseHelper(Context context,String s)
    {
        super(context, DATABASE_NAME, null , 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        addUser(s);
        //getData();
        getDetails();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        //Drop user table if exists//
        sqLiteDatabase.execSQL(DROP_USER_TABLE);
        //Creates table again//
        onCreate(sqLiteDatabase);
    }

    //Method to insert data in SQLite//
    public void addUser(String s)
    {

        JSONObject jsonObject1 = null;
        try {
            jsonObject1 = new JSONObject(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        User userModel = null;
        try {
            userModel = new User(
                    jsonObject1.getString("name"),
                    jsonObject1.getString("token")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME,userModel.getName());
        values.put(COLUMN_USER_TOKEN,userModel.getToken());

        //Inserting rows//
        sqLiteDatabase.insert(TABLE_USER,null,values);
        sqLiteDatabase.close();

    }

    public void getDetails()
    {
        String token = "";
        SQLiteDatabase sqLiteDatabase2 = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase2.rawQuery("select * from myUser",null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false)
        {
            token = cursor.getString(cursor.getColumnIndex(COLUMN_USER_TOKEN));
            //arrayList.add(cursor.getString(cursor.getColumnIndex(COLUMN_USER_TOKEN)));
            cursor.moveToNext();
        }
        recycleClickActivity = new RecycleClickActivity(token);
    }

    //Fetch all user and return the list of user records//
//    public List<User> getAllUser()
//    {
//        //Array of columns to fetch//
//        String[] columns = {
//                COLUMN_USER_NAME,
//                COLUMN_USER_TOKEN
//        };
//
//        //Sorting orders//
//        String sortOrder = COLUMN_USER_NAME + "ASC";
//        List<User> userList = new ArrayList<User>();
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//
//        //Query the user table//
//        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
//                columns,
//                null,
//                null,
//                null,
//                null,
//                sortOrder
//                );
//
//        //Traversing through all rows and adding to list//
//
//    }


}
