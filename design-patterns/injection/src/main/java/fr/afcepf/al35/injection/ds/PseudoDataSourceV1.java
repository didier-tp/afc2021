package fr.afcepf.al35.injection.ds;

//Catte classe pourrait avoir été codée ailleurs
//et on ne dispose que du code compilé (dans un .jar)
//pas possible de mettre des annotations dedans
public class PseudoDataSourceV1 implements PseudoDataSource {

	public PseudoDataSourceV1() {
	}

	@Override
	public Object getConnection() {
		return "connectionV1";
	}

}
