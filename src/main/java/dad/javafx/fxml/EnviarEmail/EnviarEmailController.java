package dad.javafx.fxml.EnviarEmail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EnviarEmailController implements Initializable {

	@FXML
	private GridPane view;

	@FXML
	private TextField serverField;

	@FXML
	private Button enviarButton;

	@FXML
	private TextArea mensajeArea;

	@FXML
	private TextField puertoField;

	@FXML
	private CheckBox SSLbox;

	@FXML
	private TextField remitenteField;

	@FXML
	private TextField destinatarioField;

	@FXML
	private TextField asuntoField;

	@FXML
	private Button vaciarButton;

	@FXML
	private Button cerrarButton;

	@FXML
	private PasswordField passField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public EnviarEmailController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public GridPane getView() {
		return view;
	}

	@FXML
	void clean(ActionEvent event) {
		mensajeArea.clear();
		serverField.clear();
		puertoField.clear();
		remitenteField.clear();
		destinatarioField.clear();
		asuntoField.clear();
		passField.clear();
	}

	@FXML
	void close(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void send(ActionEvent event) {

	}

}
