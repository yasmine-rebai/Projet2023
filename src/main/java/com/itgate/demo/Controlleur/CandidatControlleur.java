package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.IAuthority;
import com.itgate.demo.dao.ICandidatRepository;
import com.itgate.demo.dao.ICityRepository;
import com.itgate.demo.models.*;
import com.itgate.demo.services.UserServices;
import com.itgate.demo.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.nio.file.Files;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/candidat")
public class CandidatControlleur {
    private final Path rootLocation = Paths.get("upload-dir");
    @Autowired
    public ICandidatRepository iCandidatRepository;
    @Autowired
    public ICityRepository iCityRepository;
    @Autowired
    public IAuthority iAuthority;
    @Autowired
    public StorageService storage;
    @Autowired
    private UserServices service;

    @PostMapping("/process_register")
    public String processRegister(@RequestBody Candidat user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        service.registerC(user, getSiteURL(request));
        return "register_success";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (service.verify(code)) {
            return "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>Confirm Test</title>\n" +
                    "<!-- CSS only -->\n" +
                    "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                    "</head>\n" +
                    "<body style=\"margin-top: 20px\">\n" +
                    "<div style=\"background: #f5f5f5;padding-bottom:100px;padding-top:100px\">\n" +
                    "    <div class=\"row bootstrap snippets bootdeys justify-content-center\" align=\"center\">\n" +
                    "        <div class=\"col-md-6 col-md-offset-3\" >\n" +
                    "            <div class=\"text-center logo-alt-box\">\n" +
                    "                <a href=\"http://localhost:4200\" class=\"logo\" style=\"float: none;color: #3ec845;font-size: 24px;letter-spacing: .06em;line-height: 46px;\">\n" +
                    "                    <span>Nawress-JobFinder</span>\n" +
                    "                </a>\n" +
                    "                <h5 class=\"text-muted m-t-0\" style=\"font-size: 12px;\">Thank for your registration</h5>\n" +
                    "            </div>\n" +
                    "            <div class=\"m-t-30 card-box\"  style=\"margin-bottom: 20px;background-clip: padding-box;-moz-border-radius: 5px;border-radius: 5px;-webkit-border-radius: 5px;padding: 20px;background-color: #ffffff;box-shadow: 0 8px 42px 0 rgba(0, 0, 0, 0.08);\">\n" +
                    "                <div class=\"text-center\">\n" +
                    "                    <h4 class=\"text-uppercase font-bold m-b-0\">Success !!</h4>\n" +
                    "                </div>\n" +
                    "                <div class=\"panel-body text-center\">\n" +
                    "                    <img class=\"icon icons8-Star-Filled\" src=\"data:image/png;base64,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\" width=\"100\" height=\"100\">\n" +
                    "                    <p class=\"text-muted font-13 m-t-20\" style=\"color: #9a9da0\"> \n" +
                    "                        Your email is confirmedd . Please go <a href=\"http://localhost:4200/login\">login</a>  !.  \n" +
                    "                    </p>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "<!-- JavaScript Bundle with Popper -->\n" +
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\n" +
                    "</body>\n" +
                    "</html>";
        } else {
            return "\n" +
                    "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>Confirm Test</title>\n" +
                    "<!-- CSS only -->\n" +
                    "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                    "</head>\n" +
                    "<body style=\"margin-top: 20px\">\n" +
                    "<div style=\"background: #f5f5f5;padding-bottom:100px;padding-top:100px\">\n" +
                    "    <div class=\"row bootstrap snippets bootdeys justify-content-center\" align=\"center\">\n" +
                    "        <div class=\"col-md-6 col-md-offset-3\" >\n" +
                    "            <div class=\"text-center logo-alt-box\">\n" +
                    "              \n" +
                    "                <h5 class=\"text-muted m-t-0\" style=\"font-size: 12px;\"></h5>\n" +
                    "            </div>\n" +
                    "            <div class=\"m-t-30 card-box\"  style=\"margin-bottom: 20px;background-clip: padding-box;-moz-border-radius: 5px;border-radius: 5px;-webkit-border-radius: 5px;padding: 20px;background-color: #ffffff;box-shadow: 0 8px 42px 0 rgba(0, 0, 0, 0.08);\">\n" +
                    "                <div class=\"text-center\">\n" +
                    "                    <h4 class=\"text-uppercase font-bold m-b-0\">Failed !!</h4>\n" +
                    "                </div>\n" +
                    "                <div class=\"panel-body text-center\">\n" +
                    "                    <img class=\"icon icons8-Star-Filled\" src=\"https://i.ibb.co/LCrwG3L/warning.png\" width=\"100\"   height=\"100\">\n" +
                    "                    <p class=\"text-muted font-13 m-t-20\" style=\"color: #9a9da0\"> \n" +
                    "                        Failed email confirmaion Please Verify your registration or visit our <a href=\"http://localhost:4200\">website</a> !.  \n" +
                    "                    </p>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "<!-- JavaScript Bundle with Popper -->\n" +
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\"></script>\n" +
                    "</body>\n" +
                    "</html>";
        }
    }

    @GetMapping("/get")
    public List<Candidat> getAll() {
        return iCandidatRepository.findAll();
    }

    @PostMapping("/save")
    public Candidat save(@RequestBody Candidat c) {
        return iCandidatRepository.save(c);
    }


    @DeleteMapping("/delete/{iduser}")
    public HashMap<String, String> deleteCandidat(@PathVariable Long iduser) {
        HashMap message = new HashMap();
        try {

            iCandidatRepository.delete(iduser);
            message.put("status", "delete");
            return message;
        } catch (Exception e) {
            message.put("status", " not found");
            return message;
        }
    }

    @GetMapping("/getone/{iduser}")
    public Candidat get(@PathVariable Long iduser) {
        Candidat c = iCandidatRepository.findOne(iduser);
        return c;
    }

    @RequestMapping("/register")
    public ResponseEntity<?> register(Candidat user, @RequestParam("file") MultipartFile file, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        service.registerC(user, getSiteURL(request));
        try {

            String fileName = Integer.toString(new Random().nextInt(100000000));
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
            String name = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
            String original = name + fileName + ext;
            Files.copy(file.getInputStream(), this.rootLocation.resolve(original));
            user.setImage(original);

        } catch (Exception e) {
            throw new RuntimeException("FAIL c'est un probléme concesrnant l'image !");
        }
        iCandidatRepository.save(user);

        return ResponseEntity.ok(new UserTokenState(null, 0, user));


    }

    String hash(String password) {


        String hashedPassword = null;
        int i = 0;
        while (i < 5) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(password);
            i++;
        }

        return hashedPassword;
    }

    @PutMapping("/updateimage/{iduser}")
    public Candidat updateCandidatLogo(@RequestParam("file") MultipartFile file, Candidat c, @PathVariable Long iduser) {
        Candidat Existantcandidat = iCandidatRepository.findOne(iduser);
        try {
            String fileName = Integer.toString(new Random().nextInt(1000000000));
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
            String name = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
            String original = name + fileName + ext;
            Files.copy(file.getInputStream(), this.rootLocation.resolve(original));
            Existantcandidat.setImage(original);

        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        return iCandidatRepository.saveAndFlush(Existantcandidat);
    }

    @PutMapping("/update/{iduser}")
    public Candidat updateCandidat(@RequestBody Candidat s, @PathVariable Long iduser) {
        Candidat Existantcandidat = iCandidatRepository.findOne(iduser);
        Existantcandidat.setUsername(s.getUsername());
        Existantcandidat.setFirstName(s.getFirstName());
        Existantcandidat.setLastName(s.getLastName());
        Existantcandidat.setPhone(s.getPhone());
        Existantcandidat.setMailuser(s.getMailuser());
        Existantcandidat.setGender(s.getGender());
        Existantcandidat.setDate_naissance(s.getDate_naissance());
        Existantcandidat.setLinkedin(s.getLinkedin());
        Existantcandidat.setDescription(s.getDescription());
        Existantcandidat.setProfil(s.getProfil());
        Existantcandidat.setExperiencecandidat(s.getExperiencecandidat());
        return iCandidatRepository.saveAndFlush(Existantcandidat);
    }

    @PutMapping("/updateadress/{iduser}/{idcity}")
    public Candidat updateCandidatAdress(@RequestBody Candidat s, @PathVariable Long iduser, @PathVariable Long idcity) {
        Candidat Existantcandidat = iCandidatRepository.findOne(iduser);
        City city = iCityRepository.findOne(idcity);
        Existantcandidat.setAdresse(s.getAdresse());
        Existantcandidat.setCity(city);
        return iCandidatRepository.saveAndFlush(Existantcandidat);
    }

    @PutMapping("/updatecv/{iduser}")
    public Candidat updateCandidatCV(@RequestParam("file") MultipartFile file, @PathVariable Long iduser) {
        Candidat Existantcandidat = iCandidatRepository.findOne(iduser);
        try {
            String fileName = Integer.toString(new Random().nextInt(1000000000));
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
            String name = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
            String original = name + fileName + ext;
            Files.copy(file.getInputStream(), this.rootLocation.resolve(original));
            Existantcandidat.setCv(original);

        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        return iCandidatRepository.saveAndFlush(Existantcandidat);
    }
}
