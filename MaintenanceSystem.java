// Receieves PotholeReports and Creates WorkOrders from them
// adds RepPrioirity, RepairStatus, EstRepairTime

// Sends WorkOrders to MaintenanceDepartment
// Receives Updated WorkOrders from MaintenanceDepartment
// Sends WorkOrder Updates to PotholeReportingSystem

import WorkOrder;
import java.time.*;

// Create a variable for the current time.
LocalTime time = LocalTime.now(ZoneId.of("America/New_York"); 
  
// get Hour field using getHour() 
int hour = time.getHour(); 

// Gather active work orders by priority


if ( hour == 6 ) {
  // 6AM, Send workorders to MaintenanceDepartment

}

if ( hour == 20 ) {
  // 8PM, send workorder updates to PotholeReportingSystem

}



