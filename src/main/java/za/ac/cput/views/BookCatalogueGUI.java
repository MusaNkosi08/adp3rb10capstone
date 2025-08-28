package za.ac.cput.views;

import za.ac.cput.controller.OrderItemController;
import za.ac.cput.domain.Book;
import za.ac.cput.factory.OrderItemFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookCatalogueGUI extends JFrame implements ActionListener {
//Header Elements
    JPanel pnlHeader = new JPanel();
    JLabel lblHeader = new JLabel("Book Catalogue");
    JButton btnBack = new JButton("Back to Main Menu");
    JButton btnCart = new JButton ("Go to Cart");
    //Body Elements
    JPanel pnlBody = new JPanel();
    JScrollPane scrollPane = new JScrollPane(pnlBody);
    List<Book> bookList = new List<Book>();
    
public void setList (){

}
  public BookCatalogueGUI(){

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
                    OrderItemController orderItemController = new OrderItemController();
                    orderItemController.createOrderItem(OrderItemFactory.createOrderItem(01, b.isbn, requestedQuantity, b.price));
                    break;
                }
            }
        }
    }
}
