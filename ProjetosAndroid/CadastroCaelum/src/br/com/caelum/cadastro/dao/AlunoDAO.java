package br.com.caelum.cadastro.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.cadastro.modelo.Aluno;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlunoDAO extends SQLiteOpenHelper {

	private static final String DATABASE = "CadastroCaelum";
	private static final int VERSAO = 4;
	private static final String TABELA = "Alunos";

	public AlunoDAO(Context ctx) {
		super(ctx, DATABASE, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE " + TABELA + "( "
			+ "id INTEGER PRIMARY KEY, " 
			+ "nome TEXT UNIQUE NOT NULL, "
			+ "telefone TEXT, "
			+ "endereco TEXT, "
			+ "site TEXT, "
			+ "nota REAL, "
			+ "caminhoFoto TEXT"
			+ ");";
		
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS " + TABELA;
		db.execSQL(sql);
		onCreate(db);
	}

	public void insere(Aluno aluno) {
		ContentValues cv = new ContentValues();
		cv.put("nome", aluno.getNome());
		cv.put("telefone", aluno.getTelefone());
		cv.put("endereco", aluno.getEndereco());
		cv.put("site", aluno.getSite());
		cv.put("nota", aluno.getNota());
		cv.put("caminhoFoto", aluno.getCaminhoFoto());
		
		getWritableDatabase().insert(TABELA, null, cv);
		
	}

	public List<Aluno> getLista() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		String sql = "SELECT * FROM Alunos;";
		Cursor c = getReadableDatabase().rawQuery(sql,null);
		while (c.moveToNext()) {
			Aluno aluno = new Aluno();
			aluno.setId(c.getLong(c.getColumnIndex("id")));
			aluno.setNome(c.getString(c.getColumnIndex("nome")));
			aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
			aluno.setEndereco(c.getString(c.getColumnIndex("endereco")));
			aluno.setSite(c.getString(c.getColumnIndex("site")));
			aluno.setNota(c.getDouble(c.getColumnIndex("nota")));
			aluno.setCaminhoFoto(c.getString(c.getColumnIndex("caminhoFoto")));
			
			alunos.add(aluno);
		}
		return alunos;
	}

	public void deletar(Aluno aluno) {
		String[] args = {aluno.getId().toString()};
		getWritableDatabase().delete(TABELA, "id=?", args);
	}

	public void atualizar(Aluno aluno) {
		ContentValues cv = new ContentValues();
		cv.put("nome", aluno.getNome());
		cv.put("telefone", aluno.getTelefone());
		cv.put("endereco", aluno.getEndereco());
		cv.put("site", aluno.getSite());
		cv.put("nota", aluno.getNota());
		cv.put("caminhoFoto", aluno.getCaminhoFoto());
		
		String[] args = {aluno.getId().toString()};
		getWritableDatabase().update(TABELA, cv, "id=?", args );
	}

}
