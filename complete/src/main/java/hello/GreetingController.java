package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.cnp.sdk.*;
import com.cnp.sdk.generate.*;
import javax.swing.JOptionPane;

@Controller
public class GreetingController {
    static{
        System.setProperty("java.awt.headless", "false");
    }

    @GetMapping("/home")
    public String greetingForm(Model model) {
        Greeting greeting = new Greeting();
        model.addAttribute("greeting", greeting);
        ProcessCapture processCapture = new ProcessCapture();
        model.addAttribute("processCapture", processCapture);
        return "greeting";
    }

    @PostMapping("/home")
    public String greetingSubmit(Model model, @ModelAttribute Greeting greeting,
            @ModelAttribute ProcessCapture processCapture) {
        processCapture.configure(greeting);
        boolean isConfig = !greeting.getUrl().equals("") && !greeting.getUser().equals("") && !greeting.getPassword().equals("") && !greeting.getMerchantId().equals("");
        boolean isAuth = !greeting.getAuthReportGroup().equals("") && !greeting.getOrderId().equals("") && !greeting.getAuthAmount().equals("") && !greeting.getAuthId().equals("") && !greeting.getExpirationDate().equals("");
        if(!isAuth){
            JOptionPane.showMessageDialog(null, "Incomplete configuration", "Warning", JOptionPane.PLAIN_MESSAGE);
        }
        if (isAuth) {
            try{AuthorizationResponse authResponse = processCapture.simpleAuth(greeting);}
            catch(Exception e){
                greeting.setError(e.getMessage());
                JOptionPane.showMessageDialog(null, greeting.getError(), "Error", JOptionPane.PLAIN_MESSAGE);
                return "greeting";
            }
        }
        boolean isCapture = !greeting.getCnpTxnId().equals("") && !greeting.getCaptureId().equals("") && !greeting.getCaptureReportGroup().equals("") && !greeting.getCaptureAmount().equals("");
        if (isCapture) {
            try{
                CaptureResponse response = processCapture.simpleCapture(greeting);}
            catch(Exception e){
                greeting.setError(e.getMessage());
                JOptionPane.showMessageDialog(null, greeting.getError(), "Error", JOptionPane.PLAIN_MESSAGE);
                return "greeting";
            }
        }
        return "greeting";
    }

}