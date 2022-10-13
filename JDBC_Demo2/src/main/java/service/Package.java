package service;

public interface Package {

	public int AddPackage(String details);
	public int deletePckgById(String pckgId);
	public void extractMinDaysPackage();
}
