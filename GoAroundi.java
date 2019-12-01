import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;

public class GoAroundi implements Runnable, KeyListener {

    private GasStation gasStation = new GasStation();
    private GasStation gasStation2 = new GasStation();
    private Graphics gg = null;
    private JTextArea crashList = new JTextArea();

    private boolean ganeralChosen = true;
    private boolean laMapChosen = false;
    private boolean elaMapChosen = false;
    private boolean chinoMapChosen = false;
    private boolean temeMapChosen = false;
    private boolean pasaMapChosen = false;
    private boolean pomoMapChosen = false;
    private boolean artMapChosen = false;
    private boolean sanMapChosen = false;
    private boolean scMapChosen = false;
    private boolean anaheimMapChosen = false;
    private boolean spMapChosen = false;
    private boolean riversideMapChosen = false;
    private boolean cMapChosen = false;
    private boolean southLAMapChosen = false;
    private boolean montereyParkMapChosen = false;
    
    private MP_Map mp_map = new MP_Map();
    private SLA_Map sla_map = new SLA_Map();
    private LA_Map la_map = new LA_Map();
    private ELA_Map ela_map = new ELA_Map();
    private Chino_Map chino_map = new Chino_Map();
    private Temecula_Map temecula_map = new Temecula_Map();
    private Pasadena_Map pasa_map = new Pasadena_Map();
    private Pomona_Map pomo_map = new Pomona_Map();
    private Artesia_Map art_map = new Artesia_Map();
    private SanDiego_Map san_map = new SanDiego_Map();
    private SC_Map sc_map = new SC_Map();
    private Anaheim_Map a_map = new Anaheim_Map();
    private Riverside_Map riverside_map = new Riverside_Map();
    private SanPedro_Map sanPedro_map = new SanPedro_Map();
    private C_Map c_map = new C_Map();
    
    class GasStation {
        int x, y;
        int width;
        int height;
        boolean gasNearEmpty;
        Color color1;
        Color color2;
        Color color3;

        public GasStation() {
            x = 700;
            y = 300;
            width = 50;
            height = 100;
            gasNearEmpty = false;
            color1 = Color.BLUE;
            color2 = Color.BLACK;
            color3 = Color.WHITE;
        }
        
        public void refuel() {
            life = 47;
        }
    }
    
    private Connection conn = null;
    private int life = 47;
    private Map map = new Map();
    private Airplane airplane_L = new Airplane();
    private Airplane airplane_R = new Airplane();
    private Airplane airplane_T = new Airplane();
    private Airplane airplane_D = new Airplane();
    private Car car = new Car();
    private Car enemy = new Car();
    private Car enemy2 = new Car();
    private Car enemy3 = new Car();
    private Car enemy4 = new Car();
    private Car enemy8 = new Car();
    private Car enemy7 = new Car();
    private Car enemy6 = new Car();
    private Car enemy5 = new Car();
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private Random rand = new Random();
    private ArrayList<PotHole> potholes = new ArrayList<PotHole>();
    private int fines = 0;
    private String brandOfCrashCar = "";
    private Image airplaneL;
    private Image airplaneR;
    private Image airplaneT;
    private Image airplaneD;
    private String which = "L";
    
    class PotHole {
        int x, y;
        int width = 15;
    }
    
    private boolean itsOkay() {
        if (ganeralChosen && car.x >= 20 && car.x <= 250 &&
             car.y >= 20 && car.y <= 200) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)car.x/(double)250)*1000);
            car.y = (int)(((double)car.y/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pasaMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = false;
            spMapChosen = false;
            riversideMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;
            
            laMapChosen = true;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 220 && car.x <= 500 &&
             car.y >= 620 && car.y <= 760) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-200)/(double)250)*1000);
            car.y = (int)(((double)(car.y-600)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = true;
            riversideMapChosen = false;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 770 && car.x <= 960 &&
             car.y >= 220 && car.y <= 400) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-750)/(double)250)*1000);
            car.y = (int)(((double)(car.y-200)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            montereyParkMapChosen = true;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 20 && car.x <= 250 &&
             car.y >= 420 && car.y <= 600) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)car.x/(double)250)*1000);
            car.y = (int)(((double)(car.y-400)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            southLAMapChosen = true;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 220 && car.x <= 500 &&
             car.y >= 620 && car.y <= 760) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-200)/(double)250)*1000);
            car.y = (int)(((double)(car.y-600)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            cMapChosen = true;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 20 && car.x <= 250 &&
             car.y >= 620 && car.y <= 760) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x)/(double)250)*1000);
            car.y = (int)(((double)(car.y-600)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = false;
            spMapChosen = true;
            riversideMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 520 && car.x <= 750 &&
             car.y >= 20 && car.y <= 200) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-500)/(double)250)*1000);
            car.y = (int)(((double)car.y/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = true;
            artMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 20 && car.x <= 250 &&
             car.y >= 420 && car.y <= 600) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x)/(double)250)*1000);
            car.y = (int)(((double)(car.y-400)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = true;
            spMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 520 && car.x <= 750 &&
             car.y >= 620 && car.y <= 760) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-500)/(double)250)*1000);
            car.y = (int)(((double)(car.y-600)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            sanMapChosen = true;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 520 && car.x <= 750 &&
             car.y >= 220 && car.y <= 400) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-500)/(double)250)*1000);
            car.y = (int)(((double)(car.y-200)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            cMapChosen = false;
            
            pasaMapChosen = true;
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 270 && car.x <= 500 &&
             car.y >= 20 && car.y <= 200) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-250)/(double)250)*1000);
            car.y = (int)(((double)car.y/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = true;
            temeMapChosen = false;
            pasaMapChosen = false;
            pomoMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            southLAMapChosen = false;
            
            laMapChosen = false;
            chinoMapChosen = false;

            artMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            montereyParkMapChosen = false;
            
            System.out.println("sdafjklhwl;arkhj");
        }
        else if (ganeralChosen && car.x >= 770 && car.x <= 960 &&
             car.y >= 20 && car.y <= 200) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-750)/(double)250)*1000);
            car.y = (int)(((double)car.y/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pasaMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = true;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            montereyParkMapChosen = false;

            System.out.println("sdafjklhwl;arkhj");
        }
        
        else if (ganeralChosen && car.x >= 770 && car.x <= 930 &&
             car.y >= 420 && car.y <= 600) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-750)/(double)250)*1000);
            car.y = (int)(((double)(car.y-400)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pomoMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            
            pasaMapChosen = false;
            laMapChosen = false;
            chinoMapChosen = true;
            cMapChosen = false;
            
            artMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;

            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 520 && car.x <= 750 &&
             car.y >= 420 && car.y <= 600) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-750)/(double)250)*1000);
            car.y = (int)(((double)car.y/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            temeMapChosen = false;
            pasaMapChosen = false;
            pomoMapChosen = false;
            artMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = true;
            
            laMapChosen = false;
            chinoMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;

            System.out.println("sdafjklhwl;arkhj");
        }

        else if (ganeralChosen && car.x >= 770 && car.x <= 930 &&
             car.y >= 620 && car.y <= 760) {
            System.out.println(car.x + ", " + car.y);
            car.x = (int)(((double)(car.x-750)/(double)250)*1000);
            car.y = (int)(((double)(car.y-600)/(double)200)*760);
            System.out.println(car.x + ", " + car.y);
            ganeralChosen = false;
            elaMapChosen = false;
            pasaMapChosen = false;
            pomoMapChosen = false;
            anaheimMapChosen = false;
            riversideMapChosen = false;
            
            laMapChosen = false;
            chinoMapChosen = false;
            temeMapChosen = true;
            
            artMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            spMapChosen = false;
            cMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;

            System.out.println("sdafjklhwl;arkhj");
        }

        if(car.x < 0 || car.x > 1000 || car.y < 0 || car.y > 760) {
            System.out.println(car.x + ", " + car.y);
            if(laMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250);
                car.y = (int)(((double)car.y/(double)760)*200);
            }
            else if(chinoMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+750);
                car.y = (int)(((double)car.y/(double)760)*200+400);
            }
            else if(temeMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+750);
                car.y = (int)(((double)car.y/(double)760)*200+600);
            }
            else if(pasaMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+500);
                car.y = (int)(((double)car.y/(double)760)*200+200);
            }
            else if(artMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+750);
                car.y = (int)(((double)car.y/(double)760)*200);
            }
            else if(anaheimMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+250);
                car.y = (int)(((double)car.y/(double)760)*600);
            }
            else if(elaMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+250);
                car.y = (int)(((double)car.y/(double)760)*200);
            }
            else if(pomoMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+500);
                car.y = (int)(((double)car.y/(double)760)*200);
            }
            else if(sanMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+750);
                car.y = (int)(((double)car.y/(double)760)*200+600);
            }
            else if(montereyParkMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250+750);
                car.y = (int)(((double)car.y/(double)760)*200+200);
            }
            else if(scMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250);
                car.y = (int)(((double)car.y/(double)760)*200+400);
            }
            else if(spMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250);
                car.y = (int)(((double)car.y/(double)760)*200+600);
            }
            else if(cMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250);
                car.y = (int)(((double)car.y/(double)760)*200+600);
            }
            else if(southLAMapChosen) {
                car.x = (int)(((double)car.x/(double)1000)*250);
                car.y = (int)(((double)car.y/(double)760)*200+400);
            }

            System.out.println(car.x + ", " + car.y);

            riversideMapChosen = false;

            ganeralChosen = true;
            
            elaMapChosen = false;
            pasaMapChosen = false;
            pomoMapChosen = false;
            spMapChosen = false;
            southLAMapChosen = false;
            montereyParkMapChosen = false;
            
            laMapChosen = false;
            elaMapChosen = false;
            chinoMapChosen = false;
            artMapChosen = false;
            sanMapChosen = false;
            scMapChosen = false;
            anaheimMapChosen = false;
            cMapChosen = false;
        }
        
        return true;
    }

    private boolean itsOkay1() {
        if((car.x >= 20 && car.x <= 250 &&
             car.y >= 20 && car.y <= 200) ||
                (car.x >= 270 && car.x <= 500 &&
             car.y >= 20 && car.y <= 200) ||
                (car.x >= 770 && car.x <= 1000 &&
             car.y >= 20 && car.y <= 200) ||
                (car.x >= 520 && car.x <= 750 &&
             car.y >= 20 && car.y <= 200) ||
                (car.x >= 20 && car.x <= 250 &&
             car.y >= 220 && car.y <= 400) ||
                (car.x >= 20 && car.x <= 250 &&
             car.y >= 420 && car.y <= 600) ||
                (car.x >= 270 && car.x <= 500 &&
             car.y >= 20 && car.y <= 200) ||
                (car.x >= 270 && car.x <= 500 &&
             car.y >= 220 && car.y <= 400) ||
                (car.x >= 270 && car.x <= 500 &&
             car.y >= 420 && car.y <= 600) ||
                (car.x >= 520 && car.x <= 750 &&
             car.y >= 420 && car.y <= 600) ||
                (car.x >= 520 && car.x <= 750 &&
             car.y >= 220 && car.y <= 400) ||
                (car.x >= 520 && car.x <= 750 &&
             car.y >= 620 && car.y <= 700) ||
                (car.x >= 770 && car.x <= 1000 &&
             car.y >= 220 && car.y <= 400) ||
                (car.x >= 770 && car.x <= 1000 &&
             car.y >= 420 && car.y <= 600)) {
            if(car.x >= gasStation.x && car.x <= gasStation.x + gasStation.width &&
                    car.y >= gasStation.y && car.y <= gasStation.y + gasStation.height)
            {
                return true;
            }
            else if(car.x >= gasStation2.x && car.x <= gasStation2.x + gasStation.width &&
                    car.y >= gasStation2.y && car.y <= gasStation2.y + gasStation.height)
            {
                return true;
            }
            car.x = 0;
            car.y = 0;
            return false;
        }
        return true;
    }
    
    private boolean itsOkay2() {
        if(!(car.x >= 260 && car.x <= 500 &&
             car.y >= 10 && car.y <= 250)) {
            return true;
        }
        if(car.y >= 10 && car.y <= 250)
            car.y = 0;
        return false;
    }

    private boolean itsOkay3() {
        if(!(car.x >= 760 && car.x <= 1000 &&
             car.y >= 10 && car.y <= 250)) {
            return true;
        }
        if(car.y >= 10 && car.y <= 250)
            car.y = 0;
        return false;
    }
    
    private boolean itsOkay4() {
        if(!(car.x >= 510 && car.x <= 750 &&
             car.y >= 10 && car.y <= 250)) {
            return true;
        }
        if(car.y >= 10 && car.y <= 250)
            car.y = 0;
        return false;
    }

    private boolean itsOkay5() {
        if(!(car.x >= 10 && car.x <= 250 &&
             car.y >= 260 && car.y <= 500)) {
            return true;
        }
        if(car.y >= 260 && car.y <= 500)
            car.y = 250;
        return false;
    }
    
    private boolean itsOkay6() {
        if(!(car.x >= 10 && car.x <= 250 &&
             car.y >= 510 && car.y <= 600)) {
            return true;
        }
        if(car.y >= 510 && car.y <= 600)
            car.y = 500;
        return false;
    }

    private boolean itsOkay7() {
        if(!(car.x >= 260 && car.x <= 500 &&
             car.y >= 10 && car.y <= 250)) {
            return true;
        }
        if(car.y >= 10 && car.y <= 250)
            car.y = 0;
        return false;
    }
    
    private boolean itsOkay8() {
        if(!(car.x >= 260 && car.x <= 500 &&
             car.y >= 260 && car.y <= 500)) {
            return true;
        }
        if(car.y >= 260 && car.y <= 500)
            car.y = 250;
        return false;
    }

    private boolean itsOkay9() {
        if(!(car.x >= 260 && car.x <= 500 &&
             car.y >= 510 && car.y <= 600)) {
            return true;
        }
        if(car.y >= 510 && car.y <= 600)
            car.y = 500;
        return false;
    }
    
    private boolean itsOkay10() {
        if(!(car.x >= 510 && car.x <= 750 &&
             car.y >= 510 && car.y <= 600)) {
            return true;
        }
        if(car.y >= 510 && car.y <= 600)
            car.y = 500;
        return false;
    }

    private boolean itsOkay11() {
        if(!(car.x >= 510 && car.x <= 750 &&
             car.y >= 260 && car.y <= 500)) {
            return true;
        }
        if(car.y >= 260 && car.y <= 500)
            car.y = 250;
        return false;
    }
    
    private boolean itsOkay12() {
        if(!(car.x >= 510 && car.x <= 750 &&
             car.y >= 510 && car.y <= 750)) {
            return true;
        }
        if(car.y >= 510 && car.y <= 600)
            car.y = 500;
        return false;
    }

    private boolean itsOkay13() {
        if(!(car.x >= 510 && car.x <= 750 &&
             car.y >= 760 && car.y <= 1000)) {
            return true;
        }
        if(car.y >= 510 && car.y <= 600)
            car.y = 500;
        return false;
    }
    
    private boolean itsOkay14() {
        if(!(car.x >= 760 && car.x <= 1000 &&
             car.y >= 10 && car.y <= 250)) {
            return true;
        }
        if(car.y >= 510 && car.y <= 600)
            car.y = 500;
        return false;
    }

    private boolean itsOkay15() {
        if(!(car.x >= 760 && car.x <= 1000 &&
             car.y >= 260 && car.y <= 500)) {
            return true;
        }
        if(car.y >= 510 && car.y <= 600)
            car.y = 500;
        return false;
    }
    
    private boolean itsOkay16() {
        if(!(car.x >= 760 && car.x <= 1000 &&
             car.y >= 510 && car.y <= 600)) {
            return true;
        }
        if(car.y >= 510 && car.y <= 600)
            car.y = 500;
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            car.moveRight();
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            car.moveLeft();
        if(e.getKeyCode() == KeyEvent.VK_UP)
            car.moveUp();
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            car.moveDown();
        if(ganeralChosen) {
            drawMap();
            drawCities();
        }
        else if(montereyParkMapChosen) {
            mp_map.drawMap();
            drawMPLabels();
        }
        else if(scMapChosen) {
            sc_map.drawMap();
            drawSCLabels();
        }
        else if(laMapChosen) {
            la_map.drawMap();
            drawLALabels();
        }
        else if(elaMapChosen) {
            ela_map.drawMap();
            drawELALabels();
        }
        else if(southLAMapChosen) {
            sla_map.drawMap();
            drawSLALabels();
        }
        else if(spMapChosen) {
            sanPedro_map.drawMap();
            drawSanPedroLabels();
        }
        else if(anaheimMapChosen) {
            a_map.drawMap();
            drawAnaheimLabels();
        }
        else if(pomoMapChosen) {
            pomo_map.drawMap();
            drawPomoLabels();
        }
        else if(riversideMapChosen) {
            riverside_map.drawMap();
            drawRiversideLabels();
        }
        else if(pasaMapChosen) {
            pasa_map.drawMap();
            drawPasaLabels();
        }
        else if(chinoMapChosen) {
            chino_map.drawMap();
            drawChinoLabels();
        }
        else if(artMapChosen) {
            art_map.drawMap();
            drawArtLabels();
        }
        else if(sanMapChosen) {
            san_map.drawMap();
            drawSanLabels();
        }
        else if(cMapChosen) {
            c_map.drawMap();
            drawCoronaLabels();
        }
        else {//if(temeMapChosen) {
            temecula_map.drawMap();
            drawTemeculaLabels();
        }
        drawEnemy();
        drawCar();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void drawGasStation() {
        try {
            //Graphics g = panel.getGraphics();
            if(!gasStation.gasNearEmpty)
                gg.setColor(gasStation.color1);
            gg.fillRect(gasStation.x, gasStation.y, gasStation.width, gasStation.height);
            //Graphics g = panel.getGraphics();
            //g.setColor(Color.GREEN);
            //g.drawString("Gas", gasStation.x+5, gasStation.y+15);
            //g.drawString("Station", gasStation.x+5, gasStation.y+30);
            //g.dispose();
        } catch(Exception e) {e.printStackTrace(); }
    }
    
    public void drawGasStation2() {
        try {
            //Graphics g = panel.getGraphics();
            if(!gasStation2.gasNearEmpty)
                gg.setColor(gasStation2.color1);
            gg.fillRect(gasStation2.x, gasStation2.y, gasStation2.width, gasStation2.height);
            //Graphics g = panel.getGraphics();
            //g.setColor(Color.GREEN);
            //g.drawString("Gas", gasStation.x+5, gasStation.y+15);
            //g.drawString("Station", gasStation.x+5, gasStation.y+30);
            //g.dispose();
        } catch(Exception e) {e.printStackTrace(); }
    }

    public void drawEnemy() {
        try {
            Graphics g = panel.getGraphics();
            Image img = null;
            if(enemy.brand.equals("Volkswagen"))
            if(enemy.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-up.png"));
            } else if(enemy.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-down.png"));
            } else if(enemy.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-right.png"));
            }
            if(enemy.brand.equals("Datsun"))
            if(enemy.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-up.png"));
            } else if(enemy.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-down.png"));
            } else if(enemy.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-right.png"));
            }
            if(enemy.brand.equals("Honda"))
            if(enemy.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-up.png"));
            } else if(enemy.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-down.png"));
            } else if(enemy.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("honda-right.png"));
            }
            if(enemy.brand.equals("Nissan"))
            if(enemy.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-up.png"));
            } else if(enemy.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-down.png"));
            } else if(enemy.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-right.png"));
            }
            g.drawImage(img, enemy.x, enemy.y, enemy.width, enemy.height, null);
            g.dispose();
        } catch(Exception e) {}
    }
    
    public void drawEnemy2() {
        try {
            Graphics g = panel.getGraphics();
            Image img = null;
            if(enemy2.brand.equals("Volkswagen"))
            if(enemy2.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-up.png"));
            } else if(enemy2.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-down.png"));
            } else if(enemy2.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-right.png"));
            }
            if(enemy2.brand.equals("Datsun"))
            if(enemy2.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-up.png"));
            } else if(enemy2.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-down.png"));
            } else if(enemy2.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-right.png"));
            }
            if(enemy2.brand.equals("Honda"))
            if(enemy2.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-up.png"));
            } else if(enemy2.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-down.png"));
            } else if(enemy2.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("honda-right.png"));
            }
            if(enemy2.brand.equals("Nissan"))
            if(enemy2.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-up.png"));
            } else if(enemy2.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-down.png"));
            } else if(enemy2.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-right.png"));
            }
            g.drawImage(img, enemy2.x, enemy2.y, enemy2.width, enemy2.height, null);
            g.dispose();
        } catch(Exception e) {}
    }

    public void drawEnemy3() {
        try {
            Graphics g = panel.getGraphics();
            Image img = null;
            if(enemy3.brand.equals("Volkswagen"))
            if(enemy3.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-up.png"));
            } else if(enemy3.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-down.png"));
            } else if(enemy3.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-right.png"));
            }
            if(enemy3.brand.equals("Datsun"))
            if(enemy3.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-up.png"));
            } else if(enemy3.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-down.png"));
            } else if(enemy3.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-right.png"));
            }
            if(enemy3.brand.equals("Honda"))
            if(enemy3.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-up.png"));
            } else if(enemy3.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-down.png"));
            } else if(enemy3.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("honda-right.png"));
            }
            if(enemy3.brand.equals("Nissan"))
            if(enemy3.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-up.png"));
            } else if(enemy3.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-down.png"));
            } else if(enemy3.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-right.png"));
            }
            g.drawImage(img, enemy3.x, enemy3.y, enemy3.width, enemy3.height, null);
            g.dispose();
        } catch(Exception e) {}
    }

    public void drawEnemy4() {
        try {
            Graphics g = panel.getGraphics();
            Image img = null;
            if(enemy4.brand.equals("Volkswagen"))
            if(enemy4.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-up.png"));
            } else if(enemy4.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-down.png"));
            } else if(enemy4.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-right.png"));
            }
            if(enemy4.brand.equals("Datsun"))
            if(enemy4.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-up.png"));
            } else if(enemy4.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-down.png"));
            } else if(enemy4.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-right.png"));
            }
            if(enemy4.brand.equals("Honda"))
            if(enemy4.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-up.png"));
            } else if(enemy4.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-down.png"));
            } else if(enemy4.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("honda-right.png"));
            }
            if(enemy4.brand.equals("Nissan"))
            if(enemy4.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-up.png"));
            } else if(enemy4.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-down.png"));
            } else if(enemy4.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-right.png"));
            }
            g.drawImage(img, enemy4.x, enemy4.y, enemy4.width, enemy4.height, null);
            g.dispose();
        } catch(Exception e) {}
    }

    class Airplane {
        int x = -1000, y;
        String direction = "T";
    }
    
    public void drawEnemy5() {
        try {
            Graphics g = panel.getGraphics();
            Image img = null;
            if(enemy5.brand.equals("Volkswagen"))
            if(enemy5.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-up.png"));
            } else if(enemy5.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-down.png"));
            } else if(enemy5.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-right.png"));
            }
            if(enemy5.brand.equals("Datsun"))
            if(enemy5.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-up.png"));
            } else if(enemy5.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-down.png"));
            } else if(enemy5.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-right.png"));
            }
            if(enemy5.brand.equals("Honda"))
            if(enemy5.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-up.png"));
            } else if(enemy5.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-down.png"));
            } else if(enemy5.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("honda-right.png"));
            }
            if(enemy5.brand.equals("Nissan"))
            if(enemy5.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-up.png"));
            } else if(enemy5.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-down.png"));
            } else if(enemy5.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-right.png"));
            }
            g.drawImage(img, enemy5.x, enemy5.y, enemy5.width, enemy5.height, null);
            g.dispose();
        } catch(Exception e) {}
    }

    public void drawEnemy6() {
        try {
            Graphics g = panel.getGraphics();
            Image img = null;
            if(enemy6.brand.equals("Volkswagen"))
            if(enemy6.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-up.png"));
            } else if(enemy6.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-down.png"));
            } else if(enemy6.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("volkswagen-right.png"));
            }
            if(enemy6.brand.equals("Datsun"))
            if(enemy6.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-up.png"));
            } else if(enemy6.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-down.png"));
            } else if(enemy6.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("datsun-right.png"));
            }
            if(enemy6.brand.equals("Honda"))
            if(enemy6.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-up.png"));
            } else if(enemy6.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-down.png"));
            } else if(enemy6.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("honda-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("honda-right.png"));
            }
            if(enemy6.brand.equals("Nissan"))
            if(enemy6.direction.equals("up")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-up.png"));
            } else if(enemy6.direction.equals("down")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-down.png"));
            } else if(enemy6.direction.equals("left")) {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-left.png"));
            } else {
                img = ImageIO.read(getClass().getResourceAsStream("nissan-right.png"));
            }
            g.drawImage(img, enemy6.x, enemy6.y, enemy6.width, enemy6.height, null);
            g.dispose();
        } catch(Exception e) {}
    }
    
    public boolean isOutsideRangeForPothole(int x, int y) {
        if(x > 2 && x < 250 && y == 0) {
            return true;
        }
        if(x > 252 && x < 500 && y != 0) {
            return true;
        }
        if(x > 502 && x < 750 && y != 0) {
            return true;
        }
        if(x > 752 && x < 1000 && y != 0) {
            return true;
        }
        if(x > 2 && x < 250 && y != 200) {
            return true;
        }
        if(x > 252 && x < 500 && y != 200) {
            return true;
        }
        if(x > 502 && x < 750 && y != 200) {
            return true;
        }
        if(x > 752 && x < 1000 && y != 200) {
            return true;
        }
        if(x > 2 && x < 250 && y != 400) {
            return true;
        }
        if(x > 252 && x < 500 && y != 400) {
            return true;
        }
        if(x > 502 && x < 750 && y != 400) {
            return true;
        }
        if(x > 752 && x < 1000 && y != 400) {
            return true;
        }
        if(x > 2 && x < 250 && y != 600) {
            return true;
        }
        if(x > 252 && x < 500 && y != 600) {
            return true;
        }
        if(x > 502 && x < 750 && y != 600) {
            return true;
        }
        if(x > 752 && x < 1000 && y != 600) {
            return true;
        }
        return false;
    }
    
    public GoAroundi() {

        String sql = "";
        String hostName = "localhost";
        String dbName = "mydb7";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + hostName + ":3320/" + dbName + "?user=" + userName + "&password=" + password;
            conn = DriverManager.getConnection(url);
        } catch(Exception e) {
        }

        try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select content from tabl;");
        if(rs.next()) {

            sql = rs.getString("content");
        }
        } catch(Exception e) {}

        for(int i=0; i<10; i++) {
            int x; 
            int y;
            do {
                x = rand.nextInt(1000);
                y = rand.nextInt(800);
            } while(isOutsideRangeForPothole(x, y));
            PotHole pothole = new PotHole();
            pothole.x = x;
            pothole.y = y;
            System.out.println(x + "," + y);
System.out.println(x + "," + y);System.out.println(x + "," + y);System.out.println(x + "," + y);            potholes.add(pothole);
        }
        
        try {
            airplaneR = ImageIO.read(ClassLoader.getSystemResourceAsStream("airplaneL.png"));
            airplaneL = ImageIO.read(ClassLoader.getSystemResourceAsStream("airplaneR.png"));
            airplaneD = ImageIO.read(ClassLoader.getSystemResourceAsStream("airplaneT.png"));
            airplaneT = ImageIO.read(ClassLoader.getSystemResourceAsStream("airplaneD.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        frame.setTitle("East L.A. Lover");
        frame.setUndecorated(true);
        frame.setBounds(0, 0, 1200, 800);
        frame.setLayout(null);
        
        try {
            BufferedImage ii = ImageIO.read(ClassLoader.getSystemResourceAsStream("usedcars.jpg"));
            frame.setContentPane(new JLabel(new ImageIcon(ii)));
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        panel.setBounds(0, 0, 1000, 800);
        panel.setLayout(null);
        frame.add(panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        enemy.x = -125;

        enemy2.x = -125;
        
        enemy3.x = -125;
        
        enemy4.x = -125;

        enemy5.x = -125;

        enemy6.x = -125;

        
        gasStation2.x = 200;
        gasStation2.y = 620;

        
        crashList.setForeground(Color.CYAN);
        JScrollPane sp = new JScrollPane(crashList);
        sp.setBounds(1070, 10, 125, 380);
                
        crashList.setBounds(1070, 10, 125, 380);
        crashList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.requestFocus();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        frame.add(sp);
        
        JButton totalExit = new JButton();
        totalExit.setBounds(1050, 520, 150, 40);
        frame.add(totalExit);
        totalExit.setText("Total Exit");
        totalExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your total fines: -$" + fines);
                try {
                    Statement stt = conn.createStatement();
                    stt.execute("update tabl set content = '"+crashList.getText()+"';");
                } catch(Exception ibee) {ibee.printStackTrace();}
                System.exit(0);
            }
        });

        JButton copyToClipboard = new JButton();
        copyToClipboard.setBounds(1050, 480, 150, 40);
        frame.add(copyToClipboard);
        copyToClipboard.setText("Copy to clipboard");
        copyToClipboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(crashList.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                frame.requestFocus();
            }
        });
        
        JLabel j = new JLabel("in America");
        j.setBounds(1070, 620, 200, 30);
        j.setFont(new Font("arial", Font.BOLD, 20));
        j.setForeground(Color.red);
        frame.add(j);

        JLabel j2 = new JLabel(life + "");
        j2.setBounds(1070, 700, 100, 30);
        j2.setFont(new Font("arial", Font.BOLD, 20));
        j2.setForeground(Color.GREEN);
        frame.add(j2);
        
        frame.setVisible(true);
        
        frame.requestFocus();

        Thread t = new Thread() {
            public void run() {

                int baby = 0;

                int c = 0;
                
                while(true) {
                    
                    c++;
//Thanksgiving Day

//This is a joyous day when the pilgrims arrived in the New World, to make their mark upon the glory of God for their destiny.  They did not have much food so they got their grace from the Natives of that land and we still honor this union today by coming together and sharing our meal rather than making our meal from someone who is designated.  This is God’s grace at work.  We celebrate it with those also who are less fortunate than us and we bask in that grace with turkey and gravy and mashed potatoes.  This is good.  So we thank our God for his many blessings but especially for Christ in our lives and in our hearts.  We thank him many times because he is that worthy to receive thanksgiving from us.  That is why we call it Thanksgiving Day.  Because we give thanks to a God who is worthy to receive our thanks from those who have been blessed by him through his many provisions and his many condigning love in our lives.  And it shows!  That’s why it should show.  We do this every year.  But really we should do it more often as much as we can.  Amen.
                    
                    j2.setText(life + "");
                    if(c%50==0)
                        life--;
                    
                    if(life == 0)
                        System.exit(0);
                    
                    if(ganeralChosen) {
                        drawMap();
                        drawCities();
                    }
                    else if(montereyParkMapChosen) {
                        mp_map.drawMap();
                        drawMPLabels();
                    }
                    else if(southLAMapChosen) {
                        sla_map.drawMap();
                        drawSLALabels();
                    }
                    else if(cMapChosen) {
                        c_map.drawMap();
                        drawCoronaLabels();
                    }
                    else if(riversideMapChosen) {
                        riverside_map.drawMap();
                        drawRiversideLabels();
                    }
                    else if(pasaMapChosen) {
                        pasa_map.drawMap();
                        drawPasaLabels();
                    }
                    else if(spMapChosen) {
                        sanPedro_map.drawMap();
                        drawSanPedroLabels();
                    }
                    else if(laMapChosen) {
                        la_map.drawMap();
                        drawLALabels();
                    }
                    else if(anaheimMapChosen) {
                        a_map.drawMap();
                        drawAnaheimLabels();
                    }
                    else if(elaMapChosen) {
                        ela_map.drawMap();
                        drawELALabels();
                    }
                    else if(chinoMapChosen) {
                        chino_map.drawMap();
                        drawChinoLabels();
                    }
                    else if(artMapChosen) {
                        art_map.drawMap();
                        drawArtLabels();
                    }
                    else if(pomoMapChosen) {
                        pomo_map.drawMap();
                        drawPomoLabels();
                    }
                    else if(sanMapChosen) {
                        san_map.drawMap();
                        drawSanLabels();
                    }
                    else if(scMapChosen) {
                        sc_map.drawMap();
                        drawSCLabels();
                    }
                    else {//if(temeMapChosen) {
                        temecula_map.drawMap();
                        drawTemeculaLabels();
                    }
                    drawPotholes();
                    drawCar();
                    drawAirplanes();
                    drawGasStation();
                    drawGasStation2();
                    
                    if(gasStation.gasNearEmpty)
                    if(gasStation.x <= car.x && gasStation.x+gasStation.width >= car.x &&
                            gasStation.y <= car.y && gasStation.y+gasStation.height >= car.y) {

                        gasStation.refuel();
                    }

                    if(gasStation2.gasNearEmpty)
                    if(gasStation2.x <= car.x && gasStation2.x+gasStation2.width >= car.x &&
                            gasStation2.y <= car.y && gasStation2.y+gasStation2.height >= car.y) {

                        gasStation2.refuel();
                    }
//Honda (-$3000)
//Honda (-$3800)
//Honda (-$3000)
//Volkswagen (-$3000)
//uGotStuckInARut
//Datsun (-$3000)
//Datsun (-$3000)
//Datsun (-$2800)
//Datsun (-$2800)
//Volkswagen (-$5000)
//Datsun (-$3000)
//Volkswagen (-$5000)
//Nissan (-$3800)
//Datsun (-$5000)
//Honda (-$3800)
//Datsun (-$3800)
//Volkswagen (-$3000)
//Honda (-$5000)
//Nissan (-$2800)
                    for(int i=0; i<potholes.size(); i++) {
                        if(car.x >= potholes.get(i).x && car.x <= potholes.get(i).x+potholes.get(i).width &&
                                car.y >= potholes.get(i).y && car.y <= potholes.get(i).y+potholes.get(i).width) {
                            car.speed = 0;
                            car.timer = (int)((double)10*2.5);
                        String cl = crashList.getText();
                        crashList.setText(cl 
                                + System.getProperty("line.separator")
                                + "uGotStuckInARut");
                            potholes.remove(potholes.get(i));
                            life -= 10;
                        }
                    }
                    
                    if(car.timer == 0) {
                        baby = 0;
                        car.speed = 5;
                    }
                    
                    baby++;
                    
                    if(baby == 10) {
                        car.timer--;
                        baby = 0;
                    }
                    
                    if(life < 25)
                        gasStation.gasNearEmpty = true;
                    else
                        gasStation.gasNearEmpty = false;
                    
                    if(life < 25)
                        gasStation2.gasNearEmpty = true;
                    else
                        gasStation2.gasNearEmpty = false;

                    if(potholes.size() <= 4) {

                        createAirplanes();
            potholes.clear();
        for(int i=0; i<10; i++) {
            int x; 
            int y;
            do {
                x = rand.nextInt(1000);
                y = rand.nextInt(800);
            } while(isOutsideRangeForPothole(x, y));
            PotHole pothole = new PotHole();
            pothole.x = x;
            pothole.y = y;
            System.out.println(x + "," + y);
System.out.println(x + "," + y);System.out.println(x + "," + y);System.out.println(x + "," + y);            potholes.add(pothole);
        }
                    }
                    
                    if(enemy.x > 500 && enemy.x < 510 && enemy.y > 0 && enemy.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "left";
                        }
                        else {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "down";
                            enemy.width = 10;
                            enemy.height = 20;
                        }
                    } else if(enemy.x > 250 && enemy.x < 260 && enemy.y > 0 && enemy.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "left";
                        }
                        else {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "down";
                            enemy.width = 10;
                            enemy.height = 20;
                        }
                    } else if(enemy.x > 250 && enemy.x < 260 && enemy.y > 240 && enemy.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy.direction.equals("right"))
                                    enemy.direction = "up";
                                if(enemy.direction.equals("left"))
                                    enemy.direction = "up";
                            } else {
                                if(enemy.direction.equals("right"))
                                    enemy.direction = "down";
                                if(enemy.direction.equals("left"))
                                    enemy.direction = "down";
                            }
                            enemy.width = 10;
                            enemy.height = 20;
                        }
                    } else if(enemy.x > 490 && enemy.x < 510 && enemy.y > 240 && enemy.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy.direction.equals("right"))
                                    enemy.direction = "up";
                                if(enemy.direction.equals("left"))
                                    enemy.direction = "up";
                            } else {
                                if(enemy.direction.equals("right"))
                                    enemy.direction = "down";
                                if(enemy.direction.equals("left"))
                                    enemy.direction = "down";
                            }
                            enemy.width = 10;
                            enemy.height = 20;
                        }
                    } else if(enemy.x > 0 && enemy.x < 10 && enemy.y > 200 && enemy.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("down"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("up"))
                                enemy.direction = "up";
                        }
                        else {
                            if(enemy.direction.equals("down"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("up"))
                                enemy.direction = "right";
                            enemy.width = 20;
                            enemy.height = 10;
                        }
                    } else if(enemy.x > 0 && enemy.x < 10 && enemy.y > 400 && enemy.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("down"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("up"))
                                enemy.direction = "up";
                        }
                        else {
                            if(enemy.direction.equals("down"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("up"))
                                enemy.direction = "right";
                            enemy.width = 20;
                            enemy.height = 10;
                        }
                    } else if(enemy.x > 0 && enemy.x < 10 && enemy.y > 600 && enemy.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("down"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("up"))
                                enemy.direction = "up";
                        }
                        else {
                            if(enemy.direction.equals("down"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("up"))
                                enemy.direction = "right";
                            enemy.width = 20;
                            enemy.height = 10;
                        }
                    } else if(enemy.x > 0 && enemy.x < 10 && enemy.y > 750 && enemy.y < 770) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("down"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("up"))
                                enemy.direction = "up";
                        }
                        else {
                            if(enemy.direction.equals("down"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("up"))
                                enemy.direction = "right";
                            enemy.width = 20;
                            enemy.height = 10;
                        }
                    } else if(enemy.x > 750 && enemy.x < 760 && enemy.y > 0 && enemy.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "left";
                        }
                        else {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "down";
                            enemy.width = 10;
                            enemy.height = 20;
                        }
                    } else if(enemy.x > 970 && enemy.x < 990 && enemy.y > 0 && enemy.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "left";
                        }
                        else {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "down";
                            enemy.width = 10;
                            enemy.height = 20;
                        }
                    } else if(enemy.x > 970 && enemy.x < 990 && enemy.y > 200 && enemy.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "left";
                        }
                        else {
                            if(enemy.direction.equals("right"))
                                enemy.direction = "down";
                            if(enemy.direction.equals("left"))
                                enemy.direction = "down";
                            enemy.width = 10;
                            enemy.height = 20;
                        }
                    } else if(enemy.x > 970 && enemy.x < 990 && enemy.y > 400 && enemy.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("up"))
                                enemy.direction = "up";
                            if(enemy.direction.equals("down"))
                                enemy.direction = "down";
                        }
                        else {
                            if(enemy.direction.equals("up"))
                                enemy.direction = "left";
                            if(enemy.direction.equals("down"))
                                enemy.direction = "left";
                            enemy.width = 20;
                            enemy.height = 10;
                        }
                    } else if(enemy.x > 970 && enemy.x < 990 && enemy.y > 600 && enemy.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("up"))
                                enemy.direction = "up";
                            if(enemy.direction.equals("down"))
                                enemy.direction = "down";
                        }
                        else {
                            if(enemy.direction.equals("up"))
                                enemy.direction = "left";
                            if(enemy.direction.equals("down"))
                                enemy.direction = "left";
                            enemy.width = 20;
                            enemy.height = 10;
                        }
                    } else if(enemy.x > 970 && enemy.x < 990 && enemy.y > 760 && enemy.y < 780) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("up"))
                                enemy.direction = "up";
                            if(enemy.direction.equals("down"))
                                enemy.direction = "down";
                        }
                        else {
                            if(enemy.direction.equals("up"))
                                enemy.direction = "left";
                            if(enemy.direction.equals("down"))
                                enemy.direction = "left";
                            enemy.width = 20;
                            enemy.height = 10;
                        }
                    } else if(enemy.x > 500 && enemy.x < 510 && enemy.y > 400 && enemy.y < 420) {
                        int v = rand.nextInt(3);
                        if(v == 0 || v == 2 || v == 1) {
                            if(enemy.direction.equals("up")) {
                                enemy.direction = "up";
                                enemy.width = 10;
                                enemy.height = 20;
                                if(v == 2) {
                                    enemy.direction = "left";
                                    enemy.width = 20;
                                    enemy.height = 10;
                                }
                                else {
                                    enemy.direction = "right";
                                    enemy.width = 20;
                                    enemy.height = 10;
                                }
                            }
                            else if(enemy.direction.equals("down")) {
                                enemy.direction = "down";
                                enemy.width = 10;
                                enemy.height = 20;
                                if(v == 2) {
                                    enemy.direction = "right";
                                    enemy.width = 20;
                                    enemy.height = 10;
                                }
                                else {
                                    enemy.direction = "left";
                                    enemy.width = 20;
                                    enemy.height = 10;
                                }
                            }
                            else if(enemy.direction.equals("left")) {
                                enemy.direction = "left";
                                enemy.width = 20;
                                enemy.height = 10;
                                if(v == 2) {
                                    enemy.direction = "down";
                                    enemy.width = 10;
                                    enemy.height = 20;
                                }
                                else {
                                    enemy.direction = "up";
                                    enemy.width = 10;
                                    enemy.height = 20;
                                }
                            }
                        }
                    } else if(enemy.x > 500 && enemy.x < 510 && enemy.y > 0 && enemy.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy.direction.equals("up"))
                                enemy.direction = "right";
                            if(enemy.direction.equals("down"))
                                enemy.direction = "right";
                        }
                        else {
                            if(enemy.direction.equals("up"))
                                enemy.direction = "left";
                            if(enemy.direction.equals("down"))
                                enemy.direction = "left";
                            enemy.width = 20;
                            enemy.height = 10;
                        }
                    }
                    if(enemy2.x > 500 && enemy2.x < 510 && enemy2.y > 0 && enemy2.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "left";
                        }
                        else {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "down";
                            enemy2.width = 10;
                            enemy2.height = 20;
                        }
                    } else if(enemy2.x > 250 && enemy2.x < 260 && enemy2.y > 0 && enemy2.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "left";
                        }
                        else {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "down";
                            enemy2.width = 10;
                            enemy2.height = 20;
                        }
                    } else if(enemy2.x > 250 && enemy2.x < 260 && enemy2.y > 240 && enemy2.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy2.direction.equals("right"))
                                    enemy2.direction = "up";
                                if(enemy2.direction.equals("left"))
                                    enemy2.direction = "up";
                            } else {
                                if(enemy2.direction.equals("right"))
                                    enemy2.direction = "down";
                                if(enemy2.direction.equals("left"))
                                    enemy2.direction = "down";
                            }
                            enemy2.width = 10;
                            enemy2.height = 20;
                        }
                    } else if(enemy2.x > 490 && enemy2.x < 510 && enemy2.y > 240 && enemy2.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy2.direction.equals("right"))
                                    enemy2.direction = "up";
                                if(enemy2.direction.equals("left"))
                                    enemy2.direction = "up";
                            } else {
                                if(enemy2.direction.equals("right"))
                                    enemy2.direction = "down";
                                if(enemy2.direction.equals("left"))
                                    enemy2.direction = "down";
                            }
                            enemy2.width = 10;
                            enemy2.height = 20;
                        }
                    } else if(enemy2.x > 0 && enemy2.x < 10 && enemy2.y > 200 && enemy2.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "up";
                        }
                        else {
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "right";
                            enemy2.width = 20;
                            enemy2.height = 10;
                        }
                    } else if(enemy2.x > 0 && enemy2.x < 10 && enemy2.y > 400 && enemy2.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "up";
                        }
                        else {
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "right";
                            enemy2.width = 20;
                            enemy2.height = 10;
                        }
                    } else if(enemy2.x > 0 && enemy2.x < 10 && enemy2.y > 600 && enemy2.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "up";
                        }
                        else {
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "right";
                            enemy2.width = 20;
                            enemy2.height = 10;
                        }
                    } else if(enemy2.x > 0 && enemy2.x < 10 && enemy2.y > 750 && enemy2.y < 770) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "up";
                        }
                        else {
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "right";
                            enemy2.width = 20;
                            enemy2.height = 10;
                        }
                    } else if(enemy2.x > 750 && enemy2.x < 760 && enemy2.y > 0 && enemy2.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "left";
                        }
                        else {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "down";
                            enemy2.width = 10;
                            enemy2.height = 20;
                        }
                    } else if(enemy2.x > 970 && enemy2.x < 990 && enemy2.y > 0 && enemy2.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "left";
                        }
                        else {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "down";
                            enemy2.width = 10;
                            enemy2.height = 20;
                        }
                    } else if(enemy2.x > 970 && enemy2.x < 990 && enemy2.y > 200 && enemy2.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "left";
                        }
                        else {
                            if(enemy2.direction.equals("right"))
                                enemy2.direction = "down";
                            if(enemy2.direction.equals("left"))
                                enemy2.direction = "down";
                            enemy2.width = 10;
                            enemy2.height = 20;
                        }
                    } else if(enemy2.x > 970 && enemy2.x < 990 && enemy2.y > 400 && enemy2.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "up";
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "down";
                        }
                        else {
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "left";
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "left";
                            enemy2.width = 20;
                            enemy2.height = 10;
                        }
                    } else if(enemy2.x > 970 && enemy2.x < 990 && enemy2.y > 600 && enemy2.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "up";
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "down";
                        }
                        else {
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "left";
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "left";
                            enemy2.width = 20;
                            enemy2.height = 10;
                        }
                    } else if(enemy2.x > 970 && enemy2.x < 990 && enemy2.y > 760 && enemy2.y < 780) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "up";
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "down";
                        }
                        else {
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "left";
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "left";
                            enemy2.width = 20;
                            enemy2.height = 10;
                        }
                    } else if(enemy2.x > 500 && enemy2.x < 510 && enemy2.y > 400 && enemy2.y < 420) {
                        int v = rand.nextInt(3);
                        if(v == 0 || v == 2 || v == 1) {
                            if(enemy2.direction.equals("up")) {
                                enemy2.direction = "up";
                                enemy2.width = 10;
                                enemy2.height = 20;
                                if(v == 2) {
                                    enemy2.direction = "left";
                                    enemy2.width = 20;
                                    enemy2.height = 10;
                                }
                                else {
                                    enemy2.direction = "right";
                                    enemy2.width = 20;
                                    enemy2.height = 10;
                                }
                            }
                            else if(enemy2.direction.equals("down")) {
                                enemy2.direction = "down";
                                enemy2.width = 10;
                                enemy2.height = 20;
                                if(v == 2) {
                                    enemy2.direction = "right";
                                    enemy2.width = 20;
                                    enemy2.height = 10;
                                }
                                else {
                                    enemy2.direction = "left";
                                    enemy2.width = 20;
                                    enemy2.height = 10;
                                }
                            }
                            else if(enemy2.direction.equals("left")) {
                                enemy2.direction = "left";
                                enemy2.width = 20;
                                enemy2.height = 10;
                                if(v == 2) {
                                    enemy2.direction = "down";
                                    enemy2.width = 10;
                                    enemy2.height = 20;
                                }
                                else {
                                    enemy2.direction = "up";
                                    enemy2.width = 10;
                                    enemy2.height = 20;
                                }
                            }
                        }
                    } else if(enemy2.x > 500 && enemy2.x < 510 && enemy2.y > 0 && enemy2.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "right";
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "right";
                        }
                        else {
                            if(enemy2.direction.equals("up"))
                                enemy2.direction = "left";
                            if(enemy2.direction.equals("down"))
                                enemy2.direction = "left";
                            enemy2.width = 20;
                            enemy2.height = 10;
                        }
                    }
                    if(enemy3.x > 500 && enemy3.x < 510 && enemy3.y > 0 && enemy3.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "left";
                        }
                        else {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "down";
                            enemy3.width = 10;
                            enemy3.height = 20;
                        }
                    } else if(enemy3.x > 250 && enemy3.x < 260 && enemy3.y > 0 && enemy3.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "left";
                        }
                        else {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "down";
                            enemy3.width = 10;
                            enemy3.height = 20;
                        }
                    } else if(enemy3.x > 250 && enemy3.x < 260 && enemy3.y > 240 && enemy3.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy3.direction.equals("right"))
                                    enemy3.direction = "up";
                                if(enemy3.direction.equals("left"))
                                    enemy3.direction = "up";
                            } else {
                                if(enemy3.direction.equals("right"))
                                    enemy3.direction = "down";
                                if(enemy3.direction.equals("left"))
                                    enemy3.direction = "down";
                            }
                            enemy3.width = 10;
                            enemy3.height = 20;
                        }
                    } else if(enemy3.x > 490 && enemy3.x < 510 && enemy3.y > 240 && enemy3.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy3.direction.equals("right"))
                                    enemy3.direction = "up";
                                if(enemy3.direction.equals("left"))
                                    enemy3.direction = "up";
                            } else {
                                if(enemy3.direction.equals("right"))
                                    enemy3.direction = "down";
                                if(enemy3.direction.equals("left"))
                                    enemy3.direction = "down";
                            }
                            enemy3.width = 10;
                            enemy3.height = 20;
                        }
                    } else if(enemy3.x > 0 && enemy3.x < 10 && enemy3.y > 200 && enemy3.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "up";
                        }
                        else {
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "right";
                            enemy3.width = 20;
                            enemy3.height = 10;
                        }
                    } else if(enemy3.x > 0 && enemy3.x < 10 && enemy3.y > 400 && enemy3.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "up";
                        }
                        else {
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "right";
                            enemy3.width = 20;
                            enemy3.height = 10;
                        }
                    } else if(enemy3.x > 0 && enemy3.x < 10 && enemy3.y > 600 && enemy3.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "up";
                        }
                        else {
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "right";
                            enemy3.width = 20;
                            enemy3.height = 10;
                        }
                    } else if(enemy3.x > 0 && enemy3.x < 10 && enemy3.y > 750 && enemy3.y < 770) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "up";
                        }
                        else {
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "right";
                            enemy3.width = 20;
                            enemy3.height = 10;
                        }
                    } else if(enemy3.x > 750 && enemy3.x < 760 && enemy3.y > 0 && enemy3.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "left";
                        }
                        else {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "down";
                            enemy3.width = 10;
                            enemy3.height = 20;
                        }
                    } else if(enemy3.x > 970 && enemy3.x < 990 && enemy3.y > 0 && enemy3.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "left";
                        }
                        else {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "down";
                            enemy3.width = 10;
                            enemy3.height = 20;
                        }
                    } else if(enemy3.x > 970 && enemy3.x < 990 && enemy3.y > 200 && enemy3.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "left";
                        }
                        else {
                            if(enemy3.direction.equals("right"))
                                enemy3.direction = "down";
                            if(enemy3.direction.equals("left"))
                                enemy3.direction = "down";
                            enemy3.width = 10;
                            enemy3.height = 20;
                        }
                    } else if(enemy3.x > 970 && enemy3.x < 990 && enemy3.y > 400 && enemy3.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "up";
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "down";
                        }
                        else {
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "left";
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "left";
                            enemy3.width = 20;
                            enemy3.height = 10;
                        }
                    } else if(enemy3.x > 970 && enemy3.x < 990 && enemy3.y > 600 && enemy3.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "up";
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "down";
                        }
                        else {
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "left";
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "left";
                            enemy3.width = 20;
                            enemy3.height = 10;
                        }
                    } else if(enemy3.x > 970 && enemy3.x < 990 && enemy3.y > 760 && enemy3.y < 780) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "up";
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "down";
                        }
                        else {
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "left";
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "left";
                            enemy3.width = 20;
                            enemy3.height = 10;
                        }
                    } else if(enemy3.x > 500 && enemy3.x < 510 && enemy3.y > 400 && enemy3.y < 420) {
                        int v = rand.nextInt(3);
                        if(v == 0 || v == 2 || v == 1) {
                            if(enemy3.direction.equals("up")) {
                                enemy3.direction = "up";
                                enemy3.width = 10;
                                enemy3.height = 20;
                                if(v == 2) {
                                    enemy3.direction = "left";
                                    enemy3.width = 20;
                                    enemy3.height = 10;
                                }
                                else {
                                    enemy3.direction = "right";
                                    enemy3.width = 20;
                                    enemy3.height = 10;
                                }
                            }
                            else if(enemy3.direction.equals("down")) {
                                enemy3.direction = "down";
                                enemy3.width = 10;
                                enemy3.height = 20;
                                if(v == 2) {
                                    enemy3.direction = "right";
                                    enemy3.width = 20;
                                    enemy3.height = 10;
                                }
                                else {
                                    enemy3.direction = "left";
                                    enemy3.width = 20;
                                    enemy3.height = 10;
                                }
                            }
                            else if(enemy3.direction.equals("left")) {
                                enemy3.direction = "left";
                                enemy3.width = 20;
                                enemy3.height = 10;
                                if(v == 2) {
                                    enemy3.direction = "down";
                                    enemy3.width = 10;
                                    enemy3.height = 20;
                                }
                                else {
                                    enemy3.direction = "up";
                                    enemy3.width = 10;
                                    enemy3.height = 20;
                                }
                            }
                        }
                    } else if(enemy3.x > 500 && enemy3.x < 510 && enemy3.y > 0 && enemy3.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "right";
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "right";
                        }
                        else {
                            if(enemy3.direction.equals("up"))
                                enemy3.direction = "left";
                            if(enemy3.direction.equals("down"))
                                enemy3.direction = "left";
                                enemy3.width = 20;
                                enemy3.height = 10;
                        }
                    }
                    if(enemy4.x > 500 && enemy4.x < 510 && enemy4.y > 0 && enemy4.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "left";
                        }
                        else {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "down";
                            enemy4.width = 10;
                            enemy4.height = 20;
                        }
                    } else if(enemy4.x > 250 && enemy4.x < 260 && enemy4.y > 0 && enemy4.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "left";
                        }
                        else {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "down";
                            enemy4.width = 10;
                            enemy4.height = 20;
                        }
                    } else if(enemy4.x > 250 && enemy4.x < 260 && enemy4.y > 240 && enemy4.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy4.direction.equals("right"))
                                    enemy4.direction = "up";
                                if(enemy4.direction.equals("left"))
                                    enemy4.direction = "up";
                            } else {
                                if(enemy4.direction.equals("right"))
                                    enemy4.direction = "down";
                                if(enemy4.direction.equals("left"))
                                    enemy4.direction = "down";
                            }
                            enemy4.width = 10;
                            enemy4.height = 20;
                        }
                    } else if(enemy4.x > 490 && enemy4.x < 510 && enemy4.y > 240 && enemy4.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy4.direction.equals("right"))
                                    enemy4.direction = "up";
                                if(enemy4.direction.equals("left"))
                                    enemy4.direction = "up";
                            } else {
                                if(enemy4.direction.equals("right"))
                                    enemy4.direction = "down";
                                if(enemy4.direction.equals("left"))
                                    enemy4.direction = "down";
                            }
                            enemy4.width = 10;
                            enemy4.height = 20;
                        }
                    } else if(enemy4.x > 0 && enemy4.x < 10 && enemy4.y > 200 && enemy4.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "up";
                        }
                        else {
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "right";
                            enemy4.width = 20;
                            enemy4.height = 10;
                        }
                    } else if(enemy4.x > 0 && enemy4.x < 10 && enemy4.y > 400 && enemy4.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "up";
                        }
                        else {
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "right";
                            enemy4.width = 20;
                            enemy4.height = 10;
                        }
                    } else if(enemy4.x > 0 && enemy4.x < 10 && enemy4.y > 600 && enemy4.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "up";
                        }
                        else {
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "right";
                            enemy4.width = 20;
                            enemy4.height = 10;
                        }
                    } else if(enemy4.x > 0 && enemy4.x < 10 && enemy4.y > 750 && enemy4.y < 770) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "up";
                        }
                        else {
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "right";
                            enemy4.width = 20;
                            enemy4.height = 10;
                        }
                    } else if(enemy4.x > 750 && enemy4.x < 760 && enemy4.y > 0 && enemy4.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "left";
                        }
                        else {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "down";
                            enemy4.width = 10;
                            enemy4.height = 20;
                        }
                    } else if(enemy4.x > 970 && enemy4.x < 990 && enemy4.y > 0 && enemy4.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "left";
                        }
                        else {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "down";
                            enemy4.width = 10;
                            enemy4.height = 20;
                        }
                    } else if(enemy4.x > 970 && enemy4.x < 990 && enemy4.y > 200 && enemy4.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "left";
                        }
                        else {
                            if(enemy4.direction.equals("right"))
                                enemy4.direction = "down";
                            if(enemy4.direction.equals("left"))
                                enemy4.direction = "down";
                            enemy4.width = 10;
                            enemy4.height = 20;
                        }
                    } else if(enemy4.x > 970 && enemy4.x < 990 && enemy4.y > 400 && enemy4.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "up";
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "down";
                        }
                        else {
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "left";
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "left";
                            enemy4.width = 20;
                            enemy4.height = 10;
                        }
                    } else if(enemy4.x > 970 && enemy4.x < 990 && enemy4.y > 600 && enemy4.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "up";
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "down";
                        }
                        else {
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "left";
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "left";
                            enemy4.width = 20;
                            enemy4.height = 10;
                        }
                    } else if(enemy4.x > 970 && enemy4.x < 990 && enemy4.y > 760 && enemy4.y < 780) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "up";
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "down";
                        }
                        else {
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "left";
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "left";
                            enemy4.width = 20;
                            enemy4.height = 10;
                        }
                    } else if(enemy4.x > 500 && enemy4.x < 510 && enemy4.y > 400 && enemy4.y < 420) {
                        int v = rand.nextInt(3);
                        if(v == 0 || v == 2 || v == 1) {
                            if(enemy4.direction.equals("up")) {
                                enemy4.direction = "up";
                                enemy4.width = 10;
                                enemy4.height = 20;
                                if(v == 2) {
                                    enemy4.direction = "left";
                                    enemy4.width = 20;
                                    enemy4.height = 10;
                                }
                                else {
                                    enemy4.direction = "right";
                                    enemy4.width = 20;
                                    enemy4.height = 10;
                                }
                            }
                            else if(enemy4.direction.equals("down")) {
                                enemy4.direction = "down";
                                enemy4.width = 10;
                                enemy4.height = 20;
                                if(v == 2) {
                                    enemy4.direction = "right";
                                    enemy4.width = 20;
                                    enemy4.height = 10;
                                }
                                else {
                                    enemy4.direction = "left";
                                    enemy4.width = 20;
                                    enemy4.height = 10;
                                }
                            }
                            else if(enemy4.direction.equals("left")) {
                                enemy4.direction = "left";
                                enemy4.width = 20;
                                enemy4.height = 10;
                                if(v == 2) {
                                    enemy4.direction = "down";
                                    enemy4.width = 10;
                                    enemy4.height = 20;
                                }
                                else {
                                    enemy4.direction = "up";
                                    enemy4.width = 10;
                                    enemy4.height = 20;
                                }
                            }
                        }
                    } else if(enemy4.x > 500 && enemy4.x < 510 && enemy4.y > 0 && enemy4.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "right";
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "right";
                        }
                        else {
                            if(enemy4.direction.equals("up"))
                                enemy4.direction = "left";
                            if(enemy4.direction.equals("down"))
                                enemy4.direction = "left";
                            enemy4.width = 20;
                            enemy4.height = 10;
                        }
                    }
                    if(enemy5.x > 500 && enemy5.x < 510 && enemy5.y > 0 && enemy5.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "left";
                        }
                        else {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "down";
                            enemy5.width = 10;
                            enemy5.height = 20;
                        }
                    } else if(enemy5.x > 250 && enemy5.x < 260 && enemy5.y > 0 && enemy5.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "left";
                        }
                        else {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "down";
                            enemy5.width = 10;
                            enemy5.height = 20;
                        }
                    } else if(enemy5.x > 250 && enemy5.x < 260 && enemy5.y > 240 && enemy5.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy5.direction.equals("right"))
                                    enemy5.direction = "up";
                                if(enemy5.direction.equals("left"))
                                    enemy5.direction = "up";
                            } else {
                                if(enemy5.direction.equals("right"))
                                    enemy5.direction = "down";
                                if(enemy5.direction.equals("left"))
                                    enemy5.direction = "down";
                            }
                            enemy5.width = 10;
                            enemy5.height = 20;
                        }
                    } else if(enemy5.x > 490 && enemy5.x < 510 && enemy5.y > 240 && enemy5.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy5.direction.equals("right"))
                                    enemy5.direction = "up";
                                if(enemy5.direction.equals("left"))
                                    enemy5.direction = "up";
                            } else {
                                if(enemy5.direction.equals("right"))
                                    enemy5.direction = "down";
                                if(enemy5.direction.equals("left"))
                                    enemy5.direction = "down";
                            }
                            enemy5.width = 10;
                            enemy5.height = 20;
                        }
                    } else if(enemy5.x > 0 && enemy5.x < 10 && enemy5.y > 200 && enemy5.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "up";
                        }
                        else {
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "right";
                            enemy5.width = 20;
                            enemy5.height = 10;
                        }
                    } else if(enemy5.x > 0 && enemy5.x < 10 && enemy5.y > 400 && enemy5.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "up";
                        }
                        else {
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "right";
                            enemy5.width = 20;
                            enemy5.height = 10;
                        }
                    } else if(enemy5.x > 0 && enemy5.x < 10 && enemy5.y > 600 && enemy5.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "up";
                        }
                        else {
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "right";
                            enemy5.width = 20;
                            enemy5.height = 10;
                        }
                    } else if(enemy5.x > 0 && enemy5.x < 10 && enemy5.y > 750 && enemy5.y < 770) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "up";
                        }
                        else {
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "right";
                            enemy5.width = 20;
                            enemy5.height = 10;
                        }
                    } else if(enemy5.x > 750 && enemy5.x < 760 && enemy5.y > 0 && enemy5.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "left";
                        }
                        else {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "down";
                            enemy5.width = 10;
                            enemy5.height = 20;
                        }
                    } else if(enemy5.x > 970 && enemy5.x < 990 && enemy5.y > 0 && enemy5.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "left";
                        }
                        else {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "down";
                            enemy5.width = 10;
                            enemy5.height = 20;
                        }
                    } else if(enemy5.x > 970 && enemy5.x < 990 && enemy5.y > 200 && enemy5.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "left";
                        }
                        else {
                            if(enemy5.direction.equals("right"))
                                enemy5.direction = "down";
                            if(enemy5.direction.equals("left"))
                                enemy5.direction = "down";
                            enemy5.width = 10;
                            enemy5.height = 20;
                        }
                    } else if(enemy5.x > 970 && enemy5.x < 990 && enemy5.y > 400 && enemy5.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "up";
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "down";
                        }
                        else {
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "left";
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "left";
                            enemy5.width = 20;
                            enemy5.height = 10;
                        }
                    } else if(enemy5.x > 970 && enemy5.x < 990 && enemy5.y > 600 && enemy5.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "up";
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "down";
                        }
                        else {
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "left";
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "left";
                            enemy5.width = 20;
                            enemy5.height = 10;
                        }
                    } else if(enemy5.x > 970 && enemy5.x < 990 && enemy5.y > 760 && enemy5.y < 780) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "up";
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "down";
                        }
                        else {
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "left";
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "left";
                            enemy5.width = 20;
                            enemy5.height = 10;
                        }
                    } else if(enemy5.x > 500 && enemy5.x < 510 && enemy5.y > 400 && enemy5.y < 420) {
                        int v = rand.nextInt(3);
                        if(v == 0 || v == 2 || v == 1) {
                            if(enemy5.direction.equals("up")) {
                                enemy5.direction = "up";
                                enemy5.width = 10;
                                enemy5.height = 20;
                                if(v == 2) {
                                    enemy5.direction = "left";
                                    enemy5.width = 20;
                                    enemy5.height = 10;
                                }
                                else {
                                    enemy5.direction = "right";
                                    enemy5.width = 20;
                                    enemy5.height = 10;
                                }
                            }
                            else if(enemy5.direction.equals("down")) {
                                enemy5.direction = "down";
                                enemy5.width = 10;
                                enemy5.height = 20;
                                if(v == 2) {
                                    enemy5.direction = "right";
                                    enemy5.width = 20;
                                    enemy5.height = 10;
                                }
                                else {
                                    enemy5.direction = "left";
                                    enemy5.width = 20;
                                    enemy5.height = 10;
                                }
                            }
                            else if(enemy5.direction.equals("left")) {
                                enemy5.direction = "left";
                                enemy5.width = 20;
                                enemy5.height = 10;
                                if(v == 2) {
                                    enemy5.direction = "down";
                                    enemy5.width = 10;
                                    enemy5.height = 20;
                                }
                                else {
                                    enemy5.direction = "up";
                                    enemy5.width = 10;
                                    enemy5.height = 20;
                                }
                            }
                        }
                    } else if(enemy5.x > 500 && enemy5.x < 510 && enemy5.y > 0 && enemy5.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "right";
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "right";
                        }
                        else {
                            if(enemy5.direction.equals("up"))
                                enemy5.direction = "left";
                            if(enemy5.direction.equals("down"))
                                enemy5.direction = "left";
                            enemy5.width = 20;
                            enemy5.height = 10;
                        }
                    }
                    if(enemy6.x > 500 && enemy6.x < 510 && enemy6.y > 0 && enemy6.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "left";
                        }
                        else {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "down";
                            enemy6.width = 10;
                            enemy6.height = 20;
                        }
                    } else if(enemy6.x > 250 && enemy6.x < 260 && enemy6.y > 0 && enemy6.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "left";
                        }
                        else {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "down";
                            enemy6.width = 10;
                            enemy6.height = 20;
                        }
                    } else if(enemy6.x > 250 && enemy6.x < 260 && enemy6.y > 240 && enemy6.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy6.direction.equals("right"))
                                    enemy6.direction = "up";
                                if(enemy6.direction.equals("left"))
                                    enemy6.direction = "up";
                            } else {
                                if(enemy6.direction.equals("right"))
                                    enemy6.direction = "down";
                                if(enemy6.direction.equals("left"))
                                    enemy6.direction = "down";
                            }
                            enemy6.width = 10;
                            enemy6.height = 20;
                        }
                    } else if(enemy6.x > 490 && enemy6.x < 510 && enemy6.y > 240 && enemy6.y < 260) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "left";
                        }
                        else {
                            int x = rand.nextInt(2);
                            if(x == 0) {
                                if(enemy6.direction.equals("right"))
                                    enemy6.direction = "up";
                                if(enemy6.direction.equals("left"))
                                    enemy6.direction = "up";
                            } else {
                                if(enemy6.direction.equals("right"))
                                    enemy6.direction = "down";
                                if(enemy6.direction.equals("left"))
                                    enemy6.direction = "down";
                            }
                            enemy6.width = 10;
                            enemy6.height = 20;
                        }
                    } else if(enemy6.x > 0 && enemy6.x < 10 && enemy6.y > 200 && enemy6.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "up";
                        }
                        else {
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "right";
                            enemy6.width = 20;
                            enemy6.height = 10;
                        }
                    } else if(enemy6.x > 0 && enemy6.x < 10 && enemy6.y > 400 && enemy6.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "up";
                        }
                        else {
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "right";
                            enemy6.width = 20;
                            enemy6.height = 10;
                        }
                    } else if(enemy6.x > 0 && enemy6.x < 10 && enemy6.y > 600 && enemy6.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "up";
                        }
                        else {
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "right";
                            enemy6.width = 20;
                            enemy6.height = 10;
                        }
                    } else if(enemy6.x > 0 && enemy6.x < 10 && enemy6.y > 750 && enemy6.y < 770) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "up";
                        }
                        else {
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "right";
                            enemy6.width = 20;
                            enemy6.height = 10;
                        }
                    } else if(enemy6.x > 750 && enemy6.x < 760 && enemy6.y > 0 && enemy6.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "left";
                        }
                        else {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "down";
                            enemy6.width = 10;
                            enemy6.height = 20;
                        }
                    } else if(enemy6.x > 970 && enemy6.x < 990 && enemy6.y > 0 && enemy6.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "left";
                        }
                        else {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "down";
                            enemy6.width = 10;
                            enemy6.height = 20;
                        }
                    } else if(enemy6.x > 970 && enemy6.x < 990 && enemy6.y > 200 && enemy6.y < 220) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "left";
                        }
                        else {
                            if(enemy6.direction.equals("right"))
                                enemy6.direction = "down";
                            if(enemy6.direction.equals("left"))
                                enemy6.direction = "down";
                            enemy6.width = 10;
                            enemy6.height = 20;
                        }
                    } else if(enemy6.x > 970 && enemy6.x < 990 && enemy6.y > 400 && enemy6.y < 420) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "up";
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "down";
                        }
                        else {
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "left";
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "left";
                            enemy6.width = 20;
                            enemy6.height = 10;
                        }
                    } else if(enemy6.x > 970 && enemy6.x < 990 && enemy6.y > 600 && enemy6.y < 620) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "up";
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "down";
                        }
                        else {
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "left";
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "left";
                            enemy6.width = 20;
                            enemy6.height = 10;
                        }
                    } else if(enemy6.x > 970 && enemy6.x < 990 && enemy6.y > 760 && enemy6.y < 780) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "up";
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "down";
                        }
                        else {
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "left";
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "left";
                            enemy6.width = 20;
                            enemy6.height = 10;
                        }
                    } else if(enemy6.x > 500 && enemy6.x < 510 && enemy6.y > 400 && enemy6.y < 420) {
                        int v = rand.nextInt(3);
                        if(v == 0 || v == 2 || v == 1) {
                            if(enemy6.direction.equals("up")) {
                                enemy6.direction = "up";
                                enemy6.width = 10;
                                enemy6.height = 20;
                                if(v == 2) {
                                    enemy6.direction = "left";
                                    enemy6.width = 20;
                                    enemy6.height = 10;
                                }
                                else {
                                    enemy6.direction = "right";
                                    enemy6.width = 20;
                                    enemy6.height = 10;
                                }
                            }
                            else if(enemy6.direction.equals("down")) {
                                enemy6.direction = "down";
                                enemy6.width = 10;
                                enemy6.height = 20;
                                if(v == 2) {
                                    enemy6.direction = "right";
                                    enemy6.width = 20;
                                    enemy6.height = 10;
                                }
                                else {
                                    enemy6.direction = "left";
                                    enemy6.width = 20;
                                    enemy6.height = 10;
                                }
                            }
                            else if(enemy6.direction.equals("left")) {
                                enemy6.direction = "left";
                                enemy6.width = 20;
                                enemy6.height = 10;
                                if(v == 2) {
                                    enemy6.direction = "down";
                                    enemy6.width = 10;
                                    enemy6.height = 20;
                                }
                                else {
                                    enemy6.direction = "up";
                                    enemy6.width = 10;
                                    enemy6.height = 20;
                                }
                            }
                        }
                    } else if(enemy6.x > 500 && enemy6.x < 510 && enemy6.y > 0 && enemy6.y < 20) {
                        int v = rand.nextInt(2);
                        if(v == 0) {
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "right";
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "right";
                        }
                        else {
                            if(enemy6.direction.equals("up"))
                                enemy6.direction = "left";
                            if(enemy6.direction.equals("down"))
                                enemy6.direction = "left";
                            enemy6.width = 20;
                            enemy6.height = 10;
                        }
                    }

                    if(enemyIsCollided() || enemy2IsCollided() || enemy3IsCollided() || enemy4IsCollided()
                            || enemy5IsCollided() || enemy6IsCollided()) {

                        String cl = crashList.getText();
                        
                        if(enemyIsCollided()) {
                            if(cl.equals("") || cl == null)
                            {
                                crashList.setText(enemy.brand 
                                        + " (-$" + enemy.fine + ")");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + enemy.brand + " (-$" + enemy.fine + ")");
                            }
                        }
                        
                        if(enemy2IsCollided()) {
                            if(cl.equals("") || cl == null)
                            {
                                crashList.setText(enemy2.brand 
                                        + " (-$" + enemy2.fine + ")");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + enemy2.brand + " (-$" + enemy2.fine + ")");
                            }
                        }

                        if(enemy3IsCollided()) {
                            if(cl.equals("") || cl == null)
                            {
                                crashList.setText(enemy3.brand 
                                        + " (-$" + enemy3.fine + ")");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + enemy3.brand + " (-$" + enemy3.fine + ")");
                            }
                        }

                        if(enemy4IsCollided()) {
                            if(cl.equals("") || cl == null)
                            {
                                crashList.setText(enemy4.brand 
                                        + " (-$" + enemy4.fine + ")");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + enemy4.brand + " (-$" + enemy4.fine + ")");
                            }
                        }

                        if(enemy5IsCollided()) {
                            if(cl.equals("") || cl == null)
                            {
                                crashList.setText(enemy5.brand 
                                        + " (-$" + enemy5.fine + ")");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + enemy5.brand + " (-$" + enemy5.fine + ")");
                            }
                        }

                        if(enemy6IsCollided()) {
                            if(cl.equals("") || cl == null)
                            {
                                crashList.setText(enemy6.brand 
                                        + " (-$" + enemy6.fine + ")");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + enemy6.brand + " (-$" + enemy6.fine + ")");
                            }
                        }

                        int u = rand.nextInt(4);
                        if( u == 0 ) {
                            enemy.brand = "Volkswagen";
                            fines += 5000;
                            enemy.fine = 5000;
                        }
                        if( u == 1 ) {
                            enemy.brand = "Datsun";
                            fines += 3000;
                            enemy.fine = 3000;
                        }
                        if( u == 2 ) {
                            enemy.brand = "Honda";
                            fines += 3800;
                            enemy.fine = 3800;
                        }
                        if( u == 3 ) {
                            enemy.brand = "Nissan";
                            fines += 2800;
                            enemy.fine = 2800;
                        }
                        
                        u = rand.nextInt(4);
                        if( u == 0 ) {
                            enemy2.brand = "Volkswagen";
                            fines += 5000;
                            enemy2.fine = 5000;
                        }
                        if( u == 1 ) {
                            enemy2.brand = "Datsun";
                            fines += 3000;
                            enemy2.fine = 3000;
                        }
                        if( u == 2 ) {
                            enemy2.brand = "Honda";
                            fines += 3800;
                            enemy2.fine = 3800;
                        }
                        if( u == 3 ) {
                            enemy2.brand = "Nissan";
                            fines += 2800;
                            enemy2.fine = 2800;
                        }

                        u = rand.nextInt(4);
                        if( u == 0 ) {
                            enemy3.brand = "Volkswagen";
                            fines += 5000;
                            enemy3.fine = 5000;
                        }
                        if( u == 1 ) {
                            enemy3.brand = "Datsun";
                            fines += 3000;
                            enemy3.fine = 3000;
                        }
                        if( u == 2 ) {
                            enemy3.brand = "Honda";
                            fines += 3800;
                            enemy3.fine = 3800;
                        }
                        if( u == 3 ) {
                            enemy3.brand = "Nissan";
                            fines += 2800;
                            enemy3.fine = 2800;
                        }

                        u = rand.nextInt(4);
                        if( u == 0 ) {
                            enemy4.brand = "Volkswagen";
                            fines += 5000;
                            enemy4.fine = 5000;
                        }
                        if( u == 1 ) {
                            enemy4.brand = "Datsun";
                            fines += 3000;
                            enemy4.fine = 3000;
                        }
                        if( u == 2 ) {
                            enemy4.brand = "Honda";
                            fines += 3800;
                            enemy4.fine = 3800;
                        }
                        if( u == 3 ) {
                            enemy4.brand = "Nissan";
                            fines += 2800;
                            enemy4.fine = 2800;
                        }

                        u = rand.nextInt(4);
                        if( u == 0 ) {
                            enemy5.brand = "Volkswagen";
                            fines += 5000;
                            enemy5.fine = 5000;
                        }
                        if( u == 1 ) {
                            enemy5.brand = "Datsun";
                            fines += 3000;
                            enemy5.fine = 3000;
                        }
                        if( u == 2 ) {
                            enemy5.brand = "Honda";
                            fines += 3800;
                            enemy5.fine = 3800;
                        }
                        if( u == 3 ) {
                            enemy5.brand = "Nissan";
                            fines += 2800;
                            enemy5.fine = 2800;
                        }

                        u = rand.nextInt(4);
                        if( u == 0 ) {
                            enemy6.brand = "Volkswagen";
                            fines += 5000;
                            enemy6.fine = 5000;
                        }
                        if( u == 1 ) {
                            enemy6.brand = "Datsun";
                            fines += 3000;
                            enemy6.fine = 3000;
                        }
                        if( u == 2 ) {
                            enemy6.brand = "Honda";
                            fines += 3800;
                            enemy6.fine = 3800;
                        }
                        if( u == 3 ) {
                            enemy6.brand = "Nissan";
                            fines += 2800;
                            enemy6.fine = 2800;
                        }

                        if(enemyIsCollided())
                            createEnemyAutomobile();
                        
                        if(enemy2IsCollided())
                            createEnemy2Automobile();

                        if(enemy3IsCollided())
                            createEnemy3Automobile();

                        if(enemy4IsCollided())
                            createEnemy4Automobile();

                        if(enemy5IsCollided())
                            createEnemy5Automobile();

                        if(enemy6IsCollided())
                            createEnemy6Automobile();

                        createAirplanes();
                    }

                    if(enemy.x < -100 || enemy.x > 1100 || enemy.y < -100 || enemy.y > 900)
                        createEnemyAutomobile();

                    if(enemy2.x < -100 || enemy2.x > 1100 || enemy2.y < -100 || enemy2.y > 900)
                        createEnemy2Automobile();

                    if(enemy3.x < -100 || enemy3.x > 1100 || enemy3.y < -100 || enemy3.y > 900)
                        createEnemy3Automobile();

                    if(enemy4.x < -100 || enemy4.x > 1100 || enemy4.y < -100 || enemy4.y > 900)
                        createEnemy4Automobile();

                    if(enemy5.x < -100 || enemy5.x > 1100 || enemy5.y < -100 || enemy5.y > 900)
                        createEnemy5Automobile();

                    if(enemy6.x < -100 || enemy6.x > 1100 || enemy6.y < -100 || enemy6.y > 900)
                        createEnemy6Automobile();

                    
                    if(enemy.direction.equals("right"))
                        enemy.x += 2;
                    if(enemy.direction.equals("left"))
                        enemy.x -= 2;
                    if(enemy.direction.equals("down"))
                        enemy.y += 2;
                    if(enemy.direction.equals("up"))
                        enemy.y -= 2;

                    if(enemy2.direction.equals("right"))
                        enemy2.x += 2;
                    if(enemy2.direction.equals("left"))
                        enemy2.x -= 2;
                    if(enemy2.direction.equals("down"))
                        enemy2.y += 2;
                    if(enemy2.direction.equals("up"))
                        enemy2.y -= 2;

                    if(enemy3.direction.equals("right"))
                        enemy3.x += 2;
                    if(enemy3.direction.equals("left"))
                        enemy3.x -= 2;
                    if(enemy3.direction.equals("down"))
                        enemy3.y += 2;
                    if(enemy3.direction.equals("up"))
                        enemy3.y -= 2;

                    if(enemy4.direction.equals("right"))
                        enemy4.x += 2;
                    if(enemy4.direction.equals("left"))
                        enemy4.x -= 2;
                    if(enemy4.direction.equals("down"))
                        enemy4.y += 2;
                    if(enemy4.direction.equals("up"))
                        enemy4.y -= 2;

                    if(enemy5.direction.equals("right"))
                        enemy5.x += 2;
                    if(enemy5.direction.equals("left"))
                        enemy5.x -= 2;
                    if(enemy5.direction.equals("down"))
                        enemy5.y += 2;
                    if(enemy5.direction.equals("up"))
                        enemy5.y -= 2;

                    if(enemy6.direction.equals("right"))
                        enemy6.x += 2;
                    if(enemy6.direction.equals("left"))
                        enemy6.x -= 2;
                    if(enemy6.direction.equals("down"))
                        enemy6.y += 2;
                    if(enemy6.direction.equals("up"))
                        enemy6.y -= 2;

                    if(which.equals("R")) {
                        airplane_R.x -= 20;
                    }

                    if(which.equals("L")) {
                        airplane_L.x += 20;
                    }

                    if(which.equals("T")) {
                        airplane_T.y += 20;
                    }

                    if(which.equals("D")) {
                        airplane_D.y -= 20;
                    }

                    drawEnemy();
                    drawEnemy2();
                    drawEnemy3();
                    drawEnemy4();
                    drawEnemy5();
                    drawEnemy6();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException interruptedException) {
                    }
                }
            }
        };
        
        t.start();
        
        crashList.setText(sql);

        gg = panel.getGraphics();
        
        Thread thread = new Thread() {
            public void run() {
                int o = 1;
                int t = 1;
                while(true) {
                    if(gasStation.gasNearEmpty) {
                        if(o == 2)
                            gg.setColor(gasStation.color2);
                        else
                            gg.setColor(gasStation.color3);
                        try {
                            Thread.sleep(1000);
                            if(o < 2)
                                o = 2;
                            else
                                o = 1;
                        } catch(InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    } else {
                        gg.setColor(gasStation.color1);
                    }
                    
                    if(gasStation2.gasNearEmpty) {
                        if(t == 2)
                            gg.setColor(gasStation2.color2);
                        else
                            gg.setColor(gasStation2.color3);
                        try {
                            Thread.sleep(1000);
                            if(t < 2)
                                t = 2;
                            else
                                t = 1;
                        } catch(InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    } else {
                        gg.setColor(gasStation2.color1);
                    }
                }
            }
        };
        thread.start();

        frame.addKeyListener(this);
    }
    AudioInputStream audioStream;
        File audioFile;
        DataLine.Info info;
        Clip audioClip;
                AudioFormat format;
                
    private void makeSound(String file) throws Exception {
 audioFile = new File(file);
audioStream = AudioSystem.getAudioInputStream(audioFile);
 format = audioStream.getFormat();
        
 info = new DataLine.Info(Clip.class, format);
 audioClip = (Clip) AudioSystem.getLine(info);
         audioClip.open(audioStream);
audioClip.start();
        
        
    }

    public void drawAirplanes() {
        Graphics g = panel.getGraphics();
        
        if(which.equals("L"))
            g.drawImage(airplaneL, airplane_L.x, airplane_L.y, null);
        if(which.equals("R"))
            g.drawImage(airplaneR, airplane_R.x, airplane_R.y, null);
        if(which.equals("T"))
            g.drawImage(airplaneT, airplane_T.x, airplane_T.y, null);
        if(which.equals("D"))
            g.drawImage(airplaneD, airplane_D.x, airplane_D.y, null);

        g.dispose();
    }
    
    public void createEnemyAutomobile() {
        int u = rand.nextInt(4);
        if( u == 0 ) {
            enemy.brand = "Volkswagen";
        }
        if( u == 1 ) {
            enemy.brand = "Datsun";
        }
        if( u == 2 ) {
            enemy.brand = "Honda";
        }
        if( u == 3 ) {
            enemy.brand = "Nissan";
        }
        int v = rand.nextInt(12);
        if(v == 0) {
            enemy.x = -20;
            enemy.y = 5;
            enemy.width = 20;
            enemy.height = 10;
            enemy.direction = "right";
        }
        if(v == 1) {
            enemy.x = 5;
            enemy.y = -20;
            enemy.width = 10;
            enemy.height = 20;
            enemy.direction = "down";
        }
        if(v == 2) {
            enemy.x = 505;
            enemy.y = -20;
            enemy.width = 10;
            enemy.height = 20;
            enemy.direction = "down";
        }
        if(v == 3) {
            enemy.x = 960;
            enemy.y = -20;
            enemy.width = 10;
            enemy.height = 20;
            enemy.direction = "down";
        }
        if(v == 4) {
            enemy.x = 1020;
            enemy.y = 5;
            enemy.width = 20;
            enemy.height = 10;
            enemy.direction = "left";
        }
        if(v == 5) {
            enemy.x = 1020;
            enemy.y = 405;
            enemy.width = 20;
            enemy.height = 10;
            enemy.direction = "left";
        }
        if(v == 6) {
            enemy.x = 1020;
            enemy.y = 795;
            enemy.width = 20;
            enemy.height = 10;
            enemy.direction = "up";
        }
        if(v == 7) {
            enemy.x = 960;
            enemy.y = 820;
            enemy.width = 10;
            enemy.height = 20;
            enemy.direction = "up";
        }
        if(v == 8) {
            enemy.x = 505;
            enemy.y = 820;
            enemy.width = 10;
            enemy.height = 20;
            enemy.direction = "up";
        }
        if(v == 9) {
            enemy.x = 5;
            enemy.y = 820;
            enemy.width = 10;
            enemy.height = 20;
            enemy.direction = "up";
        }
        if(v == 10) {
            enemy.x = -20;
            enemy.y = 795;
            enemy.width = 20;
            enemy.height = 10;
            enemy.direction = "right";
        }
        if(v == 11) {
            enemy.x = -20;
            enemy.y = 405;
            enemy.width = 20;
            enemy.height = 10;
            enemy.direction = "right";
        }
    }
    
    public void createEnemy2Automobile() {
        int u = rand.nextInt(4);
        if( u == 0 ) {
            enemy2.brand = "Volkswagen";
        }
        if( u == 1 ) {
            enemy2.brand = "Datsun";
        }
        if( u == 2 ) {
            enemy2.brand = "Honda";
        }
        if( u == 3 ) {
            enemy2.brand = "Nissan";
        }
        int v = rand.nextInt(12);
        if(v == 0) {
            enemy2.x = -20;
            enemy2.y = 5;
            enemy2.width = 20;
            enemy2.height = 10;
            enemy2.direction = "right";
        }
        if(v == 1) {
            enemy2.x = 5;
            enemy2.y = -20;
            enemy2.width = 10;
            enemy2.height = 20;
            enemy2.direction = "down";
        }
        if(v == 2) {
            enemy2.x = 505;
            enemy2.y = -20;
            enemy2.width = 10;
            enemy2.height = 20;
            enemy2.direction = "down";
        }
        if(v == 3) {
            enemy2.x = 960;
            enemy2.y = -20;
            enemy2.width = 10;
            enemy2.height = 20;
            enemy2.direction = "down";
        }
        if(v == 4) {
            enemy2.x = 1020;
            enemy2.y = 5;
            enemy2.width = 20;
            enemy2.height = 10;
            enemy2.direction = "left";
        }
        if(v == 5) {
            enemy2.x = 1020;
            enemy2.y = 405;
            enemy2.width = 20;
            enemy2.height = 10;
            enemy2.direction = "left";
        }
        if(v == 6) {
            enemy2.x = 1020;
            enemy2.y = 795;
            enemy2.width = 20;
            enemy2.height = 10;
            enemy2.direction = "up";
        }
        if(v == 7) {
            enemy2.x = 960;
            enemy2.y = 820;
            enemy2.width = 10;
            enemy2.height = 20;
            enemy2.direction = "up";
        }
        if(v == 8) {
            enemy2.x = 505;
            enemy2.y = 820;
            enemy2.width = 10;
            enemy2.height = 20;
            enemy2.direction = "up";
        }
        if(v == 9) {
            enemy2.x = 5;
            enemy2.y = 820;
            enemy2.width = 10;
            enemy2.height = 20;
            enemy2.direction = "up";
        }
        if(v == 10) {
            enemy2.x = -20;
            enemy2.y = 795;
            enemy2.width = 20;
            enemy2.height = 10;
            enemy2.direction = "right";
        }
        if(v == 11) {
            enemy2.x = -20;
            enemy2.y = 405;
            enemy2.width = 20;
            enemy2.height = 10;
            enemy2.direction = "right";
        }
    }
    public void createEnemy3Automobile() {
        int u = rand.nextInt(4);
        if( u == 0 ) {
            enemy3.brand = "Volkswagen";
        }
        if( u == 1 ) {
            enemy3.brand = "Datsun";
        }
        if( u == 2 ) {
            enemy3.brand = "Honda";
        }
        if( u == 3 ) {
            enemy3.brand = "Nissan";
        }
        int v = rand.nextInt(12);
        if(v == 0) {
            enemy3.x = -20;
            enemy3.y = 5;
            enemy3.width = 20;
            enemy3.height = 10;
            enemy3.direction = "right";
        }
        if(v == 1) {
            enemy3.x = 5;
            enemy3.y = -20;
            enemy3.width = 10;
            enemy3.height = 20;
            enemy3.direction = "down";
        }
        if(v == 2) {
            enemy3.x = 505;
            enemy3.y = -20;
            enemy3.width = 10;
            enemy3.height = 20;
            enemy3.direction = "down";
        }
        if(v == 3) {
            enemy3.x = 960;
            enemy3.y = -20;
            enemy3.width = 10;
            enemy3.height = 20;
            enemy3.direction = "down";
        }
        if(v == 4) {
            enemy3.x = 1020;
            enemy3.y = 5;
            enemy3.width = 20;
            enemy3.height = 10;
            enemy3.direction = "left";
        }
        if(v == 5) {
            enemy3.x = 1020;
            enemy3.y = 405;
            enemy3.width = 20;
            enemy3.height = 10;
            enemy3.direction = "left";
        }
        if(v == 6) {
            enemy3.x = 1020;
            enemy3.y = 795;
            enemy3.width = 20;
            enemy3.height = 10;
            enemy3.direction = "up";
        }
        if(v == 7) {
            enemy3.x = 960;
            enemy3.y = 820;
            enemy3.width = 10;
            enemy3.height = 20;
            enemy3.direction = "up";
        }
        if(v == 8) {
            enemy3.x = 505;
            enemy3.y = 820;
            enemy3.width = 10;
            enemy3.height = 20;
            enemy3.direction = "up";
        }
        if(v == 9) {
            enemy3.x = 5;
            enemy3.y = 820;
            enemy3.width = 10;
            enemy3.height = 20;
            enemy3.direction = "up";
        }
        if(v == 10) {
            enemy3.x = -20;
            enemy3.y = 795;
            enemy3.width = 20;
            enemy3.height = 10;
            enemy3.direction = "right";
        }
        if(v == 11) {
            enemy3.x = -20;
            enemy3.y = 405;
            enemy3.width = 20;
            enemy3.height = 10;
            enemy3.direction = "right";
        }
    }
    public void createEnemy4Automobile() {
        int u = rand.nextInt(4);
        if( u == 0 ) {
            enemy4.brand = "Volkswagen";
        }
        if( u == 1 ) {
            enemy4.brand = "Datsun";
        }
        if( u == 2 ) {
            enemy4.brand = "Honda";
        }
        if( u == 3 ) {
            enemy4.brand = "Nissan";
        }
        int v = rand.nextInt(12);
        if(v == 0) {
            enemy4.x = -20;
            enemy4.y = 5;
            enemy4.width = 20;
            enemy4.height = 10;
            enemy4.direction = "right";
        }
        if(v == 1) {
            enemy4.x = 5;
            enemy4.y = -20;
            enemy4.width = 10;
            enemy4.height = 20;
            enemy4.direction = "down";
        }
        if(v == 2) {
            enemy4.x = 505;
            enemy4.y = -20;
            enemy4.width = 10;
            enemy4.height = 20;
            enemy4.direction = "down";
        }
        if(v == 3) {
            enemy4.x = 960;
            enemy4.y = -20;
            enemy4.width = 10;
            enemy4.height = 20;
            enemy4.direction = "down";
        }
        if(v == 4) {
            enemy4.x = 1020;
            enemy4.y = 5;
            enemy4.width = 20;
            enemy4.height = 10;
            enemy4.direction = "left";
        }
        if(v == 5) {
            enemy4.x = 1020;
            enemy4.y = 405;
            enemy4.width = 20;
            enemy4.height = 10;
            enemy4.direction = "left";
        }
        if(v == 6) {
            enemy4.x = 1020;
            enemy4.y = 795;
            enemy4.width = 20;
            enemy4.height = 10;
            enemy4.direction = "up";
        }
        if(v == 7) {
            enemy4.x = 960;
            enemy4.y = 820;
            enemy4.width = 10;
            enemy4.height = 20;
            enemy4.direction = "up";
        }
        if(v == 8) {
            enemy4.x = 505;
            enemy4.y = 820;
            enemy4.width = 10;
            enemy4.height = 20;
            enemy4.direction = "up";
        }
        if(v == 9) {
            enemy4.x = 5;
            enemy4.y = 820;
            enemy4.width = 10;
            enemy4.height = 20;
            enemy4.direction = "up";
        }
        if(v == 10) {
            enemy4.x = -20;
            enemy4.y = 795;
            enemy4.width = 20;
            enemy4.height = 10;
            enemy4.direction = "right";
        }
        if(v == 11) {
            enemy4.x = -20;
            enemy4.y = 405;
            enemy4.width = 20;
            enemy4.height = 10;
            enemy4.direction = "right";
        }
    }
    public void createEnemy6Automobile() {
        int u = rand.nextInt(4);
        if( u == 0 ) {
            enemy6.brand = "Volkswagen";
        }
        if( u == 1 ) {
            enemy6.brand = "Datsun";
        }
        if( u == 2 ) {
            enemy6.brand = "Honda";
        }
        if( u == 3 ) {
            enemy6.brand = "Nissan";
        }
        int v = rand.nextInt(12);
        if(v == 0) {
            enemy6.x = -20;
            enemy6.y = 5;
            enemy6.width = 20;
            enemy6.height = 10;
            enemy6.direction = "right";
        }
        if(v == 1) {
            enemy6.x = 5;
            enemy6.y = -20;
            enemy6.width = 10;
            enemy6.height = 20;
            enemy6.direction = "down";
        }
        if(v == 2) {
            enemy6.x = 505;
            enemy6.y = -20;
            enemy6.width = 10;
            enemy6.height = 20;
            enemy6.direction = "down";
        }
        if(v == 3) {
            enemy6.x = 960;
            enemy6.y = -20;
            enemy6.width = 10;
            enemy6.height = 20;
            enemy6.direction = "down";
        }
        if(v == 4) {
            enemy6.x = 1020;
            enemy6.y = 5;
            enemy6.width = 20;
            enemy6.height = 10;
            enemy6.direction = "left";
        }
        if(v == 5) {
            enemy6.x = 1020;
            enemy6.y = 405;
            enemy6.width = 20;
            enemy6.height = 10;
            enemy6.direction = "left";
        }
        if(v == 6) {
            enemy6.x = 1020;
            enemy6.y = 795;
            enemy6.width = 20;
            enemy6.height = 10;
            enemy6.direction = "up";
        }
        if(v == 7) {
            enemy6.x = 960;
            enemy6.y = 820;
            enemy6.width = 10;
            enemy6.height = 20;
            enemy6.direction = "up";
        }
        if(v == 8) {
            enemy6.x = 505;
            enemy6.y = 820;
            enemy6.width = 10;
            enemy6.height = 20;
            enemy6.direction = "up";
        }
        if(v == 9) {
            enemy6.x = 5;
            enemy6.y = 820;
            enemy6.width = 10;
            enemy6.height = 20;
            enemy6.direction = "up";
        }
        if(v == 10) {
            enemy6.x = -20;
            enemy6.y = 795;
            enemy6.width = 20;
            enemy6.height = 10;
            enemy6.direction = "right";
        }
        if(v == 11) {
            enemy6.x = -20;
            enemy6.y = 405;
            enemy6.width = 20;
            enemy6.height = 10;
            enemy6.direction = "right";
        }
    }
    public void createEnemy5Automobile() {
        int u = rand.nextInt(4);
        if( u == 0 ) {
            enemy5.brand = "Volkswagen";
        }
        if( u == 1 ) {
            enemy5.brand = "Datsun";
        }
        if( u == 2 ) {
            enemy5.brand = "Honda";
        }
        if( u == 3 ) {
            enemy5.brand = "Nissan";
        }
        int v = rand.nextInt(12);
        if(v == 0) {
            enemy5.x = -20;
            enemy5.y = 5;
            enemy5.width = 20;
            enemy5.height = 10;
            enemy5.direction = "right";
        }
        if(v == 1) {
            enemy5.x = 5;
            enemy5.y = -20;
            enemy5.width = 10;
            enemy5.height = 20;
            enemy5.direction = "down";
        }
        if(v == 2) {
            enemy5.x = 505;
            enemy5.y = -20;
            enemy5.width = 10;
            enemy5.height = 20;
            enemy5.direction = "down";
        }
        if(v == 3) {
            enemy5.x = 960;
            enemy5.y = -20;
            enemy5.width = 10;
            enemy5.height = 20;
            enemy5.direction = "down";
        }
        if(v == 4) {
            enemy5.x = 1020;
            enemy5.y = 5;
            enemy5.width = 20;
            enemy5.height = 10;
            enemy5.direction = "left";
        }
        if(v == 5) {
            enemy5.x = 1020;
            enemy5.y = 405;
            enemy5.width = 20;
            enemy5.height = 10;
            enemy5.direction = "left";
        }
        if(v == 6) {
            enemy5.x = 1020;
            enemy5.y = 795;
            enemy5.width = 20;
            enemy5.height = 10;
            enemy5.direction = "up";
        }
        if(v == 7) {
            enemy5.x = 960;
            enemy5.y = 820;
            enemy5.width = 10;
            enemy5.height = 20;
            enemy5.direction = "up";
        }
        if(v == 8) {
            enemy5.x = 505;
            enemy5.y = 820;
            enemy5.width = 10;
            enemy5.height = 20;
            enemy5.direction = "up";
        }
        if(v == 9) {
            enemy5.x = 5;
            enemy5.y = 820;
            enemy5.width = 10;
            enemy5.height = 20;
            enemy5.direction = "up";
        }
        if(v == 10) {
            enemy5.x = -20;
            enemy5.y = 795;
            enemy5.width = 20;
            enemy5.height = 10;
            enemy5.direction = "right";
        }
        if(v == 11) {
            enemy5.x = -20;
            enemy5.y = 405;
            enemy5.width = 20;
            enemy5.height = 10;
            enemy5.direction = "right";
        }
    }
    boolean firstTimeAirplaneFlies = true;
    public void createAirplanes() {
        if(firstTimeAirplaneFlies) {
            firstTimeAirplaneFlies = false;
            return;
        }
        int v = rand.nextInt(4);
        if(v == 0) {
            airplane_L.x = -20;
            airplane_L.y = 400;
            which = "L";
            airplane_R.x = -1000;
            airplane_T.x = -1000;
            airplane_D.x = -1000;
        }
        if(v == 1) {
            airplane_R.x = 1020;
            airplane_R.y = 400;
            which = "R";
            airplane_L.x = -1000;
            airplane_T.x = -1000;
            airplane_D.x = -1000;
        }
        if(v == 2) {
            airplane_T.x = 500;
            airplane_T.y = -20;
            which = "T";
            airplane_R.x = -1000;
            airplane_L.x = -1000;
            airplane_D.x = -1000;
        }
        if(v == 3) {
            airplane_D.x = 500;
            airplane_D.y = 800;
            which = "D";
            airplane_R.x = -1000;
            airplane_T.x = -1000;
            airplane_L.x = -1000;
        }

        try {
            makeSound("sound.wav");
        } catch(Exception e1) {
            try {
                makeSound("src/sound.wav");
            } catch(Exception e2) {}
        }
    }
    
    boolean wentToELAPark = false;
    boolean wentToCSLA = false;

    public void drawELALabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Olivera St.", 20, 221);

        g.setColor(Color.black);        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.fillRect(20, 20, 105, 180);
        g.fillRect(145, 20, 105, 180);
        
        g.setColor(Color.green);
        g.fillRect(520, 420, 105, 180);
        g.fillRect(645, 420, 105, 180);
        

        if(!wentToELAPark && car.x >= 520 && car.x <= 750 &&
           car.y >= 420 && car.y <= 600) {
                        String cl = crashList.getText();
                        
                        wentToELAPark = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Park");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Park");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to park");
        }
        
        if(!(car.x >= 520 && car.x <= 750 &&
           car.y >= 420 && car.y <= 600)) {
            wentToELAPark = false;
        }

        if(!wentToCSLA && car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 200) {
                        String cl = crashList.getText();
                        
                        wentToCSLA = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("CSLA");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "CSLA");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Cal State LA");
        }
        
        if(!(car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 200)) {
            wentToCSLA = false;
        }

        g.setColor(Color.white);
        
        g.drawString("CSLA.", 70, 120);
        g.drawString("LAC-USC", 310, 120);
        g.drawString("King Taco", 610, 120);
        g.drawString("Boyle Heights", 810, 120);
        g.drawString("Union Station", 310, 300);
        g.drawString("Olivera Street", 570, 290);
        g.drawString("King Taco", 790, 300);
        g.drawString("El Burrito", 820, 350);
        g.drawString("Movie Theater", 40, 300);
        g.drawString("Liquor Store", 40, 500);
        g.drawString("Supermercado", 310, 500);
        g.drawString("Park", 550, 500);
        g.drawString("Middle School", 820, 500);
        g.drawString("Park", 40, 700);
        g.drawString("High School", 310, 700);
        g.drawString("Community College", 570, 700);
        g.drawString("Super Market", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }
    
    boolean wentToUCRiverside = false;
    boolean wentToCow = false;
    
    public void drawRiversideLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Cow St.", 20, 221);

        g.setColor(Color.black);        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.fillRect(20, 20, 105, 180);
        g.fillRect(145, 20, 105, 180);
        
        g.setColor(Color.green);
        g.fillRect(520, 420, 105, 180);
        g.fillRect(645, 420, 105, 180);
        

        if(!wentToUCRiverside && car.x >= 770 && car.x <= 960 &&
           car.y >= 20 && car.y <= 200) {
                        String cl = crashList.getText();
                        
                        wentToUCRiverside = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("UC Riverside");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "UC Riverside");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to UC Riverside");
        }
        
        if(!(car.x >= 770 && car.x <= 960 &&
           car.y >= 20 && car.y <= 200)) {
            wentToUCRiverside = false;
        }

        if(!wentToCow && car.x >= 270 && car.x <= 500 &&
           car.y >= 20 && car.y <= 200) {
                        String cl = crashList.getText();
                        
                        wentToCow = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Cow");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Cow");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Cow");
        }
        
        if(!(car.x >= 270 && car.x <= 500 &&
           car.y >= 20 && car.y <= 200)) {
            wentToCow = false;
        }

        g.setColor(Color.white);
        
        g.drawString("Medical Center", 70, 120);
        g.drawString("Cow", 310, 120);
        g.drawString("King Taco", 610, 120);
        g.drawString("UC Riverside", 810, 120);
        g.drawString("Train Station", 310, 300);
        g.drawString("Cow St.", 570, 290);
        g.drawString("King Taco", 790, 300);
        g.drawString("El Burrito", 820, 350);
        g.drawString("AMC Theater", 40, 300);
        g.drawString("Liquor Store", 40, 500);
        g.drawString("Supermercado", 310, 500);
        g.drawString("Park", 550, 500);
        g.drawString("Middle School", 820, 500);
        g.drawString("Elementary School", 40, 700);
        g.drawString("High School", 310, 700);
        g.drawString("Apartments", 570, 700);
        g.drawString("Supermarket", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    boolean wentToFriend = false;
    boolean wentToPort = false;

    public void drawSanPedroLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("San Pedro Blvd.", 20, 221);

        g.setColor(Color.black);        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.fillRect(20, 20, 105, 180);
        g.fillRect(145, 20, 105, 180);
        
        g.setColor(Color.green);
        g.fillRect(520, 420, 105, 180);
        g.fillRect(645, 420, 105, 180);
        

        if(!wentToFriend && car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 200) {
                        String cl = crashList.getText();
                        
                        wentToFriend = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Korea-US Friendship Bell Park");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Korea-US Friendship Bell PArk");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Korea-US Friendship Bell Park");
        }
        
        if(!(car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 200)) {
            wentToFriend = false;
        }

        if(!wentToPort && car.x >= 20 && car.x <= 250 &&
           car.y >= 220 && car.y <= 400) {
                        String cl = crashList.getText();
                        
                        wentToPort = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Port");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Port");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Port");
        }
        
        if(!(car.x >= 20 && car.x <= 250 &&
           car.y >= 220 && car.y <= 400)) {
            wentToPort = false;
        }

        g.setColor(Color.white);
        
        g.drawString("Korea-US Friendship Bell Park", 70, 120);
        g.drawString("Bus Station", 310, 120);
        g.drawString("Hills", 610, 120);
        g.drawString("Park", 810, 120);
        g.drawString("Elementary School", 310, 300);
        g.drawString("Middle School", 570, 290);
        g.drawString("High School", 790, 300);
        g.drawString("AMC Theater", 820, 350);
        g.drawString("Port", 40, 300);
        g.drawString("Parking Lot", 40, 500);
        g.drawString("Library", 310, 500);
        g.drawString("Park", 550, 500);
        g.drawString("Market", 820, 500);
        g.drawString("Liquor Store", 40, 700);
        g.drawString("Bank", 310, 700);
        g.drawString("Community College", 570, 700);
        g.drawString("Liquor Store", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public boolean wentToPolice = false;
    
    public void drawCoronaLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Corona Pkwy.", 20, 221);

        g.setColor(Color.black);        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.fillRect(20, 20, 105, 180);
        g.fillRect(145, 20, 105, 180);
        
        g.setColor(Color.green);
        g.fillRect(520, 420, 105, 180);
        g.fillRect(645, 420, 105, 180);
        

        if(!wentToPolice && car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 200) {
                        String cl = crashList.getText();
                        
                        wentToFriend = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Korea-US Friendship Bell Park");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Korea-US Friendship Bell PArk");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Korea-US Friendship Bell Park");
        }
        
        if(!(car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 200)) {
            wentToFriend = false;
        }

        if(!wentToPort && car.x >= 20 && car.x <= 250 &&
           car.y >= 220 && car.y <= 400) {
                        String cl = crashList.getText();
                        
                        wentToPort = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Port");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Port");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Port");
        }
        
        if(!(car.x >= 20 && car.x <= 250 &&
           car.y >= 220 && car.y <= 400)) {
            wentToPort = false;
        }

        g.setColor(Color.white);
        
        g.drawString("Korea-US Friendship Bell Park", 70, 120);
        g.drawString("Bus Station", 310, 120);
        g.drawString("Hills", 610, 120);
        g.drawString("Park", 810, 120);
        g.drawString("Elementary School", 310, 300);
        g.drawString("Middle School", 570, 290);
        g.drawString("High School", 790, 300);
        g.drawString("AMC Theater", 820, 350);
        g.drawString("Cop Station", 40, 300);
        g.drawString("Parking Lot", 40, 500);
        g.drawString("Library", 310, 500);
        g.drawString("Park", 550, 500);
        g.drawString("Market", 820, 500);
        g.drawString("Liquor Store", 40, 700);
        g.drawString("Bank", 310, 700);
        g.drawString("Community College", 570, 700);
        g.drawString("Liquor Store", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public void drawSLALabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("King Blvd.", 20, 221);

        g.setColor(Color.black);        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.setColor(Color.white);
        
        g.drawString("Krispy Kreme", 70, 120);
        g.drawString("Bus Station", 310, 120);
        g.drawString("Liquor Store", 610, 120);
        g.drawString("Park", 810, 120);
        g.drawString("Elementary School", 310, 300);
        g.drawString("Middle School", 570, 290);
        g.drawString("High School", 790, 300);
        g.drawString("AMC Theater", 820, 350);
        g.drawString("Police Station", 40, 300);
        g.drawString("Adult Store", 40, 500);
        g.drawString("Library", 310, 500);
        g.drawString("Park", 550, 500);
        g.drawString("Market", 820, 500);
        g.drawString("7 Eleven", 40, 700);
        g.drawString("Bike Shop", 310, 700);
        g.drawString("City College", 570, 700);
        g.drawString("Supermarket", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    boolean wentToDisney = false;
    boolean wentToKnotts = false;
    boolean wentToExcalibur = false;
    boolean wentToPark1 = false;
    boolean wentToPark2 = false;
    boolean wentToLibrary = false;
    
    public void drawAnaheimLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.black);
        g.setFont(new Font("arial", Font.PLAIN, 10));
        g.drawString("Knotts Ave.", 20, 221);

        g.setColor(Color.black);        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.fillRect(20, 20, 105, 180);
        g.fillRect(145, 20, 105, 180);
        
        g.setColor(Color.YELLOW);
        g.fillRect(520, 220, 105, 180);
        g.fillRect(645, 220, 105, 180);
        
        g.setColor(Color.green);
        g.fillRect(520, 520, 105, 180);
        g.fillRect(645, 520, 105, 180);

        g.setColor(Color.green);
        g.fillRect(770, 620, 105, 180);
        g.fillRect(895, 620, 105, 180);

        if(!wentToDisney && car.x >= 520 && car.x <= 750 &&
           car.y >= 220 && car.y <= 400) {
                        String cl = crashList.getText();
                        
                        wentToDisney = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Disneyland");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Disneyland");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Disneyland");
        }
        
        if(!(car.x >= 520 && car.x <= 750 &&
           car.y >= 220 && car.y <= 400)) {
            wentToDisney = false;
        }

        if(!wentToKnotts && car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 200) {
                        String cl = crashList.getText();
                        
                        wentToKnotts = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Knotts Berry Farm");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Knotts Berry Farm");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Knotts Berry Farm");
        }
        
        if(!(car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 200)) {
            wentToKnotts = false;
        }

        if(!wentToPark1 && car.x >= 520 && car.x <= 750 &&
           car.y >= 420 && car.y <= 600) {
                        String cl = crashList.getText();
                        
                        wentToPark1 = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Park");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Park");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Park");
        }
        
        if(!(car.x >= 520 && car.x <= 750 &&
           car.y >= 420 && car.y <= 600)) {
            wentToPark1 = false;
        }

        if(!wentToPark2 && car.x >= 520 && car.x <= 750 &&
           car.y >= 420 && car.y <= 600) {
                        String cl = crashList.getText();
                        
                        wentToPark2 = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Park");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Park");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Park");
        }
        
        if(!(car.x >= 770 && car.x <= 960 &&
           car.y >= 620 && car.y <= 760)) {
            wentToPark2 = false;
        }

        g.setColor(Color.white);
        
        g.drawString("Knotts Berry Farm", 70, 120);
        g.drawString("Chinese Food", 310, 120);
        g.drawString("El Burrito", 610, 120);
        g.drawString("Bus Station", 810, 120);
        g.drawString("Middle School", 310, 300);
        g.drawString("Disneyland", 570, 290);
        g.drawString("Library", 790, 300);
        g.drawString("Community College", 820, 350);
        g.drawString("Library", 40, 300);
        g.drawString("Liquor Store", 40, 500);
        g.drawString("Market", 310, 500);
        g.drawString("Park", 550, 500);
        g.drawString("High School", 820, 500);
        g.drawString("Park", 40, 700);
        g.drawString("Library", 310, 700);
        g.drawString("Excalibur", 570, 700);
        g.drawString("Park", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public void drawArtLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.fillRect(20, 20, 105, 180);
        g.fillRect(145, 20, 105, 180);
        
        g.setColor(Color.green);
        g.fillRect(520, 420, 105, 180);
        g.fillRect(645, 420, 105, 180);
        
        if(!wentToArtesiaPark && car.x >= 520 && car.x <= 750 &&
           car.y >= 420 && car.y <= 600) {
                        String cl = crashList.getText();
                        
                        wentToArtesiaPark = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Park");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Park");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to park");
        }
        
        if(!(car.x >= 520 && car.x <= 750 &&
           car.y >= 420 && car.y <= 600)) {
            wentToArtesiaPark = false;
        }
        
        g.setColor(Color.white);
        
        g.drawString("Elementary School", 70, 120);
        g.drawString("Market", 310, 120);
        g.drawString("Tidal Wave", 610, 120);
        g.drawString("Downtown", 810, 120);
        g.drawString("Bus Station", 310, 300);
        g.drawString("Mini Golf", 570, 290);
        g.drawString("Taxi Station", 790, 300);
        g.drawString("El Burrito", 820, 350);
        g.drawString("Movie Theater", 40, 300);
        g.drawString("Liquor Store", 40, 500);
        g.drawString("Supermarket", 310, 500);
        g.drawString("Park", 550, 500);
        g.drawString("Middle School", 820, 500);
        g.drawString("Library", 40, 700);
        g.drawString("High School", 310, 700);
        g.drawString("Community College", 570, 700);
        g.drawString("Supermarket", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public void drawPasaLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.magenta);
        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.fillRect(20, 20, 105, 180);
        g.fillRect(145, 20, 105, 180);
        
        g.setColor(Color.green);
        g.fillRect(270, 220, 105, 180);
        g.fillRect(395, 220, 105, 180);
        

        g.setColor(Color.white);
        
        g.drawString("Cal Tech", 70, 120);
        g.drawString("Middle School", 310, 120);
        g.drawString("Market", 610, 120);
        g.drawString("Rose Bowl", 810, 120);
        g.drawString("Park", 310, 300);
        g.drawString("Market", 570, 290);
        g.drawString("Pasadena City College", 790, 300);
        g.drawString("AMC Theater", 820, 350);
        g.drawString("High School", 40, 300);
        g.drawString("Market", 40, 500);
        g.drawString("Gun Shop", 310, 500);
        g.drawString("Ice Cream Shoppe", 550, 500);
        g.drawString("Mall", 820, 500);
        g.drawString("Park", 40, 700);
        g.drawString("Elementary School", 310, 700);
        g.drawString("Market", 570, 700);
        g.drawString("Reservoir", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public void drawPomoLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.GRAY);
        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.fillRect(770, 20, 105, 180);
        g.fillRect(895, 20, 65, 180);
        
        g.setColor(Color.PINK);

        g.fillRect(270, 420, 105, 180);
        g.fillRect(395, 420, 105, 180);

        g.setColor(Color.green);
        g.fillRect(270, 220, 105, 180);
        g.fillRect(395, 220, 105, 180);
        

        g.setColor(Color.white);
        
        g.drawString("Market", 70, 120);
        g.drawString("Middle School", 310, 120);
        g.drawString("Library", 610, 120);
        g.drawString("Fairplex", 810, 120);
        g.drawString("Park", 310, 300);
        g.drawString("Liquor Store", 570, 290);
        g.drawString("AMC Theater", 820, 350);
        g.drawString("High School", 40, 300);
        g.drawString("Market", 40, 500);
        g.drawString("Cal Poly Pomona", 310, 500);
        g.drawString("Elementary School", 550, 500);
        g.drawString("Liquor Store", 820, 500);
        g.drawString("Adult Shop", 40, 700);
        g.drawString("Park", 310, 700);
        g.drawString("Market", 570, 700);
        g.drawString("Tennis Court", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    boolean wentToArtesiaPark = false;
    
    public void drawLALabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.BLUE);
        g.fillRect(20, 20, 105, 180);
        g.fillRect(145, 20, 105, 180);

        g.setColor(Color.white);
        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        if(!wentToUCLA && car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 250) {
                        String cl = crashList.getText();
                        
                        wentToUCLA = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("UCLA");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "UCLA");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to UCLA");
        }
        
        if(!(car.x >= 20 && car.x <= 250 &&
           car.y >= 20 && car.y <= 250)) {
            wentToUCLA = false;
        }

        g.drawString("UCLA", 70, 120);
        g.drawString("Griffit Park", 310, 120);
        g.drawString("Koreatown", 610, 120);
        g.drawString("Chinatown", 810, 120);
        g.drawString("Donut Shop", 310, 300);
        g.drawString("Little Tokyo", 570, 290);
        g.drawString("Downtown", 790, 300);
        g.drawString("LA Trade Tech", 820, 350);
        g.drawString("AMC Theater", 40, 300);
        g.drawString("Century City", 40, 500);
        g.drawString("Hannam Chain", 310, 500);
        g.drawString("Hanmi Bank", 550, 500);
        g.drawString("Pink's", 820, 500);
        g.drawString("Hot Wings Cafe", 40, 700);
        g.drawString("Golf", 310, 700);
        g.drawString("Country Club", 570, 700);
        g.drawString("Beverly Connection", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }
    
    boolean wentToUCLA = false;

    boolean wentToChinoState = false;

    public void drawChinoLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.YELLOW);
        g.fillRect(770, 20, 105, 180);
        g.fillRect(895, 20, 105, 180);

        g.setColor(Color.white);

        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        if(!wentToChinoState && car.x >= 770 && car.x <= 960 &&
           car.y >= 20 && car.y <= 250) {
                        String cl = crashList.getText();
                        
                        wentToChinoState = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("CSU Chino");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "CSU Chino");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Chino");
        }
        
        if(!(car.x >= 770 && car.x <= 960 &&
           car.y >= 20 && car.y <= 250)) {
            wentToChinoState = false;
        }
        
        g.drawString("Cows", 70, 120);
        g.drawString("Farm", 310, 120);
        g.drawString("Market", 610, 120);
        g.drawString("CSU Chino", 810, 120);
        g.drawString("AMC Theater", 310, 300);
        g.drawString("Mall", 570, 290);
        g.drawString("Liquor Store", 790, 300);
        g.drawString("Water Tower", 820, 350);
        g.drawString("Water Pump", 40, 300);
        g.drawString("Oil Pump", 40, 500);
        g.drawString("Market", 310, 500);
        g.drawString("Liquor Store", 550, 500);
        g.drawString("Park", 820, 500);
        g.drawString("Junior High", 40, 700);
        g.drawString("Elementary School", 310, 700);
        g.drawString("Library", 570, 700);
        g.drawString("Market", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public void drawCities() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.blue);
        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.drawString("L.A.", 70, 120);
        g.drawString("EAST L.A.", 310, 120);
        g.drawString("POMONA", 610, 120);
        g.drawString("ARTESIA", 810, 120);
        g.drawString("PICO RIVERA", 310, 300);
        g.drawString("PASADENA", 570, 290);
        g.drawString("MONTEREY", 790, 300);
        g.drawString("PARK", 820, 350);
        g.drawString("CAMPTON", 40, 300);
        g.drawString("SOUTH L.A.", 40, 500);
        g.drawString("CORONA", 310, 500);
        g.drawString("RIVERSIDE", 550, 500);
        g.drawString("CHINO", 820, 500);
        g.drawString("SAN PEDRO", 40, 700);
        g.drawString("ANAHEIM", 310, 700);
        g.drawString("SAN DIEGO", 570, 700);
        g.drawString("TEMECULA", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    boolean wentToPE = false;
    
    public void drawTemeculaLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(new Color(212, 175, 55));
        g.fillRect(20, 420, 105, 180);
        g.fillRect(145, 420, 105, 180);

        g.setColor(Color.black);
        g.drawString("Temecula PKWY", 20, 420);
        
        g.setColor(Color.white);
        
        if(!wentToPE && car.x >= 20 && car.x <= 250 &&
           car.y >= 420 && car.y <= 600) {
                        String cl = crashList.getText();
                        
                        wentToPE = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Pechanga");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Pechanga");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Pechanga Casion to gamble~.");
        }
        
        if(!(car.x >= 20 && car.x <= 250 &&
           car.y >= 420 && car.y <= 600)) {
            wentToPE = false;
        }

        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.drawString("Market", 70, 120);
        g.drawString("Horsetrack", 310, 120);
        g.drawString("Indian Reservation", 610, 120);
        g.drawString("Mini Mart", 810, 120);
        g.drawString("Park", 310, 300);
        g.drawString("Middle School", 570, 290);
        g.drawString("High School", 790, 300);
        g.drawString("Park", 820, 350);
        g.drawString("Hospital", 40, 300);
        g.drawString("Pechanga", 40, 500);
        g.drawString("Library", 310, 500);
        g.drawString("Market", 550, 500);
        g.drawString("Supermarket", 820, 500);
        g.drawString("Mini Market", 40, 700);
        g.drawString("Library", 310, 700);
        g.drawString("Park", 570, 700);
        g.drawString("Sea World", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }
    
    public boolean wentToUCSD = false;
    public boolean wentToSeaWorld = false;

    public void drawSanLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.BLUE);
        g.fillRect(770, 420, 105, 180);
        g.fillRect(895, 420, 105, 180);

        g.setColor(Color.PINK);
        g.fillRect(770, 620, 105, 180);
        g.fillRect(895, 620, 105, 180);

        if(!wentToUCSD && car.x >= 770 && car.x <= 960 &&
           car.y >= 620 && car.y <= 760) {
                        String cl = crashList.getText();
                        
                        wentToUCSD = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("UCSD");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "UCSD");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to UCSD");
        }

        if(!(car.x >= 770 && car.x <= 960 &&
           car.y >= 620 && car.y <= 760)) {
            wentToUCSD = false;
        }

        if(!wentToSeaWorld && car.x >= 770 && car.x <= 960 &&
           car.y >= 420 && car.y <= 600) {
                        String cl = crashList.getText();
                        
                        wentToSeaWorld = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Sea World");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Sea World");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to Sea World");
        }

        if(!(car.x >= 770 && car.x <= 960 &&
           car.y >= 420 && car.y <= 600)) {
            wentToSeaWorld = false;
        }

        g.setColor(Color.white);
        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.drawString("Market", 70, 120);
        g.drawString("Horsetrack", 310, 120);
        g.drawString("Indian Reservation", 610, 120);
        g.drawString("Mini Mart", 810, 120);
        g.drawString("Park", 310, 300);
        g.drawString("Middle School", 570, 290);
        g.drawString("High School", 790, 300);
        g.drawString("Park", 820, 350);
        g.drawString("Hospital", 40, 300);
        g.drawString("Market", 40, 500);
        g.drawString("Library", 310, 500);
        g.drawString("Market", 550, 500);
        g.drawString("Sea World", 820, 500);
        g.drawString("Mini Market", 40, 700);
        g.drawString("Library", 310, 700);
        g.drawString("Park", 570, 700);
        g.drawString("UC San Diego", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public boolean wentToLiquorStore = false;
    public boolean wentToGunShop = false;

    public void drawSCLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.BLUE);
        g.fillRect(770, 620, 105, 180);
        g.fillRect(895, 620, 105, 180);

        g.setColor(Color.PINK);
        g.fillRect(770, 420, 105, 180);
        g.fillRect(895, 420, 105, 180);

        if(!wentToLiquorStore && car.x >= 770 && car.x <= 960 &&
           car.y >= 420 && car.y <= 600) {
                        String cl = crashList.getText();
                        
                        wentToLiquorStore = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Gun Shop");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Gun Shop");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to a Gun Shop");
        }

        if(!(car.x >= 770 && car.x <= 960 &&
           car.y >= 420 && car.y <= 600)) {
            wentToLiquorStore = false;
        }

        if(!wentToGunShop && car.x >= 770 && car.x <= 960 &&
           car.y >= 620 && car.y <= 760) {
                        String cl = crashList.getText();
                        
                        wentToGunShop = true;

            if(cl.equals("") || cl == null)
                            {
                                crashList.setText("Liquor Store");
                            }
                            else if(!cl.equals(""))
                            {
                                crashList.setText(cl 
                                        + System.getProperty("line.separator")
                                        + "Liquor Store");
                            }
            
            fines += 10000;
            
            JOptionPane.showMessageDialog(null, "You went to a Liquor Store");
        }

        if(!(car.x >= 770 && car.x <= 960 &&
           car.y >= 620 && car.y <= 760)) {
            wentToGunShop = false;
        }

        g.setColor(Color.white);
        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.drawString("Market", 70, 120);
        g.drawString("Horsetrack", 310, 120);
        g.drawString("Indian Reservation", 610, 120);
        g.drawString("Mini Mart", 810, 120);
        g.drawString("Park", 310, 300);
        g.drawString("Middle School", 570, 290);
        g.drawString("High School", 790, 300);
        g.drawString("Park", 820, 350);
        g.drawString("Hospital", 40, 300);
        g.drawString("Market", 40, 500);
        g.drawString("Library", 310, 500);
        g.drawString("Market", 550, 500);
        g.drawString("Gun Shop", 820, 500);
        g.drawString("Mini Market", 40, 700);
        g.drawString("Library", 310, 700);
        g.drawString("Park", 570, 700);
        g.drawString("Liquor Store", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public void drawMPLabels() {
        try {
        Graphics g = panel.getGraphics();
        
        g.setColor(Color.white);
        
        g.setFont(new Font("Curlz MT", Font.ITALIC, 29));

        g.drawString("Market", 70, 120);
        g.drawString("Chinese Food", 310, 120);
        g.drawString("Szechwan Food", 610, 120);
        g.drawString("Mini Mart", 810, 120);
        g.drawString("Park", 310, 300);
        g.drawString("Middle School", 570, 290);
        g.drawString("High School", 790, 300);
        g.drawString("Park", 820, 350);
        g.drawString("Hospital", 40, 300);
        g.drawString("Market", 40, 500);
        g.drawString("Library", 310, 500);
        g.drawString("Market", 550, 500);
        g.drawString("Jewelry Store", 820, 500);
        g.drawString("Quick E Mart", 40, 700);
        g.drawString("Library", 310, 700);
        g.drawString("Park", 570, 700);
        g.drawString("Liquor Store", 780, 700);
 
        } catch(Exception e) {frame.dispose();}   
    }

    public boolean enemyIsCollided() {
        try {
            if(enemy.direction.equals("left") || enemy.direction.equals("right")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.direction.equals("right")) {
                        if(car.x+car.width >= enemy.x && car.x+car.width <= enemy.x + enemy.width) {
                            if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("left")) {
                        if(car.x+car.width >= enemy.x && car.x+car.width <= enemy.x + enemy.width) {
                            if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                                return true;
                            }
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.direction.equals("down")) {
                        if(car.x+car.width >= enemy.x && car.x+car.width <= enemy.x + enemy.width) {
                            if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("up")) {
                        if(car.x+car.width >= enemy.x && car.x+car.width <= enemy.x + enemy.width) {
                            if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                                return true;
                            }
                        }
                    }
                }
            }
            if(enemy.direction.equals("up") || enemy.direction.equals("down")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.x >= enemy.x && car.x <= enemy.x + enemy.width) {
                        if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                            return true;
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.x >= enemy.x && car.x <= enemy.x + enemy.width) {
                        if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                            return true;
                        }
                    }
                }
            }
        } catch(Exception e) {
            
        }
        return false;
    }

    public boolean enemy5IsCollided() {
        try {
            if(enemy.direction.equals("left") || enemy.direction.equals("right")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.direction.equals("right")) {
                        if(car.x+car.width >= enemy.x && car.x+car.width <= enemy.x + enemy.width) {
                            if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("left")) {
                        if(car.x+car.width >= enemy.x && car.x+car.width <= enemy.x + enemy.width) {
                            if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                                return true;
                            }
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.direction.equals("down")) {
                        if(car.x+car.width >= enemy.x && car.x+car.width <= enemy.x + enemy.width) {
                            if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("up")) {
                        if(car.x+car.width >= enemy.x && car.x+car.width <= enemy.x + enemy.width) {
                            if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                                return true;
                            }
                        }
                    }
                }
            }
            if(enemy.direction.equals("up") || enemy.direction.equals("down")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.x >= enemy.x && car.x <= enemy.x + enemy.width) {
                        if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                            return true;
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.x >= enemy.x && car.x <= enemy.x + enemy.width) {
                        if(car.y >= enemy.y && car.y <= enemy.y + enemy.height) {
                            return true;
                        }
                    }
                }
            }
        } catch(Exception e) {
            
        }
        return false;
    }
    
    public boolean enemy6IsCollided() {
        try {
            if(enemy6.direction.equals("left") || enemy6.direction.equals("right")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.direction.equals("right")) {
                        if(car.x+car.width >= enemy6.x && car.x+car.width <= enemy6.x + enemy6.width) {
                            if(car.y >= enemy6.y && car.y <= enemy6.y + enemy6.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("left")) {
                        if(car.x+car.width >= enemy6.x && car.x+car.width <= enemy6.x + enemy6.width) {
                            if(car.y >= enemy6.y && car.y <= enemy6.y + enemy6.height) {
                                return true;
                            }
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.direction.equals("down")) {
                        if(car.x+car.width >= enemy6.x && car.x+car.width <= enemy6.x + enemy6.width) {
                            if(car.y >= enemy6.y && car.y <= enemy6.y + enemy6.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("up")) {
                        if(car.x+car.width >= enemy6.x && car.x+car.width <= enemy6.x + enemy6.width) {
                            if(car.y >= enemy6.y && car.y <= enemy6.y + enemy6.height) {
                                return true;
                            }
                        }
                    }
                }
            }
            if(enemy6.direction.equals("up") || enemy6.direction.equals("down")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.x >= enemy6.x && car.x <= enemy6.x + enemy6.width) {
                        if(car.y >= enemy6.y && car.y <= enemy6.y + enemy6.height) {
                            return true;
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.x >= enemy6.x && car.x <= enemy6.x + enemy6.width) {
                        if(car.y >= enemy6.y && car.y <= enemy6.y + enemy6.height) {
                            return true;
                        }
                    }
                }
            }
        } catch(Exception e) {
            
        }
        return false;
    }

    public boolean enemy2IsCollided() {
        try {
            if(enemy2.direction.equals("left") || enemy2.direction.equals("right")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.direction.equals("right")) {
                        if(car.x+car.width >= enemy2.x && car.x+car.width <= enemy2.x + enemy2.width) {
                            if(car.y >= enemy2.y && car.y <= enemy2.y + enemy2.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("left")) {
                        if(car.x+car.width >= enemy2.x && car.x+car.width <= enemy2.x + enemy2.width) {
                            if(car.y >= enemy2.y && car.y <= enemy2.y + enemy2.height) {
                                return true;
                            }
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.direction.equals("down")) {
                        if(car.x+car.width >= enemy2.x && car.x+car.width <= enemy2.x + enemy2.width) {
                            if(car.y >= enemy2.y && car.y <= enemy2.y + enemy2.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("up")) {
                        if(car.x+car.width >= enemy2.x && car.x+car.width <= enemy2.x + enemy2.width) {
                            if(car.y >= enemy2.y && car.y <= enemy2.y + enemy2.height) {
                                return true;
                            }
                        }
                    }
                }
            }
            if(enemy2.direction.equals("up") || enemy2.direction.equals("down")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.x >= enemy2.x && car.x <= enemy2.x + enemy2.width) {
                        if(car.y >= enemy2.y && car.y <= enemy2.y + enemy2.height) {
                            return true;
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.x >= enemy2.x && car.x <= enemy2.x + enemy2.width) {
                        if(car.y >= enemy2.y && car.y <= enemy2.y + enemy2.height) {
                            return true;
                        }
                    }
                }
            }
        } catch(Exception e) {
            
        }
        return false;
    }

    public boolean enemy3IsCollided() {
        try {
            if(enemy3.direction.equals("left") || enemy3.direction.equals("right")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.direction.equals("right")) {
                        if(car.x+car.width >= enemy3.x && car.x+car.width <= enemy3.x + enemy3.width) {
                            if(car.y >= enemy3.y && car.y <= enemy3.y + enemy3.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("left")) {
                        if(car.x+car.width >= enemy3.x && car.x+car.width <= enemy3.x + enemy3.width) {
                            if(car.y >= enemy3.y && car.y <= enemy3.y + enemy3.height) {
                                return true;
                            }
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.direction.equals("down")) {
                        if(car.x+car.width >= enemy3.x && car.x+car.width <= enemy3.x + enemy3.width) {
                            if(car.y >= enemy3.y && car.y <= enemy3.y + enemy3.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("up")) {
                        if(car.x+car.width >= enemy3.x && car.x+car.width <= enemy3.x + enemy3.width) {
                            if(car.y >= enemy3.y && car.y <= enemy3.y + enemy3.height) {
                                return true;
                            }
                        }
                    }
                }
            }
            if(enemy3.direction.equals("up") || enemy3.direction.equals("down")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.x >= enemy3.x && car.x <= enemy3.x + enemy3.width) {
                        if(car.y >= enemy3.y && car.y <= enemy3.y + enemy3.height) {
                            return true;
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.x >= enemy3.x && car.x <= enemy3.x + enemy3.width) {
                        if(car.y >= enemy3.y && car.y <= enemy3.y + enemy3.height) {
                            return true;
                        }
                    }
                }
            }
        } catch(Exception e) {
            
        }
        return false;
    }

    public boolean enemy4IsCollided() {
        try {
            if(enemy4.direction.equals("left") || enemy4.direction.equals("right")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.direction.equals("right")) {
                        if(car.x+car.width >= enemy4.x && car.x+car.width <= enemy4.x + enemy4.width) {
                            if(car.y >= enemy4.y && car.y <= enemy4.y + enemy4.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("left")) {
                        if(car.x+car.width >= enemy4.x && car.x+car.width <= enemy4.x + enemy4.width) {
                            if(car.y >= enemy4.y && car.y <= enemy4.y + enemy4.height) {
                                return true;
                            }
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.direction.equals("down")) {
                        if(car.x+car.width >= enemy4.x && car.x+car.width <= enemy4.x + enemy4.width) {
                            if(car.y >= enemy4.y && car.y <= enemy4.y + enemy4.height) {
                                return true;
                            }
                        }
                    }
                    if(car.direction.equals("up")) {
                        if(car.x+car.width >= enemy4.x && car.x+car.width <= enemy4.x + enemy4.width) {
                            if(car.y >= enemy4.y && car.y <= enemy4.y + enemy4.height) {
                                return true;
                            }
                        }
                    }
                }
            }
            if(enemy4.direction.equals("up") || enemy4.direction.equals("down")) {
                if(car.direction.equals("left") || car.direction.equals("right")) {
                    if(car.x >= enemy4.x && car.x <= enemy4.x + enemy4.width) {
                        if(car.y >= enemy4.y && car.y <= enemy4.y + enemy4.height) {
                            return true;
                        }
                    }
                }
                if(car.direction.equals("up") || car.direction.equals("down")) {
                    if(car.x >= enemy4.x && car.x <= enemy4.x + enemy4.width) {
                        if(car.y >= enemy4.y && car.y <= enemy4.y + enemy4.height) {
                            return true;
                        }
                    }
                }
            }
        } catch(Exception e) {
            
        }
        return false;
    }

    public void drawCar() {
        try {
            Graphics g = panel.getGraphics();
            g.setColor(car.color);
            g.fillRect(car.x, car.y, car.width, car.height);
            g.dispose();
        } catch(Exception e) {frame.dispose();}
    }
    
    public void drawPotholes() {
        try {
            Graphics g = panel.getGraphics();
            g.setColor(Color.magenta);
            for(int i=0; i<potholes.size(); i++) {
                g.fillRect(potholes.get(i).x, potholes.get(i).y, potholes.get(i).width, potholes.get(i).width);
            }
            g.dispose();
        } catch(Exception e) {frame.dispose();}
    }

    class Car {
        int x, y;
        int width;
        int height;
        Color color;
        String direction;
        String brand;
        int fine;
        int timer;
        int speed;
        
        Car() {
            speed = 5;
            timer = 0;
            x = 105;
            y = 5;
            width = 20;
            height = 10;
            color = Color.RED;
            brand = "Tatoyo";
            fine = 3000;
        }
        
        void moveDown() {
            if(itsOkay()) {
                width = 10;
                height = 20;
                y+=speed;
                direction = "down";
            }
        }

        void moveUp() {
            if(itsOkay()) {
                width = 10;
                height = 20;
                y-=speed;
                direction = "up";
            }
        }

        void moveRight() {
            if(itsOkay()) {
                width = 20;
                height = 10;
                x+=speed;
                direction = "right";
            }
        }

        void moveLeft() {
            if(itsOkay()) {
                width = 20;
                height = 10;
                x-=speed;
                direction = "left";
            }
        }
    }
    
    class Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(Color.red);

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }
    
    class Pasadena_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class LA_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class Riverside_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class SLA_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }
    
    class MP_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class ELA_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class SanPedro_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class C_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class Anaheim_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class SanDiego_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class Artesia_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class Pomona_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class Chino_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class Temecula_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    class SC_Map {
        Color backColor = new Color(240, 231, 201);
        Color lane = Color.GRAY;
        Color line = Color.WHITE;
        
        void drawMap() {
            Graphics g = panel.getGraphics();

            try {
                g.setColor(new Color(128,0,128));

                g.fillRect(0, 0, 1000, 800);

                g.setColor(Color.GRAY);

                g.fillRect(0, 0, 1000, 20);
                g.fillRect(0, 200, 1000, 20);
                g.fillRect(0, 400, 1000, 20);
                g.fillRect(0, 600, 1000, 20);
                g.fillRect(0, 740, 1000, 20);

                g.fillRect(0, 0, 20, 800);
                g.fillRect(125, 0, 20, 800);
                g.fillRect(250, 0, 20, 800);
                g.fillRect(375, 0, 20, 800);
                g.fillRect(500, 0, 20, 800);
                g.fillRect(625, 0, 20, 800);
                g.fillRect(750, 0, 20, 800);
                g.fillRect(875, 0, 20, 800);
                g.fillRect(960, 0, 20, 800);

                g.setColor(Color.WHITE);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 10, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 410, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 750, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(385, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(510, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(635, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(970, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 210, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(2*i, 610, 5, 1);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(10, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(135, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(260, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(760, 2*i, 1, 5);
                for(int i=0; i<=500; i+=5)
                    g.drawRect(885, 2*i, 1, 5);

                g.dispose();
            } catch(Exception e) {frame.dispose();}
        }
    }

    public void drawMap() {
        map.drawMap();
    }
 
    public void run() {
        GoAroundi goAroundi = new GoAroundi();
        goAroundi.frame.dispose();
    }
    
    public static void main(String args[]) {
        
        Thread t = new Thread(new GoAroundi());
        t.start();
    }
}