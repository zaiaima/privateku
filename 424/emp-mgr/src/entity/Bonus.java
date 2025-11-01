package entity;

public class Bonus {

	private String ename;
	private String job;
	private int sal;
	private int comm;
	private Emp bonemp;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public Bonus(String ename, String job, int sal, int comm) {
		super();
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	public Bonus() {
		super();
	}
	public Emp getBonemp() {
		return bonemp;
	}
	public void setBonemp(Emp bonemp) {
		this.bonemp = bonemp;
	}

}
