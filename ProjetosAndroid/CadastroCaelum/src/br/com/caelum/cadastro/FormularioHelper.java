package br.com.caelum.cadastro;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import br.com.caelum.cadastro.modelo.Aluno;

import com.caelum.cadastrocaelum.R;

public class FormularioHelper {

	private TextView campoNome;
	private TextView campoTelefone;
	private TextView campoEndereco;
	private TextView campoSite;
	private SeekBar campoNota;
	private Aluno aluno;
	private ImageView campoFoto;

	public FormularioHelper(FormularioActivity activity) {
		aluno = new Aluno();
		
		campoNome = (TextView) activity.findViewById(R.id.nome);
		campoTelefone = (TextView) activity.findViewById(R.id.telefone);
		campoEndereco = (TextView) activity.findViewById(R.id.endereco);
		campoSite = (TextView) activity.findViewById(R.id.site);
		campoNota = (SeekBar) activity.findViewById(R.id.nota);
		campoFoto = (ImageView) activity.findViewById(R.id.foto);
	}

	public Aluno pegaAlunoDoFormulario() {
		
		aluno.setNome(campoNome.getText().toString());
		aluno.setTelefone(campoTelefone.getText().toString());
		aluno.setEndereco(campoEndereco.getText().toString());
		aluno.setSite(campoSite.getText().toString());
		aluno.setNota(campoNota.getProgress());
		
		return aluno;
	}

	public void colocaAlunoNoFormulario(Aluno alunoParaSerAlterado) {
		aluno = alunoParaSerAlterado;
		campoNome.setText(alunoParaSerAlterado.getNome());
		campoSite.setText(alunoParaSerAlterado.getSite());
		campoEndereco.setText(alunoParaSerAlterado.getEndereco());
		campoTelefone.setText(alunoParaSerAlterado.getTelefone());
		campoNota.setProgress((int) alunoParaSerAlterado.getNota());
		
		if (aluno.getCaminhoFoto() != null) {
			carregaImagem(aluno.getCaminhoFoto());
		}
	}

	public ImageView getCampoFoto() {
		return campoFoto;
	}

	public void carregaImagem(String caminhoArquivo) {
		aluno.setCaminhoFoto(caminhoArquivo);
		
		Bitmap imagem = BitmapFactory.decodeFile(caminhoArquivo);
		Bitmap imagemReduzida = Bitmap.createScaledBitmap(imagem, 100, 100, true);
		campoFoto.setImageBitmap(imagemReduzida);
	}
	
	
}
