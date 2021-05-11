package com.elms.mohamed.service;

import java.util.ArrayList;
import java.util.List;

import com.elms.mohamed.model.LeaveRequest;

/**
 * Class to manage all the operations or actions performed on a leave request.
 *
 */

public class LeaveRequestManager {
	private static List<LeaveRequest> requestList = new ArrayList<LeaveRequest>();
	public static int idNo=1;
	
	/**
	 * This method adds the leave request to the list of request whenever an employee 
	 * wants to apply for leave.
	 * @param leaveRequest
	 */
	public static void addRequest(LeaveRequest leaveRequest) {
		leaveRequest.setLeaveId(idNo);
		requestList.add(leaveRequest);
		idNo++;
	}
	
	/**
	 * Function of the method is to return the list of requests so that list can be 
	 * accessed or traversed.
	 * @return List<LeaveRequest>
	 */
	public static List<LeaveRequest> getRequestList() {
		return requestList;
	}
	/**
	 * Method used  to get a particular leave request
	 * @param leaveId
	 * @return LeaveRequest
	 */
	public static LeaveRequest getLeaveRequest(int leaveId) {
		leaveId--;
		return requestList.get(leaveId);
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
	 * Used to reassign the values of leaveID after cancellation
	 */
	public static void reassignLeaveId() {
		int leaveId=1;
		for (LeaveRequest leaveRequest : requestList) {
			leaveRequest.setLeaveId(leaveId);
			leaveId++;
		}
		idNo=leaveId;
	}
	
	/**
	 * used to cancel requests in case an employee needs to.
	 * @param leaveId
	 */
	public static void cancelRequest(int leaveId) {
		leaveId--;
		try {
			requestList.remove(leaveId);
			reassignLeaveId();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ArrayIndexOutOfBoundsException("No leave request found with that Id");
		}
	}
	
	/**
	 * used to approve the request of an employee
	 * @param leaveId
	 */
	public static void approveRequest(int leaveId) {
		try {
			LeaveRequest leaveRequest = getLeaveRequest(leaveId);
			leaveRequest.setStatus("Approved");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ArrayIndexOutOfBoundsException("Cannot approve a non-existing requests");
		}
	}
	
	/**
	 * used to reject the request of the employee
	 * @param leaveId
	 */
	public static void rejectRequest(int leaveId) {
		LeaveRequest leaveRequest;
		try {
			leaveRequest = getLeaveRequest(leaveId);
			leaveRequest.setStatus("Request Rejected");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ArrayIndexOutOfBoundsException("Cannot reject a non-existing request");
		}
	}
}
