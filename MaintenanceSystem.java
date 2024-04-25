// Receieves PotholeReports and Creates WorkOrders from them
// adds RepPrioirity, RepairStatus, EstRepairTime

// Sends WorkOrders to MaintenanceDepartment
// Receives Updated WorkOrders from MaintenanceDepartment
// Sends WorkOrder Updates to PotholeReportingSystem

import WorkOrder;
import java.time.*;

// Create a variable for the current time.
LocalTime time = LocalTime.now(); 
  
// get Hour field using getHour() 
int Hour = time.getHour(); 
  
// print result 
System.out.println("Hour Field: " + Hour); 



