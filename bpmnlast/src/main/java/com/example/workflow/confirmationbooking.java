package com.example.workflow;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class confirmationbooking implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {

       String answer = "";
       String receiptType = "Reciept";

       answer = (String) delegateExecution.getVariable("confirmation");

       if (answer == "yes") {
           receiptType = "Accepted";
       } else if (answer == "no") {
           receiptType = "Declined";
       }

       delegateExecution.setVariable("receiptType", receiptType);


    }
}

