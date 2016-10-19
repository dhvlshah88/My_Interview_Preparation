package datastructures.linkedlist;

public class EmployeeNode {

	private int eid;
	private String ename;
	private String title;
	
	private EmployeeNode nextNode;
	
	public EmployeeNode(int eid, String ename, String title){
		this.eid = eid;
		this.ename = ename;
		this.title = title;
		nextNode = null;
	}
	
	public void setEid(int eid){
		this.eid = eid;
	}
	
	public int getEid(){
		return eid;
	}
	
	public String getEname(){
		return ename;
	}

	public String getTitle(){
		return title;
	}
	
	public void setNext(EmployeeNode nextNode){
		this.nextNode = nextNode;
	}
	
	public EmployeeNode getNext(){
		return nextNode;
	}
	
	public void printDetails(){
		System.out.println("Id: " + eid);
		System.out.println("Name: " + ename);
		System.out.println("Title: " + title);
	}
	
}
