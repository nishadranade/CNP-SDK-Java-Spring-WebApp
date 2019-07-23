package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.cnp.sdk.*;
import com.cnp.sdk.generate.*;

@Controller
public class GreetingController {

    @GetMapping("/home")
    public String greetingForm(Model model) {
        Greeting greeting = new Greeting();
        model.addAttribute("greeting", greeting);
        ProcessCapture processCapture = new ProcessCapture();
        model.addAttribute("processCapture", processCapture);
        return "greeting";
    }

    // @PostMapping("/greeting")
    // public void checkboxCheck(@RequestParam(value = "checkbox1") String checkboxValue){
    //         if(checkboxValue != null){
    //             System.out.println("checkbox is checked");
    //         }
    //         else{
    //             System.out.println("checkbox is unchecked");
    //         }
    //     }

    @PostMapping("/home")
    public String greetingSubmit(Model model, @ModelAttribute Greeting greeting,
            @ModelAttribute ProcessCapture processCapture) {
        processCapture.configure(greeting);
        boolean isAuth = !greeting.getAuthReportGroup().equals("") && !greeting.getOrderId().equals("") && !greeting.getAuthAmount().equals("") && !greeting.getAuthId().equals("") && !greeting.getExpirationDate().equals("");
        if (isAuth) {
            try{AuthorizationResponse authResponse = processCapture.simpleAuth(greeting);}
            catch(Exception e){
                greeting.setError(e.getMessage());
                return "errors";
            }
        }
        boolean isCapture = !greeting.getCnpTxnId().equals("") && !greeting.getCaptureId().equals("") && !greeting.getCaptureReportGroup().equals("") && !greeting.getCaptureAmount().equals("");
        if (isCapture) {
            try{
                CaptureResponse response = processCapture.simpleCapture(greeting);}
            catch(Exception e){
                greeting.setError(e.getMessage());
                return "errors";
            }
        }
        return "greeting";
    }

}