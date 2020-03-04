package com.tactfactory.designpattern.controle.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tactfactory.designpattern.controle.entities.Meal;

public class ItemSelection extends JFrame {

  private Home home;
  private Meal meal;

  private JButton cheeseBurger = new JButton("Cheese Burger");
  private JButton  veganBurger = new JButton("Vegan Burger");

  private JButton coca = new JButton("Coca-Cola Small");
  private JButton cocaMedium = new JButton("Coco-Cola Medium");
  private JButton cocaBig = new JButton("Coca-Cola Big");

  private JButton orangina = new JButton("Orangina Small");
  private JButton oranginaMedium = new JButton("Orangina Medium");
  private JButton oranginaBig = new JButton("Orangina Big");

  private JButton friesSmall = new JButton("Fries Small");
  private JButton friesMedium = new JButton("Fries Medium");
  private JButton friesBig = new JButton("Fries Big");

  private JButton potatoesSmall = new JButton("Potatoes Small");
  private JButton potatoesMedium = new JButton("Potatoes Medium");
  private JButton potatoesBig = new JButton("Potatoes Big");

  private JButton validate = new JButton("Valider");

  public ItemSelection() {
    this.setTitle("Items");
    this.setSize(1000, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    bindActions();
    addButtons();

    this.setVisible(true);
  }

  private void addButtons() {
    JPanel container = new JPanel();
    container.setLayout(new GridLayout(4, 1));

    JPanel containerBurger = new JPanel();
    containerBurger.setLayout(new GridLayout(2, 4));
    containerBurger.add(cheeseBurger);
    containerBurger.add(veganBurger);
    container.add(containerBurger);

    JPanel containerDrink = new JPanel();
    containerDrink.setLayout(new GridLayout(2, 3));
    containerDrink.add(coca);
    containerDrink.add(cocaMedium);
    containerDrink.add(cocaBig);
    containerDrink.add(orangina);
    containerDrink.add(oranginaMedium);
    containerDrink.add(oranginaBig);
    container.add(containerDrink);

    JPanel containerAccompaniment = new JPanel();
    containerAccompaniment.setLayout(new GridLayout(2, 3));
    containerAccompaniment.add(friesSmall);
    containerAccompaniment.add(friesMedium);
    containerAccompaniment.add(friesBig);
    containerAccompaniment.add(potatoesSmall);
    containerAccompaniment.add(potatoesMedium);
    containerAccompaniment.add(potatoesBig);
    container.add(containerAccompaniment);

    container.add(validate);
    this.setContentPane(container);
  }

  private void bindActions() {

    // Actions code here
//    JButton.addActionListener(new ActionListener() {
//
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        // Do something
//      }
//    });

    validate.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        home.setMeal(meal);
        home.setVisible(true);
        ItemSelection.this.dispose();
      }
    });
  }

  public void setHome(Home home) {
    this.home = home;
    meal = home.getMeal();
    home.setVisible(false);
  }
}
