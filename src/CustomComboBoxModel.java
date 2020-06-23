import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

public class CustomComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<String> datas = new ArrayList<String>();
	//private String sido;
	//private String gugun;
	
	public CustomComboBoxModel() {
		// TODO Auto-generated constructor stub
		ZipcodeDAO dao = new ZipcodeDAO();
		datas = dao.allSido();
	}
	public CustomComboBoxModel(String sido) {
		ZipcodeDAO dao = new ZipcodeDAO();
		datas = dao.allGugun(sido);
	}
	
	public CustomComboBoxModel(int any, String gugun) {
		ZipcodeDAO dao = new ZipcodeDAO();
		datas = dao.allDong(gugun);
	}

	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return datas.size();
	}
	
	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return datas.get(index);
	}
}
