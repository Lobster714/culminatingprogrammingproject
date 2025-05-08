/**
* A system where you can create & read reviews on planets and calculate your distance to them
* Programmed by Sargon, Kyler, David, Tenzin, Kuthula
* Last edited: 8 May 2025 
* Last edited by: Kyler, Tenzin, David, Sargon
*/
import java.util.*;
import java.io.*;

public class Main {
    
    /**
     * Main method
     */
    public static void main(String[] args) throws IOException, InterruptedException
    {
        // Objects, constants, and variables
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in), inputFile;
        File myFile;
        Colors colors = new Colors();
        int lineCounter;
        final int NUM_OF_PLANET_DATA = 5;
        boolean ifSignedIn = false, ifWantToLeaveReview = false;
        String userInput, password, username, newUsername, newPassword;
        String[] planetDataTemp;
        Planet[] convertedPlanetData;
        String[][] planetReviews, planetRatings, planetData;
        ArrayList<String> accountInfo = new ArrayList<>();
        
        // Check if files exist
        checkFileExists("Planets.txt");
        checkFileExists("Usernames.txt");
        checkFileExists("Passwords.txt");
        checkFileExists("Reviews.txt");
        checkFileExists("AdminsList.txt");
        checkFileExists("Colors.java");
        
        // Convert planet data from text file to array
        planetData = readDataTwoDArray("Planets.txt", "@Γ", NUM_OF_PLANET_DATA);
        convertedPlanetData = convertTwodArrayToPlanetArray(planetData);
        
        //Convert review data from text file to array
        planetReviews = readDataTwoDArray
        
        //title message
        System.out.println(colors.ANSI_GREEN +"Welcome to the\n" + colors.ANSI_RESET);
        System.out.println("   ><<<<              ><<                   ><<         ><<                 ");
        System.out.println(" ><    ><<            ><<                   ><<   >< ><<   ><<              ");
        System.out.println("><<           ><<     ><<   ><<       ><<<><>< ><   ><<          ><<        ");
        System.out.println("><<         ><<  ><<  ><< ><<  ><<  ><<     ><<  ><<><<        ><<  ><<     ");
        System.out.println("><<   ><<<<><<   ><<  ><<><<   ><< ><<      ><<  ><<><<       ><<    ><<    ");
        System.out.println(" ><<    >< ><<   ><<  ><<><<   ><<  ><<     ><<  ><< ><<   ><< ><<  ><<     ");
        System.out.println("  ><<<<<     ><< ><<<><<<  ><< ><<<   ><<<   ><< ><<   ><<<<     ><<    ><< ");
        System.out.println("\n><<<<<<<   ><<                               ><<                            ");
        System.out.println("><<    ><< ><<                               ><<                            ");
        System.out.println("><<    ><< ><<   ><<    ><< ><<     ><<    ><>< ><   ><<    >< ><<<><<   ><<");
        System.out.println("><<<<<<<   ><< ><<  ><<  ><<  ><< ><   ><<   ><<   ><<  ><<  ><<    ><< ><< ");
        System.out.println("><<        ><<><<   ><<  ><<  ><<><<<<< ><<  ><<  ><<   ><<  ><<      ><<<  ");
        System.out.println("><<        ><<><<   ><<  ><<  ><<><          ><<  ><<   ><<  ><<       ><<  ");
        System.out.println("><<       ><<<  ><< ><<<><<<  ><<  ><<<<      ><<   ><< ><<<><<<      ><<   ");
        System.out.println("\n><<<<<<<                ><<                                                 ");
        System.out.println("><<    ><<              ><<   ><                                            ");
        System.out.println("><<    ><<     ><<    ><>< ><   ><< ><<     ><<                             ");
        System.out.println(">< ><<       ><<  ><<   ><<  ><< ><<  ><< ><<  ><<                          ");
        System.out.println("><<  ><<    ><<   ><<   ><<  ><< ><<  ><<><<   ><<                          ");
        System.out.println("><<    ><<  ><<   ><<   ><<  ><< ><<  ><< ><<  ><<                          ");
        System.out.println("><<      ><<  ><< ><<<   ><< ><<><<<  ><<     ><<                           ");
        System.out.println("                                           ><<                              ");
        System.out.println("\n><<<<<<<   ><<            ><<      ><<                                      ");
        System.out.println("><<    ><< ><<            ><<    ><                                         ");
        System.out.println("><<    ><< ><<   ><<    ><>< ><><>< ><   ><<    >< ><<<><<< ><< ><<         ");
        System.out.println("><<<<<<<   ><< ><<  ><<   ><<    ><<   ><<  ><<  ><<    ><<  ><  ><<        ");
        System.out.println("><<        ><<><<   ><<   ><<    ><<  ><<    ><< ><<    ><<  ><  ><<        ");
        System.out.println("><<        ><<><<   ><<   ><<    ><<   ><<  ><<  ><<    ><<  ><  ><<        ");
        System.out.println("><<       ><<<  ><< ><<<   ><<   ><<     ><<    ><<<   ><<<  ><  ><<        ");

        System.out.println(colors.ANSI_GREEN + "\nfor all of your planetary rating needs!" + colors.ANSI_RESET);
        // Home page / sign in page
        System.out.print("\n\nAre you a new user? Or do you have an account?\n");
        while (!ifSignedIn) {
            System.out.println("> CREATE ACCOUNT\n> LOG IN\n> EXIT");
            userInput = keyboard.nextLine();
            
            if (userInput.equalsIgnoreCase("EXIT")) {
                System.exit(0);
            }// end if statement
            
            else if (userInput.equalsIgnoreCase("CREATE ACCOUNT")) {
                // Send user to method createAccount
                accountInfo = createAccount();
                ifSignedIn = true;

            }// end else if statement
            else if (userInput.equalsIgnoreCase("LOG IN")) {
                // send user to method LogIn
                LogIn();
                ifSignedIn = true;

            }// end else if statement
            else {
                System.out.println("INVALID INPUT. PLEASE SELECT FROM THE LIST.");
            } // end else statement
        } // end while loop
        
        //menu once signed in
        
        
        //loop until user wants to leave
        //System.out.println("WELCOME, " + LogIn.getUsername() + "!");
        do{
            //reset variables from previous loops
            ifWantToLeaveReview = false;
            
            //present options
            System.out.println(colors.ANSI_BLUE + "\n\n\nOptions: " + colors.ANSI_RESET);
            System.out.println("\t1. View recommendations");
            System.out.println("\t2. Browse planets");
            System.out.println("\t3. View my ratings");
            System.out.println("\t4. View Unrated Planets");
            System.out.println("\t5. Log out");
            System.out.println("\t6. Shut down program");
            System.out.print(colors.ANSI_CYAN + "\nEnter your choice: " + colors.ANSI_RESET);
            userInput = keyboard.nextLine();
            
            if(userInput.equals("1") || userInput.equalsIgnoreCase("view recommendations")){
                //
            }//end if statement
            
            else if (userInput.equals("2") || userInput.equalsIgnoreCase("browse planets")) {
                //Print 10 random planets (prototype)
                for (int i = 0; i < 10; i++) {
                    System.out.println(convertedPlanetData[random.nextInt(planetData.length)]);
                    System.out.println("\n\n");
                }
            } // end else if
            
            else if (userInput.equals("3") || userInput.equalsIgnoreCase("view my ratings")) {
                // View user's ratings
            } // end else if
            
            else if (userInput.equals("4") || userInput.equalsIgnoreCase("view unrated planets")) {
                //View unrated planets
                System.out.println("\nEnter the planet you wish to review: ");
                userInput = keyboard.nextLine();
                
            } // end else if
            
            else if (userInput.equals("5") || userInput.equalsIgnoreCase("log out")) {
                // Log out of account & return to sign in page
                ifSignedIn = false;
                //save data
                //sign out
                mainCaller();
            } // end else if
            
            else if (userInput.equals("6") || userInput.equals("shut down program")){
                //shut down program
                //outro message
                System.out.println("\n\nThank you for using this program. Have a nice day.");
                //save data
                //close program
                System.exit(0);
            }//end else if
            
            else{
                //Invalid option message
                System.out.println("\nThis program does not recognize such a command. Please try again.\n");
            }//end else
            
            //if user selects to leave a review
            if(ifWantToLeaveReview){
                //run a method to add a review to the collection of reviews
                planetReviews = leaveReview("test", planetReviews, "test", "3", "Earth");
                for(int i = 0; i < planetReviews.length; i++){
                    for(int j = 0; j < planetReviews[i].length; j++){
                        System.out.println(planetReviews[i][j]);
                    }
                }
                
            }//end if statement
            
        } while(true);//end do while loop
        
    }//end method main
        
    // Account Creation
    /**
     * Method to create a new account
     * Created by David
     * Edited and rewrote by Sargon on April 28, 2025
     * @return newAccountInfo The info of the new account
     */
    public static ArrayList<String> createAccount() throws IOException {
        // Create objects, constants, and variables
        String accountName, accountPassword, confirmPassword;
        boolean notAcceptedName = false;
        Scanner keyboard = new Scanner(System.in);
        
        ArrayList<String> newAccountInfo = new ArrayList<>();
        
        // Account name loop
        while (true) {
            System.out.print("Enter account name OR ELSE MWAHAHAHHAA: ");
            accountName = keyboard.nextLine();
            System.out.println(accountName);
            
            notAcceptedName = accountName.length() >= 30 || accountName.length() <= 8;
            
            if (notAcceptedName) {
                System.out.println("Please have 8-30 characters in your account name.");
            }
            
            for (int i = 0; i < accountName.length(); i++) {
                if (!(accountName.charAt(i) <= 'A' && accountName.charAt(i) >= 'Z' || accountName.charAt(i) >= 'a' && accountName.charAt(i) <= 'z' || accountName.charAt(i) <= '9' && accountName.charAt(i) >= '0')) {
                    System.out.println("Please ensure that your account name only includes letters and numbers with no spaces.");
                    notAcceptedName = true;
                    break;
                }
            }
            
            if (!notAcceptedName) {
                break;
            }
        }
        
        // Account password loop
        while (true) {
            System.out.print("Enter password or ELSE: ");
            accountPassword = keyboard.nextLine();
            
            // Reaffirm the user's password
            System.out.print("Confirm your password: ");
            confirmPassword = keyboard.nextLine();
            
            if (confirmPassword.equals(accountPassword)) {
                break;
            }
        }
        
        // Add new account name and password to the same ArrayList to later return
        newAccountInfo.add(accountName);
        newAccountInfo.add(accountPassword);
 
        // Add new account name and the password to the files
        writeToFile("Usernames.txt", accountName);
        writeToFile("Passwords.txt", accountPassword);
        
        // Return accountName 
        return newAccountInfo;
    } // end method createAccount
   
    
    // Log in page
    /**
     * Log in method
     * Created by Tenzin & David
     * Last edited by Tenzin and Sargon on April 28th, 2025
     * @return username The username associated with the logged in account
     */
    public static String LogIn() throws IOException {
    // Initialize variables
    Colors colors = new Colors();
    String username, password, line;
    String[] Usernames = createArrayForFile("Usernames.txt");
    String[] Passwords = createArrayForFile("Passwords.txt");
    Usernames = readData("Usernames.txt", Usernames);
    Passwords = readData("Passwords.txt", Passwords);
    
    Scanner keyboard = new Scanner(System.in);
    int ln = -1;  // Line/index tracker
    // Username confirmation loop
    do {
        System.out.println("Please enter your username:");
        username = keyboard.nextLine();
        ln = -1; // Reset ln each attempt
        for (int i = 0; i < Usernames.length; i++) {
            if (username.equals(Usernames[i])) {
                ln = i; // Set to correct index
                break;
            }
        }
        if (ln != -1) {
            break; // Username found
        } else {
            System.out.println(colors.ANSI_RED + "Username not found. Try again." + colors.ANSI_RESET);
        }
    } while (true);
    line = Passwords[ln];
    
    // Password confirmation loop
    do {
        System.out.print("Please enter your password: ");
        password = keyboard.nextLine();
        if (password.equals(line)) {
            System.out.println("Password accepted.");
            break;
        } else {
            System.out.println(colors.ANSI_RED + "Password does not match user." + colors.ANSI_RESET);
        }
    } while (true);
    return username;
}


    // end method LogIn
    
    // Admin sign in
    
    // Explore page
    
    // Search page
    
    // View account
    
    // Recomendations
    
    // Leave a review
    
    // View other reviews
    
    // View other users
    
    // Distance claculator
    
    // something
    
    /**
     * Append to text file method
     * David
     * 
     * @param fileName Name of the file that is being written to
     */
    public static void writeToFile(String fileName, String temp) throws IOException {
        // Create objects, constants, and variables
        FileWriter fw = new FileWriter(fileName, true);
        PrintWriter outputFile = new PrintWriter(fw);

        outputFile.println(temp);   
        outputFile.close();
    }
    
    /**
     * Creates an array for a file reader to use
     * Created by Sargon
     * @param fileName The name of the file the be read in
     * @return The array to be used by the file reader
     */
    public static String[] createArrayForFile(String fileName) throws IOException {
        // Declare variables and objects
        String[] fileArray;
        File myFile = new File(fileName);
        Scanner inputFile = new Scanner(myFile);
        int lineCounter = 0;
        
        while (inputFile.hasNext()) {
            lineCounter++;
            inputFile.nextLine();
        }
        inputFile.close();
        
        fileArray = new String[lineCounter];
        
        return fileArray;
    }// end createArrayForFile
    
    /**
     * Reads a file into an array
     * Created by Sargon
     * @param fileName The name of the file the be read in
     * @param fileArray The array for the file
     * @return The updated array
     */
    public static String[] readData(String fileName, String[] fileArray) throws IOException {
        File myFile = new File(fileName);
        Scanner inputFile = new Scanner(myFile);
        
        for (int i = 0; i < fileArray.length; i++) {
            fileArray[i] = inputFile.nextLine();
        }
        
        return fileArray;
    }//end readData
    
    /**
     * readDataTwoDArray Reads data from a file and puts it into a 2D array
     * Created on 7 April 2025 by Kyler Kliks
     * @param fileName The name of the file to be scanned
     * @param splitCode What characters the array will be split at
     * @param numOfSplits How many times the array is split into
     * @return The 2D array
     */
    public static String[][] readDataTwoDArray(String fileName, String splitCode, int numOfSplits) throws IOException{
        //declare variables
        String[][] twoDArray;
        String[] fileArray = createArrayForFile(fileName);
        
        //fill in arrays
        fileArray = readData(fileName, fileArray);
        twoDArray = new String[fileArray.length][numOfSplits];
        for(int i = 0; i < fileArray.length; i++){
            twoDArray[i] = fileArray[i].split(splitCode);
        }//end for loop
        
        //return array
        return twoDArray;
    }//end readDataTwoDArray
    
    /**
     * convertTwodArrayToPlanetArray A method to create a Planet array
     * Created by Sargon K
     * Created on 22 April 2025
     * @param twoDArray The 2D array to be inputted
     * @return The array of planets
     */
    public static Planet[] convertTwodArrayToPlanetArray(String[][] twoDArray) {
        Planet[] planetArray = new Planet[twoDArray.length];
        String name;
        String type;
        String location;
        String identifier;
        String description;
        
        for (int i = 0; i < twoDArray.length; i++) {
            name = twoDArray[i][0];
            type = twoDArray[i][1];
            location = twoDArray[i][2];
            identifier = twoDArray[i][3];
            description = twoDArray[i][4];
            
            planetArray[i] = new Planet(name, type, location, identifier, description);
        }//end for loop
        
        return planetArray;
    }//end convertTwodArray
    
    /**
     * Checks files exist
     * Created by Sargon
     * @param fileName The name of the file that is to be checked if it exists
     */
    public static void checkFileExists(String fileName) {
        File file = new File(fileName);
        if(!file.exists()){
            System.out.println("The file " + fileName + " is missing. The program is going to shut down.");
            System.exit(0);
        }//end if statement
    }//end checkFileExists
    
    /**
     * mainCaller Calls the main method
     */
    public static void mainCaller() throws IOException, InterruptedException {
               // Clear the console
        System.out.print("\033[H\033[2J");
        main(null);
    }//end method mainCaller
    
    /**
     * leaveReview A method to add reviews to existing arrays
     * Created on 2 May 2025 by Kyler 
     * Edited 5 May 2025
     * @param newReview The review to be added
     * @param previousReviewsForPlanet The data structure for the reviews of the planet
     * @param reviewer The person leaving the review
     * @param reviewScore The numerical value of the review
     * @param planet What planet is getting reviewed
     * @return The updated data structure
     */
    public static String[][] leaveReview(String newReview, String[][] previousReviewsForPlanet, String reviewer, String reviewScore, String planet){
        String[][] tempArray;
        tempArray = new String[previousReviewsForPlanet.length][previousReviewsForPlanet[0].length + 1];
        for(int i = 0; i < previousReviewsForPlanet.length; i++){
            for(int j = 0; j < previousReviewsForPlanet[i].length; j++){
                tempArray[i][j] = previousReviewsForPlanet[i][j];
            }//end interal for loop
            
            if(tempArray[i][0].equals(planet) ){
                tempArray[i][tempArray[i].length - 1] = reviewer + "%?" + newReview + "%?" + reviewScore;
            }//end if statement
            
        }//end for loop
        
        return tempArray;
    }//end leaveReview
    
}//end class Main: D