package com.calc.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import utils.Evaluate;

import java.awt.*;

public class CalculatorController {
    private double lastAnswer = 0;

    @FXML
    private TextArea expression;

    @FXML
    private Label result;

    @FXML


    public void insertNumber(String num){
        expression.setText(expression.getText() + num);
    }

    public void insertOperator(String operator){
        expression.setText(expression.getText() + " " + operator + " ");
    }

    public void clearExpression(){
        expression.setText("");
        result.setText("= ");
    }

    public void insertANS(){
        expression.setText(expression.getText() + String.valueOf((int)lastAnswer));
    }

    public void delLast(){
        if(!getExpression().getText().isEmpty()){
            StringBuilder text = new StringBuilder(getExpression().getText());
            text.deleteCharAt(text.length()-1);
            getExpression().setText(text.toString());
        }
    }


    public Label getResult() {
        return result;
    }

    public void setResult(String newResult) {
        this.result.setText("= " + newResult);
    }

    public TextArea getExpression(){
        return expression;
    }



    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button)mouseEvent.getSource();
        String buttonText = button.getText();


        switch(buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(buttonText);
                break;

            case "+":
            case "-":
            case "/":
            case "*":
                insertOperator(buttonText);
                break;

            case "AC":
                clearExpression();
                break;

            case "=":
                double result = Evaluate.evaluate(expression.getText());
                lastAnswer = result;
                clearExpression();
                setResult(String.valueOf(result));
                break;
                
            case "ANS":
                insertANS();
                break;

            case "DEL":
                delLast();
                break;

        }

    }
}