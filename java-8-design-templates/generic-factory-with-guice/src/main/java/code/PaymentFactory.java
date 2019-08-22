package code;

import java.time.LocalDateTime;
import java.util.UUID;

public interface PaymentFactory {

    PaymentDefault create(UUID uuid, LocalDateTime localDateTime);

}
