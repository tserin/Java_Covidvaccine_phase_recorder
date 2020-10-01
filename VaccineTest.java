import java.util.Scanner;

public class VaccineTest {

	//setting constant for governmentRebate
	final static int governmentRebate=10;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String ch;
		int choice;
		String studentID = "S121032";	
		// String studentID = "S12109372";		//Defining studentID
		//Setting default value of largest to 3.
		//If every digit in student id is smaller than 3, then N will be set to 3 i.e., largest
		int largest = 3;
		//This loop will traverse each character of the studentID
		for(int i=0;i<studentID.length();i++) {
			//Check if the character is a digit or not
			if (Character.isDigit(studentID.charAt(i))){
				int num=Integer.parseInt(String.valueOf(studentID.charAt(i)));
				//checks if digit is greater than largest.
				if(num>largest)
					largest=num;
			}
		}
		//constant N
		final int N=largest;
		
		//Array of Vaccine
		Vaccine vaccine = new Vaccine(N);
		
		String name; 
		int id,trialphase; 
		double predictedcost,realcost;
		
		//do-while loop
		do {
			//calling function menu
			menu();
			choice=scan.nextInt();
			//switch
			switch (choice) {
			case 1:
				//loop to input the details for N vaccines
				for(int i=0;i<N;i++) {
					int j=i+1;
					System.out.println(i);
					System.out.println("\n\nEnter the name for vaccine "+j+": ");
					name=scan.next();
					System.out.println("Enter the id for vaccine "+j+": ");
					id=scan.nextInt();
					do {
						System.out.println("Enter the trial phase for vaccine "+j+": ");
						trialphase=scan.nextInt();
						if(trialphase<1||trialphase>4) {
							System.out.println("Trial phase should be between 1 and 4");
						}
					}while(trialphase<1||trialphase>4);
					do {
						System.out.println("Enter the predicted cost for vaccine "+j+": ");
						predictedcost=scan.nextDouble();
						if(predictedcost<10||predictedcost>220) {
							System.out.println("Predicted cost should be between 10 and 220");
						}
					}while(predictedcost<10||predictedcost>220);
					//calling function setDetails from Vaccine class
					vaccine.setDetails(name, id, trialphase, predictedcost, i);
				}
				break;
			case 2:
				//calling function calcRealCost from Vaccine class
				vaccine.calcRealCost(governmentRebate);
				break;
			case 3:
				System.out.println("Vaccine Name\t\tID\t\tTrial Phase\tPredicted Cost\tRealCost");
				//loop to display information of N vaccines
				for(int i=0;i<N;i++) {
					//calling function getDetails from Vaccine class
					vaccine.getDetails(i);
				}
				break;
			case 4:
				//This flag defines if there are any vaccines in trial phase 3 or not.
				boolean flag = false;
				System.out.println("Vaccine Name\t\tID\t\tTrial Phase\tPredicted Cost\tRealCost");
				//loop to traverse through N vaccines
				for(int i=0;i<N;i++) {
					//calling getTrialPhase from Vaccine class to get the trial phase of respective vaccine
					if(vaccine.getTrialPhase(i)==3) {
						//if vaccine is found, set flag to true
						flag = true;
						//display information of vaccine
						vaccine.getDetails(i);
					}
				}
				//if no vaccine is found
				if(flag==false)
					System.out.println("There is no vaccine in trial phase 3.");
				break;
			case 5:
				//This flag is used to identify if the vaccine with defined id is found or not.
				boolean flag2 = false;
				System.out.println("Enter the id of vaccine to search: ");
				int searchID = scan.nextInt();
				System.out.println("\nVaccine Name\t\tID\t\tTrial Phase\tPredicted Cost\tRealCost");
				//loop to traverse through N vaccines
				for(int i=0;i<N;i++) {
					//calling getVaccineID from Vaccine class to get the ID of respective vaccine
					if(vaccine.getVaccineID(i)==searchID) {
						//if vaccine is found, set flag to true
						flag2=true;
						//display information of vaccine
						vaccine.getDetails(i);
					}
				}
				//if no vaccine is found
				if(flag2==false)
					System.out.println("Vaccine with given id is not found.");
				break;
			case 6:
				//copying vaccine IDs to another array
				String[] array=new String[N];
				for(int i=0;i<N;i++) {
					array[i]=vaccine.getVaccineName(i);
				}
				String temp;
				//sorting the array
				for(int i=1;i<N;i++) {
					for (int j=i+1; j< N;j++)
						{
							if (array[i].compareTo(array[j])>0)
							{
								temp = array[i];
								array[i] = array[j];
								array[j] = temp;
							}
						}
					}
				
				System.out.println("Vaccine Name\t\tID\t\tTrial Phase\tPredicted Cost\tRealCost");
				//this loop is used to traverse through array
				for(int i=0;i<N;i++) {
					//this loop is used to traverse through vaccineID array
					for(int j=0;j<N;j++) {
						//check if the vaccineID matches the value in array
						if(array[i]==vaccine.getVaccineName(j)) {
							//display information of vaccine
							vaccine.getDetails(j);
						}
					}
				}
				break;
			case 7:
				//terminate the program
				System.out.println(studentID+ ": The program terminates here... ");
				break;
			}
			System.out.println("Do you want to continue (y/n)? ");
			ch=scan.next();
		}while(ch.equalsIgnoreCase("y"));
		
	}

	//This function displays the menu
	private static void menu() {
		System.out.println("Welcome to COVID-19 Vaccines\n");
		System.out.println("1. Read, validate and store vaccine data for N vaccines");
		System.out.println("2. Calculate and store the real cost for each vaccine");
		System.out.println("3. Display all vaccines");
		System.out.println("4. Display all vaccines in trial phase 3");
		System.out.println("5. Search a vaccine by id");
		System.out.println("6. Sort and display vaccines by name");
		System.out.println("7. Exit from the application");
		System.out.println("Enter menu options 1-7: ");
	}



}
