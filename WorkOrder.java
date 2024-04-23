import java.util.Scanner;

public class WorkOrder extends PotholeReport{
  //private int ReportID;
  private int RepPriority;
  private int EstRepairTime;
  private String RepairStatus;
  Scanner scanner = new Scanner(System.in);
  
  public WorkOrder() {
    updateRepairTime();
    
  }

  public updateRepairTime() {
		System.out.println("Enter Repair Time: ");
		this.EstRepairTime = scanner.nextLine();
  }
  public updateStatus() {
		System.out.println("Enter Pothole Status (Not Started, In-Progress, Fixed): ");
		this.RepairStatus = scanner.nextLine();
  }

  public getRepPriority(){
    return RepPriority;
  }

  public getEstRepairTime(){
    return EstRepairTime;
  }

  public getRepairStatus(){
    return RepairStatus;
  }

  
}  


    
