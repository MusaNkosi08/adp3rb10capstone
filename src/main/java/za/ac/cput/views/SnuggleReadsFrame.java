package za.ac.cput.views;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import za.ac.cput.Main;
import za.ac.cput.domain.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class SnuggleReadsFrame extends JFrame implements ActionListener {
//Data

    public static String runQuery(String url) {
        // Method to run a query using OkHttpClient
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response= client.newCall(request).execute()){
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

User activeUser;
    //Pages
    JPanel pages;
    static CardLayout cl = new CardLayout();
    private AddEmployeeGUI addEmp;
    private AddSupplierGUI addSup;
    private BookCatalogueGUI catalogue;
    private BusinessReportGUI report;
    private Cart cart;
    private CreateSupplyOrderGUI createSup;
    private LoginGUI login;
    private HomepageGUI home;
    private Payment payment;
    private SignupGUI signup;
   // private SupplyItemGUI supplyItem;

    //Constructor
    public SnuggleReadsFrame(){
        createPages();
        createActionListeners();
        showPage("home");
    }

    public static void main(String[] args) {
        SnuggleReadsFrame frame = new SnuggleReadsFrame();
    }

    public void createPages() {
        pages = new JPanel();

        pages.setLayout(cl);
        addEmp = new AddEmployeeGUI();
        addSup = new AddSupplierGUI();
        catalogue = new BookCatalogueGUI();
        report = new BusinessReportGUI();
        cart = new Cart();
        createSup = new CreateSupplyOrderGUI();
        login = new LoginGUI();
        home = new HomepageGUI();

        signup = new SignupGUI();
     //   supplyItem = new SupplyItemGUI();

        this.add(pages);
        pages.add(addEmp,"emp");
        pages.add(addSup,"supplier");
        pages.add(catalogue,"books");
        pages.add(report,"report");
        pages.add(cart,"cart");
        pages.add(createSup,"supplyorder");
        pages.add(login,"login");
        pages.add(home,"home");
        pages.add(signup,"signup");
      //  pages.add(supplyItem);

        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void showPage(String pageName) {
        cl.show(pages, pageName);
    }

    public void setActiveUser(User active) {

        activeUser = active;

    }

    public void createActionListeners(){
        home.btnLogin.addActionListener(this);
        home.btnSignup.addActionListener(this);
        addEmp.cancelBtn.addActionListener(this);
        home.btnLogin.addActionListener(this);
        home.btnSignup.addActionListener(this);
        login.btnLogin.addActionListener(this);
    signup.btnSignup.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
switch(e.getActionCommand()){
    case "Login":
        System.out.println("aoo");
       String active= runQuery("http://localhost:8080/bookstore/api/users/login/"+login.txtName.getText()+"/"+login.txtPsword.getText());
        if (active == null || active.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Login failed: No response from server.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JSONObject obj;
        try {
            obj = new JSONObject(active);
        } catch (JSONException ex) {
            JOptionPane.showMessageDialog(this, "Invalid response format.", "Error", JOptionPane.ERROR_MESSAGE);
            break;
        }
        Gson g = new Gson();
     activeUser= g.fromJson(obj.toString(),User.class);
     System.out.println(activeUser.toString());

     showPage("emp");
        break;

    case "Signup":
        String firstName = signup.txtName.getText();
        String lastName = signup.txtSname.getText();
        String email = signup.txtEmail.getText();
        String password = signup.txtPsword.getText();
        String phoneNumber = signup.txtNumber.getText();
        User user = new User.UserBuilder(0, firstName, lastName, email, password, phoneNumber).build();
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(userJson, okhttp3.MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("http://localhost:8080/bookstore/api/users/create")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                JOptionPane.showMessageDialog(this, "Signup successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Signup failed: " + response.message(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to server.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        showPage("emp");
        break;
    case "Cancel":
        showPage("home");
        break;
    case "Join Now":
        showPage("signup");
        break;
    case "Go To Login":
        showPage("login");
        break;
}
    }
}
