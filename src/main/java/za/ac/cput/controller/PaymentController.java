package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.impl.PaymentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/{paymentID}")
    public Payment getPayment(@PathVariable String paymentID) {
        Optional<Payment> payment = paymentService.read(paymentID);
        return payment.orElse(null); // or handle with ResponseEntity
    }

    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        // You'll need to add this method to your PaymentService
        // For now, you can filter manually or add the method to service
        List<Payment> allPayments = paymentService.getAll();
        return allPayments.stream()
                .filter(p -> p.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    @GetMapping("/above/{amount}")
    public List<Payment> getPaymentsAboveAmount(@PathVariable double amount) {
        // You'll need to add this method to your PaymentService
        // For now, you can filter manually or add the method to service
        List<Payment> allPayments = paymentService.getAll();
        return allPayments.stream()
                .filter(p -> p.getAmount() > amount)
                .toList();
    }

    @PutMapping("/process/{paymentID}")
    public boolean processPayment(@PathVariable String paymentID) {
        return paymentService.processPayment(paymentID);
    }

    @PutMapping("/refund/{paymentID}")
    public boolean refundPayment(@PathVariable String paymentID) {
        return paymentService.refundPayment(paymentID);
    }

    @GetMapping("/verify/{paymentID}")
    public boolean verifyTransaction(@PathVariable String paymentID) {
        return paymentService.verifyTransaction(paymentID);
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAll();
    }

    @DeleteMapping("/delete/{paymentID}")
    public boolean deletePayment(@PathVariable String paymentID) {
        return paymentService.delete(paymentID);
    }



}