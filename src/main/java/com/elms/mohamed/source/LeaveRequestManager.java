package com.elms.mohamed.source;

import java.util.ArrayList;


public class LeaveRequestManager {
	public static ArrayList<LeaveRequest> requestList = new ArrayList<LeaveRequest>();
	public static int idNo=0;
	public static void addRequest(LeaveRequest leaveRequest) {
		idNo++;
		leaveRequest.setLeaveId(idNo);
		requestList.add(leaveRequest);
	}
	
	public static ArrayList<LeaveRequest> getRequestList() {
		return requestList;
	}
	
	public static void displayRequests() {
		System.out.println("-----------------LeaveRequest----------------");
		System.out.println("S.No\tEmp.Id\tName\tFrom\t\tTo\t\tReason\tStatus");
		for (LeaveRequest leaveRequest : requestList) {
			System.out.println(leaveRequest.getLeaveId()+"\t"+ leaveRequest.getId()+"\t"+leaveRequest.getName()+"\t"+leaveRequest.getFromDate()+"\t"
					+leaveRequest.getToDate()+"\t"+leaveRequest.getReason()+"\t"+leaveRequest.getStatus());
		}
	}
	public static void cancelRequests(int leaveId) {
		int removeId=0;
		for (LeaveRequest leaveRequest : requestList) {
			if(leaveId==leaveRequest.getLeaveId()) {
				break;
			}
			removeId++;
		}
		requestList.remove(removeId);
	}
	
	public static void approveRequest(int leaveId) {
		for (LeaveRequest leaveRequest : requestList) {
			if(leaveRequest.getLeaveId() == leaveId) {
				leaveRequest.setStatus("Request Approved");
				break;
			}
		}	
	}
	
	
	public static void rejectRequest(int leaveId) {
		for (LeaveRequest leaveRequest : requestList) {
			if(leaveId == leaveRequest.getLeaveId()) {
				leaveRequest.setStatus("Request Rejected");
				break;
			}
		}
	}
}
