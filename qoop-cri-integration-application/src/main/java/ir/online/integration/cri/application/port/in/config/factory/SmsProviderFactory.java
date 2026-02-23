package ir.online.integration.cri.application.port.in.config.factory;

import ir.online.shared.sms.application.port.out.SmsPort;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 1/17/2026 6:53 PM
 * Package: ir.online.integration.sms.application.port.in.config
 */

public interface SmsProviderFactory {
    SmsPort smsPort();
}
