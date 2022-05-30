package oodp_reservation;

import java.util.Scanner;

public class MeetingRoomRunner {
	static int[] month_length = {0,31,28,31,30,31,30,31,31,30,31,30,31};  
	static int meetingRoomLength = 3;
	//	static MeetingRoom[] meetingRooms = new MeetingRoom[meetingRoomLength];
	int month,day,startTime,endTime=0;
	int meetingRoomNum=0;
	boolean checkReservation = true;

	
	public void run() {
		// for(int i=0;i<meetingRoomLength;i++) {
		//  	meetingRooms[i] = new MeetingRoom();
		// }
		MeetingRoomRunner m = new MeetingRoomRunner();
		m.getInfo();
		//예약 완료 후에는 어디로 가야하는 걸까요? 
	}
	
	public static void main(String[] args) {
		MeetingRoomRunner m = new MeetingRoomRunner();
		m.run();
	}
	
	public void getInfo() {
		int recursive=0;
		MeetingRoom meetingRoom = MeetingRoom.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====회의실 예약창=====");
		//System.out.println("1. 특정 날짜 예약"); //당일 예약 기능 이번에 있어야하는 건가요? 
		do {
			do {
				checkReservation = true;
			//	do {
			//		System.out.println("예약하기 원하시는 회의실 번호를 입력해주세요.\n\t1. biggest\n\t2. medium\n\t3. smallest\n: ");
			//		meetingRoomNum = sc.nextInt();
			//		if(meetingRoomNum >3 || meetingRoomNum <1 ) System.out.println("다시 입력해주세요: ");
			//	}while(meetingRoomNum >3 || meetingRoomNum <1 );
				
				do {
					System.out.println("예약하기 원하시는 '월'을 입력해주세요: ");
					month = Integer.parseInt(sc.nextLine());
					if(month >12 || month <1 ) System.out.println("다시 입력해주세요: ");
				}while(month >12 || month <1);
				
				do {
					System.out.println("예약하기 원하시는 '일'을 입력해주세요: ");
					day = Integer.parseInt(sc.nextLine());
					if(day > month_length[month] || day < 1 ) System.out.println("다시 일자를 입력해주세요: ");
				}while(day >month_length[month] || day <1);
				
				do {
					System.out.println("예약하시는 회의 시작시간을 입력해주세요(ex. 13): ");
					startTime = Integer.parseInt(sc.nextLine());
					if(startTime >23 || startTime <0 ) System.out.println("다시 입력해주세요: ");
				}while(startTime >23 || startTime <0);
				
				do {
					System.out.println("예약하시는 회의 끝 시간을 입력해주세요(ex. 15): ");
					endTime = Integer.parseInt(sc.nextLine());
					if(endTime >24 && endTime <1 ) System.out.println("다시 입력해주세요: ");
					if(startTime == endTime) System.out.println("시작 시간과 끝시간이 같습니다. 다시 입력해주세요.");
				}while(endTime >24 || endTime <1 || startTime > endTime || startTime == endTime);
				
				//false = 예약할 수 없다는 의미 
				if(/*meetingRooms[meetingRoomNum-1]*/meetingRoom.checkReservation(month,day,startTime,endTime)==0) {
					checkReservation = false;
					System.out.println("예약하시려는 시간은 이미 예약이 차있습니다. 다른 시간이나 회의실로 시도해주세요. ");//조회하는 기능이 없어서 어느 시간이 겹치는지는 말 안해요!
				}
			}while(checkReservation == false);
			
			int result = /*meetingRooms[meetingRoomNum-1]*/meetingRoom.addReserve(month, day, startTime, endTime);
			if(result == 1) System.out.println("예약이 성공적으로 완료되었습니다.\n 1. 다른 예약 진행 \t2. 예약 종료");
			else if(result !=1 ||result != 2) System.out.println("예상치못한 입력으로 종료됩니다.");
			recursive = Integer.parseInt(sc.nextLine());
		}while(recursive == 1);
		//MeetingRoomsc.close();
	}
}
