//Create a page at /roll-dice that asks the user to guess a number. There should be links on this page for 1 through 6 that should make a GET request to /roll-dice/n where n is the number guessed. This page should display a random number (the dice roll), the user's guess and a message based on whether or not they guessed the correct number.
package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String roll(@PathVariable int n, Model model) {
        int randomNum = (int)(Math.random() * 6) + 1;
        String str = "You guessed wrong.";
        Boolean matchesRoll = n == randomNum;

        if (matchesRoll) {
            str = "You guessed right!";
        }
        model.addAttribute("guess", n);
        model.addAttribute("random", randomNum);
        model.addAttribute("message", str);
//        model.addAttribute("matchesRoll", matchesRoll);
        return "roll-dice";
    }
}
