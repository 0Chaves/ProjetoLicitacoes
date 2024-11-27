module ProjetoLicitacoes {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens Controller to javafx.graphics, javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
