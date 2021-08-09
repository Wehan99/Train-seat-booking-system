import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;



import com.sun.deploy.util.ArrayUtil;
        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.GridPane;
        import javafx.scene.text.Font;
        import javafx.scene.text.FontPosture;
        import javafx.scene.text.FontWeight;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

        import java.io.*;
        import java.util.ArrayList;
        import java.util.Scanner;



        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.GridPane;
        import javafx.scene.text.Font;
        import javafx.scene.text.FontPosture;
        import javafx.scene.text.FontWeight;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

        import java.io.*;
        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Scanner;


public class Main extends Application {
    static final int SEATING_CAPACITY = 42;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String[] seats = new String[SEATING_CAPACITY];                     //declaring 2 arrays
        String[] seats2 = new String[SEATING_CAPACITY];
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("            **********************************************************************");
        System.out.println("            ++++++   WELCOME TO DENUWARA MENIKE TRAIN SEAT BOOKING SYSTEM   ++++++");
        System.out.println("            **********************************************************************");
        System.out.println();
        menu:
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("    <>  Enter V to view all  seats ");
            System.out.println("    <>  Enter S to store programme data ");                    //getting a input to userinput
            System.out.println("    <>  Enter E to view all empty seats ");
            System.out.println("    <>  Enter D to delete customer from seat  ");
            System.out.println("    <>  Enter F to Find the seat for a given customers name ");
            System.out.println("    <>  Enter O to View seats Ordered alphabetically by name");
            System.out.println("    <>  Enter A to add a customer ");
            System.out.println("    <>  Enter L to Load programme data from file ");
            System.out.println("    <>  Enter Q to quit the programme  ");
            System.out.print("       *  Please select an option : ");
            String userinput = sc.next();
            System.out.println();
            switch (userinput) {
                case "V":
                case "v":
                    viewAllSeats(seats, seats2);
                    break;
                case "S":
                case "s":
                    storeProgrammeData(seats, seats2);              //selecting the user input to matching method
                    break;
                case "E":
                case "e":
                    viewAllEmptySeats(seats, seats2);
                    break;
                case "A":
                case "a":
                    addCustomer(seats, seats2);
                    break;


                case "D":
                case "d":
                    deleteCustomerData(seats, seats2);
                    break;


                case "L":
                case "l":
                    loadProgramme(seats, seats2);
                    break;

                case "O":
                case "o":
                    viewAlphabeticallyName(seats, seats2);
                    break;
                case "F":
                case "f":
                    findSeatByCustomer(seats, seats2);
                    break;
                case "Q":
                case "q":


                    System.exit(0);

                default:
                    System.out.println("Invalid");
                    System.out.println();
            }
        }
    }


    private static void findSeatByCustomer(String[] seats, String[] seats2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name you should want to find the seat : ");                  //asking which seat shoul find
        String name = sc.next();
        int index;

        for (int n = 0; n < seats.length; n++) {
            if (name.equals(seats[n])) {
                index = n + 1;                                                                              //equaling and find correct seat user input to 1st array
                System.out.println(name + " has booked the seat " + index + " from Colombo to Badulla");
                System.out.println();
            }
        }


        for (int n = 0; n < seats.length; n++) {
            if (name.equals(seats2[n])) {
                index = n + 1;
                System.out.println(name + " has booked the seat " + index + " from Badulla to Colombo");            //equaling and find correct seat user input to 1st array
                System.out.println();

            }

        }


    }




    private static void viewAlphabeticallyName(String[] seats, String[] seats2) {            //view passenger's name alphabetically
        //declare a new array for names in seats array
        //count= assigning how many passenger has booked a seat
        int count = 0;
        int j = 0;

        for (int i = 0; i < 42; i++) {
            if (seats[i] != null) {
                count++;
            }
        }
        String[] alp = new String[count];
        for (int i = 0; i < 42; i++) {
            if (seats[i] != null) {
                alp[j] = seats[i];
                j++;
            }
        }

        String t;

        for (int i = 0; i < count - 1; i++) {
            for (j = 0; j < (count - 1) - i; j++) {
                if (alp[j].compareTo(alp[j + 1]) > 0) {
                    t = alp[j];
                    alp[j] = alp[j + 1];
                    alp[j + 1] = t;
                }
            }
        }
        System.out.println("Colombo to Badulla passenger's names in alphabetically");
        for (int i = 0; i < count; i++) {
            System.out.println("- "+alp[i]);
        }
        System.out.println();


        //declare a new array for names in seats2 array
        //count= assigning how many passenger has booked a seat
        int count2 = 0;
        int k=0;


        for (int i = 0; i < 42; i++) {
            if (seats2[i] != null) {
                count2++;
            }
        }
        String[] alp2 = new String[count2];
        for (int i = 0; i < 42; i++) {
            if (seats2[i] != null) {
                alp2[k] = seats2[i];
                k++;
            }
        }

        String u;
        for (int i = 0; i < count2 - 1; i++) {
            for (k= 0; k< (count2 - 1) - i; k++) {
                if (alp2[k].compareTo(alp2[k + 1]) > 0) {
                    u = alp2[k];
                    alp2[k] = alp2[k + 1];
                    alp2[k + 1] = u;
                }
            }
        }
        System.out.println("Badulla to Colombo  passenger's names in alphabetically");
        for (int i = 0; i < count2; i++) {
            System.out.println("- "+alp2[i]);
        }
        System.out.println();

    }


    private static void loadProgramme(String[] seats, String[] seats2) {
        BufferedReader objReader = null;
        int i = 0;
        try {
            String CurrentLine;

            objReader = new BufferedReader(new FileReader("E:\\seats.txt"));
            //reading text file
            while ((CurrentLine = objReader.readLine()) != null) {

                //storing the passengers name in to name variable
                String name = CurrentLine.substring(11, CurrentLine.length());
                if (!"null".equals(name)) {
                    //storing the passengers name in to seats array
                    seats[i] = name;
                }
                i++;
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        //reading data from seats2 text file
        int j = 0;
        try {
            String CurrentLine2;

            objReader = new BufferedReader(new FileReader("E:\\seats2.txt"));
            //reading text file
            while ((CurrentLine2 = objReader.readLine()) != null) {

                //storing the passengers name2 in to name variable
                String name2 = CurrentLine2.substring(11, CurrentLine2.length());
                if (!"null".equals(name2)) {
                    //storing the passengers name in to seats2 array
                    seats2[j] = name2;
                }
                j++;
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
        System.out.println("Programme Data Loaded !");
        System.out.println();
    }


    private static void deleteCustomerData(String[] seats, String[] seats2) {
        Scanner scc = new Scanner(System.in);
        System.out.println("Enter 1 to delete a seat from Colombo to Badulla :");
        System.out.println("Enter 2 to delete a seat from Badulla to Colombo :");            //asking which route seat you want to delete
        try {
            int trip = scc.nextInt();
            if (trip == 1) {                                                            //delete a seat from colombo to Badulla
                boolean value = Boolean.TRUE;
                while (value) {
                    int passenger;
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter the number of the seat you should want to delete : ");      //asking what seat should delete
                    try {
                        passenger = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        continue;                                                               //checking that seat booking and deleting
                    }
                    if (passenger < 1 || passenger > SEATING_CAPACITY) {
                        System.out.println("Invalid Input");
                        continue;
                    }
                    if (seats[passenger - 1] != null) {
                        value = false;
                        seats[passenger - 1] = null;
                        System.out.println("Booking Deleted !");
                        System.out.println();
                    } else {
                        value = false;
                        System.out.println("No Booking Found");
                    }
                }
            } else if (trip == 2) {
                boolean value = Boolean.TRUE;                                        //delete a seat from badulla to Colombo as same as above
                while (value) {
                    int passenger;
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter the number of the seat you should want to delete : ");
                    try {
                        passenger = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        continue;
                    }
                    if (passenger < 1 || passenger > SEATING_CAPACITY) {
                        System.out.println("Invalid Input");
                        continue;
                    }
                    if (seats2[passenger - 1] != null) {
                        value = false;
                        seats2[passenger - 1] = null;
                        System.out.println("Booking Deleted !");
                        System.out.println();
                    } else {
                        value = false;
                        System.out.println("No Booking Found");
                    }
                }
            } else {
                System.out.println("Invalid Input");
                System.out.println();

            }

        } catch (Exception e) {
            System.out.println("Invalid Input ! ");
        }
    }

    private String[] addCustomer(String[] seats, String[] seats2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to book a seat from Colombo to Badulla :");
        System.out.println("Enter 2 to book a seat from Badulla to Colombo :");         //asking which trip seat you want book
        try {
            int trip = sc.nextInt();
            int i = 0;
            int j=0;
            if (trip == 1) {

                System.out.println("Enter your name :");        //colombo to badulla process
                String name = sc.next();
                //to see if this passenger has booked a seat
                if(Arrays.asList(seats).contains(name)){
                    System.out.println("This passenger has already booked a seat");
                    System.out.println();
                    //if not add this customer
                }else {
                    Stage stage = new Stage();                              //adding buttons,gridpane and text to gui
                    Button[] button = new Button[42];
                    GridPane gridPane = new GridPane();
                    Text text1 = new Text("WELCOME TO DENUWARA MENIKE TRAIN SEAT BOOKING\n              * Click On The Seat You Want To Book *");
                    text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                    //exit button
                    Button confirm = new Button("CONFIRM");
                    confirm.setOnAction((Event) -> {
                        stage.close();
                    });
                    gridPane.add(confirm, 5, 23);


                    int z = 0;
                    while (z < 42) {
                        button[z] = new Button("Seat" + (z + 1));
                        button[z].setStyle("-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%); -fx-background-radius: 8,7,6; -fx-background-insets: 0,1,2; -fx-text-fill: black; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
                        int finalZ = z;
                        int finalZ2 = z;
                        if (seats[z] != null) {
                            button[z].setStyle("-fx-background-color:red;");    //adding button on actions
                            button[z].setDisable(true);

                        }
                        button[z].setOnAction((Event) -> {
                            seats[finalZ2] = name;


                            button[finalZ].setStyle("-fx-background-color:red;");
                            for (int k = 0; k < 42; k++) {
                                button[k].setDisable(true);
                            }

                        });
                        z++;
                    }

                    gridPane.setHgap(10);
                    gridPane.setVgap(10);

                    int btn = 0;
                    for (int x = 13; x < 20; x++) {
                        for (int y = 3; y < 9; y++) {
                            gridPane.add(button[btn++], y, x);
                        }
                    }

                    gridPane.add(text1, 5, 4);
                    Scene scene = new Scene(gridPane, 850, 480);
                    stage.setTitle("* New Passenger *");        //adding title
                    stage.setScene(scene);
                    stage.showAndWait();
                    return seats;

                }

            } else if (trip == 2) {
                System.out.println("Enter your  name :");
                String name = sc.next();                                    //same as above process
                //to see if this passenger has booked a seat
                if(Arrays.asList(seats2).contains(name)) {
                    System.out.println("This passenger has already booked a seat");
                    System.out.println();
                }else {
                    //if not add this customer
                    Stage stage = new Stage();
                    Button[] button = new Button[42];
                    GridPane gridPane = new GridPane();
                    Text text1 = new Text("WELCOME TO DENUWARA MENIKE TRAIN SEAT BOOKING\n              * Click On The Seat You Want To Book *");
                    text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

                    //exit button
                    Button confirm = new Button("CONFIRM");
                    confirm.setOnAction((Event) -> {
                        stage.close();
                    });
                    gridPane.add(confirm, 5, 23);

                    int z = 0;
                    while (z < 42) {
                        button[z] = new Button("Seat" + (z + 1));
                        button[z].setStyle("-fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%); -fx-background-radius: 8,7,6; -fx-background-insets: 0,1,2; -fx-text-fill: black; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
                        int finalZ = z;
                        int finalZ2 = z;
                        if (seats2[z] != null) {
                            button[z].setStyle("-fx-background-color:red;");
                            button[z].setDisable(true);

                        }
                        button[z].setOnAction((Event) -> {
                            seats2[finalZ2] = name;

                            button[finalZ].setStyle("-fx-background-color:red;");
                            for (int k = 0; k < 42; k++) {
                                button[k].setDisable(true);
                            }

                        });
                        z++;
                    }

                    gridPane.setHgap(10);
                    gridPane.setVgap(10);

                    int btn = 0;
                    for (int x = 13; x < 20; x++) {
                        for (int y = 3; y < 9; y++) {
                            gridPane.add(button[btn++], y, x);
                        }
                    }
                    gridPane.add(text1, 5, 4);
                    Scene scene = new Scene(gridPane, 850, 480);
                    stage.setTitle("* New Passenger *");
                    stage.setScene(scene);
                    stage.showAndWait();
                }
            } else {
                System.out.println("Invalid input");
                System.out.println();
            }
            return seats2;
        } catch (Exception e) {
            System.out.println("Invalid Input !");
            System.out.println();
        }

        return seats;
    }


    private static void viewAllEmptySeats(String[] seats, String[] seats2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to view empty seats from Colombo to Badulla :");        //asking which trip you should want view empty seats
        System.out.println("Enter 2 to view empty seats from Badulla to Colombo :");
        try {
            int trip = sc.nextInt();
            if (trip == 1) {
                Stage stage = new Stage();
                Button[] button = new Button[42];
                GridPane gridPane = new GridPane();
                Text text1 = new Text("***   COLOMBO TO BADULLA EMPTY SEATS    ***");
                text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

                int z = 0;
                while (z < 42) {
                    button[z] = new Button("Seat" + (z + 1));

                    if (seats[z] != null) {                             //define booked seats
                        button[z].setDisable(true);

                    } else {
                        button[z].setStyle("-fx-background-color:green;");
                    }
                    //booked seats are red non-booked are green
                    z++;
                }

                gridPane.setHgap(10);
                gridPane.setVgap(10);
                int btn = 0;
                for (int x = 13; x < 20; x++) {
                    for (int y = 3; y < 9; y++) {
                        gridPane.add(button[btn++], y, x);              //grid pane, text, button adding to gui
                    }
                }
                gridPane.add(text1, 5, 4);
                Scene scene = new Scene(gridPane, 850, 480);
                stage.setScene(scene);
                stage.showAndWait();
            } else if (trip == 2) {
                Stage stage = new Stage();
                Button[] button = new Button[42];                                       //same as above process
                GridPane gridPane = new GridPane();
                Text text1 = new Text("***    BADULLA TO COLOMBO EMPTY SEATS    ***");
                text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

                int z = 0;
                while (z < 42) {
                    button[z] = new Button("Seat" + (z + 1));

                    if (seats2[z] != null) {
                        button[z].setDisable(true);

                    } else {
                        button[z].setStyle("-fx-background-color:green;");
                    }

                    z++;
                }

                gridPane.setHgap(10);
                gridPane.setVgap(10);
                int btn = 0;
                for (int x = 13; x < 20; x++) {
                    for (int y = 3; y < 9; y++) {
                        gridPane.add(button[btn++], y, x);
                    }
                }
                gridPane.add(text1, 5, 4);
                Scene scene = new Scene(gridPane, 850, 480);
                stage.setScene(scene);
                stage.showAndWait();
            } else {
                System.out.println("Invalid Input");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input !");
            System.out.println();
        }
    }

    private static void storeProgrammeData(String[] seats, String[] seats2) {
        try (PrintWriter out = new PrintWriter(new FileWriter("E:\\seats.txt"))) {
            int s;                                                                                         //store Colombo to Bdadulla bookings
            for (s =  0; s < SEATING_CAPACITY; s++) {
                if (s < 9) {
                    out.println("Seat  " + (s + 01) + " at " + seats[s]);

                } else {
                    out.println("Seat " + (s + 01) + " at " + seats[s]);
                }
            }
        } catch (Exception e) {
        }
        try (PrintWriter out = new PrintWriter(new FileWriter("E:\\seats2.txt"))) {
            int s;
            for (s = 0; s < SEATING_CAPACITY; s++) {                                                 //store Badulla to Colombo Booikngs

                if (s < 9) {
                    out.println("Seat  " + (s + 01) + " at " + seats2[s]);

                } else {
                    out.println("Seat " + (s + 01) + " at " + seats2[s]);
                }
            }
        } catch (Exception e) {

        }
        System.out.println("All seats have been saved");
        System.out.println();
    }

    private static void viewAllSeats(String[] seats, String[] seats2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to view all seats from Colombo to Badulla :");          //asking which trip you should want to view
        System.out.println("Enter 2 to view all seats from Badulla to Colombo :");
        try {
            int trip = sc.nextInt();
            if (trip == 1) {
                Stage stage = new Stage();
                Button[] button = new Button[42];
                GridPane gridPane = new GridPane();
                Text text1 = new Text("***    COLOMBO TO BADULLA ALL SEATS    ***");
                text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

                int z = 0;
                while (z < 42) {
                    button[z] = new Button("Seat" + (z + 1));

                    if (seats[z] != null) {
                        button[z].setStyle("-fx-background-color:red;");           //selecting booked or non booked seats

                    } else {
                        button[z].setStyle("-fx-background-color:green;");
                    }

                    z++;
                }

                gridPane.setHgap(10);
                gridPane.setVgap(10);
                int btn = 0;
                for (int x = 13; x < 20; x++) {                     //adding gridpane,buttons,text to gui
                    for (int y = 3; y < 9; y++) {
                        gridPane.add(button[btn++], y, x);
                    }
                }
                gridPane.add(text1, 5, 4);
                Scene scene = new Scene(gridPane, 850, 480);
                stage.setScene(scene);
                stage.showAndWait();
            } else if (trip == 2) {
                Stage stage = new Stage();
                Button[] button = new Button[42];                               //same as above process
                GridPane gridPane = new GridPane();
                Text text1 = new Text("***    BADULLA TO COLOMBO ALL SEATS   ***");
                text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));

                int z = 0;
                while (z < 42) {
                    button[z] = new Button("Seat" + (z + 1));

                    if (seats2[z] != null) {
                        button[z].setStyle("-fx-background-color:red;");

                    } else {
                        button[z].setStyle("-fx-background-color:green;");
                    }

                    z++;
                }

                gridPane.setHgap(10);
                gridPane.setVgap(10);
                int btn = 0;
                for (int x = 13; x < 20; x++) {
                    for (int y = 3; y < 9; y++) {
                        gridPane.add(button[btn++], y, x);
                    }
                }
                gridPane.add(text1, 5, 4);
                Scene scene = new Scene(gridPane, 850, 480);
                stage.setScene(scene);
                stage.showAndWait();

            } else {
                System.out.println("Invalid input");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input !");
            System.out.println();
        }

    }
}




