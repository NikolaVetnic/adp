package main;

public class Guma implements IGuma {

	private ETipGume tipGume;
	private int starost;
	private boolean puklaGuma;
	
	public Guma(ETipGume tipGume, int starost) {
		this.starost = starost;
		this.puklaGuma = verovatnoca();
	}
	
	public boolean jeUpotrebljiva() {
		return !jePuklaGuma() && this.starost < getTipGume().granicnaStarost;
	}

	@Override
	public boolean jePuklaGuma() {
		return puklaGuma;
	}

	@Override
	public ETipGume getTipGume() {
		return tipGume;
	}
}
