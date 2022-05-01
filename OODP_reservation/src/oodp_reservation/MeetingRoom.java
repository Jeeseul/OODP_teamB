package oodp_reservation;

import java.util.TreeMap;

public class MeetingRoom {
	@SuppressWarnings("unchecked")
	private TreeMap<Integer,Integer[]>[] reservation = (TreeMap<Integer,Integer[]>[]) new TreeMap[12];
	
	//static MeetingRoom[] meetingRooms = new MeetingRoom[meetingRoomLength];
	
	MeetingRoom(){
		//reservation = new TreeMap<Integer,Integer[]>[12];
		for(int i=0;i<12;i++) {
			reservation[i] = new TreeMap<Integer,Integer[]>();
		}
		
	}
	
	public int addReserve(int month,int day,int startTime,int endTime) {
		Integer[] time = new Integer[24];
		for(int i = startTime;i<endTime;i++) {
			time[i] = 1;
		}
		reservation[month].put(day, time);
	
		//System.out.println("저장: "+reservation.get(day));
		//Integer[] newThing = reservation.get(day);
		//for(int i =0;i<24;i++) System.out.println(i+": "+newThing[i]);
		return 1;
	}
	
	public int checkReservation(int month,int day,int startTime,int endTime) {
		//현재 예약하려는 날짜에 회의가 존재하긴함! 
		if(reservation[month].containsKey(day)) {
			//System.out.println(reservation.get(day));
			Integer[] newThing = new Integer[24];
			newThing = reservation[month].get(day);
			//for(int i =0;i<24;i++) System.out.println(i+": "+newThing[i]);
			for(int j=startTime;j<endTime;j++) {
				//System.out.println("startTime: "+startTime);
				//System.out.println("newThing[j]: "+newThing[j]);
				if(newThing[j] == null) newThing[j] =0 ;
				else if(newThing[j] == 1) return 0;
				
			}
		}else return 1;
		
		return 2;
	}
}
