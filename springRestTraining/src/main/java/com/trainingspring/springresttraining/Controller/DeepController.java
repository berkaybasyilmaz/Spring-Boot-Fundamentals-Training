package com.trainingspring.springresttraining.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deep") // karışmayı engellemek için ekstra bir page eşlemlemesi
public class DeepController {

    @GetMapping("/tesseract/{number}")
    public double getTesseract(@RequestParam (name = "number") double num) {
        //RequestParam ?/ şeklinde vermen gerekir. Aramayı filtrelendirmek için kullanılır.
        return num * num * num * num;
    }


    @GetMapping("/square/{number}") // Pathvariable sayesinde "değişken değerimizi eşleştirme yaparız
    public double getSquare(@PathVariable(name = "number") double num) {
        return Math.sqrt(num);
    }

    @GetMapping("/reply")
    public String getReply(){
        return "Reply";
    }

}
