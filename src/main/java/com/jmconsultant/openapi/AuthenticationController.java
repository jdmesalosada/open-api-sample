package com.jmconsultant.openapi;


import com.jmconsultant.openapi.api.AuthenticationApi;
import com.jmconsultant.openapi.dto.Credentials;
import com.jmconsultant.openapi.dto.User;
import com.jmconsultant.openapi.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

@CrossOrigin(origins = "*")
@RestController
public class AuthenticationController implements AuthenticationApi {
    @Override
    public ResponseEntity<User> authenticateUser(Credentials credentials) {

        try {
            if (credentials.getBillId() == null || credentials.getBillId().isEmpty()) {
                Error error = new Error();
                error.setCode("RED");
                error.setValue("Required bill id");

                return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
            }

            if (!credentials.getPass().equals("123Valid")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            if(!validateBillFormat(credentials.getBillId()))
            {
                Error error = new Error();
                error.code("INV_BILL_ID");
                error.value("Invalid format bill id must start with 000 and the number lenght after that should be five digits: 00012345");
                return new ResponseEntity(error, HttpStatus.CONFLICT);
            }

            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.name("Julian Mesa");
            user.customerSince(LocalDate.of(2018, 11, 07));
            return ResponseEntity.ok(user);

        } catch (Exception exc) {
            Error error = new Error();
            error.setCode("ERR");
            error.setValue("Sistema no disponible");
            return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateBillFormat(String billId) {
        Pattern pattern = Pattern.compile("000[0-9]{5}$");
        return pattern.matcher(billId).matches();
    }
}
