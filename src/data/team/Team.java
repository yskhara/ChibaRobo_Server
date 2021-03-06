package data.team;

import java.util.Arrays;

import data.main.CodeXML;

class Team {
	private int id;
	private String name;
	private int robot_id[];
	private String desc;
	private boolean valid = false;
	
	Team(int id, String name, int id1, int id2, String desc){
		this.id = id;
		this.name = name;
		this.robot_id = new int[]{id1, id2};
		this.desc = desc;
		this.valid = true;
	}

	public int get_id(){ return id; }
	public String get_name(){ return name; }
	public int[] get_robot_id(){ return Arrays.copyOf(robot_id, robot_id.length); }
	public int get_robot_id(int id) throws ArrayIndexOutOfBoundsException{ return robot_id[id]; }
	public String get_desc(){ return desc; }
	public boolean get_valid(){ return valid; }
	
	public String get_summary(){
		String ret = "";
		ret += get_id();
		ret += "," + get_robot_id(0);
		ret += "," + get_robot_id(1);
		ret += "," + get_name();
		return ret;
	}
	
	// このクラスのXML表記を出力
	public CodeXML create_xml(CodeXML xml) throws NullPointerException{
		if( xml == null ){
			throw new NullPointerException("CodeXML(class) has no instance.\n");
		}
		xml.add_line(1, "<team id=\"" + id +"\">");
		xml.add_line(2, "<name>"+ name +"</name>");
		xml.add_line(2, "<robot id=\""+ robot_id[0] +"\" />");
		xml.add_line(2, "<robot id=\""+ robot_id[1] +"\" />");
		xml.add_line(2, "<desc>"+ desc +"</desc>");
		xml.add_line(1, "</team>");
		return xml;
	}
}
