package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SampleController implements Initializable {
	@FXML
	private Label labelInicial = new Label();
	
	@FXML
	private Button botaoInicial = new Button();
	
	@FXML
	private TextArea textAno = new TextArea();
	
	@FXML
	private TextArea textDia = new TextArea();
	
	@FXML
	private TextArea textMes = new TextArea();

	@FXML
	private void clickBotao(ActionEvent event) {
		String ano = textAno.getText();
		String mes = textMes.getText();
		String dia = textDia.getText();
		String textoDaIdade;
		Model anoCalc = new Model(dia, mes, ano);
		anoCalc.calcule();
		String complemento = new String();
		if (anoCalc.getIdade()< 16) {
			complemento = " anos. N�o pode tirar titulo de eleitor, habilita��o, nem se aposentar";
		} else if ((anoCalc.getIdade() >= 16) &&(anoCalc.getIdade()<18)) {
			complemento = " anos. Pode tirar titulo de eleitor, mas n�o pode tirar habilita��o, ou se aposentar";
		} else if ((anoCalc.getIdade()) >= 18 && (anoCalc.getIdade() <60)) {
			complemento = " anos. Deve tirar titulo de eleitor, pode tirar habilita��o, mas n�o pode se aposentar";
		} else {
			complemento = " anos. Deve tirar titulo de eleitor, pode tirar habilita��o e se aposentar";
		}
		if (anoCalc.getIdade() < 0) {
			textoDaIdade = "Voc� ainda n�o nasceu, que estranho... acho que errou algum n�mero";
		} else {
			textoDaIdade = String.valueOf(anoCalc.getIdade())+complemento;
		}
		labelInicial.setText(textoDaIdade);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
}
