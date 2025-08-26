package za.ac.cput.views;

import za.ac.cput.domain.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BookCatalogueGUI extends JFrame {


  public BookCatalogueGUI(){

  }

  public class BookItemPanel extends JPanel {

    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel genreLabel;
    private JLabel lengthLabel;
    private JLabel availabilityLabel;

    public BookItemPanel(Book b) {
      setLayout(new GridLayout(5, 1));
      setBorder(new EmptyBorder(10, 10, 10, 10));
      setBackground(Color.LIGHT_GRAY);

      titleLabel = new JLabel("Title: " + b.title);
      authorLabel = new JLabel("Author: " + b.author);
      genreLabel = new JLabel("Genre: " + b.genre);
      lengthLabel = new JLabel("Length: " + b.pages + " pages");
      availabilityLabel = new JLabel("Available: " + (b.quantity>0 ? "Yes" : "No"));

      add(titleLabel);
      add(authorLabel);
      add(genreLabel);
      add(lengthLabel);
      add(availabilityLabel);
    }
  }
}
