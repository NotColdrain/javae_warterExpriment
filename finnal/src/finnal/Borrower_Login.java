package finnal;

import java.util.ArrayList;
import java.util.List;

public class Borrower_Login {
	public Borrower LogIn(Borrower u) {
		List<Borrower> Borrower_Data = new ArrayList<>();
		Borrower_Read in=new Borrower_Read("Borrower");
		Borrower_Data = in.Read_Borrower();
		for(int i = 0;i<Borrower_Data.size();i++) {
			if(u.getName().equals(Borrower_Data.get(i).getName()) &&
				u.getStudent_Number() == Borrower_Data.get(i).getStudent_Number()
			){
				u.setClass(Borrower_Data.get(i).getclass());
				u.setSex(Borrower_Data.get(i).getSex());
				return u;
			}
		}
		return null;
	}
}
