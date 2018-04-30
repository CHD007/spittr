package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import spitter.domain.Spitter;
import spitter.data.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    public SpitterController() {
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String proccessRegistration(
            @Valid Spitter spitter,
            @RequestPart("profilePicture") MultipartFile profilePicture,
            Errors errors) throws IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        profilePicture.transferTo(new File("/" + profilePicture.getOriginalFilename()));
        spitterRepository.save(spitter);

        return "redirect:/spitter/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable String userName, Model model) {
        Spitter spitter = spitterRepository.findByUserName(userName);
        model.addAttribute(spitter);
        return "profile";
    }
}
