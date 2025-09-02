
package za.ac.cput.views;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.controller.BookController;
import za.ac.cput.controller.OrderController;
import za.ac.cput.controller.OrderItemController;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.OrderItemFactory;
import za.ac.cput.service.impl.BookService;
import za.ac.cput.service.impl.OrderItemService;
import za.ac.cput.service.impl.OrderService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static za.ac.cput.views.SnuggleReadsFrame.runQuery;

public class BookCatalogueGUI extends JPanel implements ActionListener {
//Data Elements

ArrayList<Book> bookList= new ArrayList<>();

/*

//Header Elements
 */
    JPanel pnlHeader = new JPanel();
    JLabel lblHeader = new JLabel("Book Catalogue");
    JButton btnBack = new JButton("Back to Main Menu");
    JButton btnCart = new JButton ("Go to Cart");
    //Body Elements
    JPanel pnlBody = new JPanel();
    JScrollPane scrollPane = new JScrollPane(pnlBody);



public void setList (){
    pnlBody.removeAll();
  //  bookList = bc.getAllBooks();
for(int i=0;i<bookList.size();i++){
    pnlBody.add(new BookItemPanel(bookList.get(i)));
}
}

    public void testClient(){
    System.out.println(runQuery("http://localhost:8080/bookstore/api/book/hello"));

    }


  public BookCatalogueGUI(){
//setList();
testClient();
pnlHeader.add(lblHeader);
pnlHeader.add(btnBack);
pnlHeader.add(btnCart);
pnlHeader.setLayout(new GridLayout(1,3));
this.add(pnlHeader);
this.add(scrollPane);
  }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class BookItemPanel extends JPanel implements ActionListener {

    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel genreLabel;
    private JLabel lengthLabel;
    private JLabel availabilityLabel;
    private JButton btnAddToCart;
    private Book b;

    public BookItemPanel(Book b) {
      setLayout(new GridLayout(5, 1));
      setBorder(new EmptyBorder(10, 10, 10, 10));
      setBackground(Color.LIGHT_GRAY);

      titleLabel = new JLabel("Title: " + b.title);
      authorLabel = new JLabel("Author: " + b.author);
      genreLabel = new JLabel("Genre: " + b.genre);
      lengthLabel = new JLabel("Length: " + b.pages + " pages");
      availabilityLabel = new JLabel("Available: " + (b.quantity>0 ? "Yes" : "No"));
        btnAddToCart = new JButton("Add To Cart");

      add(titleLabel);
      add(authorLabel);
      add(genreLabel);
      add(lengthLabel);
      add(availabilityLabel);
        add(btnAddToCart);
        btnAddToCart.addActionListener(BookCatalogueGUI.this);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Add To Cart": {
                    int requestedQuantity = Integer.parseInt(JOptionPane.showInputDialog("Please enter how much of this book you would like to purchase:"));
                    if (requestedQuantity > b.quantity) {
                        JOptionPane.showMessageDialog(null, "Sorry, we do not have enough stock to fulfill your request.");
                        return;
                    }
                    if (requestedQuantity <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid quantity.");
                        return;
                    }
                // oic.createOrderItem(OrderItemFactory.createOrderItem(b, oc.getLatestOrder(Long.valueOf(1)), requestedQuantity));
                    break;
                }
            }
        }
    }
}

