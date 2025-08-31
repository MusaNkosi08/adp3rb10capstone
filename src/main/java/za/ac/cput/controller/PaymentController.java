package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.impl.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {


    private PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        return service.create(payment);
    }

    @GetMapping("/{paymentID}")
    public Payment getPayment(@PathVariable String paymentID) {
        return service.read(paymentID).orElse(null);
    }

    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        return service.findByStatus(status);
    }

    @GetMapping("/above/{amount}")
    public List<Payment> getPaymentsAboveAmount(@PathVariable double amount) {
        return service.findByAmountGreaterThan(amount);
    }

    @PutMapping("/process/{paymentID}")
    public boolean processPayment(@PathVariable String paymentID) {
        return service.processPayment(paymentID);
    }

    @PutMapping("/refund/{paymentID}")
    public boolean refundPayment(@PathVariable String paymentID) {
        return service.refundPayment(paymentID);
    }

    @GetMapping("/verify/{paymentID}")
    public boolean verifyTransaction(@PathVariable String paymentID) {
        return service.verifyTransaction(paymentID);
    }
}
