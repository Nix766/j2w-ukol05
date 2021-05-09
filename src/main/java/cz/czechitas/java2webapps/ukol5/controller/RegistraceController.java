package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.EnumSet;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
public class RegistraceController {

  @GetMapping("")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("/formular");
    modelAndView.addObject("form", new RegistraceForm());
    return modelAndView;
  }

  @PostMapping("")
  public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "/formular";
    }

    if (form.getSport().size() < 2) {
      System.out.println(form.getSport().size());
      bindingResult.rejectValue("sport", "", "Prosím vyberte alespoň 2 sporty.");
      return "/formular";

    }

    int vek = form.getVek();
    if (vek < 9 || vek > 15) {

      bindingResult.rejectValue("datumNarozeni", "", "Tábory pořádáme jen pro děti mezi 9 - 15 lety.");
      return "/formular";

    }

    return new ModelAndView("/registrovano")
            .addObject("jmeno", form.getJmeno())
            .addObject("prijmeni", form.getPrijmeni())
            .addObject("datumNarozeni", form.getDatumNarozeni())
            .addObject("turnus", form.getTurnusObdobi())
            .addObject("pohlavi", form.getPohlavi())
            .addObject("sport", form.getSport())
            .addObject("email", form.getEmail())
            .addObject("telefon", form.getTelefon());


  }


}
