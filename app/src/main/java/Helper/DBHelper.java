package Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context)
    {
        super(context,"loginapp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE users (usuario Text primary key, email text, senha text, telefone text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS users";
        db.execSQL(sql);
    }
    public boolean validarLoginSenha(String usuario, String senha)
    {
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor c = myDB.rawQuery("SELECT * FROM users WHERE usuario=? AND senha=?", new String[]{usuario, senha});
        if (c.getCount()>0)
        {
            return true;
        }
        return false;
    }
    public boolean cadastrarUsuario (String usuario, String senha, String email, String telefone)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("usuario",usuario);
        contentValues.put("senha",senha);
        contentValues.put("email", email);
        db.insert("users",null,contentValues);

        return true;
    }
}
