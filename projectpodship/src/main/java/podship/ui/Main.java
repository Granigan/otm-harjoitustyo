package podship.ui;

import java.util.*;

public class Main {
    

    public static void main(String[] args) {
        
        
        int turnCount = 3;
        Scanner input = new Scanner(System.in);
        String name;

        System.out.println("Welcome to Podship, director. What is your name?");
        name = input.nextLine();
        System.out.println("Very good. Let's get started then, director " + name + ".\n\n");

        System.out.println("You've been tasked with overseeing the Project Podship. "
                + "In short, Earth is facing an existential crisis, and no one knows for sure if "
                + "we'll survive. \nTo ensure humanity will not perish with the planet, we'll need to ensure "
                + "our survival by colonising elsewhere. Unfortunately, our colonies in Mars and Ganymede "
                + "will still be reliant on Earth for decades to come, and thus we must look elsewhere.\n");
        System.out.println("You'll oversee the construction of Podship, destined for Gliese 832.\n\n"
                + "That's 16.16 light years away.\n\n"
                + "That means the population of the ship will "
                + "not be passengers, but rather, they'll move to the ship to live and die there. "
                + "Dozens of the next generations will be born and will die inside the ship, "
                + "while it travels.\n\n"
                + "I'm sure you understand the enormity of the task. But you must succeed.\n"
                + "Good luck, director " + name + ".\n\n");

        while (true) {
            System.out.println("It's time to make a decision, director " + name + ".\n\n");

            System.out.println("Decide on the captain of the ship.\n"
                    + "Should it be \n"
                    + "1) AI alone - leave all the decision-making to an AI as advanced as we can create.\n"
                    + "2) AI with publicly elected captain - a democracy onboard the ship\n"
                    + "3) AI with the highest ranking military officer");

            System.out.println("Please make your selection by inputing just the number of the option.");
            int selection = Integer.parseInt(input.nextLine());
            if (selection == 1) {
                System.out.println("AI alone will be in charge of the mission.\n");
            } else if (selection == 2) {
                System.out.println("Captain will be elected in general elections, and assited by AI.\n");
            } else if (selection == 3) {
                System.out.println("We'll give the lead to the military. This mission is too critical to have debates over.\n");
            } else {
                System.out.println("Since it seems you're incapable of even providing accurate input, you are unfit"
                        + "for this task. You are relieved of your duty. Goodbye, " + name + ".");
                break;
            }

            System.out.println("Is the ship ready for launch?\n(y)es or (n)o");
            String launch = input.nextLine();
            if (launch.equals("y")) {
                System.out.println("Congratulations, the ship is now launched. Now we can but wait.");
                break;
            } else if (launch.equals("n")) {
                System.out.println("We'll continue the construction and recruitment process. You "
                        + "have " + turnCount + " turns left before the mandatory launch date.");
            }
        }
    }
}
