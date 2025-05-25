package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private IPaymentRepository paymentRepository;

    @PostMapping("/create")
    public boolean createPayment(@RequestBody Payment payment) {
        return paymentRepository.create(payment);
    }

    @GetMapping("/{paymentID}")
    public Payment getPayment(@PathVariable String paymentID) {
        return paymentRepository.read(paymentID);
    }

    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        return paymentRepository.findByStatus(status);
    }

    @GetMapping("/above/{amount}")
    public List<Payment> getPaymentsAboveAmount(@PathVariable double amount) {
        return paymentRepository.findPaymentsAboveAmount(amount);
    }

    @PutMapping("/process/{paymentID}")
    public boolean processPayment(@PathVariable String paymentID) {
        return paymentRepository.processPayment(paymentID);
    }

    @PutMapping("/refund/{paymentID}")
    public boolean refundPayment(@PathVariable String paymentID) {
        return paymentRepository.refundPayment(paymentID);
    }

    @GetMapping("/verify/{paymentID}")
    public boolean verifyTransaction(@PathVariable String paymentID) {
        return paymentRepository.verifyTransaction(paymentID);
    }
}
