/*
IPaymentService.java
Payment Service Interface
Author: Siphosethu Msengeni
*/

package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IPaymentService extends IRepository<Payment, String> {
    List<Payment> findByStatus(String status);
    List<Payment> findPaymentsAboveAmount(double amount);
    boolean processPayment(String paymentID);
    boolean refundPayment(String paymentID);
    boolean verifyTransaction(String paymentID);
}
