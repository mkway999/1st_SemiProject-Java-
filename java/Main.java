import java.io.IOException;
import java.time.LocalDate;

public class Main
{	
	public static void main(String[] args) throws IOException
	{	
		Certify cf = new Certify();
		AdMain am = new AdMain(); //CuMain cm = new CuMain(); �ǸŸ�� �ν��Ͻ� ���� ����
		
		cf.adCertify();	// ������ �ڵ� �Ǻ��ϴ� �޼ҵ� �������� false��� ���α׷� ����. ��, ���� �ڵ� ���� �� ��
						// ���� ����� ���̶�� ���� �ڵ� ���డ��
		Serial.fruitGet();
		Serial.subGet();

		// ���ѿ� ���� - �������� �����
		Serial.totahapGet();
		Serial.dailySalesGet();
		Serial.totalPdHuruListGet();
		Serial.pdHuruListGet();
		Serial.fruitCountsGet();

		do
		{
			am.turnOn();
			am.switchSM(); //cm.cuSelect(); �ǸŸ�� ���� ����
			
		}
		while (true);
	}
}