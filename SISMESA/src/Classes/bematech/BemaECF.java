/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.bematech;

import classess.Utilitario;
import bemajava.BemaInteger;
import bemajava.Bematech;
import javax.swing.JOptionPane;

/**
 *
 * @author Valdemir
 */
public class BemaECF {
    
    private static int iRetorno;
    public static int iRet = 0;
    
    
    public static void analisaiRetorno() {
        iRet = 0;
        switch (iRetorno) {
            case 0:
                JOptionPane.showMessageDialog(null, "Erro de comunicação");
                iRet = 1;
                break;
            case -1:
                JOptionPane.showMessageDialog(null, "Erro de Execução na Função. Verifique!");
                iRet = 1;
                break;
            case -2:
                JOptionPane.showMessageDialog(null, "Parâmetro Inválido!");
                iRet = 1;
                break;
            case -3:
                JOptionPane.showMessageDialog(null, "Aliquota não programada!");
                iRet = 1;
                break;
            case -4:
                JOptionPane.showMessageDialog(null, "Arquivo BemaFI32.INI não encontrado. Verifique!");
                iRet = 1;
                break;
            case -5:
                JOptionPane.showMessageDialog(null, "Erro ao Abrir a Porta de Comunicação!");
                iRet = 1;
                break;
            case -6:
                JOptionPane.showMessageDialog(null, "Impressora Desligada ou Desconectada!");
                iRet = 1;
                break;
            case -7:
                JOptionPane.showMessageDialog(null, "Banco Não Cadastrado no Arquivo BemaFI32.ini!");
                iRet = 1;
                break;
            case -8:
                JOptionPane.showMessageDialog(null, "Erro ao Criar ou Gravar no Arquivo Retorno.txt ou Status.txt!");
                iRet = 1;
                break;
            case -18:
                JOptionPane.showMessageDialog(null, "Não foi Possível Abrir arquivo INTPOS.001!");
                iRet = 1;
                break;
            case -19:
                JOptionPane.showMessageDialog(null, "Parâmetro Diferentes!");
                iRet = 1;
                break;
            case -20:
                JOptionPane.showMessageDialog(null, "A Transação Cancelada pelo Operador!");
                iRet = 1;
                break;
            case -21:
                JOptionPane.showMessageDialog(null, "A Transação não foi aprovada!");
                iRet = 1;
                break;
            case -22:
                JOptionPane.showMessageDialog(null, "Não foi Possível Terminar a Impressão!");
                iRet = 1;
                break;
            case -23:
                JOptionPane.showMessageDialog(null, "Não foi Possível Terminar a Operação!");
                iRet = 1;
                break;
            case -24:
                JOptionPane.showMessageDialog(null, "Forma de Pagamento não Programada!");
                iRet = 1;
                break;
            case -25:
                JOptionPane.showMessageDialog(null, "Totalizador não Fiscal não Programado!");
                iRet = 1;
                break;
            case -26:
                JOptionPane.showMessageDialog(null, "Transação já Efetuada!");
                iRet = 1;
                break;
            case -28:
                JOptionPane.showMessageDialog(null, "Não há Informações para Serem Impressas!");
                iRet = 1;
                break;
            default:
                break;
            
        }
    }
    
    public static void retornoImpressora() {
        // private static BemaInteger iACK, iST1, iST2;
        BemaInteger iACK = new BemaInteger();
        BemaInteger iST1 = new BemaInteger();
        BemaInteger iST2 = new BemaInteger();
        iRetorno = Bematech.RetornoImpressora(iACK, iST1, iST2);

        // Verifica iST1
        if (iST1.number >= 128) {
            iST1.number = iST1.number - 128;
            JOptionPane.showMessageDialog(null, "Fim de Papel");
            iRet = 1;
        }
        if (iST1.number >= 64) {                  // bit 6
            iST1.number = iST1.number - 64;
            JOptionPane.showMessageDialog(null, "Pouco Papel");
            iRet = 1;
        }
        if (iST1.number >= 32) {                  // bit 5
            iST1.number = iST1.number - 32;
            JOptionPane.showMessageDialog(null, "Erro no Relógio");
            iRet = 1;
        }
        if (iST1.number >= 16) {                  // bit 4
            iST1.number = iST1.number - 16;
            JOptionPane.showMessageDialog(null, "Impressora em Erro");
            iRet = 1;
        }
        if (iST1.number >= 8) {                  // bit 3
            iST1.number = iST1.number - 8;
            JOptionPane.showMessageDialog(null, "Comando não iniciado com ESC");
            iRet = 1;
        }
        if (iST1.number >= 4) {                  // bit 2
            iST1.number = iST1.number - 4;
            JOptionPane.showMessageDialog(null, "Comando Inexistente");
            iRet = 1;
        }
        if (iST1.number >= 2) {                  // bit 1
            iST1.number = iST1.number - 2;
            JOptionPane.showMessageDialog(null, "Cupom Aberto");
            iRet = 1;
        }
        if (iST1.number >= 1) {                  // bit 0
            iST1.number = iST1.number - 1;
            JOptionPane.showMessageDialog(null, "Número de Parâmetro(s) Inválido(s)");
            iRet = 1;
        }

        //Verifica iST2
        if (iST2.number >= 128) {                  // bit 7
            iST2.number = iST2.number - 128;
            JOptionPane.showMessageDialog(null, "Tipo de Parâmetro de Comando Inválido");
            iRet = 1;
        }
        if (iST2.number >= 64) {                  // bit 6
            iST2.number = iST2.number - 64;
            JOptionPane.showMessageDialog(null, "Memória Fiscal Lotada");
            iRet = 1;
        }
        if (iST2.number >= 32) {                  // bit 5
            iST2.number = iST2.number - 32;
            JOptionPane.showMessageDialog(null, "Erro na Memória RAM");
            iRet = 1;
        }
        if (iST2.number >= 16) {                  // bit 4
            iST2.number = iST2.number - 16;
            JOptionPane.showMessageDialog(null, "Alíquota Não Programada");
            iRet = 1;
        }
        if (iST2.number >= 8) {                  // bit 3
            iST2.number = iST2.number - 8;
            JOptionPane.showMessageDialog(null, "Capacidade de Alíquotas Lotada");
            iRet = 1;
        }
        if (iST2.number >= 4) {                  // bit 2
            iST2.number = iST2.number - 4;
            JOptionPane.showMessageDialog(null, "Cancelamento Não Permitido");
            iRet = 1;
        }
        if (iST2.number >= 2) {                  // bit 1
            iST2.number = iST2.number - 2;
            JOptionPane.showMessageDialog(null, "CNPJ/IE do Proprietário Não Programado");
            iRet = 1;
        }
        if (iST2.number >= 1) {                  // bit 0
            iST2.number = iST2.number - 1;
            JOptionPane.showMessageDialog(null, "Comando Não Executado");
            iRet = 1;
        }
        
    }
    
    public static void leituraX() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Emitir a Leitura X?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            iRetorno = Bematech.LeituraX();
            analisaiRetorno();
            retornoImpressora();
        }
    }
    
    public static void leituraZ() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Emitir a Redução Z? - ATENÇÃO: Caixa será encerrado!", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            iRetorno = Bematech.ReducaoZ("", "");
            analisaiRetorno();
            retornoImpressora();
        }
    }
    
    public static void abreCupom() {
        iRetorno = Bematech.AbreCupom("");
        analisaiRetorno();
        retornoImpressora();
    }
    
    public static void fechaCupom(String acrescimoDesconto, String tipoAcrescimoDesconto, String valorAcrescimoDesconto, String mensagem, String formaPagamento, String valorFormaPagamento) {
        iRetorno = Bematech.IniciaFechamentoCupom(acrescimoDesconto, tipoAcrescimoDesconto, valorAcrescimoDesconto);
        iRetorno = Bematech.EfetuaFormaPagamento(formaPagamento, valorFormaPagamento);
        iRetorno = Bematech.TerminaFechamentoCupom(mensagem);
        
        analisaiRetorno();
        retornoImpressora();
    }
    
    public static void abrirPortaSerial() {
        iRetorno = Bematech.AbrePortaSerial();
        analisaiRetorno();
        retornoImpressora();
    }
    
    public static void fechaPortaSerial() {
        iRetorno = Bematech.FechaPortaSerial();
        analisaiRetorno();
        retornoImpressora();
    }
    
    public static void horarioVerao() {
        if (JOptionPane.showConfirmDialog(null, "Deseja sair/entrar no Horário de Verão", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            iRetorno = Bematech.ProgramaHorarioVerao();
            analisaiRetorno();
            retornoImpressora();
        }
    }
    
    public static void memoriaFiscalPorData() {
        String data1 = JOptionPane.showInputDialog("Insira a data Inicial(ddmmaaaa) : ");
        String data2 = JOptionPane.showInputDialog("Insira a data Final (ddmmaaaa) : ");
        if (JOptionPane.showConfirmDialog(null, "Deseja emitir o relatório de memória fiscal", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            iRetorno = Bematech.LeituraMemoriaFiscalData(data1, data2);
            analisaiRetorno();
            retornoImpressora();
        }
    }
    
    public static void memoriaFiscalPorReducao() {
        String reducao1 = JOptionPane.showInputDialog("Insira o Número da Redução Z Inicial (4 dígitos) : ");
        String reducao2 = JOptionPane.showInputDialog("Insira o Número da Redução Z Final (4 dígitos) : ");
        if (JOptionPane.showConfirmDialog(null, "Deseja emitir o relatório de memória fiscal", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            iRetorno = Bematech.LeituraMemoriaFiscalReducao(reducao1, reducao2);
            analisaiRetorno();
            retornoImpressora();
        }
    }
    
    public static void cancelaCupom() {
        if (JOptionPane.showConfirmDialog(null, "Deseja cancelar o cupom anterior", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            iRetorno = Bematech.CancelaCupom();
            analisaiRetorno();
            retornoImpressora();
        }
    }
    
    public static void vendeItem(String codigo, String descricao, String aliquota, String tipoQtde, String qtde, int casasDecimais, String vlrUnitario, String tipoDesconto, String vlrDesconto) {
        iRetorno = Bematech.VendeItem(codigo, descricao, aliquota, tipoQtde, qtde, casasDecimais, vlrUnitario, tipoDesconto, vlrDesconto);
        analisaiRetorno();
        retornoImpressora();
    }
    
    public static void cancelaItemGenerico(String item) {
        iRetorno = Bematech.CancelaItemGenerico(item);
        analisaiRetorno();
        retornoImpressora();
    }
    
    public static void cancelaItemAterior() {
        iRetorno = Bematech.CancelaItemAnterior();
        analisaiRetorno();
        retornoImpressora();
    }
    
    public static void programaAliquota() {
        String tipo = JOptionPane.showInputDialog("Informe o tipo de aliquota, ICMS ou ISS: ");
        if (tipo != null && !tipo.trim().equals("")) {
            tipo = tipo.toUpperCase();
            if (!tipo.equals("ICMS") && !tipo.equals("ISS")) {
                JOptionPane.showMessageDialog(null, "Formato inválido, deve ser ICMS ou ISS!", "Alerta", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int vinculo = 0;
            if (tipo.equals("ICMS")) {
                vinculo = 0;
            }
            if (tipo.equals("ISS")) {
                vinculo = 1;
            }
            String aliquota = JOptionPane.showInputDialog("Informe o valor em percentual aliquota : ");
            
            if (aliquota != null && !aliquota.trim().equals("")) {
                if (JOptionPane.showConfirmDialog(null, "Deseja programar aliquota?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    iRetorno = Bematech.ProgramaAliquota(aliquota, vinculo);
                    analisaiRetorno();
                    retornoImpressora();
                    if (iRet == 0) {
                        Utilitario.SalvaAliquota(tipo, aliquota); 
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aliquota não programada, deve ser informado um valor em percentual!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aliquota não programada, deve ser informado o tipo ICMS ou ISS!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void programaHorarioVerao() {
        iRetorno = Bematech.ProgramaHorarioVerao();
        analisaiRetorno();
        retornoImpressora();
    }
}
