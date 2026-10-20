package com.trainingspring.springresttraining.transfer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @GetMapping("/transfer/setheader")
    public ResponseEntity<?> setHeader(){
        return ResponseEntity.ok()
                .header("input","godoro")
                .body("Başlık gönderildi.");

    }

    //cookie header için
    @GetMapping("/transfer/setcookie")
    public ResponseEntity<?> setCookie(){
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE,"godoro")
                .body("Başlık gönderildi.");

    }

}
