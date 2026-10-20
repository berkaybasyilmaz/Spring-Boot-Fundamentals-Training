package com.trainingspring.springresttraining;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    /* klasik yöntem
    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable(name ="id" ) long playerId) {
        Player player = new Player(playerId,"Yıldırım Gürses", 34.53);
        return player;
    }
    */

    @GetMapping("/player/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable(name = "id") long playerId) {

        Player player = new Player(playerId, "Yıldırım Gürses" , 34.52);
        // return new ResponseEntity<>(player, HttpStatus.OK); aşağıdaki daha günceli
        /* return ResponseEntity
                .status(HttpStatus.OK)
                .body(player);
         */
        return ResponseEntity.ok(player); // aynı görevi gören kısa versiyonu ( kısaca http isteğinin ok olduğu ve body de player odaklı olduğunu göstermek

        /* @GetMapping("/player/{id}")
        public ResponseEntity<?> getPlayer(@PathVariable long id) {

            // 1. Veritabanına git ve o ID'li oyuncuyu BUL (Yaratma, sadece bul!)
            Player player = playerRepository.findById(id);

            // 2. Bulduğun bu oyuncuyu paketle ve müşteriye gönder
            return ResponseEntity.ok(player);
        }
        ŞEKLİNDE GERÇEĞİDİR.
         */

    }









}
