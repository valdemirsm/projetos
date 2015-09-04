package br.com.caelum.cadastro;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import br.com.caelum.cadastro.dao.AlunoDAO;
import br.com.caelum.cadastro.modelo.Aluno;

import com.caelum.cadastrocaelum.R;

public class FormularioActivity extends Activity{
	
	
	private FormularioHelper helper;
	private String caminhoArquivo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		
		helper = new FormularioHelper(this);
		
		final Button botao = (Button) findViewById(R.id.botao);
		
		final Aluno alunoParaSerAlterado = (Aluno) getIntent().getSerializableExtra(Extras.ALUNO_SELECIONADO);
		if (alunoParaSerAlterado != null) {
			botao.setText("Alterar");
			helper.colocaAlunoNoFormulario(alunoParaSerAlterado);			
		}
		
		botao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Aluno aluno = helper.pegaAlunoDoFormulario();
				
				AlunoDAO alunoDAO = new AlunoDAO(FormularioActivity.this);
				if (alunoParaSerAlterado != null) {
					aluno.setId(alunoParaSerAlterado.getId());
					alunoDAO.atualizar(aluno);
				} else {
					alunoDAO.insere(aluno);					
				}
				alunoDAO.close();
				
				finish();
				
			}
		});
		
		ImageView foto = helper.getCampoFoto();
		foto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent irParaCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				
				caminhoArquivo = getExternalFilesDir(null) + "/" +System.currentTimeMillis() + ".png";
				File arquivo = new File(caminhoArquivo);
				Uri localFoto = Uri.fromFile(arquivo);
				
				irParaCamera.putExtra(MediaStore.EXTRA_OUTPUT, localFoto);
				startActivityForResult(irParaCamera, 123);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Toast.makeText(this, requestCode, Toast.LENGTH_LONG).show();
		if (requestCode == 123) {
			if (resultCode == Activity.RESULT_OK){
				helper.carregaImagem(caminhoArquivo);
			} else {
				caminhoArquivo = null;
			}
		}
	}
}
