package anotherTechnique;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;
import sun.awt.RepaintArea;

public class Simulator {

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    private int x, y;
    private int randomMove;

    //constructor
    public Simulator(DisplayFrame myDisplayer_) {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(70);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
    }

    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException {
        //ciclo infinito
        while (true) {
            this.moveShapes();
            this.createImages();

            //pone en espera el flujo del programa
            Thread.sleep(waitingTime);
        }
    }//end method

    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {
//        x = (int) (Math.random() * (305 - 12) + 12);
//        y = (int) (Math.random() * (314 - 24) + 24);
        x = (int) (Math.random() * (310 - 10) + 10);
        y = (int) (Math.random() * (310 - 22) + 22);
        //para saber si se mueve en y o x
        int ejes = (int) (Math.random() * 2 + 0);
        //Si el random es 0 se mueve en el eje X
        if (ejes == 0) {

            int izqDer = (int) (Math.random() * 2 + 0);
            System.out.println(izqDer);
//        x se mueve a la izquierda
            if (izqDer == 0) {
                if (x <= myDisplayer.getWidth()) {
                    x += 10;
                }
            } else {
                x -= 10;
            }
            if (izqDer == 1) {
                if (x >= myDisplayer.getWidth() - myCircle.getWidth()) {
                    x -= 10;
                }

            } else {
                x += 10;
            }
        }
        //si ejes es 1 se movera en Y
        if (ejes == 1) {
            //Para saber si se mueve al inferor o superior de y
            int supInfe = (int) (Math.random() * 2 + 0);
            System.out.println(supInfe);
            if (supInfe == 0) {
                if (y <= myDisplayer.getHeight()) {
                    y += 10;

                } else {
                    y -= 10;

                }
            }
            if (supInfe == 1) {
                if (y >= myDisplayer.getWidth() - myCircle.getHeight()) {
                    y -= 10;
                } else {
                    y += 10;
                }
            } //fin infe

        }//end if ejey
        
        getMyCircle().setRow(y);
        getMyCircle().setColumn(x);
        //*****************Rectangle*****************
         x = (int) (Math.random() * (255 - 5) + 5);
        y = (int) (Math.random() * (300 - 30) + 30);
        int ejesRect = (int) (Math.random() * 2 + 0);
        //Si el random es 0 se mueve en el eje X
        if (ejesRect == 0) {

            int izqDerR = (int) (Math.random() * 2 + 0);
            System.out.println(izqDerR);
//        x se mueve a la izquierda
            if (izqDerR == 0) {
                if (x <= myDisplayer.getWidth()) {
                    x += 10;
                }
            } else {
                x -= 10;
            }
            if (izqDerR == 1) {
                if (x >= myDisplayer.getWidth() - myCircle.getWidth()) {
                    x -= 10;
                }

            } else {
                x += 10;
            }
        }
        //si ejes es 1 se movera en Y
        if (ejesRect == 1) {
            //Para saber si se mueve al inferor o superior de y
            int supInfeR = (int) (Math.random() * 2 + 0);
            System.out.println(supInfeR);
            if (supInfeR == 0) {
                if (y <= myDisplayer.getHeight()) {
                    y += 10;

                } else {
                    y -= 10;

                }
            }
            if (supInfeR == 1) {
                if (y >= myDisplayer.getWidth() - myCircle.getHeight()) {
                    y -= 10;
                } else {
                    y += 10;
                }
            } //fin infe

        }//end if ejey
        getMyRectangle().setColumn(x);
        getMyRectangle().setRow(y);
    }//end moveShapes

    //coloca nuevos valores aleatorios en las figuras
    public void createImages() {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.PINK);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }

    //**************************************************************************
    /*     metodos accesores      */
    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public anotherTechnique.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(anotherTechnique.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }

}
