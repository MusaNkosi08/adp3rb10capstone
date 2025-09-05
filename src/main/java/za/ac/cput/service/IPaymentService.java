package za.ac.cput.service;

import za.ac.cput.domain.Payment;
import java.util.List;

public interface IPaymentService extends IService<Payment, Long> {
    Payment create(Payment payment);

    @Override
    Payment read(Long paymentId);

    Payment update(Payment payment);

    boolean delete(Long paymentId);

    List<Payment> getAll();

    boolean processPayment(Long paymentId);

    boolean refundPayment(Long paymentId);

    boolean verifyTransaction(Long paymentId);
}
