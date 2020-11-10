package dad.javafx.fxml.EnviarEmail;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EnviarEmailModel {

	StringProperty puerto = new SimpleStringProperty();
	BooleanProperty SSL = new SimpleBooleanProperty();
	StringProperty servidor = new SimpleStringProperty();
	StringProperty remitente = new SimpleStringProperty();
	StringProperty contraseña = new SimpleStringProperty();
	StringProperty destinatario = new SimpleStringProperty();
	StringProperty asunto = new SimpleStringProperty();
	StringProperty mensaje = new SimpleStringProperty();

	public final BooleanProperty SSLProperty() {
		return this.SSL;
	}

	public final boolean isSSL() {
		return this.SSLProperty().get();
	}

	public final void setSSL(final boolean SSL) {
		this.SSLProperty().set(SSL);
	}

	public final StringProperty servidorProperty() {
		return this.servidor;
	}

	public final String getServidor() {
		return this.servidorProperty().get();
	}

	public final void setServidor(final String servidor) {
		this.servidorProperty().set(servidor);
	}

	public final StringProperty remitenteProperty() {
		return this.remitente;
	}

	public final String getRemitente() {
		return this.remitenteProperty().get();
	}

	public final void setRemitente(final String remitente) {
		this.remitenteProperty().set(remitente);
	}

	public final StringProperty contraseñaProperty() {
		return this.contraseña;
	}

	public final String getContraseña() {
		return this.contraseñaProperty().get();
	}

	public final void setContraseña(final String contraseña) {
		this.contraseñaProperty().set(contraseña);
	}

	public final StringProperty destinatarioProperty() {
		return this.destinatario;
	}

	public final String getDestinatario() {
		return this.destinatarioProperty().get();
	}

	public final void setDestinatario(final String destinatario) {
		this.destinatarioProperty().set(destinatario);
	}

	public final StringProperty asuntoProperty() {
		return this.asunto;
	}

	public final String getAsunto() {
		return this.asuntoProperty().get();
	}

	public final void setAsunto(final String asunto) {
		this.asuntoProperty().set(asunto);
	}

	public final StringProperty mensajeProperty() {
		return this.mensaje;
	}

	public final String getMensaje() {
		return this.mensajeProperty().get();
	}

	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}

	public final StringProperty puertoProperty() {
		return this.puerto;
	}

	public final String getPuerto() {
		return this.puertoProperty().get();
	}

	public final void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}

}
