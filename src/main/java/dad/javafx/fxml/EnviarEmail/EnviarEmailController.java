package dad.javafx.fxml.EnviarEmail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

public class EnviarEmailController implements Initializable {

	EnviarEmailModel model = new EnviarEmailModel();

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

		// bindeos
		model.servidorProperty().bind(serverField.textProperty());

		model.puertoProperty().bind(puertoField.textProperty());

		model.SSLProperty().bind(SSLbox.selectedProperty());

		model.remitenteProperty().bind(remitenteField.textProperty());

		model.contraseñaProperty().bind(passField.textProperty());

		model.destinatarioProperty().bind(destinatarioField.textProperty());

		model.asuntoProperty().bind(asuntoField.textProperty());

		model.mensajeProperty().bind(mensajeArea.textProperty());

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
	void send(ActionEvent event) throws EmailException {

		// System.out.println(model.getServidor());
		// Servidor = smtp.gmail.com:465
		// SSL = sí
		// Email/Usuario = dad.iesdpm@gmail.com
		// pass = Minikit0$

		int puerto;
		puerto = Integer.valueOf(model.getPuerto());

		Alert nice = new Alert(AlertType.INFORMATION);
		Alert bad = new Alert(AlertType.ERROR);

		try {
			Email email = new SimpleEmail();
			email.setHostName(model.getServidor());
			email.setSmtpPort(puerto);
			email.setAuthenticator(new DefaultAuthenticator(model.getRemitente(), model.getContraseña()));
			email.setSSLOnConnect(model.isSSL());
			email.setFrom(model.getRemitente());
			email.setSubject(model.getAsunto());
			email.setMsg(model.getMensaje());
			email.addTo(model.getDestinatario());
			email.send();

			nice.setTitle("Mensaje enviado");
			nice.setHeaderText("Mensaje enviado con éxito a '" + model.getDestinatario() + "'");
			nice.showAndWait();

			destinatarioField.clear();
			asuntoField.clear();
			mensajeArea.clear();
		} catch (EmailException e) {
			bad.setTitle("Error");
			bad.setHeaderText("No se pudo enviar el email.");
			bad.setContentText(e.getMessage());
			bad.showAndWait();
		}

	}

}
