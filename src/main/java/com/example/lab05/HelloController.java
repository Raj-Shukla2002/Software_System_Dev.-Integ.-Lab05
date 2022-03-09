package com.example.lab05;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TableView<StudentRecord> tableView;
    public TableColumn<StudentRecord, String> colSID;
    public TableColumn<StudentRecord, Float> colAssignments;
    public TableColumn<StudentRecord, Float> colMidterm;
    public TableColumn<StudentRecord, Float> colExam;
    public TableColumn<StudentRecord, Float> colFinalGrade;
    public TableColumn<StudentRecord, String> colLetterGrade;

    public TextField textfieldID;
    public TextField textfieldMidterm;
    public TextField textfieldAssignment;
    public TextField textfieldExam;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colSID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colAssignments.setCellValueFactory(new PropertyValueFactory<>("studentAssginment"));
        colMidterm.setCellValueFactory(new PropertyValueFactory<>("studentMidterm"));
        colExam.setCellValueFactory(new PropertyValueFactory<>("studentExam"));
        colFinalGrade.setCellValueFactory(new PropertyValueFactory<>("studentFinal"));
        colLetterGrade.setCellValueFactory(new PropertyValueFactory<>("studentLetter"));
        tableView.setItems(marks);
    }

    private DataSource students = new DataSource();
    public ObservableList<StudentRecord> marks = students.getAllMarks();

    public void buttonAdd(ActionEvent actionEvent){
        marks.add(new StudentRecord(textfieldID.getText(), Float.parseFloat(textfieldAssignment.getText()), Float.parseFloat(textfieldMidterm.getText()), Float.parseFloat(textfieldExam.getText())));

    }
}