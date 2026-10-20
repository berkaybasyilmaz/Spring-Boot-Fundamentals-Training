package com.trainingspring.springresttraining.transfer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceivingController {

    @GetMapping("/receiving/getheader")
    public ResponseEntity<?> getHeader(@RequestHeader( value = "input") String input) {
        return ResponseEntity.ok("Coming " + input);

    }

}
