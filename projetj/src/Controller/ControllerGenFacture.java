package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ClassModel.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControllerGenFacture implements Initializable {
@FXML
Label idFacture;
@FXML
Label idClient;
@FXML
Label idResa;
@FXML
Label reservationHotel;
@FXML
Label chambre;
@FXML
Label montant;

Reservation resa;
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
		
		
}
public void imprimer(ActionEvent e) {
	
	Document document=new Document();
	
	try {
		
		PdfWriter.getInstance(document, new FileOutputStream("C:/Users/salah/Desktop/pdf/hello.pdf"));
		document.open();
		document.add(new Paragraph("Facture du Client"));
		
		document.add(new Paragraph(idFacture.getText()));
		document.add(new Paragraph(idClient.getText()));
		document.add(new Paragraph(idResa.getText()));
		document.add(new Paragraph(reservationHotel.getText()));
		document.add(new Paragraph(chambre.getText()));
		document.add(new Paragraph(montant.getText()));
		document.close();




		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (DocumentException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}

}
