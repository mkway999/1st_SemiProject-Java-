/*
[���α׷� ���� Ŭ����]
*/
class Exit
{
	public static void exit()
	{	
		Serial.fruitSet();
		Serial.subSet();
		
		// ���ѿ� ���� - �������� �����
		Serial.totahapSet();
		Serial.dailySalesSet();
		Serial.totalPdHuruListSet();
		Serial.pdHuruListSet();
		Serial.fruitCountsSet();

		System.out.println("\n���α׷��� �����մϴ�.");
		System.exit(-1);
	}
}