import java.io.IOException;

interface VmMenu
{
	public void turnOn() throws IOException;		// �޴� ȣ�� �޼ҵ�

	public void menuDisp();		// �޴� ��� �޼ҵ�

	public void menuSelect() throws IOException;  // �޴� ���� �޼ҵ�

	public void menuRun() throws IOException;	// �޴� ���� �޼ҵ�
}