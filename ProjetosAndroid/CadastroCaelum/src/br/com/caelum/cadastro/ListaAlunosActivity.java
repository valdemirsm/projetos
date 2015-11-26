package br.com.caelum.cadastro;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;
import br.com.caelum.cadastro.adapter.AlunoAdapter;
import br.com.caelum.cadastro.converter.AlunoConverter;
import br.com.caelum.cadastro.dao.AlunoDAO;
import br.com.caelum.cadastro.modelo.Aluno;
import br.com.caelum.cadastro.support.WebClient;
import br.com.caelum.cadastro.task.EnviarContatosTask;

import com.caelum.cadastrocaelum.R;

public class ListaAlunosActivity extends Activity{
	private ListView lista;
	protected Aluno aluno;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listagem_aluno);
		
		lista = (ListView) findViewById(R.id.lista);
		
		registerForContextMenu(lista);
		
		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
				Aluno alunoParaSerAlterado = (Aluno) adapter.getItemAtPosition(posicao);
				
				Intent irParaFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
				irParaFormulario.putExtra(Extras.ALUNO_SELECIONADO, alunoParaSerAlterado);
				startActivity(irParaFormulario);
				
			}
		});
		
		lista.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				aluno = (Aluno) adapter.getItemAtPosition(posicao);
				return false;
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_lista_alunos, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_novo:
			Intent irParaFormulario = new Intent(this, FormularioActivity.class);
			startActivity(irParaFormulario);
			break;
			
		case R.id.menu_enviar_alunos:
			new EnviarContatosTask(this).execute();
			return false;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		carregaLista();
	}
	
	private void carregaLista() {
		AlunoDAO alunoDAO = new AlunoDAO(this);
		List<Aluno> alunos = alunoDAO.getLista();
	
		AlunoAdapter alunoAdapter = new AlunoAdapter(alunos, this);

		lista.setAdapter(alunoAdapter);
    }  
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuItem ligar = menu.add("Liga");
		ligar.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent irParaATelaDeDiscagem = new Intent(Intent.ACTION_CALL); 
				Uri telefoneDoAluno = Uri.parse("tel: " + aluno.getTelefone());
				irParaATelaDeDiscagem.setData(telefoneDoAluno);
				
				startActivity(irParaATelaDeDiscagem);
				return false;
			}
		});
		
		MenuItem sms = menu.add("Enviar SMS");
		sms.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent irParaATelaDeSms = new Intent(Intent.ACTION_VIEW);
				Uri smsDoAluno = Uri.parse("sms:" + aluno.getTelefone());
				irParaATelaDeSms.setData(smsDoAluno);
				irParaATelaDeSms.putExtra("sms_body", "Mensagem");
				
				startActivity(irParaATelaDeSms);
				return false;
			}
		});
		
		MenuItem mapa = menu.add("Achar no Mapa");
		mapa.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent irParaOMataDoAluno = new Intent(Intent.ACTION_VIEW);
				Uri mapaDoAluno = Uri.parse("geo:0,0?z=14&q=" + aluno.getEndereco());
				irParaOMataDoAluno.setData(mapaDoAluno);
				startActivity(irParaOMataDoAluno);
				return false;
			}
		});
		
		MenuItem site = menu.add("Navegar no Site");
		site.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent irParaOSiteDoAluno = new Intent(Intent.ACTION_VIEW);
				Uri siteDoAluno = Uri.parse("http:" + aluno.getSite());
				irParaOSiteDoAluno.setData(siteDoAluno);
				
				startActivity(irParaOSiteDoAluno);
				return false;
			}
		});
		MenuItem deletar = menu.add("Deletar");
		deletar.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(ListaAlunosActivity.this, "teste", Toast.LENGTH_SHORT).show();
				AlunoDAO dao = new AlunoDAO(ListaAlunosActivity.this);
				dao.deletar(aluno);
				dao.close();
				carregaLista();
				return false;
			}
		});
		MenuItem email = menu.add("Enviar E-Mail");
		email.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent intentEmail = new Intent(Intent.ACTION_SEND);
			    intentEmail.setType("message/rtc822");
			    intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {"valdemirsm@gmail.com"});
			    intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Testando subject do email");
			    intentEmail.putExtra(Intent.EXTRA_TEXT, "Testando corpo do email");
			    startActivity(intentEmail);
				return false;
			}
		});
	}
}
