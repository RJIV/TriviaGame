import javafx.fxml.FXML;

import javafx.scene.control.ToggleGroup;

import javafx.event.ActionEvent;

import javafx.scene.control.ProgressBar;

import javafx.scene.control.TextArea;

import javafx.scene.image.ImageView;

import javafx.scene.control.RadioButton;

import javafx.scene.layout.Pane;

public class DefaultQuestionPanelController {
	@FXML
	private Pane defaultQuestionPanel;
	@FXML
	private ImageView moviePoster;
	@FXML
	private TextArea question;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private RadioButton choiceA;
	@FXML
	private ToggleGroup buttonGroup;
	@FXML
	private RadioButton choiceC;
	@FXML
	private RadioButton choiceB;
	@FXML
	private RadioButton choiceD;
	
	private Question q;

	public void initialize() {
		q = new Question();
		question.setText(q.getQue());
		choiceA.setText(q.getAChoice());
		choiceB.setText(q.getBChoice());
		choiceC.setText(q.getCChoice());
		choiceD.setText(q.getDChoice());
		
	}
	// Event Listener on RadioButton[#choiceA].onAction
	@FXML
	public void answerA(ActionEvent event) {
		System.out.println("Answer A");
	}
	// Event Listener on RadioButton[#choiceC].onAction
	@FXML
	public void answerC(ActionEvent event) {
		System.out.println("Answer C");
	}
	// Event Listener on RadioButton[#choiceB].onAction
	@FXML
	public void answerB(ActionEvent event) {
		System.out.println("Answer B");
	}
	// Event Listener on RadioButton[#choiceD].onAction
	@FXML
	public void answerD(ActionEvent event) {
		System.out.println("Answer D");
	}
}
