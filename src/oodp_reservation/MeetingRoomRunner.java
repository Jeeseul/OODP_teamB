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
		//���� �Ϸ� �Ŀ��� ���� �����ϴ� �ɱ��? 
	}
	
	public static void main(String[] args) {
		MeetingRoomRunner m = new MeetingRoomRunner();
		m.run();
	}
	
	public void getInfo() {
		int recursive=0;
		MeetingRoom meetingRoom = MeetingRoom.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====ȸ�ǽ� ����â=====");
		//System.out.println("1. Ư�� ��¥ ����"); //���� ���� ��� �̹��� �־���ϴ� �ǰ���? 
		do {
			do {
				checkReservation = true;
			//	do {
			//		System.out.println("�����ϱ� ���Ͻô� ȸ�ǽ� ��ȣ�� �Է����ּ���.\n\t1. biggest\n\t2. medium\n\t3. smallest\n: ");
			//		meetingRoomNum = sc.nextInt();
			//		if(meetingRoomNum >3 || meetingRoomNum <1 ) System.out.println("�ٽ� �Է����ּ���: ");
			//	}while(meetingRoomNum >3 || meetingRoomNum <1 );
				
				do {
					System.out.println("�����ϱ� ���Ͻô� '��'�� �Է����ּ���: ");
					month = Integer.parseInt(sc.nextLine());
					if(month >12 || month <1 ) System.out.println("�ٽ� �Է����ּ���: ");
				}while(month >12 || month <1);
				
				do {
					System.out.println("�����ϱ� ���Ͻô� '��'�� �Է����ּ���: ");
					day = Integer.parseInt(sc.nextLine());
					if(day > month_length[month] || day < 1 ) System.out.println("�ٽ� ���ڸ� �Է����ּ���: ");
				}while(day >month_length[month] || day <1);
				
				do {
					System.out.println("�����Ͻô� ȸ�� ���۽ð��� �Է����ּ���(ex. 13): ");
					startTime = Integer.parseInt(sc.nextLine());
					if(startTime >23 || startTime <0 ) System.out.println("�ٽ� �Է����ּ���: ");
				}while(startTime >23 || startTime <0);
				
				do {
					System.out.println("�����Ͻô� ȸ�� �� �ð��� �Է����ּ���(ex. 15): ");
					endTime = Integer.parseInt(sc.nextLine());
					if(endTime >24 && endTime <1 ) System.out.println("�ٽ� �Է����ּ���: ");
					if(startTime == endTime) System.out.println("���� �ð��� ���ð��� �����ϴ�. �ٽ� �Է����ּ���.");
				}while(endTime >24 || endTime <1 || startTime > endTime || startTime == endTime);
				
				//false = ������ �� ���ٴ� �ǹ� 
				if(/*meetingRooms[meetingRoomNum-1]*/meetingRoom.checkReservation(month,day,startTime,endTime)==0) {
					checkReservation = false;
					System.out.println("�����Ͻ÷��� �ð��� �̹� ������ ���ֽ��ϴ�. �ٸ� �ð��̳� ȸ�ǽǷ� �õ����ּ���. ");//��ȸ�ϴ� ����� ��� ��� �ð��� ��ġ������ �� ���ؿ�!
				}
			}while(checkReservation == false);
			
			int result = /*meetingRooms[meetingRoomNum-1]*/meetingRoom.addReserve(month, day, startTime, endTime);
			if(result == 1) System.out.println("������ ���������� �Ϸ�Ǿ����ϴ�.\n 1. �ٸ� ���� ���� \t2. ���� ����");
			else if(result !=1 ||result != 2) System.out.println("����ġ���� �Է����� ����˴ϴ�.");
			recursive = Integer.parseInt(sc.nextLine());
		}while(recursive == 1);
		//MeetingRoomsc.close();
	}
}
