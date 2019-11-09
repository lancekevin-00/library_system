package library_system;

public class Checked_out_itm {
	private Item item;
	private String type;
	private int renewals;
	private int time_remaining;
	private String title;
	private int id,userid;
	public Checked_out_itm(String t, Item item) {
		type = t;
		renewals = 0;
		time_remaining = item.getMax_checkout_time();
		title = item.getTitle();
		id = item.getId();
	}
	public Checked_out_itm(int userid, String title, int id, int renewals, int timeremaining) { 
		this.userid = userid;
		this.title = title;
		this.id = id;
		this.renewals = renewals;
		this.time_remaining = timeremaining;
	}
	public void return_itm() {
		item.setCopies_avalible(item.getCopies_avalible() + 1);
	}
	
	public void renew() {
		if(renewals == 3) {
			System.out.println("this item is not renewable");
		}
		else {
			renewals ++;
			System.out.println("this is the "+ renewals + "renewal of this item");
		}
	}
	
	public int getUserId() {
		return userid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRenewals() {
		return renewals;
	}
	public void setRenewals(int renewals) {
		this.renewals = renewals;
	}
	public int getTime_remaining() {
		return time_remaining;
	}
	public void updateDay() {
		time_remaining--;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String name) {
		this.title = name;
	}
	public String toString() {
		return "{\n\"userid\":"+ userid+",\n\"id\":" +id+",\n\"\title\":"+title+"\",\n\"renewals\":"+renewals+",\n\"timeremaining\":"+time_remaining+"\n}";
	}
}
