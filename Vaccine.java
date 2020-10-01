import java.util.Scanner;

public class Vaccine {
	
	private String[] vaccineName;
	private int[] vaccineID;
	private int[] trialPhase;
	private double[] predictedCost;
	private double[] realCost;
	
	//constructor to initialize the arrays
	public Vaccine(int N) {
		vaccineName= new String[N];
		vaccineID = new int[N];
		trialPhase = new int[N];
		predictedCost = new double[N];
		realCost = new double[N];
	}
	
	//This function is used to set the name, id, trialphase and predictedCost of the vaccine
	public void setDetails(String name, int id, int tp, double pc, int i) {
		vaccineName[i]=name;
		vaccineID[i]=id;
		trialPhase[i]=tp;
		predictedCost[i]=pc;
	}
	
	//This function displays the vaccine information
	public void getDetails(int i) {
		System.out.println(vaccineName[i]+"\t\t\t"+vaccineID[i]+"\t\t"+trialPhase[i]+"\t\t"+predictedCost[i]+"\t\t"+realCost[i]);
	}
	
	//This function calculates the real cost of the vaccine
	public void calcRealCost(int governmentRebate) {
		for(int i=0;i<predictedCost.length;i++) {
			realCost[i]=predictedCost[i]-governmentRebate;
		}
	}
	
	//This function returns the trial phase for a vaccine
	public int getTrialPhase(int i) {
		return trialPhase[i];
	}
	
	//This function returns the VaccineID
	public int getVaccineID(int i) {
		return vaccineID[i];
	}
	public String getVaccineName(int i) {
		return vaccineName[i];
	}

}
