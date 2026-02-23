package ir.online.integration.cri.presentation.rest.dto.request;

import lombok.Data;

/**
 * Author: davood akbari
 * Email: daak1365@gmail.com
 * Created: 1/17/2026 4:26 PM
 * Package: ir.online.integration.sms.presentation.rest.dto.req
 */

@Data
public class SendOtpReauest {
    private String recipients;
    private String Code;
}
