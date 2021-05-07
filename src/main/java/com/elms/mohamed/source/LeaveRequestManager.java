package com.elms.mohamed.source;

import java.util.ArrayList;

/**
 * Class to manage all the operations or actions performed on a leave request.
 *
 */

public class LeaveRequestManager {
	public static ArrayList<LeaveRequest> requestList = new ArrayList<LeaveRequest>();
	public static int idNo=0;
	
	/**
	 * This method adds the leave request to the list of request whenever an employee 
	 * wants to apply for leave.
	 * @param leaveRequest
	 */
	public static void addRequest(LeaveRequest leaveRequest) {
		idNo++;
		leaveRequest.setLeaveId(idNo);
		requestList.add(leaveRequest);
	}
	
	/**
	 * Function of the method is to return the list of requests so that list can be 
	 * accessed or traversed.
	 * @return ArrayList<LeaveRequest>
	 */
	public static ArrayList<LeaveRequest> getRequestList() {
		return requestList;
	}
	
	/**
	 * Displays all the requests applied by the employee and also displays their 
	 * standing status
	 */
	public static void displayRequests() {
		System.out.println("-----------------LeaveRequest----------------");
		System.out.println("S.No\tEmp.Id\tName\tFrom\t\tTo\t\tReason\tStatus");
		for (LeaveRequest leaveRequest : requestList) {
			System.out.println(leaveRequest.getLeaveId()+"\t"+ leaveRequest.getId()+"\t"+leaveRequest.getName()+"\t"+leaveRequest.getFromDate()+"\t"
					+leaveRequest.getToDate()+"\t"+leaveRequest.getReason()+"\t"+leaveRequest.getStatus());
		}
	}
	
	/**
	 * used to cancel requests in case an employee needs to.
	 * @param leaveId
	 */
	public static void cancelRequest(int leaveId) {
		int removeId=0;
		for (LeaveRequest leaveRequest : requestList) {
			if(leaveId==leaveRequest.getLeaveId()) {
				break;
			}
			removeId++;
		}
		requestList.remove(removeId);
	}
	
	/**
	 * used to approve the request of an employee
	 * @param leaveId
	 */
	public static void approveRequest(int leaveId) {
		for (LeaveRequest leaveRequest : requestList) {
			if(leaveRequest.getLeaveId() == leaveId) {
				leaveRequest.setStatus("Request Approved");
				break;
			}
		}	
	}
	
	/**
	 * used to reject the request of the employee
	 * @param leaveId
	 */
	public static void rejectRequest(int leaveId) {
		for (LeaveRequest leaveRequest : requestList) {
			if(leaveId == leaveRequest.getLeaveId()) {
				leaveRequest.setStatus("Request Rejected");
				break;
			}
		}
	}
}
