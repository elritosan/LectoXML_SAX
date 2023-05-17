package FuncionMain;

public class AnalizadorLexico {

	public static void main(String[] args) {
        SaxParser sp = new SaxParser("SudamericaPoblacion.xml");
        try {
			sp.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
