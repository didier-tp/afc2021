package fr.afcepf.al35.injection.ds;

public class PseudoDataSourceV2 implements PseudoDataSource {

	public PseudoDataSourceV2() {
	}

	@Override
	public Object getConnection() {
		return "connectionV2";
	}

}
